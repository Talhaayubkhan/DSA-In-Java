public class Question3 {
    public static void main(String[] args) {
            final Car car = new ElectricCar();
            System.out.println(car.drive());
    }
}


class Automobile{
    private String drive(){
        return "Driving Car ";           
    }
}

class car extends Automobile {
    protected String drive(){
        return "Driving Car ";  
    }
}
public class ElectricCar extends car {
    public final String drive() {
        return "Driving Electric Car ";
    }
}
