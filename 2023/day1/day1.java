/*
 * THINKING PROCESS: open and read the file line by line, we are going to always want to count
 * the first number in that line and store it. we then want to keep going through the line and change
 * the value of the number after the first, once we stop, we know we reach to the end. if there is no
 * second number, then the first number is now the second number. we'll want to return a sum of the
 * whole text file. 
 * 
 * CONCERNS:
 * - how do i merge the two numbers and not add them lol. i imagine i can change both numbers
 *      into a string and then concatentate(?) or add them together then turn the string 
 *      back into an integer.
 * - tba im sure i'll run into other stuff like syntax or whatever.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1{
    public static void main(String[] args){
        //String filePath = "./2023/day1/day1input.txt";

        // testing file with only 10 lines
        String filePath = "./2023/day1/day1input-copy.txt";

        // look into Buffered Reader
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";
            int sum = 0;
            // while we are not at the end of the file, read off the line in the file
            while((line = reader.readLine()) != null){
                // calling a function to process each line of the file and to declutter the mess
                processLine(line, sum);
            }
        } catch(IOException e){
            System.out.println("error: " + e);
        }
    }

    // this function will process each line and will determine which numbers are what 
    private static void processLine(String fileLine, int finalSum){
        String firstNum = "0";
        String lastNum = "0";
        String newNum = "";
        int numStringToInt = 0;
        int endOfLine = fileLine.length() - 1;

        for(int i = 0; i < fileLine.length(); i++){
            char c = fileLine.charAt(i);

            // this if statement works
            if(Character.isDigit(c) && firstNum == "0"){
                firstNum = Character.toString(c);
            }
            // this if statement works
            else if(Character.isDigit(c) && firstNum != "0"){
                lastNum = Character.toString(c);
            }
            else if(i == endOfLine){
                if(lastNum == "0"){
                    lastNum = firstNum;
                }
                else{
                    newNum = firstNum + lastNum;
                    System.out.println(newNum);
                    numStringToInt = Integer.parseInt(newNum);

                    finalSum = finalSum + numStringToInt;
                }
            }
        }
        //System.out.println(finalSum);
    }
}
