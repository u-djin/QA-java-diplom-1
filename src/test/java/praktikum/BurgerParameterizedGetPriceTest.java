package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerParameterizedGetPriceTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    float bunPrice, ingredientPrice, expectedPrice;
    int ingredientsCount;

    public BurgerParameterizedGetPriceTest(float bunPrice, float ingredientPrice, int ingredientsCount, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredientsCount = ingredientsCount;
        this.expectedPrice = expectedPrice;
    }

    Burger burger = new Burger();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {15, 40, 1, 70},
                {15, 40, 3, 150},
                {7, 19, 4, 90}
        };
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        for (int i = 0; i < ingredientsCount; i++) {
            burger.addIngredient(new Ingredient(IngredientType.values()[0], "ingredientForTest", ingredientPrice));
        }
        assertEquals("Цены не совпадают", expectedPrice, burger.getPrice(), 1E-10f);
    }
}