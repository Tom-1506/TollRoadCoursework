public class Truck extends Vehicle //inherits from vehicle
{
    //specific variable for truck that determines price at toll road
    private int numberOfTrailers;

    /*constructor that calls super class constructor then sets
    the specific variable for this class: "numberOfTrailers"*/
    public Truck(String regPlate, String make, int numberOfTrailers)
    {
        this.regPlate = regPlate;
        this.make = make;
        this.numberOfTrailers = numberOfTrailers;
    }

    //Overrides method from super class
    public int calculateBasicTripCost()
    {
        if(numberOfTrailers == 1)
        { //if the truck has 1 trailer, cost is £12.50
            return 1250;
        }
        else
        { //any more than 1 trailer, cost is £15
            return 1500;
        }
    }

    //Accessor for numberOfTrailers
    public int getTrailers()
    {
        return numberOfTrailers;
    }

    //main method used as test harness
    public static void main(String[] args)
    {
        //make two trucks that cover both costs for testing
        Truck truck = new Truck("wk65eza", "Ford",1);
        Truck biggerTruck = new Truck("wk66eza", "Ford", 2);

        //test class methods using both trucks
        System.out.println("Regular Truck");
        System.out.println("*********************");
        System.out.println(truck.getReg());
        System.out.println(truck.getMake());
        System.out.println(truck.getTrailers());
        System.out.println(truck.calculateBasicTripCost());
        System.out.println("");

        System.out.println("Bigger Truck");
        System.out.println("*********************");
        System.out.println(biggerTruck.getReg());
        System.out.println(biggerTruck.getMake());
        System.out.println(biggerTruck.getTrailers());
        System.out.println(biggerTruck.calculateBasicTripCost());
        System.out.println("");
    }
}
