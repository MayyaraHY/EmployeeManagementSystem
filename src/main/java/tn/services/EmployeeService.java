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
        String sql = "INSERT INTO `employees` (`nameEmployee`, `lastNameEmployee`, `emailEmployee`, `phoneEmployee`, `imageEmployee`, " +
                "`birthdayEmployee`, `genderEmployee`, `positionEmployee`, `hireDateEmployee`, `salaryEmployee`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setString(1, employee.getNameEmployee());
            ps.setString(2, employee.getLastNameEmployee());
            ps.setString(3, employee.getEmailEmployee());
            ps.setString(4, employee.getPhoneEmployee());
            ps.setString(5, employee.getImageEmployee());
            ps.setDate(6, new java.sql.Date(employee.getBirthdayEmployee().getTime()));
            ps.setString(7, employee.getGenderEmployee());
            ps.setString(8, employee.getPositionEmployee());
            ps.setDate(9, new java.sql.Date(employee.getHireDateEmployee().getTime()));
            ps.setFloat(10, employee.getSalaryEmployee());

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
            ps.setString(3, employee.getEmailEmployee());
            ps.setString(4, employee.getPhoneEmployee());
            ps.setString(5, employee.getImageEmployee());
            ps.setDate(6, employee.getBirthdayEmployee());
            ps.setString(7, employee.getGenderEmployee());
            ps.setString(8, employee.getPositionEmployee());
            ps.setDate(9, employee.getHireDateEmployee());
            ps.setFloat(10, employee.getSalaryEmployee());
            ps.setInt(11, employee.getIdEmployee());

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
