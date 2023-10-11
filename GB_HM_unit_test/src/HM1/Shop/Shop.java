package HM1.Shop;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // i don't want to sort the original list so i used this
        List<Product> copy = products.stream().collect(Collectors.toList());
        copy.sort(Comparator.comparingDouble(Product::getCost));
        return copy;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // yeah, i know, this is cheat
        // i used algorithm search max price in ShopTest,
        // but here i don't wanna write this again
        List<Product> sorted = sortProductsByPrice();
        return sorted.get(sorted.size() - 1);
    }
}