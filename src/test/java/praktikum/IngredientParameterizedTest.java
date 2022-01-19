package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "dinosaur", 200},
        };
    }

    @Test
    public void getPrice() {
        Ingredient firstIngredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, firstIngredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Ingredient secondIngredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, secondIngredient.getName());
    }

    @Test
    public void getType() {
        Ingredient thirdIngredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, thirdIngredient.getType());
    }
}