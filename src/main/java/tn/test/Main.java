package tn.test;


import tn.models.Employees;
import tn.services.EmployeeService;
import tn.util.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;




public class Main {
    public static void main(String[] args) {
        Connection cnx = Connexion.getInstance().getCnx();

        EmployeeService employeeService = new EmployeeService();


        try {
            // Initialize the SimpleDateFormat with the correct date format
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilBirthDate = sdf.parse("10/10/2015");
            java.util.Date utilHireDate = sdf.parse("10/10/2020");

            // Convert java.util.Date to java.sql.Date
            Date sqlBirthDate = new Date(utilBirthDate.getTime());
            Date sqlHireDate = new Date(utilHireDate.getTime());

            // Initialize Employee object with the correct types
           /* Employees emp = new Employees(
                    "bla",                   // nameEmployee (String)
                    "blob",                  // lastNameEmployee (String)
                    "nvnre",                 // emailEmployee (String)
                    "12345678",              // phoneEmployee (String)
                    "image",                 // imageEmployee (String)
                    sqlBirthDate,            // birthdayEmployee (java.sql.Date)
                    "male",                  // genderEmployee (String)
                    "accounting",            // positionEmployee (String)
                    sqlHireDate,             // hireDateEmployee (java.sql.Date)
                    200.0f                 // salaryEmployee (float)

            );
*/
            //employeeService.add(emp);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        //employeeService.remove(3);



    }
}