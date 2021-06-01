public class Gorilla extends Mammal {
    public Gorilla() {
        super(100);
    }
    public void throwSomething() {
        System.out.println("Gorilla threw something; -5 Energy");
        energyLevel -= 5;
    }
    public void eatBanana() {
        System.out.println("Gorilla eats banana and is happy; +10 Energy");
        energyLevel += 10;
    }
    public void climb() {
        System.out.println("Climbing the tree; -10 Energy");
        energyLevel -= 10;
    }
}







