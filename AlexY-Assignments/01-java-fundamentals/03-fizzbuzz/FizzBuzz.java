public class FizzBuzz {
    public String fizzBuzz(int number) {
        if(number % 5 == 0 && number % 3 == 0){
            return "FizzBuzz!";
        } else if(number % 3 == 0){
            return "Fizz!";
        } else if(number % 5 == 0){
            return "Buzz!";
        } else {
            return Integer.toString(number);
        }
    }
    public void FizzBuzzTest() {
        for (int i = 1; i <= 100; i++) {
            String result = fizzBuzz(i);
            System.out.println("number " + i + " Result: " + result);
        }
    }
}