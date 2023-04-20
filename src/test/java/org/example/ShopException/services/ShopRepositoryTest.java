package org.example.ShopException.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ShopRepositoryTest {

    @Test
    public void testProductExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Carrot", 75);
        Product product2 = new Product(2, "Pear", 100);
        Product product3 = new Product(3, "Melon", 125);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(3);
        Product[] expected = {product1, product2};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testProductNotExist() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Молоко", 120);
        Product product3 = new Product(3, "Кофе", 400);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(5)
        );
    }
}