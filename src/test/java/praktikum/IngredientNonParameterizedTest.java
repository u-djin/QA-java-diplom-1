package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

public class IngredientNonParameterizedTest {
    Random random = new Random();

    private float randomAttribute = random.nextInt(100) + random.nextFloat();
    private String randomName = "anyName" + randomAttribute;
    private float randomPrice = randomAttribute;
    private IngredientType ingredientType;

    Ingredient ingredient = new Ingredient(ingredientType, randomName, randomPrice);

    @Test
    public void getNameTest() {
        assertEquals("Имена не совпадают", randomName, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Цены не совпадают", randomPrice, ingredient.getPrice(), 1E-10f);
    }
}