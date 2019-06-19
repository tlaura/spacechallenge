package spacechallenge;
import java.util.ArrayList;

public class SpaceApp{
	
    public static void main(String[] args) throws Exception{
    	final int phase1 = 1;
        final int phase2 = 2;
    	
    	Simulation sim = new Simulation();

    	//Loading items:
    	ArrayList<Item> phase1Item = sim.loadItems(phase1);
        ArrayList<Item> phase2Item = sim.loadItems(phase2);
        System.out.println();
        
        //Simulation U1 rocket phase1:
    	ArrayList<Rocket> rocket1 = sim.loadU1(phase1Item);
    	System.out.println(rocket1);
    	sim.runSimulation(rocket1, phase1);
    	int phase1Rockets = RocketU1.getRocketU1Counter();
    	System.out.println("Rockets used for phase 1: " + phase1Rockets);
        System.out.println();

    	
    	//Simulation U1 rocket phase2:
    	sim.runSimulation(sim.loadU1(phase2Item), phase1);
    	int phase2Rockets = RocketU1.getRocketU1Counter() - phase1Rockets;
    	System.out.println("Rockets used for phase 2: " + phase2Rockets);
    	System.out.println("Total U1 Rockets: " + RocketU1.getRocketU1Counter());
        System.out.println();
        
    	
        // get cost:
        long costU1 = RocketU1.getTotalCost();
        System.out.println("U1 Total Cost: " + costU1);
        System.out.println();

        
        //Simulation U2 rocket phase1:
        ArrayList<Rocket> rocket2 = sim.loadU2(phase1Item);
        System.out.println(rocket2);
        sim.runSimulation(rocket2, phase2);
        phase1Rockets = RocketU2.getRocketU2Counter();
        System.out.println("Rockets used for phase 1: " + phase1Rockets);
        System.out.println();
        
        //Simulation U2 rocket phase2:
        sim.runSimulation(sim.loadU2(phase2Item), phase2);
    	phase2Rockets = RocketU2.getRocketU2Counter() - phase1Rockets;
    	System.out.println("Rockets used for phase 2: " + phase2Rockets);
    	System.out.println("Total U2 Rockets: " + RocketU2.getRocketU2Counter());
        System.out.println();
        
        // get cost:
        long costU2 = RocketU2.getTotalCost();
        System.out.println("U2 Total Cost: " + costU2);
        System.out.println();

        if (costU1 > costU2) {
        	System.out.println("U2 is cheaper in this Simulation");
        } else {
        	System.out.println("U1 is cheaper in this Simulation");
        }
        
    }
}