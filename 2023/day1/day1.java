import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day1{
    // variable for final answer
    private static int finalSum = 0;
    public static void main(String[] args){
        //String filePath = "./2023/day1/day1input.txt";

        // testing file
        String filePath = "./2023/day1/day1input-copy.txt";

        List<String> numText = new ArrayList<String>();
        numText.add("one");
        numText.add("two");
        numText.add("three");
        numText.add("four");
        numText.add("five");
        numText.add("six");
        numText.add("seven");
        numText.add("eight");
        numText.add("nine");
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                // calling a function to process each line of the file and to declutter the mess
                processLine(line, numText);
            }
        } catch(IOException e){
            System.out.println("error: " + e);
        }
        System.out.println(finalSum);
    }

    private static void processLine(String fileLine, List<String> numText){
        String firstNum = "";
        String lastNum = "";
        String newNum = "";
        int numStringToInt = 0;
        int endOfLine = fileLine.length() - 1;

        for(int i = 0; i < fileLine.length(); i++){
            char letter = fileLine.charAt(i);

            if(Character.isDigit(letter) && firstNum == "" && i != endOfLine){
                firstNum = Character.toString(letter);
            }

            else if(Character.isDigit(letter) && firstNum != "" && i != endOfLine){
                lastNum = Character.toString(letter);
            }

            else if(i == endOfLine){
                if(firstNum == "" && Character.isDigit(letter)){
                    firstNum = Character.toString(letter);
                    lastNum = firstNum;
                }
                else if(lastNum == "" && !Character.isDigit(letter)){
                    lastNum = firstNum;
                }
                else if(Character.isDigit(letter) && firstNum != ""){
                    lastNum = Character.toString(letter);
                }

                newNum = firstNum + lastNum;
                numStringToInt = Integer.parseInt(newNum);
                finalSum = finalSum + numStringToInt;
            }
        }
    }
}
