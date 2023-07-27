import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Torch {
    //add attibutes for torch
    Battery bt;


    public Torch(Battery battery){
        bt = battery;
    }

    /**
     * 10% power consumption per hour for using a torch
     * return true if enough power
     * return false if battery cannot support for the specified hours
     */
    public boolean turnOn(int hours){
        //add code here
        if (bt.useBattery(bt.getConsumptionRate() * hours)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 20% power production per hour for charging the battery
     */
    public void charge(int hours){
        //add code here
        bt.chargeBattery(bt.getProductionRate() * hours);
    }



}
