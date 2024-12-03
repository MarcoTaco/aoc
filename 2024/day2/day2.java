import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day2{
    // final answers for both part one and two
    static int finalAnswerPartOne = 0;
    static int finalAnswerPartTwo = 0;

    static List<Integer> lineOfNums = new ArrayList<>();

    public static void processLinePartOne(String line){
        String[] numbers = line.trim().split("\\s+");

        for(int i = 0; i < numbers.length; i++){
            lineOfNums.add(Integer.parseInt(numbers[i]));
        }

        System.out.println(lineOfNums);
        lineOfNums.clear();
    }

    public static void main(String[] args){
        String filePath = "./2024/day2/day2-input-test.txt";

        // String filePath = "./2024/day2/day2-input.txt"

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                processLinePartOne(line);
            }
        } catch(IOException e){
            System.out.println("Error reading file: " + e);
        }
    }
}