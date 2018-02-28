public class Van extends Vehicle
{
    private int payload;

    public Van(String regPlate, String make, int payload)
    {
        this.regPlate = regPlate;
        this.make = make;
        this.payload = payload;
    }

    public int calculateBasicTripCost()
    {
        if(payload <= 600)
        {
            return 500;
        }
        if(payload <= 800 && payload > 600)
        {
            return 750;
        }
        else
        {
            return 1000;
        }
    }

    public int getPayload()
    {
        return payload;
    }

    public void setPayload()
    {
        this.payload = payload;
    }

    public static void main(String[] args)
    {
        Van van = new Van("wk65eza", "Ford",500);
        Van biggerVan = new Van("wk66eza", "Ford", 800);
        Van evenBiggerVan = new Van("wk67eza", "Ford", 1000);

        System.out.println("Regular Van");
        System.out.println("*********************");
        System.out.println(van.getReg());
        System.out.println(van.getMake());
        System.out.println(van.getPayload());
        System.out.println(van.calculateBasicTripCost());
        System.out.println("");

        System.out.println("Bigger Van");
        System.out.println("*********************");
        System.out.println(biggerVan.getReg());
        System.out.println(biggerVan.getMake());
        System.out.println(biggerVan.getPayload());
        System.out.println(biggerVan.calculateBasicTripCost());
        System.out.println("");

        System.out.println("Even Bigger Van");
        System.out.println("*********************");
        System.out.println(evenBiggerVan.getReg());
        System.out.println(evenBiggerVan.getMake());
        System.out.println(evenBiggerVan.getPayload());
        System.out.println(evenBiggerVan.calculateBasicTripCost());
        System.out.println("");
    }
}
