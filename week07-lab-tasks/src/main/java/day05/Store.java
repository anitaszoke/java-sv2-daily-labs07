package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product productSold) {
        if (productSold.getDateOfSell().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Out of date.");
        } else {
            products.add(productSold);
        }
    }

    public Path writeProductListByMonth(Month month, Path dir) {
        Path path = Paths.get(dir + "\\" + month.name() + ".csv");
        writeFile(path, sortProductsByMonth(month));
        return path;
    }

    private List<String> sortProductsByMonth(Month month) {
        List<String> productsSoldInMonth = new ArrayList<>();
        for (Product actual : products) {
            if (actual.getDateOfSell().getMonth() == month) {
                productsSoldInMonth.add(getProductData(actual));
            }
        }
        return productsSoldInMonth;
    }

    private void writeFile(Path path, List<String> data) {
        try {
            Files.write(path, data);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot write file.", ioe);
        }
    }

    private String getProductData(Product product) {
        return product.getProductName() + ";" + String.valueOf(product.getDateOfSell()) + ";" + product.getPrice();
    }
}