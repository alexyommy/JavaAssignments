public class BasicsTest {
    public static void main(String[] args) {
        Basics JB = new Basics();
        int [] arr = {1,3,5,7,9,13};
        int [] arr2 = {1,5,10,-2};
        int y = 6;
        JB.OneTo255();
        JB.PrintOdds();
        JB.PrintSum();
        JB.LoopArray(arr);
        JB.FindMax(arr);
        System.out.println(JB.GetAverage(arr));
        System.out.println(JB.OddArr());
        System.out.println(JB.GreaterThan(arr, y));
        System.out.println(JB.SquareTheValue(arr));
        System.out.print(JB.EliminateNegative(arr2));
        System.out.print(JB.MaxMinAvg(arr2));
        System.out.print(JB.ShiftValues(arr2));
    }
}
