package views;

import controller.ProductManagerArrayList;
import model.Product;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagerArrayList productList = new ProductManagerArrayList();
        Product product1 = new Product(1, "Pepsi Chanh", 12000);
        Product product2 = new Product(2, "Coca Cola", 10000);
        Product product3 = new Product(3, "Red Bull", 13000);
        Product product4 = new Product(4, "Sting Vàng", 11000);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);


        while (true) {
            System.out.println("""
				\nMenu:
				    1. Add new product
					2. Edit product information
					3. Delete a product
					4. Show product list
					5. Search product by name
					6. Sort products by ascending price
					7. Sort products by descending price
					0. Exit
				""");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Adding new product:");
                    productList.addNewProduct();
                    break;
                case 2:
                    System.out.println("Editing product:");
                    productList.editProduct();
                    break;
                case 3:
                    System.out.println("Deleted product:");
                    productList.removeProduct();
                    break;
                case 4:
                    System.out.println("Products list:");
                    productList.sortByDefault();
                    productList.displayProductsList();
                    break;
                case 5:
                    System.out.println("Searching product:");
                    productList.searchProduct();

                    break;
                case 6:
                    System.out.println("Sort products by ascending price:");
                    productList.sortByAscPrice();
                    break;
                case 7:
                    System.out.println("Sort products by descending price:");
                    productList.sortByDscPrice();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
