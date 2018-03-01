import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
	int row = 0;
	int column = 0;
	int vehicles = 0;
	int rides = 0;
	int bonusPerRide = 0;
	int numberOfSteps = 0;
	
    //If we need to read from a file
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
	System.out.println(row);
	System.out.println(column);
	System.out.println(vehicles);
	System.out.println(rides);
	System.out.println(bonusPerRide);
	System.out.println(numberOfSteps);
  }
}