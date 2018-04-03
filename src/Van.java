public class Van extends Vehicle //inherits from vehicle
{
    //specific variable for van that determines price at toll road
    private int payload;

    /*constructor that calls super class constructor then sets
    the specific variable for this class: "payload"*/
    public Van(String regPlate, String make, int payload)
    {
        super(regPlate, make);
        this.payload = payload;
    }

    //Overrides method from super class
    public int calculateBasicTripCost()
    {
        if(payload <= 600)
        { //if the payload is 600KG or less, toll is £5
            return 500;
        }
        if(payload <= 800 && payload > 600)
        { //if the payload is 800KG or less and greater than 600KG
          //then toll costs £7.50
            return 750;
        }
        else
        { //if the payload is greater than 800kg the toll is £10
            return 1000;
        }
    }

    //Accessor for payload
    public int getPayload()
    {
        return payload;
    }

    //main method used as test harness
    public static void main(String[] args)
    {
        //make the three types of vans to test class methods
        Van van = new Van("wk65eza", "Ford",500);
        Van biggerVan = new Van("wk66eza", "Ford", 800);
        Van evenBiggerVan = new Van("wk67eza", "Ford", 1000);

        //testing for methods for each payload size of van
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
