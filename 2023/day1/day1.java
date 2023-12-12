import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1{
    // variable for final answer
    private static int finalSum = 0;
    public static void main(String[] args){
        String filePath = "./2023/day1/day1input.txt";

        // testing file with only 10 lines
        // String filePath = "./2023/day1/day1input-copy.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            // while we are not at the end of the file, read off the line in the file
            while((line = reader.readLine()) != null){
                // calling a function to process each line of the file and to declutter the mess
                processLine(line);
            }
        } catch(IOException e){
            System.out.println("error: " + e);
        }
        System.out.println(finalSum);
    }

    // this function will process each line and will determine which numbers are what 
    private static void processLine(String fileLine){
        String firstNum = "";
        String lastNum = "";
        String newNum = "";
        int numStringToInt = 0;
        int endOfLine = fileLine.length() - 1;

        // looping through the line 
        for(int i = 0; i < fileLine.length(); i++){
            char letter = fileLine.charAt(i);

            // if letter is a digit and the firstNum is still original value, then change value
            // of firstNum
            if(Character.isDigit(letter) && firstNum == "" && i != endOfLine){
                firstNum = Character.toString(letter);
            }

            // if letter is a digit and we already found the firstNum, AND we are not at the end 
            // of the line, then change value of the lastNum
            // we are checking that we are not end of the line because it skips the logic/formula of
            // adding the nums together and adding it all up 
            else if(Character.isDigit(letter) && firstNum != "" && i != endOfLine){
                lastNum = Character.toString(letter);
            }

            // if we reach the end of this line, we know to start adding nums together
            else if(i == endOfLine){
                // check if firstNum was still not found and we are at the last char of the line
                if(firstNum == "" && Character.isDigit(letter)){
                    firstNum = Character.toString(letter);
                    lastNum = firstNum;
                }
                // if we havent gotten a second num, then make it equal firstNum
                else if(lastNum == "" && !Character.isDigit(letter)){
                    lastNum = firstNum;
                }
                // if last letter is a num, and we already found the first num, then do this
                else if(Character.isDigit(letter) && firstNum != ""){
                    lastNum = Character.toString(letter);
                }

                // concatenation of first and last num, turning it into an int, then adding it all up
                newNum = firstNum + lastNum;
                numStringToInt = Integer.parseInt(newNum);
                finalSum = finalSum + numStringToInt;
            }
        }
    }
}
