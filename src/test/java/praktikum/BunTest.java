package praktikum;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    private String bunName = "BunName";
    private float bunPrice = 30;
    private Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getName() {
        assertEquals (bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals (bunPrice, bun.getPrice(), 0);
    }

}