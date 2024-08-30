package tn.services;

import tn.interfaces.InterfaceCRUD;
import tn.models.Employees;
import tn.util.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements InterfaceCRUD<Employees> {
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void add(Employees employee) {
        String sql = "INSERT INTO `employees` (`nameEmployee`, `lastNameEmployee`,  `CIN`,`emailEmployee`, `phoneEmployee`, `imageEmployee`, " +
                "`birthdayEmployee`, `genderEmployee`, `positionEmployee`, `hireDateEmployee`, `salaryEmployee`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setString(1, employee.getNameEmployee());
            ps.setString(2, employee.getLastNameEmployee());
            ps.setString(3,employee.getCIN());
            ps.setString(4, employee.getEmailEmployee());
            ps.setString(5, employee.getPhoneEmployee());
            ps.setString(6, employee.getImageEmployee());
            ps.setDate(7, new java.sql.Date(employee.getBirthdayEmployee().getTime()));
            ps.setString(8, employee.getGenderEmployee());
            ps.setString(9, employee.getPositionEmployee());
            ps.setDate(10, new java.sql.Date(employee.getHireDateEmployee().getTime()));
            ps.setFloat(11, employee.getSalaryEmployee());

            ps.executeUpdate();
            System.out.println("Employee: " + employee.getNameEmployee() + " " + employee.getLastNameEmployee() + " added successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Employees employee) {
        try {
            // SQL query to update an employee record
            String req = "UPDATE employees SET " +
                    "nameEmployee=?, " +
                    "lastNameEmployee=?, " +
                    "CIN=?, " +
                    "emailEmployee=?, " +
                    "phoneEmployee=?, " +
                    "imageEmployee=?, " +
                    "birthdayEmployee=?, " +
                    "genderEmployee=?, " +
                    "positionEmployee=?, " +
                    "hireDateEmployee=?, " +
                    "salaryEmployee=? " +
                    "WHERE idEmployee=?";

            // Prepare the SQL statement
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, employee.getNameEmployee());
            ps.setString(2, employee.getLastNameEmployee());
            ps.setString(3,employee.getCIN());
            ps.setString(4, employee.getEmailEmployee());
            ps.setString(5, employee.getPhoneEmployee());
            ps.setString(6, employee.getImageEmployee());
            ps.setDate(7, employee.getBirthdayEmployee());
            ps.setString(8, employee.getGenderEmployee());
            ps.setString(9, employee.getPositionEmployee());
            ps.setDate(10, employee.getHireDateEmployee());
            ps.setFloat(11, employee.getSalaryEmployee());
            ps.setInt(12, employee.getIdEmployee());

            // Execute the update statement
            ps.executeUpdate();

            // Output a success message
            System.out.println("Employee *" + employee.getNameEmployee() + "* updated successfully");

        } catch (SQLException sqlException) {
            // Print any SQL exceptions
            sqlException.printStackTrace();
        }

    }

    @Override
    public void remove(int idEmployee) {
        try {
            // SQL query to delete an employee record
            String req = "DELETE FROM employees WHERE idEmployee = ?";

            // Prepare the SQL statement
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, idEmployee);

            // Execute the delete statement
            int rowsAffected = ps.executeUpdate();

            // Check if any rows were affected
            if (rowsAffected > 0) {
                System.out.println("Employee with ID *" + idEmployee + "* removed successfully");
            } else {
                System.out.println("No employee found with ID *" + idEmployee + "*");
            }

        } catch (SQLException exp) {
            // Print any SQL exceptions
            exp.printStackTrace();
        }
    }

    public List<Employees> getAllEmployees() {
        List<Employees> employees = new ArrayList<>();
        try {
            String req = "SELECT * FROM employees";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Employees e = new Employees();
                e.setIdEmployee(rs.getInt(1));
                e.setNameEmployee(rs.getString(2));
                e.setLastNameEmployee(rs.getString(3));
                e.setCIN(rs.getString(4));
                e.setEmailEmployee(rs.getString(5));
                e.setPhoneEmployee(rs.getString(6));
                e.setImageEmployee(rs.getString(7));
                e.setBirthdayEmployee(rs.getDate(8));
                e.setGenderEmployee(rs.getString(9));
                e.setPositionEmployee(rs.getString(10));
                e.setHireDateEmployee(rs.getDate(11));
                e.setSalaryEmployee(rs.getFloat(12));

                employees.add(e);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employees;
    }
}
