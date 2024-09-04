package tn.models;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String imageProduct;
    private int quantityProduct;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Product() {}

    public Product(int idProduct, String nameProduct, String imageProduct, int quantityProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.imageProduct = imageProduct;
        this.quantityProduct = quantityProduct;
    }

    public Product(String nameProduct, String imageProduct, int quantityProduct) {
        this.nameProduct = nameProduct;
        this.imageProduct = imageProduct;
        this.quantityProduct = quantityProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", imageProduct='" + imageProduct + '\'' +
                ", quantityProduct=" + quantityProduct +
                '}';
    }
}
