package tn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

            //parametre DB
    static final String URL ="jdbc:mysql://localhost:3306/complexpilote";
    static final String USER = "root";
    static final String PWD ="";

            //var
    private Connection cnx;
    static Connexion instance;

    public Connexion() {
        try{
            cnx = DriverManager.getConnection(URL,USER,PWD);
            System.out.println("Connection established");
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public Connection getCnx(){
        return cnx;
    }

    public static Connexion getInstance(){
        if (instance == null)
            instance = new Connexion();
        return instance;
    }
}




