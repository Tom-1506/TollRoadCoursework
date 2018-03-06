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

                for(int i = 0; i <= inCustomerData.length; i++)
                {
                    String[] singleCustomerData = inCustomerData[i]
                                                    .split(",");

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

                        newTollRoad.addCustomer(firstName,
                                lastName,
                                newVehicle,
                                Integer.parseInt(startingBalance));
                    }
                    else if(vehicleType.equals("Van"))
                    {
                        Van newVehicle = new Van(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));
                    }
                    else if(vehicleType.equals("Truck"))
                    {
                        Truck newVehicle = new Truck(regPlate,
                                vehicleMake,
                                Integer.parseInt(vehicleInfo));
                    }
                    else
                    {
                        System.out.println("Invalid vehicle type");
                        break;
                    }
                }
            }

            bufferedReader.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch (IOException ex)
        {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public void simulateFromFile(TollRoad road)
    {

    }

    public static void main(String[] args)
    {

    }
}
