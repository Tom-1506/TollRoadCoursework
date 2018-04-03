public class CustomerAccount implements Comparable
{
    //define all variables needed for a CustomerAccount object
    private String firstName;
    private String secondName;
    private Vehicle vehicle;
    private int accountBalance;
    private enum DiscountType{NONE, STAFF, FRIENDS_AND_FAMILY}
    private DiscountType discountType;

    /*constructor takes values for all variables except DiscountType and sets
    DiscountType to be NONE*/
    public CustomerAccount(String firstName, String secondName, Vehicle vehicle,
                           int accountBalance)
    {
        //set values of variables from inputs
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicle = vehicle;
        this.accountBalance = accountBalance;

        //set discount to NONE
        this.discountType = DiscountType.NONE;
    }

    //method that changes DiscountType to STAFF
    public void activateStaffDiscount()
    {
        this.discountType = DiscountType.STAFF;
    }

    //method that changes DiscountType to FRIENDS_AND_FAMILY
    public void activateFriendsAndFamilyDiscount()
    {
        /*before changing DiscountType check if there is already a STAFF
        discount, if there's already a STAFF discount then don't change
        DiscountType*/
        if(this.discountType != DiscountType.STAFF)
        {
            this.discountType = DiscountType.FRIENDS_AND_FAMILY;
        }
        else
        {
            System.out.println("This account already has a Staff discount");
        }
    }

    //method that changes DiscountType to NONE
    public void deactivateDiscount()
    {
        this.discountType = DiscountType.NONE;
    }

    //method that increases the accountBalance variable by the input amount
    public void addFunds(int amount)
    {
        this.accountBalance += amount;
    }

    /*method that calculates the cost of making a trip with a customers
    vehicle and applying any reductions in cost due to their discount.
    if the customer has enough money in their account for the trip then
    the cost is subtracted from their account balance*/
    public int makeTrip() throws InsufficientAccountBalanceException
    {
        //calculate trip cost using vehicles method
        double cost = this.vehicle.calculateBasicTripCost();

        /*check for discounts and give 50% or 90% discount for staff and
        friends and family respectively*/
        if(this.discountType == DiscountType.STAFF)
        {
            cost = cost*0.5;
        }
        else if(this.discountType == DiscountType.FRIENDS_AND_FAMILY)
        {
            cost = cost*0.9;
        }

        /*check if account balance has the required amount to pay,
        then reduce it by the cost of the trip*/
        if(this.accountBalance > cost)
        {
            this.accountBalance = this.accountBalance - (int) cost;
            return (int) cost;
        }
        else
        {
            throw new InsufficientAccountBalanceException();
        }
    }

    //Override compareTo method from implementing the comparable interface
    @Override
    public int compareTo(Object other)
    {
        /*compares by taking the regPlate of another object and
        comparing it alphabetically to this objects regPlate, returns
        if the regPlate of this object is alphabetically higher than
        the input then it returns a positive number, if they are equal
        then it returns 0 and if it's less than it returns a negative*/
        int compare = this.vehicle.getReg()
                        .compareTo(((CustomerAccount)other).vehicle.getReg());
        return compare;
    }

    //Accessor method for the firstName variable
    public String getFirstName()
    {
        return firstName;
    }

    //Accessor method for the secondName variable
    public String getSecondName()
    {
        return secondName;
    }

    //Accessor method for the Vehicle
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    //Accessor method for the accountBalance variable
    public int getAccountBalance()
    {
        return accountBalance;
    }

    //Accessor method for the discountType value
    public DiscountType getDiscountType()
    {
        return this.discountType;
    }

    //main method used as test harness
    public static void main(String[] args)
    {
        /*make 2 car objects for 2 customers, regPlates are easily seen to
        be comparable so they can be tested easily*/
        Car car1 = new Car("aaaaaaa", "Ford",5);
        Car car2 = new Car("bbbbbbb", "Ford",5);

        //Create the customerAccounts
        CustomerAccount tom = new CustomerAccount("Tom",
                                                  "Mcloughlin",
                                                  car1,
                                                  10000);

        CustomerAccount matt = new CustomerAccount("Matthew",
                                                   "Mcloughlin",
                                                   car2,
                                                   10000);

        //test comparison should return -1
        System.out.println(tom.compareTo(matt));

        //test getting vehicle, should use toString method of vehicle object
        System.out.println(tom.getVehicle());

        //test getting the discount type of an account
        System.out.println(tom.getDiscountType());

        //tests the various accessor methods for variables
        System.out.println(tom.vehicle.getReg());
        System.out.println(tom.vehicle.getMake());
        System.out.println(((Car) tom.vehicle).getSeats());

        //tests showing account balance and the difference after making a trip
        System.out.println(tom.accountBalance);
        try
        {
            System.out.println(tom.makeTrip());
        }
        catch(InsufficientAccountBalanceException e)
        {
            System.out.println("insufficient funds");
        }
        System.out.println(tom.accountBalance);

        /*testing changing discounts and making trips with the different
        discount types*/
        System.out.println(tom.discountType);
        tom.activateFriendsAndFamilyDiscount();
        System.out.println(tom.discountType);
        try
        {
            System.out.println(tom.makeTrip());
        }
        catch(InsufficientAccountBalanceException e)
        {
            System.out.println("insufficient funds");
        }
        tom.deactivateDiscount();
        System.out.println(tom.discountType);
        try
        {
            System.out.println(tom.makeTrip());
        }
        catch(InsufficientAccountBalanceException e)
        {
            System.out.println("insufficient funds");
        }
        tom.activateStaffDiscount();
        System.out.println(tom.discountType);
        try
        {
            System.out.println(tom.makeTrip());
        }
        catch(InsufficientAccountBalanceException e)
        {
            System.out.println("insufficient funds");
        }

    }
}
