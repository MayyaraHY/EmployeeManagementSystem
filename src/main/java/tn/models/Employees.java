package tn.models;

import java.sql.Date;

public class Employees {


  private int idEmployee;
  private String nameEmployee;
  private String lastNameEmployee;
  private String CIN;
  private String emailEmployee;
  private String phoneEmployee;
  private String imageEmployee;
  private Date birthdayEmployee;
  private String genderEmployee;
  private String positionEmployee;
  private Date hireDateEmployee;
  private float salaryEmployee;


    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getLastNameEmployee() {
        return lastNameEmployee;
    }

    public void setLastNameEmployee(String lastNameEmployee) {
        this.lastNameEmployee = lastNameEmployee;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getImageEmployee() {
        return imageEmployee;
    }

    public void setImageEmployee(String imageEmployee) {
        this.imageEmployee = imageEmployee;
    }

    public Date getBirthdayEmployee() {
        return birthdayEmployee;
    }

    public void setBirthdayEmployee(Date birthdayEmployee) {
        this.birthdayEmployee = birthdayEmployee;
    }

    public String getGenderEmployee() {
        return genderEmployee;
    }

    public void setGenderEmployee(String genderEmployee) {
        this.genderEmployee = genderEmployee;
    }

    public String getPositionEmployee() {
        return positionEmployee;
    }

    public void setPositionEmployee(String positionEmployee) {
        this.positionEmployee = positionEmployee;
    }

    public Date getHireDateEmployee() {
        return hireDateEmployee;
    }

    public void setHireDateEmployee(Date hireDateEmployee) {
        this.hireDateEmployee = hireDateEmployee;
    }

    public float getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(float salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }



    public Employees(){};

    public Employees(int idEmployee, String nameEmployee, String lastNameEmployee,String CIN, String emailEmployee, String phoneEmployee, String imageEmployee, Date birthdayEmployee, String genderEmployee, String positionEmployee, Date hireDateEmployee, float salaryEmployee) {

        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.lastNameEmployee = lastNameEmployee;
        this.CIN=CIN;
        this.emailEmployee = emailEmployee;
        this.phoneEmployee = phoneEmployee;
        this.imageEmployee = imageEmployee;
        this.birthdayEmployee = birthdayEmployee;
        this.genderEmployee = genderEmployee;
        this.positionEmployee = positionEmployee;
        this.hireDateEmployee = hireDateEmployee;
        this.salaryEmployee = salaryEmployee;

    }



    public Employees(String nameEmployee, String lastNameEmployee,String CIN, String emailEmployee, String phoneEmployee, String imageEmployee, Date birthdayEmployee, String genderEmployee, String positionEmployee, Date hireDateEmployee, float salaryEmployee) {

        this.nameEmployee = nameEmployee;
        this.lastNameEmployee = lastNameEmployee;
        this.CIN = CIN;
        this.emailEmployee = emailEmployee;
        this.phoneEmployee = phoneEmployee;
        this.imageEmployee = imageEmployee;
        this.birthdayEmployee = birthdayEmployee;
        this.genderEmployee = genderEmployee;
        this.positionEmployee = positionEmployee;
        this.hireDateEmployee = hireDateEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", lastNameEmployee='" + lastNameEmployee + '\'' +
                ", CIN='" + CIN + '\'' +
                ", emailEmployee='" + emailEmployee + '\'' +
                ", phoneEmployee='" + phoneEmployee + '\'' +
                ", imageEmployee='" + imageEmployee + '\'' +
                ", birthdayEmployee=" + birthdayEmployee +
                ", genderEmployee='" + genderEmployee + '\'' +
                ", positionEmployee='" + positionEmployee + '\'' +
                ", hireDateEmployee=" + hireDateEmployee +
                ", salaryEmployee=" + salaryEmployee +
                '}';
    }
}
