import java.util.*;
import java.io.*;

public class day5 {
    static int finalAnswerPartOne = 0;
    // static int finalAnswerPartTwo = 0;
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

        dayFivePartOne(pageNums, pageToCheck);
    }

    public static void dayFivePartOne(List<List<Integer>>pageNums, List<Integer> pageToCheck){
        int middle = pageToCheck.size() / 2;

        for(List<Integer> pages : pageNums){
            for(int page : pages){
                
            }
        }
         
        finalAnswerPartOne += pageToCheck.get(middle);
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
    }
}
