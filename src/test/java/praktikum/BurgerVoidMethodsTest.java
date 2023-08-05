package praktikum;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BurgerVoidMethodsTest {
    // объекты создаются, чтобы в тестах были определённые значения, а не null (иначе пропадает смысл тестов)
    Bun bun = new Bun("", 0);
    Ingredient ingredient1 = new Ingredient(IngredientType.values()[0],"",0);
    Ingredient ingredient2 = new Ingredient(IngredientType.values()[0],"",0);
    private List<Ingredient> ingredients = new ArrayList<>();
    Burger burger = new Burger();

    @Before
    // так как проверяются методы, работающие со списком, то в него добавляется начальный элемент, имитирующий работу с реальным списком
    public void init() {
        burger.ingredients.clear();
        burger.ingredients.add(ingredient1);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient2);
        assertEquals(ingredient2, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientTest() {
        burger.ingredients.add(ingredient2);
        burger.removeIngredient(0);
        // проверяется, что удалён определённый элемент, а не весь список
        assertFalse(burger.ingredients.contains(ingredient1));
        assertTrue(burger.ingredients.contains(ingredient2));
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }
}