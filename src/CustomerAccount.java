public class CustomerAccount
{
    private String firstName;
    private String secondName;
    private Vehicle vehicle;
    private int accountBalance;
    private enum DiscountType{NONE, STAFF, FRIENDS_AND_FAMILY}
    private DiscountType discountType;

    public CustomerAccount(String firstName, String secondName, Vehicle vehicle,
                           int accountBalance)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicle = vehicle;
        this.accountBalance = accountBalance;
        this.discountType = DiscountType.NONE;
    }

    public void activateStaffDiscount()
    {
        this.discountType = DiscountType.STAFF;
    }

    public void activateFriendsAndFamilyDiscount()
    {
        if(this.discountType != DiscountType.STAFF)
        {
            this.discountType = DiscountType.FRIENDS_AND_FAMILY;
        }
        else
        {
            System.out.println("This account already has a Staff discount");
        }
    }

    public void deactivateDiscount()
    {
        this.discountType = DiscountType.NONE;
    }

    public void addFunds(int amount)
    {
        this.accountBalance += amount;
    }

    public int makeTrip()
    {
        double cost = this.vehicle.calculateBasicTripCost();

        if(this.discountType == DiscountType.STAFF)
        {
            cost = cost*0.5;
        }
        else if(this.discountType == DiscountType.FRIENDS_AND_FAMILY)
        {
            cost = cost*0.9;
        }

        if(this.accountBalance > cost)
        {
            this.accountBalance -= cost;
            return (int) cost;
        }
        else
        {
            return -1;
            //throw InsufficientFundsException;
        }
    }

    public static void main(String[] args)
    {
        Car car = new Car("wk65eza", "Ford",5);
        CustomerAccount tom = new CustomerAccount("Tom",
                                                  "Mcloughlin",
                                                  car,
                                                  1000);

        System.out.println(tom.vehicle.getReg());
        System.out.println(tom.vehicle.getMake());
    }
}
