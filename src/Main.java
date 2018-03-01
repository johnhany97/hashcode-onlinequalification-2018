import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
	int row = 0;
	int column = 0;
	int vehicles = 0;
	int rides = 0;
	int bonusPerRide = 0;
	int numberOfSteps = 0;
	ArrayList<Ride> ridesList = new ArrayList<Ride>();
    BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader("a_example.in"));
        String line = br.readLine();
        String[] splited = line.split(" ");
        row = Integer.parseInt(splited[0]);
        column = Integer.parseInt(splited[1]);
        vehicles = Integer.parseInt(splited[2]);
        rides = Integer.parseInt(splited[3]);
        bonusPerRide = Integer.parseInt(splited[4]); //If you start trip on time
        numberOfSteps = Integer.parseInt(splited[5]);
        for (int i = 0; i < rides; i++) {
        	line = br.readLine();
        	splited = line.split(" ");
        	int[] arr = Arrays.asList(splited).stream().mapToInt(Integer::parseInt).toArray();
        	ridesList.add(new Ride(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], i));
        }
        ridesList.sort(new RideComparator());
    }  catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
        try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
  }
}