/*
 * part 1: im going to read through each line and add each line to an array of left and right
 *  after reading through all ids, i will call another function to handle the sorting and adding
 *  functionality then get a final answer.
 * 
 * part 2: add each number to a hashmap and count how many times it appears. then loop through each
 *  map and check if it exists in both, if it doesn't, then add 0 to the array. if it does, multiply.
 *  BUT if leftMap happens more than once, loop through the count and just add the answer multiple times
 *  to array. at the end, add everything in the array for the final answer.
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
    // part 1: using lists since the size of the list is changing and idk what sizes it would be.
    static List<Integer> leftList = new ArrayList<>();
    static List<Integer> rightList = new ArrayList<>();

    // part 2: using list to add each score, and adding it all up in the end.
    static List<Integer> sums = new ArrayList<>();

    static HashMap<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
    static HashMap<Integer, Integer> rightMap = new HashMap<Integer, Integer>();
    
    public static void main(String[] args){
        String filePath = "./2024/day1/day1-input.txt";

        // testing file
        // String filePath = "./2024/day1/day1-input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                addArrayElements(line);
            }
        } catch(IOException e){
            System.out.println("error" + e);
        }
        
        // after adding all the numbers to a list, sort them to make it easier for calcumalations
        Collections.sort(leftList);
        Collections.sort(rightList);

        addHashElements(leftList, rightList);

        // calling function for day 1 part 1 calculations
        // locationIdsPartOne(leftList, rightList);

        // calling function for day 1 part 2 calculations
        locationsIdsPartTwo(leftMap, rightMap);
        
        // System.out.println(finalAnswer); 
    }
    // part 1
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

            // this is stupid that i needed to get absolute value if it wasnt specified on the problem lol
            int diffyWiffy = Math.abs(right - left);

            finalAnswer = finalAnswer + diffyWiffy;
        }
    }

    // part 2
    // adding each list to a hashmap so we can keep count of the amount of times a repeatings
    // key happened
    private static void addHashElements(List<Integer> leftList, List<Integer> rightList){
        // looping through both left and right list. then putting each value in a map and checking
        // if a value is already there
        // getOrDefault is get the count, then add by 1, or assign a default value of 0.
        for(Integer leftNum : leftList){
            leftMap.put(leftNum, leftMap.getOrDefault(leftNum, 0) + 1);
        }
        for(Integer rightNum : rightList){
            rightMap.put(rightNum, rightMap.getOrDefault(rightNum, 0) + 1);
        }
    }

    private static void locationsIdsPartTwo(HashMap<Integer, Integer> leftMap, HashMap<Integer, Integer> rightMap){
        for(Integer num : leftMap.keySet()){
            if(rightMap.containsKey(num)){
                // here we check how many time it occurs on right map and multiply it by that many times
                int repeatNums = rightMap.get(num);
                int repeatLeftNums = leftMap.get(num);

                for(int i = 0; i < repeatNums; i++){
                    int sum = num * repeatLeftNums;
                    finalAnswer = finalAnswer + sum;
                }
            }
        }
        System.out.println("answer: " + finalAnswer);
    }
}