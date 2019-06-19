package spacechallenge;

import java.util.ArrayList;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

// responsible for reading item data and filling up the rockets
public class Simulation{
    	private ArrayList<Item> items;
    	File file1 = new File("phase-1.txt");
    	File file2 = new File("phase-2.txt");
    	
    	public ArrayList<Item> loadItems(int phase) throws Exception {
    		
    		if (phase == 1) {
    			System.out.println("Loading Phase 1");
    			loadPhaseItems(file1);
    		} else {
    			System.out.println("Loading Phase 2");
    			loadPhaseItems(file2);
    		}
    		return items;
    	}
    	
    	// loads all items from phase-1.txt, phase-2.txt and returns an ArrayList of Items
        public void loadPhaseItems(File file) throws Exception {
        	items = new ArrayList<Item>();
        	
        	// read files 
        	Scanner scanner = new Scanner(file);
        	
        	// insert into arraylist of items
        	
            while (scanner.hasNextLine()) {
            	String line = scanner.nextLine();
            	String [] separateLine = line.split("=");
            	Item item = new Item(separateLine[0], Integer.parseInt(separateLine[1]));
                items.add(item);
         
            }
            scanner.close();
        }

        public ArrayList<Rocket> loadU1(ArrayList<Item> items){
            ArrayList<Rocket> rockets = new ArrayList<Rocket>();
            Iterator<Item> iterator = items.iterator();

            Rocket rocket = new RocketU1();
            
            while (iterator.hasNext()){
                
                // fill it 
                Item item = iterator.next();
                if (rocket.canCarry(item)) {
                	rocket.carry(item);
                } else {
                	// add it to the list
                	rockets.add(rocket);
                    rocket = new RocketU1();
                    rocket.carry(item);
                }

            }
            // half full rocket to add:
            rockets.add(rocket);
                
            return rockets;
        }
        
        
        public ArrayList<Rocket> loadU2(ArrayList<Item> items){
            ArrayList<Rocket> rockets = new ArrayList<Rocket>();
            Iterator<Item> iterator = items.iterator();
            
            Rocket rocket = new RocketU2();
            
            while (iterator.hasNext()) {
            	
            	Item item = iterator.next();
            	if (rocket.canCarry(item)) {
            		rocket.carry(item);
            	} else {
            		// add it to the list of items 
            		rockets.add(rocket);
            		rocket = new RocketU2();
            		rocket.carry(item);
            	}
            }
            rockets.add(rocket);
            return rockets;

        }
        
        public void runSimulation(ArrayList<Rocket> rockets, int phase){
            for (Rocket rocket : rockets) {
            	while (!rocket.launch()) {
            		launchSimulation(phase);
            	}
            	while(!rocket.land()) {
            		launchSimulation(phase);
            	}
            	launchSimulation(phase);
            }
        }
        
        public void launchSimulation(int i){ 
        	
        	if (i == 1) {
        		int counter = RocketU1.getRocketU1Counter(); 
        		counter++;
        		RocketU1.setRocketU1Counter(counter);
        	} else {
        		int counter = RocketU2.getRocketU2Counter();
                counter++;
                RocketU2.setRocketU2Counter(counter);
        	}
            
        }
    }

