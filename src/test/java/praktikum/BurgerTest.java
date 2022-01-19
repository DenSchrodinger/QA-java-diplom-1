package praktikum;

import org.junit.Test;
import org.mockito.Mock;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    @Mock
    private Ingredient ingredientMock;
    @Mock
    private Bun bunMock;

    private void ingredientMockCount(int count) {
        for (int i = 1; i <= count; i++) {
            ingredientMock.price = i;
            burger.addIngredient(ingredientMock);
        }
    }

    @Test
    public void addIngredientTest() {
        ingredientMockCount(3);
        int expected = 3;
        Assert.assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        ingredientMockCount(3);
        burger.removeIngredient(0);
        int sizeExpected = 2;
        int priceExpected = 3;
        Assert.assertEquals(sizeExpected, burger.ingredients.size());
        Assert.assertEquals(priceExpected, burger.ingredients.get(0).price, 0);
    }

    @Test
    public void moveIngredientTest() {
        ingredientMockCount(3);
        int index = 0;
        int newIndex = 2;
        int expected = 3;
        burger.moveIngredient(index, newIndex);
        Assert.assertEquals(expected, burger.ingredients.get(2).price, 0);
    }

    @Test
    public void getPriceTest() {
        ingredientMockCount(2);
        float expected = 20;
        when(bunMock.getPrice()).thenReturn(4f);
        burger.setBuns(bunMock);
        when(ingredientMock.getPrice()).thenReturn(6f);
        Assert.assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Database database = new Database();
        burger.setBuns(bunMock);
        for(int i = 1; i <= 2; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        String name = database.availableIngredients().get(1).getName();
        String secondName = database.availableIngredients().get(2).getName();
        when(bunMock.getName()).thenReturn("Тесто");
        assertTrue(burger.getReceipt().contains("Тесто")
                &burger.getReceipt().contains(name)
                &burger.getReceipt().contains(secondName));
    }

}