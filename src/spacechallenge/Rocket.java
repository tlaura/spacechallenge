package spacechallenge;

public class Rocket implements Spaceship {
    private int currentWeight;
    private int weight;
    private int maxCargo;
    private double totalWeight = currentWeight + weight;
    private int cost;
    
    public Rocket(int maxCargo) {
    	this.maxCargo = maxCargo;
    }

    public int getMaxCargo(){
        return maxCargo;
    }

    // to update maxCargo 
    public void setMaxCargo(int maxCargo){
        this.maxCargo = maxCargo;
    }

    // get and set cost
    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    }

    // get weight
    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }

    //get current weight and calculate total weight 
    public int getCurrentWeight() {
        return currentWeight;
    }
    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    // get totalWeight variable
    public double getTotalWeight() {
        totalWeight = getCurrentWeight() + getWeight();
        // totalWeight = this.currentWeight + this.weight;
        return totalWeight;
    }

    @Override
    public boolean launch(){
        return true;
    }

    @Override
    public boolean land(){
        return true;
    }

    @Override
    public boolean canCarry(Item item){
    // check if it exceeds the weight limit
        if (maxCargo >= (currentWeight + item.getWeight())) 
            return true;
        else 
            return false;

    }

    @Override
    public void carry(Item item){
    // updates the current weight of the rocket
        currentWeight += item.getWeight();
    }
    
    public String toString() {
    	return Integer.toString(currentWeight);
    }

}