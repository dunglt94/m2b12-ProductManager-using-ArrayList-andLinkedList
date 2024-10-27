package controller;

import model.Product;

import java.util.ArrayList;

public interface ProductManager {
    void add(Product product);

    void editProduct();

    void removeProduct();

    void displayProductsList();

    void searchProduct();

    void sortByDefault();

    void sortByAscPrice();

    void sortByDscPrice();
}
