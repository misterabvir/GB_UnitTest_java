package HM1.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        Shop shop = new Shop();
        int amountOfProducts = 100;
        List<Product> createdProducts = createProducts(amountOfProducts);
        shop.setProducts(createdProducts);

        // products in the store must exist and must be equal 'amountOfProducts'
        assertThat(shop.getProducts().size())
                .isNotEqualTo(0)
                .isEqualTo(amountOfProducts)
                .isEqualTo(createdProducts.size());

        // products in shop must be contains in created list of products
        assertThat(createdProducts.containsAll(shop.getProducts()))
                .isTrue();

        List<Product> sorted = shop.sortProductsByPrice();
        // sorted products in the store must exist and must be equal 'amountOfProducts'
        assertThat(sorted.size())
                .isNotEqualTo(0)
                .isEqualTo(amountOfProducts)
                .isEqualTo(createdProducts.size())
                .isEqualTo(shop.getProducts().size());

        // sorted products in shop must be contains in the created list of products
        assertThat(createdProducts.containsAll(sorted))
                .isTrue();

        int maxPrice = getMaxPrice(createdProducts);

        // cost in mostExpensiveProduct must be equal maxPrice
        assertThat(shop.getMostExpensiveProduct().getCost())
                .isEqualTo(maxPrice);

        for (int i = 0; i < amountOfProducts - 1; i++) {
            // in sorted goods, the price of each item must be less than or equal to the next item
            assertThat(sorted.get(i).getCost() <= sorted.get(i + 1).getCost())
                    .isTrue();
        }
    }

    private static int getMaxPrice(List<Product> products) {
        int max = 0;
        for (int i = 0; i < products.size(); i++) {
            if(max <= products.get(i).getCost()) {
                max = products.get(i).getCost();
            }
        }
        return max;
    }

    private static List<Product> createProducts(int length) {
        List<Product> products = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            Product product = new Product();
            product.setTitle("Product_" + rand.nextInt());
            product.setCost(rand.nextInt(500, 1000));
            products.add(product);
        }
        return products;
    }
}