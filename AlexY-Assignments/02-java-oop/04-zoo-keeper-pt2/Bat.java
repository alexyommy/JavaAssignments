public class Bat extends Mammal{
    public Bat() {
        super(300);
    }
    public void fly() {
        System.out.println("Whoosh! *Bat takes flight* -50 Energy");
        energyLevel -= 50;
    }
    public void eatHumans() {
        System.out.println("Omnom humans +25 Energy");
        energyLevel += 25;
    }
    public void attackTown() {
        System.out.println("Boom, Town is on fire! -100 Energy");
        energyLevel -= 100;
    }
}