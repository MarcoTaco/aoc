//part 2. add each character to a string until we hit a whole word

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class day1{
    // variable for final answer
    private static int finalSum = 0;
    public static void main(String[] args){
        //String filePath = "./2023/day1/day1input.txt";

        // testing file
        String filePath = "./2023/day1/day1input-copy.txt";

        HashMap<String, String> numText = new HashMap<String, String>();
        numText.put("one", "1");
        numText.put("two", "2");
        numText.put("three", "3");
        numText.put("four", "4");
        numText.put("five", "5");
        numText.put("six", "6");
        numText.put("seven", "7");
        numText.put("eight", "8");
        numText.put("nine", "9");

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                // calling a function to process each line of the file and to declutter the mess
                processLine(line, numText);
            }
        } catch(IOException e){
            System.out.println("error: " + e);
        }
        //System.out.println(finalSum);
    }

    private static void processLine(String fileLine, HashMap<String, String> numTxt){
        String firstNum = "";
        String lastNum = "";
        String newNum = "";
        String txtNum = "";
        int numStringToInt = 0;
        int endOfLine = fileLine.length() - 1;

        /*
         * double loop. one looping through the line, another comparing each char (up to 5).
         * put each character into a string for a max of 5. keep comparing the string to the map to
         * find matching numbers. 
         * if we hit a digit, then just reset the loop
         * 
         * CONCERNS: how to know we don't hit the end out of index.
         */
        for(int i = 0; i < fileLine.length(); i++){
            char letter = fileLine.charAt(i);
            txtNum += Character.toString(letter);
            for(int j = i + 1; j < fileLine.length(); j++){
                char tmpLetter = fileLine.charAt(j);
                txtNum += Character.toString(tmpLetter);

                System.out.println(txtNum);

                if(txtNum.contains(txtNum)){
                    firstNum = numTxt.get(txtNum);
                    if(firstNum != null){
                        //System.out.println("s: " + firstNum);
                        txtNum = "";
                        break;
                    }
                }
                if(j > 5){
                    txtNum = "";
                    break;
                }
       
                //numStringToInt = Integer.parseInt(newNum);
                //finalSum = finalSum + numStringToInt;
            }
            // if reach end of line, then check if first || last num are empty
            // then just copy what i had before then adding it all together 









        }
        // for(int i = 0; i < fileLine.length(); i++){
        //     char letter = fileLine.charAt(i);
        //     txtNum += Character.toString(letter);

        //     if(Character.isDigit(letter) && firstNum == "" && i != endOfLine){
        //         firstNum = Character.toString(letter);
        //         txtNum = "";
        //     }
        //     else if(numTxt.containsKey(txtNum) && firstNum == "" && i != endOfLine){
        //         firstNum = numTxt.get(txtNum);
        //         txtNum = "";
        //         i--;
        //     }
        //     else if(Character.isDigit(letter) && firstNum != "" && i != endOfLine){
        //         lastNum = Character.toString(letter);
        //         txtNum = "";
        //     }
        //     else if(numTxt.containsKey(txtNum) && firstNum != "" && i != endOfLine){
        //         lastNum = numTxt.get(txtNum);
        //         txtNum = "";
        //         i--;
        //     }
        //     else if(i == endOfLine){
        //         if(firstNum == "" && Character.isDigit(letter)){
        //             firstNum = Character.toString(letter);
        //             lastNum = firstNum;
        //         }
        //         else if(firstNum == "" & numTxt.containsKey(txtNum)){
        //             firstNum = numTxt.get(txtNum);
        //             lastNum = firstNum;
        //         }
        //         else if(lastNum == "" && !Character.isDigit(letter)){
        //             lastNum = firstNum;
        //         }
        //         else if(lastNum == "" && !numTxt.containsKey(txtNum)){
        //             lastNum = firstNum;
        //         }
        //         else if(Character.isDigit(letter) && firstNum != ""){
        //             lastNum = Character.toString(letter);
        //         }
        //         else if(numTxt.containsKey(txtNum) && firstNum != ""){
        //             lastNum = numTxt.get(txtNum);
        //         }

        //         newNum = firstNum + lastNum;
        //         System.out.println(newNum);
        //         //numStringToInt = Integer.parseInt(newNum);
        //         //finalSum = finalSum + numStringToInt;
        //     }
        // }
        //System.out.println(finalSum);
    }
}
