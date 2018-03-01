import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
	ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
    BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader("e_high_bonus.in"));
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
        for (int i = 0; i < vehicles; i++) {
        	vehiclesList.add(new Vehicle());
        }
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
	
	
	//Algorithm
	//First step
	for (int i = 0; i < vehicles && i < rides; i++) {
		if (feasible(ridesList.get(i), vehiclesList.get(i), 0)) {
			vehiclesList.get(i).setRide(ridesList.get(i), vehicleTimeForGivenRide(ridesList.get(i), vehiclesList.get(i), 0));
		}
	}
	for (int i = 0; i < vehicles; i++) {
		if (vehiclesList.get(i).isTaken()) {
			ridesList.remove(i);
		}
	}
	//All the other steps
	for (int i = 1; i < numberOfSteps; i++) {
		ArrayList<Integer> vehiclesFree = new ArrayList<Integer>();
		//Update all cars
		for  (int j = 0; j < vehiclesList.size(); j++) {
			vehiclesList.get(j).update();
			if (!vehiclesList.get(j).isTaken()) {
				vehiclesFree.add(j);
			}
		}
		ArrayList<Integer> indicesChosen = new ArrayList<Integer>();
		//Loop through available cars to pick rides??
		for (int j = 0; j < vehiclesFree.size(); j++) {
			boolean notTaken = true;
			for (int k = 0; k < ridesList.size() && notTaken; k++) {
				if (feasible(ridesList.get(k), vehiclesList.get(j), i)) {
					notTaken = false;
                    vehiclesList.get(j).setRide(ridesList.get(k), vehicleTimeForGivenRide(ridesList.get(k), vehiclesList.get(j), i));
                    indicesChosen.add(k);
				}
			}
		}
        //clean up list of rides
        for (int j = 0; j < indicesChosen.size(); j++) {
            ridesList.remove(indicesChosen.get(j));
        }
	}
	
	
	Writer writer = null;

	try {
	    writer = new BufferedWriter(new OutputStreamWriter(
	          new FileOutputStream("e_high_bonus.out"), "utf-8"));
	    for (int i = 0; i < vehiclesList.size(); i++) {
	    	writer.write(vehiclesList.get(i).outputOfVehicle());
	    	writer.write('\n');
	    }
	} catch (IOException ex) {
	    // Report
	} finally {
	   try {writer.close();} catch (Exception ex) {/*ignore*/}
	}
	
  }
  
  public static boolean feasible(Ride ride, Vehicle vehicle, int step) {
	  int vtfgr = vehicleTimeForGivenRide(ride, vehicle, step);
	  return step + vtfgr < ride.getLatestFinish() && !ride.taken;
  }
  
  public static int vehicleTimeForGivenRide(Ride ride, Vehicle vehicle, int step) {
	  //Distance to arrive
	  int total = vehicle.getDistance(ride.getRowStart(), ride.getColStart());
	  //Waiting time
	  int arrival = total + step;
	  if (arrival < ride.getEarliestStart()) {
		  total += ride.getEarliestStart() - arrival;
	  }
	  //Trip time
	  total += ride.getTotalTripDistance();
	  return total;
  }
}