/*
 * for this day problem, i want to use a breadth first search, so i will need to look into how to
 * use one of those lol.
 * i know i will need to add all these lines into an array to start
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day3 {
    public static int finalAnswer = 0;
    public static void main(String[] args){
        String file = "./2023/day3/day3input.txt";

        String testFile = "./2023/day3/day3input-test.txt";
        String[] testArray = new String[10];
        int count = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(testFile))){
            String line = "";

            while((line = reader.readLine()) != null){
                // adding lines to array
                testArray[count] = line;
                count++;
            }
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
        
    }

    public static void lineToArray(String line){

    }
}
