package tn.models;

import java.sql.Date;

public class Reservation {
    private int idReservation;
    private int idEmployee;
    private int idRoom;
    private int idMateriel;
    private Date startReservation;
    private Date endReservation;
    private String nameReservee;
    private String descriptionReservation;

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public Date getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(Date startReservation) {
        this.startReservation = startReservation;
    }

    public Date getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(Date endReservation) {
        this.endReservation = endReservation;
    }

    public String getNameReservee() {
        return nameReservee;
    }

    public void setNameReservee(String nameReservee) {
        this.nameReservee = nameReservee;
    }

    public String getDescriptionReservation() {
        return descriptionReservation;
    }

    public void setDescriptionReservation(String descriptionReservation) {
        this.descriptionReservation = descriptionReservation;
    }

    public Reservation() {
    }

    public Reservation(int idReservation, int idEmployee, int idRoom, int idMateriel, Date startReservation, Date endReservation, String nameReservee, String descriptionReservation) {
        this.idReservation = idReservation;
        this.idEmployee = idEmployee;
        this.idRoom = idRoom;
        this.idMateriel = idMateriel;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.nameReservee = nameReservee;
        this.descriptionReservation = descriptionReservation;
    }

    public Reservation(int idEmployee, int idMateriel, Date startReservation, Date endReservation, String nameReservee, String descriptionReservation) {
        this.idEmployee = idEmployee;
        this.idMateriel = idMateriel;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.nameReservee = nameReservee;
        this.descriptionReservation = descriptionReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", idEmployee=" + idEmployee +
                ", idRoom=" + idRoom +
                ", idMateriel=" + idMateriel +
                ", startReservation=" + startReservation +
                ", endReservation=" + endReservation +
                ", nameReservee='" + nameReservee + '\'' +
                ", descriptionReservation='" + descriptionReservation + '\'' +
                '}';
    }
}
