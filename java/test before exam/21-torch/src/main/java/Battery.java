public class Battery {

    //add the attributes for class Battery
    private double electricQuality;
    private double ConsumptionRate;
    private double ProductionRate;

    //No Parameter Constructor
    //set the attributes with default value
    public Battery(){
        electricQuality = 0;
        ConsumptionRate = 0.1;
        ProductionRate = 0.2;
    }

    public Battery(double cRate,double rRate){
        electricQuality = 0;
        ConsumptionRate = rRate;
        ProductionRate = cRate;
    }

    public double getConsumptionRate(){
        return ConsumptionRate;
    }

    public double getProductionRate(){
        return ProductionRate;
    }
    public double getElectricQuality(){
        return electricQuality;
    }


    //冲 p 电量
    //charge power which amount is p
    public void chargeBattery(double p){
        if (electricQuality + p > 1) {
            electricQuality = 1;
        } else {
            electricQuality += p;
        }
    }
    //如果剩余电量》=p，使用 p电量，返回true，否则剩余电量=0，返回false
    //if the remaining power amount is larger than p, consume the p power and return true;
    //else the remaining power become 0 and return false;
    public boolean useBattery(double p){
        if(electricQuality >= p) {
            electricQuality -= p;
            return true;
        } else {
            electricQuality = 0;
            return false;
        }
    }

}
