import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
// import java.util.*;

public class Puzzling {
    public void GreaterThanTen(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(arr[i] > 10){
                newArr.add(arr[i]);
            }
        }
        System.out.print("The Sum is: " + sum);
        System.out.println(" New Array > 10: " + newArr);
    }

    public ArrayList<String> NameShuffle(ArrayList<String> arr){
        Collections.shuffle(arr);
        System.out.print(arr);
        ArrayList<String> GreaterThanFive = new ArrayList<String>();
        for (int i = 0; i < arr.size(); i++){
            if(arr.get(i).length() > 5){
                GreaterThanFive.add(arr.get(i));
            }
        }
        return GreaterThanFive;
    }

    public void AlphabetVowel(){
        ArrayList<String> alphabet = new ArrayList<String>();
        for(char ch = 'a'; ch <= 'z'; ++ch){
            alphabet.add(Character.toString(ch));
        }
        System.out.println(alphabet);
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println(String.format("%s is first", alphabet.get(0)));
        System.out.println(String.format("%s is last", alphabet.get(25)));
        if(alphabet.get(0).equals("a") || alphabet.get(0).equals("e")  || alphabet.get(0).equals("i")  || alphabet.get(0).equals("o")  || alphabet.get(0).equals("u") ){
            System.out.println("First letter is a vowel!");
        }
    }

    public ArrayList<Integer> NumArray(){
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            Integer rand = r.nextInt(100 - 55) + 55;
            arrList.add(rand);
        }
        return arrList;
    }

    public ArrayList<Integer> SortArray(){
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            Integer rand = r.nextInt(100 - 55) + 55;
            arrList.add(rand);
        }
        Collections.sort(arrList);
        System.out.println(arrList);
        System.out.println(String.format("%s is min", arrList.get(0)));
        System.out.println(String.format("%s is max", arrList.get(9)));
        return arrList;
    }

    public String RandomString(){
        ArrayList<String> arr = new ArrayList<String>();
        for(char ch = 'a'; ch <= 'z'; ++ch){
            arr.add(Character.toString(ch));
        }
        String word = "";
        for (int i = 0; i < 5; i++){
            Collections.shuffle(arr);
            word += arr.get(0);
        }
        return word;
    }

    public String[] RandomStringArr() { 
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = RandomString();
        }
        return arr;
    }
}









