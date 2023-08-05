package praktikum;

import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;

public class BunTest {
    Random random = new Random();

    private float randomAttribute = random.nextInt(100) + random.nextFloat();
    private String randomName = "anyName" + randomAttribute;
    private  float randomPrice = randomAttribute;

    Bun bun = new Bun(randomName, randomPrice);

    @Test
    public void getNameTest() {
        assertEquals("Имена не совпадают", randomName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цены не совпадают", randomPrice, bun.getPrice(), 1E-10f);
    }
}