public class FirstProgram {
    // Entry Point Method
    public static void main(String[] args) {
        System.out.println("Hello world!");   

        byte myByte = 100; // Stores whole numbers from -128 to 127
        short myShort = 1000; // Stores whole numbers from -32768 to 32767
        int myInt = 100000; // Stores whole numbers from -2,147,484,648 to, 2,147,483,647
        long myLong = 1000000000; // Stores whole numbers from 9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        float myFloat = 3.14f; // Stores fractional numbers. sufficient for storing up to 15 decimal digits
        boolean myBool = true; // stores true or false values
        char myChar = 'x'; // Stpres a single character/letter or ASCII values

        // Default to Null
        Integer myInteger = 100000;
        Character myCharacter = 'd';

        String myString = "Java April 2021";
        System.out.println(myString.length());
    }
}