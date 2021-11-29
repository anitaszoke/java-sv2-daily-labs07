package day05;

import java.time.LocalDate;

public class Product {
    private final String productName;
    private final LocalDate dateOfSell;
    private final int price;

    public Product(String productName, LocalDate dateOfSell, int price) {
        this.productName = productName;
        this.dateOfSell = dateOfSell;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDate getDateOfSell() {
        return dateOfSell;
    }

    public int getPrice() {
        return price;
    }
}
