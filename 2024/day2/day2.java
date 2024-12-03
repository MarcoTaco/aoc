import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class day2{
    // final answers for both part one and two
    static int finalAnswerPartOne = 0;
    static int finalAnswerPartTwo = 0;

    static List<Integer> lineOfNums = new ArrayList<>();

    public static void processLinePartOne(String line){
        int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();        

        // adding nums array to list so i can clear the list after im done with calculation
        for(Integer n : nums){
            lineOfNums.add(n);
        }

        // im going to use two pointers to compare the two numbers
        int start = 0;
        int end = 1;

        if(lineOfNums.get(start) > lineOfNums.get(end)){
            for(int i = 1; i < lineOfNums.size(); i++){
                int check = lineOfNums.get(start) - lineOfNums.get(i);

                if((check <= 3 && check >= 1) && (lineOfNums.get(start) > lineOfNums.get(i))){
                    start++;
                    continue;
                }
                else{
                    lineOfNums.clear();
                    break;
                }
            }
        }
        else if(lineOfNums.get(start) < lineOfNums.get(end)){
            for(int i = 1; i < lineOfNums.size(); i++){
                int check = lineOfNums.get(start) - lineOfNums.get(i);
                check = Math.abs(check);
                
                if((check <= 3 && check >= 1) && (lineOfNums.get(start) < lineOfNums.get(i))){
                    start++;
                    continue;
                }
                else{
                    lineOfNums.clear();
                    break;
                }
            }
        }
        else{
            lineOfNums.clear();
        }
        
        if(lineOfNums.size() != 0){
            finalAnswerPartOne++;
            lineOfNums.clear();
        }
    }

    public static void main(String[] args){
        // String filePath = "./2024/day2/day2-input-test.txt";

        String filePath = "./2024/day2/day2-input.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                processLinePartOne(line);
            }
        } catch(IOException e){
            System.out.println("Error reading file: " + e);
        }

        System.out.println(finalAnswerPartOne);
    }
}