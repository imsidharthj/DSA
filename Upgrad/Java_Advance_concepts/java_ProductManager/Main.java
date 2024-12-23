import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.function.Predicate;

public class Main {
    static class Product {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + category + ") - $" + price;
        }
    }

    static class ProductManager {
        private List<Product> products;

        public ProductManager() {
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public List<Product> getSortedProducts(Comparator<Product> comparator) {
            List<Product> sortedProducts = new ArrayList<>(products);
            sortedProducts.sort(comparator);
            return sortedProducts;
        }

        public List<Product> filterProducts(Predicate<Product> predicate) {
            List<Product> filteredProducts = new ArrayList<>();
            for (Product product : products) {
                if (predicate.test(product)) {
                    filteredProducts.add(product);
                }
            }
            return filteredProducts;
        }
    }
    
	public static void main(String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        productManager.addProduct(new Product("Laptop", "Electronics", 1200.0));
        productManager.addProduct(new Product("Book", "Education", 25.0));
        productManager.addProduct(new Product("Shirt", "Clothing", 35.0));
        productManager.addProduct(new Product("Shoes", "Clothing", 50.0));
        List<Product> sortedProducts = productManager.getSortedProducts(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Sorted by price: " + sortedProducts);
        String category = scanner.nextLine();
        List<Product> filteredProducts = productManager.filterProducts(product -> product.getCategory().equalsIgnoreCase(category));
        System.out.println("Filtered products: " + filteredProducts);
        scanner.close();
	}
}