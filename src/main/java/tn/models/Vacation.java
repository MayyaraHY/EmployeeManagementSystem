package tn.models;

import java.sql.Date;

public class Vacation {
    private int idVac;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String descriptionVac;

    public int getIdVac() {
        return idVac;
    }

    public void setIdVac(int idVac) {
        this.idVac = idVac;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescriptionVac() {
        return descriptionVac;
    }

    public void setDescriptionVac(String descriptionVac) {
        this.descriptionVac = descriptionVac;
    }
    public Vacation(){}

    public Vacation(int idVac, Date startDate, Date endDate, String reason, String descriptionVac) {

        this.idVac = idVac;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.descriptionVac = descriptionVac;
    }

    public Vacation(Date startDate, Date endDate, String reason, String descriptionVac) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.descriptionVac = descriptionVac;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "idVac=" + idVac +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reason='" + reason + '\'' +
                ", descriptionVac='" + descriptionVac + '\'' +
                '}';
    }
}
