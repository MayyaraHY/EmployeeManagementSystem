package tn.services;

import tn.interfaces.InterfaceCRUD;
import tn.models.Employees;
import tn.models.Vacation;
import tn.util.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacationService implements InterfaceCRUD<Vacation> {
    Connection cnx = Connexion.getInstance().getCnx();

    EmployeeService employeeService = new EmployeeService();

    @Override
    public void add(Vacation vacation) {
        String sql = "INSERT INTO vacation (idEmployee, startDate, endDate, reason, descriptionVac) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setInt(1, vacation.getIdEmployee());
            ps.setDate(2, vacation.getStartDate());
            ps.setDate(3, vacation.getEndDate());
            ps.setString(4, vacation.getReason());
            ps.setString(5, vacation.getDescriptionVac());
            ps.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Vacation vacation) {
        String sql = "UPDATE vacation SET idEmployee = ?, startDate = ?, endDate = ?, reason = ?, descriptionVac = ? WHERE idVac = ?";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setInt(1, vacation.getIdEmployee());
            ps.setDate(2, vacation.getStartDate());
            ps.setDate(3, vacation.getEndDate());
            ps.setString(4, vacation.getReason());
            ps.setString(5, vacation.getDescriptionVac());
            ps.setInt(6, vacation.getIdVac());
            ps.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(int idVac) {
        try{
        String sql = "DELETE FROM vacation WHERE idVac = ?";
         PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, idVac);
            ps.executeUpdate();
        }catch (SQLException exp) {
            // Print any SQL exceptions
            exp.printStackTrace();
        }
    }

    public List<Vacation> getAllVacations() {
        List<Vacation> vacations = new ArrayList<>();
        String sql = "SELECT * FROM vacation";
        try (PreparedStatement stmt = cnx.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Vacation vacation = new Vacation(
                        rs.getInt("idVac"),
                        rs.getInt("idEmployee"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate"),
                        rs.getString("reason"),
                        rs.getString("descriptionVac")
                );
                vacations.add(vacation);
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching vacations: " + e.getMessage());
            e.printStackTrace();
        }
        return vacations;
    }
    public Vacation getVacationById(int idVac) {
        Vacation vacation = null;
        String sql = "SELECT * FROM vacation WHERE idVac = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            stmt.setInt(1, idVac);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vacation = new Vacation(
                            rs.getInt("idVac"),
                            rs.getInt("idEmployee"),
                            rs.getDate("startDate"),
                            rs.getDate("endDate"),
                            rs.getString("reason"),
                            rs.getString("descriptionVac")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching vacation by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return vacation;
    }
    public List<Vacation> getVacationsByEmployeeId(int idEmployee) {
        List<Vacation> vacations = new ArrayList<>();

        try {
            // SQL query to select vacations based on idEmployee
            String sql = "SELECT * FROM Vacation WHERE idEmployee = ?";
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, idEmployee);

            ResultSet resultSet = statement.executeQuery();

            // Iterate through the result set and create Vacation objects
            while (resultSet.next()) {
                Vacation vacation = new Vacation();
                vacation.setIdVac(resultSet.getInt("idVac"));
                vacation.setIdEmployee(resultSet.getInt("idEmployee"));
                vacation.setStartDate(resultSet.getDate("startDate"));
                vacation.setEndDate(resultSet.getDate("endDate"));
                vacation.setReason(resultSet.getString("reason"));
                vacation.setDescriptionVac(resultSet.getString("descriptionVac"));

                // Add each vacation to the list
                vacations.add(vacation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching vacations: " + e.getMessage());
        }

        return vacations;
    }

    public void addVacationByCIN(String cin, Vacation vacation) {
        try {
            // Get the employee by CIN
            Employees employee = employeeService.getEmployeeByCIN(cin);

            // If employee exists, add the vacation
            if (employee != null) {
                vacation.setIdEmployee(employee.getIdEmployee()); // Set the employee ID in vacation
                add(vacation); // Add vacation
                System.out.println("Vacation added successfully for employee with CIN: " + cin);
            } else {
                System.out.println("No employee found with CIN: " + cin);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error adding vacation by CIN: " + e.getMessage());
        }
    }




}
