package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTypesTest {
    private IngredientType ingredientType;

    public IngredientParameterizedTypesTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[] ingredientsData() {
        return IngredientType.values();
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, "", 0);
        MatcherAssert.assertThat("Тип ингредиента не корректен", ingredientType, allOf(notNullValue(), equalTo(ingredient.getType())));
    }
}