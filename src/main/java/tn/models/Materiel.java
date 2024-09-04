package tn.models;

public class Materiel {
    private int idMateriel;
    private String nameMateriel;
    private String imageMateriel;
    private int quantiteMateriel;

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getNameMateriel() {
        return nameMateriel;
    }

    public void setNameMateriel(String nameMateriel) {
        this.nameMateriel = nameMateriel;
    }

    public String getImageMateriel() {
        return imageMateriel;
    }

    public void setImageMateriel(String imageMateriel) {
        this.imageMateriel = imageMateriel;
    }

    public int getQuantiteMateriel() {
        return quantiteMateriel;
    }

    public void setQuantiteMateriel(int quantiteMateriel) {
        this.quantiteMateriel = quantiteMateriel;
    }

    public Materiel() {
    }

    public Materiel(int idMateriel, String nameMateriel, String imageMateriel, int quantiteMateriel) {
        this.idMateriel = idMateriel;
        this.nameMateriel = nameMateriel;
        this.imageMateriel = imageMateriel;
        this.quantiteMateriel = quantiteMateriel;
    }

    public Materiel(String nameMateriel, String imageMateriel, int quantiteMateriel) {
        this.nameMateriel = nameMateriel;
        this.imageMateriel = imageMateriel;
        this.quantiteMateriel = quantiteMateriel;
    }

    @Override
    public String toString() {
        return "Materiel{" +
                "idMateriel=" + idMateriel +
                ", nameMateriel='" + nameMateriel + '\'' +
                ", imageMateriel='" + imageMateriel + '\'' +
                ", quantiteMateriel=" + quantiteMateriel +
                '}';
    }
}
