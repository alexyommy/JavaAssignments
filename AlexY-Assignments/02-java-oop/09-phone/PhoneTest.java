public class PhoneTest {
    public static void main(String[] args) {
        IPhone iPhone12 = new IPhone("12", 100, "Verizon", "Beep Boop");
        Galaxy fold = new Galaxy("Fold", 73, "AT&T", "Starsssss");
        System.out.println("Phone info for IPhone 12");
        iPhone12.displayInfo();
        System.out.println("Phone info for Galaxy Fold");
        fold.displayInfo();
    }
}
class Human implements java.io.Serializable {





