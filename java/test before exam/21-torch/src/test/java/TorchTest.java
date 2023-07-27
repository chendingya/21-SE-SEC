import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TorchTest {
    @Test
    public void test1(){
        Battery battery = new Battery();
        Torch torch = new Torch(battery);
        torch.charge(2);
        assertTrue(torch.turnOn(3));
    }

    @Test
    public void test2(){
        Battery battery = new Battery();
        Torch torch = new Torch(battery);
        torch.charge(2);
        assertFalse(torch.turnOn(5));
    }

    @Test
    public void test3(){
        Battery battery = new Battery();
        Torch torch = new Torch(battery);
        torch.charge(2);
        assertTrue(torch.turnOn(4));
        torch.charge(1);
        assertFalse(torch.turnOn(5));
    }
}
