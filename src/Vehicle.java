public abstract class Vehicle
{
    protected String regPlate;
    protected String make;

    public Vehicle(){}

    public Vehicle(String regPlate, String make)
    {
        this.regPlate = regPlate;
        this.make = make;
    }

    public abstract int calculateBasicTripCost();

    public String getReg()
    {
        return regPlate;
    }

    public String getMake()
    {
        return make;
    }

    public void setReg(String regPlate)
    {
        this.regPlate = regPlate;
    }

    public void setMake(String make)
    {
        this.make = make;
    }
}
