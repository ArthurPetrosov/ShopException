import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void testShopRepositoryException() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "carrot", 75);
        Product product2 = new Product(2, "pear", 100);
        Product product3 = new Product(3, "melon", 125);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(0);
        });
    }

    @Test
    public void testForGetter() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "carrot", 75);
        Product product2 = new Product(2, "pear", 100);
        Product product3 = new Product(3, "melon", 125);

        int[] expected = {1,2,3};
        int[] actual ={product1.getId(), product2.getId(), product3.getId()};
    }
    @Test
    public void testForFindByAll(){
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "carrot", 75);
        Product product2 = new Product(2, "pear", 100);
        Product product3 = new Product(3, "melon", 125);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product expected = product1;
        Assertions.assertEquals(expected, repo.findById(1));
    }
    @Test
    public  void testForFindAll(){
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "carrot", 75);
        Product product2 = new Product(2, "pear", 100);
        Product product3 = new Product(3, "melon", 125);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(1);
        Product[] actual3 = repo.findAll();
        Product[] expected3 = {product2, product3};
        Assertions.assertArrayEquals(actual3, expected3);
    }
}