import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Arrays;
public class Basics{
    // Print 1-255
    public static void OneTo255() {
        for (int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }
    // Print odd numbers between 1-255
    public static void PrintOdds() {
        for (int i = 1; i <= 255; i++){
            if(i % 2 == 1);
                System.out.println(i);   
        }
    }
    // Print Sum
    public void PrintSum() {
        int sum = 0;
        for (int i = 0; i <= 255; i++){
            sum += i;
            System.out.println(String.format("New number: %d, Sum: %d", i, sum));
        }
    }
    // Iterating through an array
    public static void LoopArray(int[] arr) {
        for(int val: arr){
            System.out.println(val);
        }
    }
    // Find Max
    public void FindMax(int[] arr) {
        int max = arr[0];
        for(int val: arr){
            if(val > max){
                max = val;
            }
        }
        System.out.println(max);
    }
    // Get Average
    public double GetAverage(int[] arr) {
        double sum = 0;
        for(int val :arr){
            sum += val;
        }
        double avg = sum/arr.length;
        return avg;
    }
    // Array with Odd Numbers
    public ArrayList<Integer> OddArr() {
        ArrayList<Integer> oddNums = new ArrayList<Integer>();
        for(int i = 0; i <= 255; i++){
            if(i % 2 == 1)
            oddNums.add(i);
        }
        return oddNums;
    }
    // Greater Than Y
    public int GreaterThan(int[] arr, int y) {
        int count = 0;
        for(int num: arr) {
            if (num > y)
                count++;
        }
        return count;
    }
    // Square the Values
    public String SquareTheValue(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        return Arrays.toString(arr);
    }
    // Eliminate Negative Numbers
    public String EliminateNegative(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] < 0)
                arr[i] = 0;
        }
        return Arrays.toString(arr);
    }
    // Max, Min, Average
    public String MaxMinAvg(int[] arr){
        double Max = (double)arr[0];
        double Min = (double)arr[0];
        double Sum = 0;
        for(int i = 0; i < arr.length; i++){
            Sum += arr[i];
            if (Max < arr[i]){
                Max = arr[i];
            }
            if (Min > arr[i]){
                Min = arr[i];
            }
        }
        double Avg = Sum/arr.length;
        double[] result = {Max,Min,Avg};
        return Arrays.toString(result);
    }
    // Shifting the Values in the Array
    public String ShiftValues(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = 0;
        return Arrays.toString(arr);
    }
}