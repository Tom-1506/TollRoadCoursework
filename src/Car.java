public class Car extends Vehicle
{
    private int numberOfSeats;

    public Car(String regPlate, String make, int numberOfSeats)
    {
        this.regPlate = regPlate;
        this.make = make;
        this.numberOfSeats = numberOfSeats;
    }

    public int calculateBasicTripCost()
    {
        if(numberOfSeats <= 5)
        {
            return 500;
        }
        else
        {
            return 600;
        }
    }

    public int getSeats()
    {
        return numberOfSeats;
    }

    public void setSeats(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }

    public static void main(String[] args)
    {
        Car car = new Car("wk65eza", "Ford",5);
        Car biggerCar = new Car("wk66eza", "Ford", 6);

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
