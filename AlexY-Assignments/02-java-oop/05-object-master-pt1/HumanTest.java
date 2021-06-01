public class HumanTest {
    public static void main(String[] args) {
        Human alex = new Human();
        Human dave = new Human();
        alex.attack(dave);
        System.out.println(dave.health);
    }
}
