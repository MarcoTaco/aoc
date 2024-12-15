import java.util.*;
import java.io.*;

public class day5 {
    static int finalAnswerPartOne = 0;
    static int finalAnswerPartTwo = 0;

    static List<String> firstSection = new ArrayList<>();
    static List<List<Integer>> pageNums = new ArrayList<>();
    
    // this function is for making a 2d list to have a collection of all pages
    public static List<List<Integer>> processFirstSection(List<String> firstSection){
        List<List<Integer>> pages = new ArrayList<>();
        
        for(String s : firstSection){
            List<Integer> row = new ArrayList<>();

            String[] pageOrder = s.split("\\|");

            int firstNum = Integer.parseInt(pageOrder[0]);
            int secondNum = Integer.parseInt(pageOrder[1]);

            row.add(firstNum);
            row.add(secondNum);

            pages.add(row);
        }
        return pages;
    }
    // this function is for making the second section into int lists instead of lists of strings
    public static void processEachSecondSection(List<List<Integer>> pageNums, String line){
        List<Integer> pageToCheck = new ArrayList<>();

        String[] commas = line.split(",");

        for(String comma : commas){
            pageToCheck.add(Integer.parseInt(comma.trim()));
        }

        // after every second section gets added to a list, call this function to figure out the stuff
        dayFivePartOne(pageNums, pageToCheck);
    }

    // im going to do a two pointer approach where i check if left pointer is greater than right so i know 
    // whether to look at the first or second picture
    public static void dayFivePartOne(List<List<Integer>>pageNums, List<Integer> pageToCheck){
        // getting the middle of the list that are we adding
        int middle = pageToCheck.size() / 2;
        int mainPointer = 0;
        int secondPointer = 0;

        boolean goodToGo = false;;

        while(mainPointer < pageToCheck.size()){
            if(mainPointer == secondPointer){
                secondPointer++;
                if(secondPointer == pageToCheck.size()){
                    break;
                }
            }
            // first for loop looks at first set of pages, second for loop looks at each page in the set
            for(List<Integer> pages : pageNums){
                if(mainPointer < secondPointer){
                    if(pageToCheck.get(mainPointer) == pages.get(0) && pageToCheck.get(secondPointer) == pages.get(1)){
                        goodToGo = true;
                        break;
                    }
                    else{
                        goodToGo = false;
                    }
                }
                else{
                    if(pageToCheck.get(mainPointer) == pages.get(1) && pageToCheck.get(secondPointer) == pages.get(0)){
                        goodToGo = true;
                        break;
                    }
                    else{
                        goodToGo = false;
                    }
                }
            }
            if(!goodToGo){
                break;
            }

            secondPointer++;

            if(secondPointer >= pageToCheck.size()){
                mainPointer++;
                secondPointer = 0;
            }
        }
        
        if(goodToGo){
            finalAnswerPartOne += pageToCheck.get(middle);
        }
        else{
            day5PartTwo(pageToCheck);
        }
    }
    
    public static void day5PartTwo(List<Integer> pageToCheck){
        
        
        int middle = pageToCheck.size() / 2;

        System.out.println(pageToCheck);
        finalAnswerPartTwo += pageToCheck.get(middle);
    }
    public static void main(String[] args){
        // String filePath = "./2024/day5/day5-input.txt";
        String filePath = "./2024/day5/day5-input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";
            boolean newLine = false;

            while((line = reader.readLine()) != null){
                if(line.length() == 0){
                    newLine = true;
                    pageNums = processFirstSection(firstSection);
                }
                if(!newLine){
                    firstSection.add(line);
                }
                else if(newLine && line.length() != 0){
                    processEachSecondSection(pageNums, line);
                }
            }

        }catch(IOException e){
            System.out.println("Error: " + e);
        }

        // System.out.println("Final answer part one: " + finalAnswerPartOne);
        // System.out.println("Final answer part two: " + finalAnswerPartTwo);
    }
}
