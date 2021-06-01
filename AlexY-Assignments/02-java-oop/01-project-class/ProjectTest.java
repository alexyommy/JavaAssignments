// import java.util.ArrayList;

public class ProjectTest {
    public static void main(String[] args) {
        Project p1 = new Project();
        Project p2 = new Project("Hilton");
        Project p3 = new Project("Ritz", "A New Hotel", 500);
        System.out.println(p1.ElevatorPitch());
        System.out.println(p2.ElevatorPitch());
        System.out.println(p3.ElevatorPitch());

        p1.setName("Chili's");
        p1.setDescription("Another Building");
        p1.setCost(4000.54);
        System.out.println(p1.ElevatorPitch());

        p2.setDescription("A new restaurant");
        p2.setCost(3152.00);
        System.out.println(p2.ElevatorPitch());

        Portfolio PL = new Portfolio();
        PL.showPortfolio();
    }
}







