/*
 * part 1: im going to read through each line and add each line to an array of left and right
 * after reading through all ids, i will call another function to handle the sorting and adding
 * functionality then get a final answer.
 * 
 * part 2: 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class day1{
    // value of final answer
    static int finalAnswer = 0;

    // using lists since the size of the list is changing and idk what sizes it would be.
    static List<Integer> leftList = new ArrayList<>();
    static List<Integer> rightList = new ArrayList<>();

    HashMap<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
    
    public static void main(String[] args){
        String filePath = "./2024/day1/day1-input.txt";

        // testing file
        // String testFilePath = "./2024/day1/day1-input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                // addArrayElements(line);
            }
        } catch(IOException e){
            System.out.println("error" + e);
        }
        
        // after adding all the numbers to a list, sort them to make it easier for calcumalations
        Collections.sort(leftList);
        Collections.sort(rightList);

        // calling function for day 1 part 1 calculations
        // locationIdsPartOne(leftList, rightList);
        
        System.out.println(finalAnswer);
    }

    private static void addArrayElements(String line){
        // splitting the left and right by one or more spaces
        String[] numbers = line.trim().split("\\s+");
        int leftNum = Integer.parseInt(numbers[0]);
        int rightNum = Integer.parseInt(numbers[1]);

        // numbers[0] and [1] is left and right. adding them to their respective list.
        leftList.add(leftNum);
        rightList.add(rightNum);
    }

    private static void locationIdsPartOne(List<Integer> leftList, List<Integer> rightList){
        for(int i = 0; i < leftList.size(); i++){
            int left = leftList.get(i);
            int right = rightList.get(i);
            // this is stupid that i needed to get absolute value if it wasnt specified on the problem
            // lol
            int diffyWiffy = Math.abs(right - left);

            finalAnswer = finalAnswer + diffyWiffy;
        }
    }
}