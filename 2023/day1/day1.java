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
        int finalSum = 0;
        int firstNum = 0;
        int lastNum = 0;

        String filePath = "./2023/day1/day1input.txt";

        // look into Buffered Reader
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch(IOException e){
            System.out.println("error: " + e);
        }

        System.out.println("");
    }
}
