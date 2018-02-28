public class Truck extends Vehicle
{
    private int numberOfTrailers;

    public Truck(String regPlate, String make, int numberOfTrailers)
    {
        this.regPlate = regPlate;
        this.make = make;
        this.numberOfTrailers = numberOfTrailers;
    }

    public int calculateBasicTripCost()
    {
        if(numberOfTrailers == 1)
        {
            return 1250;
        }
        else
        {
            return 1500;
        }
    }

    public int getTrailers()
    {
        return numberOfTrailers;
    }

    public void setNumberOfTrailers()
    {
        this.numberOfTrailers = numberOfTrailers;
    }

    public static void main(String[] args)
    {
        Truck truck = new Truck("wk65eza", "Ford",1);
        Truck biggerTruck = new Truck("wk66eza", "Ford", 2);

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
