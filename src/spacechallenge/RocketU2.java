package spacechallenge;
import java.util.Random;

public class RocketU2 extends Rocket {
	private static int rocketU2Counter;
    private static final int cost = 120000000; 
    private Random randomGenerator = new Random();
    
    
    public static int getRocketU2Counter() {
    	return rocketU2Counter;
    }
    
    public static void setRocketU2Counter(int rocketU2Counter) {
    	RocketU2.rocketU2Counter = rocketU2Counter;
    }
    
    public static long getTotalCost() {
        return (long) getRocketU2Counter() * cost;
    }
    
    // weight max 29 tonnes with cargo
    public RocketU2() {
    	super(11000);
    }
    
    private double getRandomProbability() {
        return this.randomGenerator.nextDouble();
    }
    
    @Override
    public boolean launch() {
    // Chance of launch explosion = 4% * (cargo carried / cargo limit)
        double chanceOfExploision = 0.04*(getTotalWeight()/getMaxCargo());
        if (getRandomProbability() <= chanceOfExploision){
            System.out.println("U2 Explosion");
            return false;
        }
        System.out.println("U2 Launch successful");
        return true;
    }

    @Override
    public boolean land(){
    // Chance of landing crash = 8% * (cargo carried / cargo limit)
        double chanceOfCrash = 0.08*(getTotalWeight()/getMaxCargo());
        if (getRandomProbability() <= chanceOfCrash){
            System.out.println("U2 Crash");
            return false;
        }
        System.out.println("U2 Launch successful");
        return true;
    }
}
