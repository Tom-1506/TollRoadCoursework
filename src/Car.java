public class Car extends Vehicle //inherits from Vehicle
{
    //specific variable for car that determines price at toll road
    private int numberOfSeats;

    /*constructor that calls super class constructor then sets
    the specific variable for this class: "numberOfSeats"*/
    public Car(String regPlate, String make, int numberOfSeats)
    {
        super(regPlate, make);
        this.numberOfSeats = numberOfSeats;
    }

    //Overrides method from super class Vehicle
    public int calculateBasicTripCost()
    {
        if(numberOfSeats <= 5)
        { //if the car has 5 or less seats, toll costs £5
            return 500;
        }
        else
        { //if it has more than 5 then toll costs £6
            return 600;
        }
    }

    //Accessor for numberOfSeats
    public int getSeats()
    {
        return numberOfSeats;
    }

    //main method used as test harness
    public static void main(String[] args)
    {
        //make the two types of cars to test
        Car car = new Car("wk65eza", "Ford",5);
        Car biggerCar = new Car("wk66eza", "Ford", 6);

        //testing methods for both cars
        System.out.println("Regular Car");
        System.out.println("*********************");
        System.out.println(car.getReg());
        System.out.println(car.getMake());
        System.out.println(car.getSeats());
        System.out.println(car.calculateBasicTripCost());
        System.out.println("");

        System.out.println("Bigger Car");
        System.out.println("*********************");
        System.out.println(biggerCar.getReg());
        System.out.println(biggerCar.getMake());
        System.out.println(biggerCar.getSeats());
        System.out.println(biggerCar.calculateBasicTripCost());
        System.out.println("");
    }
}
