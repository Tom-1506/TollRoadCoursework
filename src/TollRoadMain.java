import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TollRoadMain
{
    public TollRoad initialiseTollRoadFromFile()
    {
        TollRoad newTollRoad = new TollRoad();

        String fileName = "customerData.txt";

        String line;

        try
        {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if((line = bufferedReader.readLine()) != null)
            {
                String[] inCustomerData = line.split("#");

                for(int i = 0; i < inCustomerData.length; i++)
                {
                    String[] singleCustomerData = inCustomerData[i]
                                                    .split(",");

                    /*
                    for(int j = 0; j < singleCustomerData.length; j++)
                    {
                        System.out.println(singleCustomerData[j]);
                    }
                    */

                    String vehicleType = singleCustomerData[0];
                    String regPlate = singleCustomerData[1];
                    String firstName = singleCustomerData[2];
                    String lastName = singleCustomerData[3];
                    String vehicleMake = singleCustomerData[4];
                    String vehicleInfo = singleCustomerData[5];
                    String startingBalance = singleCustomerData[6];
                    String discountType = singleCustomerData[7];

                    if(vehicleType.equals("Car"))
                    {
                        Car newVehicle = new Car(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));

                        CustomerAccount newCustomer =
                                makeNewCustomer(firstName,
                                    lastName,
                                    newVehicle,
                                    Integer.parseInt(startingBalance),
                                    discountType);

                        newTollRoad.addCustomer(newCustomer);
                    }
                    else if(vehicleType.equals("Van"))
                    {
                        Van newVehicle = new Van(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));

                        CustomerAccount newCustomer =
                                makeNewCustomer(firstName,
                                        lastName,
                                        newVehicle,
                                        Integer.parseInt(startingBalance),
                                        discountType);

                        newTollRoad.addCustomer(newCustomer);

                        newTollRoad.addCustomer(newCustomer);
                    }
                    else if(vehicleType.equals("Truck"))
                    {
                        Truck newVehicle = new Truck(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));

                        CustomerAccount newCustomer =
                                makeNewCustomer(firstName,
                                        lastName,
                                        newVehicle,
                                        Integer.parseInt(startingBalance),
                                        discountType);

                        newTollRoad.addCustomer(newCustomer);

                        newTollRoad.addCustomer(newCustomer);
                    }
                    else
                    {
                        System.out.println("Invalid vehicle type");
                        break;
                    }
                }
                return newTollRoad;
            }

            bufferedReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch (IOException e)
        {
            System.out.println("Error reading file '" + fileName + "'");
        }
        return newTollRoad;
    }

    private CustomerAccount makeNewCustomer(String firstName, String lastName,
                                 Vehicle newVehicle, int startingBalance,
                                 String discountType)
    {
        CustomerAccount newCustomer = new CustomerAccount(
                firstName,
                lastName,
                newVehicle,
                startingBalance);

        setDiscount(newCustomer, discountType);

        return newCustomer;
    }

    private void setDiscount(CustomerAccount customer, String discountType)
    {
        if(discountType.equals("STAFF"))
        {
            customer.activateStaffDiscount();
        }
        else if(discountType.equals("FRIENDS_AND_FAMILY"))
        {
            customer.activateFriendsAndFamilyDiscount();
        }
    }

    public void simulateFromFile(TollRoad road)
    {
        String fileName = "transactions.txt";

        String line;

        try
        {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if((line = bufferedReader.readLine()) != null)
            {
                String[] inTransactions = line.split("\\$");

                for(int i = 0; i < inTransactions.length; i++)
                {
                    String[] inSingleTransaction = inTransactions[i]
                            .split(",");

                    /*
                    for(int j = 0; j < inSingleTransaction.length; j++)
                    {
                        System.out.println(inSingleTransaction[j]);
                    }
                    */

                    String instruction = inSingleTransaction[0];
                    String regPlate = inSingleTransaction[1];

                    if(instruction.equals("addFunds"))
                    {
                        String amount = inSingleTransaction[2];
                        try
                        {
                            road.findCustomer(regPlate)
                                    .addFunds(Integer.parseInt(amount));

                            System.out.println(regPlate + " : " + amount +
                                    " added successfully");
                        }
                        catch(CustomerNotFoundException e)
                        {
                            System.out.println(regPlate + " : addFunds " +
                                  "failed. CustomerAccount does not exist");
                        }
                    }
                    else if(inSingleTransaction[0].equals("makeTrip"))
                    {
                        try
                        {
                            road.chargeCustomer(regPlate);

                            System.out.println(regPlate + " : Trip completed" +
                                    " successfully");
                        }
                        catch(CustomerNotFoundException e)
                        {
                            System.out.println(regPlate + " : makeTrip " +
                                    "failed. CustomerAccount does not exist");
                        }
                        catch(InsufficientAccountBalanceException e)
                        {
                            System.out.println(regPlate + " : makeTrip " +
                                    "failed. Insufficient funds");
                        }

                    }
                }
            }

            bufferedReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch (IOException e)
        {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public static void main(String[] args)
    {
        TollRoadMain tollRoadMain = new TollRoadMain();

        TollRoad tollRoad = tollRoadMain.initialiseTollRoadFromFile();

        /*
        try
        {
            CustomerAccount jose = tollRoad.findCustomer("HQ09WIJ");

            System.out.println(jose.getVehicle().getReg());
            System.out.println(jose.getFirstName());
            System.out.println(jose.getSecondName());
            System.out.println(jose.getVehicle().getMake());
            System.out.println(jose.getAccountBalance());
            System.out.println(jose.getDiscountType());
        }
        catch(CustomerNotFoundException e)
        {
            System.out.println("customer not found");
        }
        */

        tollRoadMain.simulateFromFile(tollRoad);

        System.out.println("Money Made : " + tollRoad.getMoneyMade());
    }
}
