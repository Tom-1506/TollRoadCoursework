import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TollRoadMain
{
    public void initialiseTollRoadFromFile()
    {
        String fileName = "customerData.txt";

        String line;

        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            if((line = bufferedReader.readLine()) != null)
            {
                String[] inCustomerData = line.split("#");

                for (int i = 0; i == inCustomerData.length; i++)
                {
                    String[] singleCustomerData = inCustomerData[i]
                                                    .split(",");

                    
                }
            }

            /*
            if (Character.isLetter(line.charAt(0)))
            {
                //then create an album using that line
                String[] inAlbum = line.split(" : ");
                String inArtist = inAlbum[0];
                String inAlbumName = inAlbum[1];

                newAlbum = new Album(inArtist, inAlbumName);
                newAlbumCollection.albumArray.add(newAlbum);
            }
            //if the first character in the line is a number
            else if (Character.isDigit(line.charAt(0)))
            {
                 create a track and add it to the
                last made albums track array
                String[] inTrack = line.split(" - ");
                String inTime = inTrack[0];
                String inTrackName = inTrack[1];

                Track newTrack = new Track(inTime, inTrackName);
                newAlbum.trackArray.add(newTrack);
            }*/


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
