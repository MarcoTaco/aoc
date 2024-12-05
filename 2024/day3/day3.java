import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class day3 {
    static int finalAnswerPartOne = 0;
    static int firstNum = 0;
    static int secondNum = 0;

    static String mulRegex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

    static int finalAnswerPartTwo = 0;
    static boolean isCheck = true;
    
    public static void mullItOverPartOne(String line){
        // pattern and matcher are for finding regex inside a string
        Pattern pattern = Pattern.compile(mulRegex);
        Matcher matcher = pattern.matcher(line);
        
        // while there's the string we are looking for (mulRegex), grab the first and second number.
        // multiply then add.
        while(matcher.find()){
            firstNum = Integer.parseInt(matcher.group(1));
            secondNum = Integer.parseInt(matcher.group(2));
            
            int multiply = firstNum * secondNum;
            
            finalAnswerPartOne += multiply;
        }
    }

    public static void mullItOverPartTwo(String line){
        Pattern pattern = Pattern.compile(mulRegex);
        
        // splitting the string with do and don't
        String[] tokens = line.split("(?=do\\(\\)|don't\\(\\))");
        
        // looping through each token (substring), and check if the substring starts with either do or don't.
        // if it starts with do and isCheck is false, then change isCheck to true and vice versa.
        // if isCheck is already true, then grab the numbers like previously done.
        for(String token : tokens){
            if(token.startsWith("do()") && !isCheck){
                isCheck = true;
            }
            else if(token.startsWith("don't()") && isCheck){
                isCheck = false;
            }
            if(isCheck){
                Matcher matcher = pattern.matcher(token);

                while(matcher.find()){
                    firstNum = Integer.parseInt(matcher.group(1));
                    secondNum = Integer.parseInt(matcher.group(2));
                    
                    int multiply = firstNum * secondNum;

                    finalAnswerPartTwo += multiply;
                }
            }
        }
    }

    public static void main(String[] args){
        String filePath = "./2024/day3/day3-input.txt";
        // String filePath = "./2024/day3/day3-input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                mullItOverPartOne(line);
                mullItOverPartTwo(line);
            }
        }catch(IOException e){
            System.out.println("Error: " + e);
        }

        System.out.println("final answer part one: " + finalAnswerPartOne);
        System.out.println("final answer part two: " + finalAnswerPartTwo);
    }
}
