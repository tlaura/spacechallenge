package spacechallenge;

public class Item{
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    // to access item name/weight in other methods
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
