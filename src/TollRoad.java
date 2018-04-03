import java.util.ArrayList; //import so I can use ArrayList

public class TollRoad
{
    /*define variables for TollRoad object, an ArrayList of CustomerAccounts
    and integer moneyMade*/
    private ArrayList<CustomerAccount> customerArray =
            new ArrayList<CustomerAccount>();
    private int moneyMade = 0;

    //default empty constructor
    public TollRoad(){}

    //method that adds a CustomerAccount to the ArrayList for this toll road
    public void addCustomer(CustomerAccount newCustomer)
    {
        this.customerArray.add(newCustomer);
    }

    /*method that searches the ArrayList of this toll road for a customer
    account based on their regPlate, throws an exception if there is
    no customer with that regPlate in the ArrayList*/
    public CustomerAccount findCustomer(String regPlate)
                                        throws CustomerNotFoundException
    {
        //loop through the array and compare regPlates to find customer
        for (int i = 0; i < customerArray.size(); i++)
        {
            if (customerArray.get(i).getVehicle().getReg().equals(regPlate))
            {
                return customerArray.get(i);
            }
        }
        throw new CustomerNotFoundException();
    }

    /*method uses the findCustomer method to get a customer from the ArrayList
    and then uses the makeTrip method of CustomerAccount to charge the
    customer for passing the toll road. It then adds this to the moneyMade
    integer to tally how much money the toll road has collected*/
    public void chargeCustomer(String regPlate)
            throws CustomerNotFoundException,
            InsufficientAccountBalanceException
    {
        CustomerAccount chargedCustomer = findCustomer(regPlate);
        moneyMade += chargedCustomer.makeTrip();
    }

    //Accessor method for the ArrayList customerArray
    public ArrayList getCustomerArray()
    {
        return customerArray;
    }

    //Accessor method for the moneyMade variable
    public int getMoneyMade()
    {
        return moneyMade;
    }

    //main method used as test harness
    public static void main(String[] args)
    {
        //create TollRoad object called road
        TollRoad road = new TollRoad();

        /*make cars and customers (this is the same as the CustomerAccount
        test harness*/
        Car car1 = new Car("aaaaaaa", "Ford",5);
        Car car2 = new Car("bbbbbbb", "Ford",5);

        CustomerAccount tom = new CustomerAccount("Tom",
                "Mcloughlin",
                car1,
                10000);

        CustomerAccount matt = new CustomerAccount("Matthew",
                "Mcloughlin",
                car2,
                10000);

        //add each customer to the TollRoad
        road.addCustomer(tom);
        road.addCustomer(matt);

        //test findCustomer method, should return "Matthew"
        try
        {
            System.out.println(road
                    .findCustomer("bbbbbbb").getFirstName());
        }
        catch(CustomerNotFoundException e)
        {
            System.out.println("not found");
        }

        //testing finding customer that doesnt exist, should return "not found"
        try
        {
            System.out.println(road.findCustomer("c").getFirstName());
        }
        catch(CustomerNotFoundException e)
        {
            System.out.println("not found");
        }
    }
}
