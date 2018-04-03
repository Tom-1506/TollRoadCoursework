public abstract class Vehicle
{
    /*initialise variables for the number plate and manufacturer of the
    vehicle, named regPlate and make respectively*/
    protected String regPlate;
    protected String make;

    public Vehicle(){} // empty constructor

    //constructor sets the values of regPlate and make from String inputs
    public Vehicle(String regPlate, String make)
    {
        this.regPlate = regPlate;
        this.make = make;
    }

    /*abstract method to be overridden in subclasses so we can add more
    functionality specific to those sub classes*/
    public abstract int calculateBasicTripCost();

    //Overriding toString for the vehicle object
    @Override
    public String toString()
    {
        return "Registration: " + regPlate + "  |  Manufacturer: " + make;
    }

    //Accessor for regPlate
    public String getReg()
    {
        return regPlate;
    }

    //Accessor for make
    public String getMake()
    {
        return make;
    }
}
