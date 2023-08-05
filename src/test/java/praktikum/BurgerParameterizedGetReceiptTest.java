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
public class BurgerParameterizedGetReceiptTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    String bunName, ingredientName, expectedReceipt;
    int ingredientsCount;

    public BurgerParameterizedGetReceiptTest(String bunName, String ingredientName, String expectedReceipt, int ingredientsCount) {
        this.bunName = bunName;
        this.ingredientName = ingredientName;
        this.expectedReceipt = expectedReceipt;
        this.ingredientsCount = ingredientsCount;
    }

    Burger burger = new Burger();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        // шаблон рецепта в виде строки
        String receiptTemplate = "(==== %s ====)%n%s(==== %s ====)%n%nPrice: 0.000000%n";

        return new Object[][]{
                {"buuun", "inrrrredient", receiptTemplate, 1},
                {"BUN", "INGREDIENT", receiptTemplate, 3},
        };
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        String ingredientReceipt = "";
        for (int i = 0; i < ingredientsCount; i++) {
            burger.addIngredient(new Ingredient(IngredientType.values()[0], ingredientName, 0));
            // формируется содержимое бургера в виде строки для последующей вставки в шаблон рецепта
            ingredientReceipt += String.format("= %s %s =%n", IngredientType.values()[0].toString().toLowerCase(), ingredientName);
        }
        // конечный рецепт
        expectedReceipt = String.format(expectedReceipt, bunName, ingredientReceipt, bunName);
        assertEquals("Рецепты не совпадают", expectedReceipt, burger.getReceipt());
    }
}