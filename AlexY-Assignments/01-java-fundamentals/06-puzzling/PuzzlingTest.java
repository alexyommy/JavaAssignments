import java.util.*;

public class PuzzlingTest{
    public static void main(String[] args) {        
        Puzzling PT= new Puzzling();
        int[] arr = new int[]{3,5,1,2,7,9,8,13,25,32};
        String[] Names = {"Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"};
        ArrayList<String> NameList = new ArrayList<String>(Arrays.asList(Names));

        PT.GreaterThanTen(arr);
        System.out.println(PT.NameShuffle(NameList));
        PT.AlphabetVowel();
        System.out.println(PT.NumArray());
        PT.SortArray();
        System.out.println(PT.RandomString());
        System.out.println(PT.RandomStringArr());
        }
    }