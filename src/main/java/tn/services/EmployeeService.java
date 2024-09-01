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
        try{
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

         PreparedStatement ps = cnx.prepareStatement(req);
            // Print debug information
            System.out.println("Updating employee with ID: " + employee.getIdEmployee());
            System.out.println("Name: " + employee.getNameEmployee());
            System.out.println("Last Name: " + employee.getLastNameEmployee());
            System.out.println("CIN: " + employee.getCIN());
            System.out.println("Email: " + employee.getEmailEmployee());
            System.out.println("Phone: " + employee.getPhoneEmployee());
            System.out.println("Image URL: " + employee.getImageEmployee());
            System.out.println("Birthday: " + employee.getBirthdayEmployee());
            System.out.println("Gender: " + employee.getGenderEmployee());
            System.out.println("Position: " + employee.getPositionEmployee());
            System.out.println("Hire Date: " + employee.getHireDateEmployee());
            System.out.println("Salary: " + employee.getSalaryEmployee());


            ps.setString(1, employee.getNameEmployee());
            ps.setString(2, employee.getLastNameEmployee());
            ps.setString(3, employee.getCIN());
            ps.setString(4, employee.getEmailEmployee());
            ps.setString(5, employee.getPhoneEmployee());
            ps.setString(6, employee.getImageEmployee());
            ps.setDate(7, employee.getBirthdayEmployee());
            ps.setString(8, employee.getGenderEmployee());
            ps.setString(9, employee.getPositionEmployee());
            ps.setDate(10, employee.getHireDateEmployee());
            ps.setFloat(11, employee.getSalaryEmployee());
            ps.setInt(12, employee.getIdEmployee());

            int rowsAffected = ps.executeUpdate();

            // Check if any rows were affected
            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException sqlException) {
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

    public Employees getEmployeeById(int employeeId) {
        Employees employee = null;

        // SQL query to fetch employee by ID
        String query = "SELECT * FROM employees WHERE idEmployee = ?";

        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            // Set the employee ID in the query
            ps.setInt(1, employeeId);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Process the result set
            if (rs.next()) {
                // Create an Employee object with the retrieved data
                employee = new Employees(
                        rs.getInt("idEmployee"),
                        rs.getString("nameEmployee"),
                        rs.getString("lastNameEmployee"),
                        rs.getString("CIN"),
                        rs.getString("emailEmployee"),
                        rs.getString("phoneEmployee"),
                        rs.getString("imageEmployee"),
                        rs.getDate("birthdayEmployee"),
                        rs.getString("genderEmployee"),
                        rs.getString("positionEmployee"),
                        rs.getDate("hireDateEmployee"),
                        rs.getFloat("salaryEmployee")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception (log it or show a user-friendly message)
        }

        return employee;
    }

    public void update2(Employees employee, int id) {
        try {
            // SQL query to update an employee record
            String query = "UPDATE employees SET " +
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
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setString(1, employee.getNameEmployee());
            ps.setString(2, employee.getLastNameEmployee());
            ps.setString(3, employee.getCIN());
            ps.setString(4, employee.getEmailEmployee());
            ps.setString(5, employee.getPhoneEmployee());
            ps.setString(6, employee.getImageEmployee());
            ps.setDate(7, employee.getBirthdayEmployee());
            ps.setString(8, employee.getGenderEmployee());
            ps.setString(9, employee.getPositionEmployee());
            ps.setDate(10, employee.getHireDateEmployee());
            ps.setFloat(11, employee.getSalaryEmployee());
            ps.setInt(12, id); // Set the id for the WHERE clause

            // Execute the update statement
            int rowsAffected = ps.executeUpdate();

            // Output the result
            System.out.println("Rows affected: " + rowsAffected);
            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + id + " updated successfully.");
            } else {
                System.out.println("No employee found with ID " + id + ".");
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
