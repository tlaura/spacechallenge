package spacechallenge;
import java.util.Random;

public class RocketU1 extends Rocket {
    private static final int cost = 100000000;
    // weight 18 tonnes max with cargo
    private static int rocketU1Counter;
    Random randomGenerator = new Random();

    public RocketU1() {
    	super(8000);
    }
    
    public static int getRocketU1Counter() {
        return rocketU1Counter;
    }
    
    public static void setRocketU1Counter(int rocketU1Counter) {
        RocketU1.rocketU1Counter = rocketU1Counter;
    }
    
    public static long getTotalCost() {
        return (long) getRocketU1Counter() * cost;
    }
    
    private double getRandomProbability() {
        return this.randomGenerator.nextDouble();
    }

    @Override
    public boolean launch(){
    // Chance of launch explosion = 5% * (cargo carried / cargo weight)
        double chanceOfExploision = 0.05*(getTotalWeight()/getMaxCargo());
        System.out.println();
        System.out.println("Launching with: " + getCurrentWeight() + " weight.");

        if (getRandomProbability() <= chanceOfExploision){
            System.out.println("U1 Explosion");
            return false;
        }
        System.out.println("U1 Launch successful");
        return true;

    }
    @Override
    public boolean land(){
    // Chance of landing crash = 1% * (cargo carried / cargo limit)
        double chanceOfCrash = 0.01*(getTotalWeight()/getMaxCargo());
        if (getRandomProbability() <= chanceOfCrash){
            System.out.println("U1 Crash");
            return false;
        }
        System.out.println("U1 Launch successful");
        return true;
    }
}