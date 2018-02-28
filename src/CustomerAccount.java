public class CustomerAccount implements Comparable
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

    public int makeTrip() throws InsufficientAccountBalanceException
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
            this.accountBalance = this.accountBalance - (int) cost;
            return (int) cost;
        }
        else
        {
            throw new InsufficientAccountBalanceException();
        }
    }

    @Override
    public int compareTo(Object other)
    {
        int compare = this.vehicle.getReg()
                        .compareTo(((CustomerAccount)other).vehicle.getReg());
        return compare;
    }

    public static void main(String[] args)
    {
        Car car = new Car("wk65eza", "Ford",5);
        CustomerAccount tom = new CustomerAccount("Tom",
                                                  "Mcloughlin",
                                                  car,
                                                  10000);
        /*
        System.out.println(tom.vehicle.getReg());
        System.out.println(tom.vehicle.getMake());
        System.out.println(((Car) tom.vehicle).getSeats());
        System.out.println(tom.accountBalance);
        System.out.println(tom.makeTrip());
        System.out.println(tom.accountBalance);

        System.out.println(tom.discountType);
        tom.activateFriendsAndFamilyDiscount();
        System.out.println(tom.discountType);
        System.out.println(tom.makeTrip());
        tom.deactivateDiscount();
        System.out.println(tom.discountType);
        System.out.println(tom.makeTrip());
        tom.activateStaffDiscount();
        System.out.println(tom.discountType);
        System.out.println(tom.makeTrip());*/
    }
}
