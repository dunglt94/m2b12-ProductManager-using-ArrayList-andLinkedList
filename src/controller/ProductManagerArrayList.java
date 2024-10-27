package controller;

import model.Product;

import java.util.*;

public class ProductManagerArrayList implements ProductManager{
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Product> productList;

    public ProductManagerArrayList() {
        productList = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    public void addNewProduct() {
        Product newProduct = new Product();
        boolean found;
        do {
            found = false;
            System.out.print("Enter product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Product product : productList) {
                if (product.getId() == id) {
                    System.out.println("A product with Id " + id + " already exists!");
                    System.out.println("Please try again!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                newProduct.setId(id);
                inputProductInformation(newProduct);
                productList.add(newProduct);
                System.out.println("Added new product with Id " + id + " successfully!");
            }
        } while (found);

    }

    @Override
    public void editProduct() {
        boolean found = false;
        do {
            System.out.print("Enter product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Product product : productList) {
                if (product.getId() == id) {
                    inputProductInformation(product);
                    System.out.println("Edited product with Id " + id + " successfully!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No product with Id " + id + ". Please try again.");
            }
        } while (!found);
    }

    private void inputProductInformation(Product product) {
        System.out.print("Enter product name: ");
        product.setName(scanner.nextLine());
        System.out.print("Enter product price: ");
        product.setPrice(scanner.nextInt());
        scanner.nextLine();
    }

    @Override
    public void removeProduct() {
        boolean isValidId = false;
        do {
            System.out.print("Enter product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            for (Product product : productList) {
                if (product.getId() == id) {
                    productList.remove(product);
                    System.out.println("Removed product with Id " + id + " successfully!");
                    isValidId = true;
                    break;
                }
            }
            if (!isValidId) {
                System.out.println("No product with Id " + id + ". Please try again.");
            }

        } while (!isValidId);
    }

    public boolean isValidId(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayProductsList() {
        if (productList.isEmpty()) {
            System.out.println("There is no products in the database!");
        } else {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }

    public void searchProduct() {
        boolean foundProduct = false;
        do {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            for (Product product : productList) {
                if (product.getName().equals(productName)) {
                    System.out.println(product);
                    foundProduct = true;
                }
            }
            if (!foundProduct) {
                System.out.println("No product with name " + productName + ". Please try again.");
            }
        } while (!foundProduct);

    }

    @Override
    public void sortByDefault() {
        Comparator<Product> sortByDefault = new Comparator<>() {
            public int compare(Product o1, Product o2){
                return o1.getId() - o2.getId();
            }
        };
        productList.sort(sortByDefault);
    }

    @Override
    public void sortByAscPrice() {
        Comparator<Product> sortByAscPrice = new Comparator<>() {
            public int compare(Product o1, Product o2){
                return o1.getPrice() - o2.getPrice();
            }
        };
        productList.sort(sortByAscPrice);
        displayProductsList();
    }

    @Override
    public void sortByDscPrice() {
        Comparator<Product> sortByDscPrice = new Comparator<>() {
            public int compare(Product o1, Product o2){
                return o2.getPrice() - o1.getPrice();
            }
        };
        productList.sort(sortByDscPrice);
        displayProductsList();
    }


}
