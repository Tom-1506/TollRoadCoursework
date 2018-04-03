import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//These imports are used for reading from the text file

public class TollRoadMain
{
    /*method that creates a new TollRoad and then populates the TollRoad
    with CustomerAccounts by reading from a text file and adding to the
    CustomerAccount ArrayList*/
    public TollRoad initialiseTollRoadFromFile()
    {
        //create new TollRoad called newTollRoad
        TollRoad newTollRoad = new TollRoad();

        //set filename to be read
        String fileName = "customerData.txt";

        String line;

        /*try catch statement for file reading, this is for cases where the
        text file doesnt exist*/
        try
        {
            /*create a file reader and set it to use the already defined
            fileName of customerData.txt*/
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //if there is another line in the text file then do this
            if((line = bufferedReader.readLine()) != null)
            {
                //split the file into a String array on # symbols
                String[] inCustomerData = line.split("#");

                //loop through each element in the String array
                for(int i = 0; i < inCustomerData.length; i++)
                {
                    /*split the current element into another String array
                    on commas*/
                    String[] singleCustomerData = inCustomerData[i]
                                                    .split(",");

                    /*here set each part of the single customer array
                    to be each part of data needed to create a CustomerAccount
                    object*/
                    String vehicleType = singleCustomerData[0];
                    String regPlate = singleCustomerData[1];
                    String firstName = singleCustomerData[2];
                    String lastName = singleCustomerData[3];
                    String vehicleMake = singleCustomerData[4];
                    String vehicleInfo = singleCustomerData[5];
                    String startingBalance = singleCustomerData[6];
                    String discountType = singleCustomerData[7];

                    /*this massive if else statement is used to check what
                    type of vehicle the customer has so that it can correctly
                    set the vehicle info, after setting the vehicle the
                    new CustomerAccount object will be created and added to
                    the TollRoad object using the TollRoad addCustomer()
                    method*/
                    //if the vehicle is a car
                    if(vehicleType.equals("Car"))
                    {
                        //create a new car with the relevant data
                        Car newVehicle = new Car(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));

                        /*create a new CustomerAccount using the car and
                        other relevant data*/
                        CustomerAccount newCustomer =
                                makeNewCustomer(firstName,
                                    lastName,
                                    newVehicle,
                                    Integer.parseInt(startingBalance),
                                    discountType);

                        //add the new customer to the TollRoad
                        newTollRoad.addCustomer(newCustomer);
                    }
                    else if(vehicleType.equals("Van"))//if vehicle is a van
                    {
                        //create a new van with the relevant data
                        Van newVehicle = new Van(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));

                        /*create a new CustomerAccount using the van and
                        other relevant data*/
                        CustomerAccount newCustomer =
                                makeNewCustomer(firstName,
                                        lastName,
                                        newVehicle,
                                        Integer.parseInt(startingBalance),
                                        discountType);

                        //add the new customer to the TollRoad
                        newTollRoad.addCustomer(newCustomer);
                    }
                    else if(vehicleType.equals("Truck"))//if vehicle is a truck
                    {
                        //create a new truck with the relevant data
                        Truck newVehicle = new Truck(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));

                        /*create a new CustomerAccount using the truck and
                        other relevant data*/
                        CustomerAccount newCustomer =
                                makeNewCustomer(firstName,
                                        lastName,
                                        newVehicle,
                                        Integer.parseInt(startingBalance),
                                        discountType);

                        //add the new customer to the TollRoad
                        newTollRoad.addCustomer(newCustomer);
                    }
                    else //otherwise it is not a valid vehicle type
                    {
                        System.out.println("Invalid vehicle type");
                        break;
                    }
                }
                //now return the tollRoad with the Customer array filled
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
        //return after possible exceptions
        return newTollRoad;
    }

    /*method used in the initialiseTollRoadFromFile method to create
    new CustomerAccount objects with the info from the file*/
    private CustomerAccount makeNewCustomer(String firstName, String lastName,
                                 Vehicle newVehicle, int startingBalance,
                                 String discountType)
    {
        //make a new customer
        CustomerAccount newCustomer = new CustomerAccount(
                firstName,
                lastName,
                newVehicle,
                startingBalance);

        //set the discount type for the new customer using setDiscount method
        setDiscount(newCustomer, discountType);

        return newCustomer;
    }

    /*method that takes a customer and a string and uses the string to set
    the discount type for the given CustomerAccount*/
    private void setDiscount(CustomerAccount customer, String discountType)
    {
        //if the string discountType is STAFF
        if(discountType.equals("STAFF"))
        {
            //use the activateStaffDiscount method from CustomerAccount
            customer.activateStaffDiscount();
        }
        else if(discountType.equals("FRIENDS_AND_FAMILY"))
        {
            //use friends and family discount method from CustomerAccount
            customer.activateFriendsAndFamilyDiscount();
        }
    }

    /*this method takes a TollRoad object, in this case the TollRoad from
    initialiseTollRoadFromFile()reads commands from a text file to add
    funds to customers accounts, use the makeTrip method to simulate
    them passing through the toll road and counting the money made
    from all of the trips*/
    public void simulateFromFile(TollRoad road)
    {
        //set the file name that the commands are in
        String fileName = "transactions.txt";

        String line;

        //the same try catch statement from initialiseTollRoadFromFile
        try
        {
            /*create a fileReader using the file name and then a
            bufferReader*/
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //if there is a line in the text file
            if((line = bufferedReader.readLine()) != null)
            {
                //split the file into an array on $ symbols
                String[] inTransactions = line.split("\\$");

                //loop through the inTransactions array
                for(int i = 0; i < inTransactions.length; i++)
                {
                    /*split each element in the array into another array
                    on commas*/
                    String[] inSingleTransaction = inTransactions[i]
                            .split(",");

                    /*assign the first two elements in inSingleTransaction
                    to relevant variables*/
                    String instruction = inSingleTransaction[0];
                    String regPlate = inSingleTransaction[1];

                    //if the instruction is addFunds
                    if(instruction.equals("addFunds"))
                    {
                        //set the third element in the array to amount
                        String amount = inSingleTransaction[2];

                        /*try catch for if the customer isnt part of the
                        toll roads customer array*/
                        try
                        {
                            /*use the findCustomer() method to get the customer
                            by regPlate and then use the addFunds() method
                            to add amount to their account balance*/
                            road.findCustomer(regPlate)
                                    .addFunds(Integer.parseInt(amount));

                            //print a success message
                            System.out.println(regPlate + " : " + amount +
                                    " added successfully");
                        }
                        catch(CustomerNotFoundException e)
                        {//run if the customer does not exist in the array
                            //print failure message
                            System.out.println(regPlate + " : addFunds " +
                                  "failed. CustomerAccount does not exist");
                        }
                    }
                    //if the instruction is maketrip
                    else if(inSingleTransaction[0].equals("makeTrip"))
                    {
                        /*try catch for customer not existing or if they
                        cannot afford the*/
                        try
                        {
                            //use the chargeCustomer() method with regPlate
                            road.chargeCustomer(regPlate);

                            //print success message
                            System.out.println(regPlate + " : Trip completed" +
                                    " successfully");
                        }
                        catch(CustomerNotFoundException e)
                        {//run if customer doesn't exist
                            //print failure message
                            System.out.println(regPlate + " : makeTrip " +
                                    "failed. CustomerAccount does not exist");
                        }
                        catch(InsufficientAccountBalanceException e)
                        {//run if the customer cannot afford the toll
                            //print failure message
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

    //main method
    public static void main(String[] args)
    {
        //create new TollRoadMain object
        TollRoadMain tollRoadMain = new TollRoadMain();

        /*create new TollRoad and assign customers using
        initialiseTollRoadFromFile()*/
        TollRoad tollRoad = tollRoadMain.initialiseTollRoadFromFile();

        //carry out instructions on tollRoad with simulateFromFile()
        tollRoadMain.simulateFromFile(tollRoad);

        //print out the total money made after the simulation
        System.out.println("Money Made : " + tollRoad.getMoneyMade());

        //This block was used for incremental testing
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
    }
}
