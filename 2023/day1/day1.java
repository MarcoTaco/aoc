import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class day1{
    // variable for final answer
    private static int finalSum = 0;
    public static void main(String[] args){
        String filePath = "./2023/day1/day1input.txt";

        // testing file
        // String filePath = "./2023/day1/day1input-copy.txt";

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
        System.out.println(finalSum);
    }

    private static void processLine(String fileLine, HashMap<String, String> numTxt){
        String firstNum = "";
        String lastNum = "";
        String newNum = "";
        String txtNum = "";
        boolean check = false;
        int numStringToInt = 0;
        int endOfLine = fileLine.length() - 1;

        for(int i = 0; i < fileLine.length(); i++){
            check = false;
            int count = 0;
            char letter = fileLine.charAt(i);
            txtNum += Character.toString(letter);

            if(Character.isDigit(letter) && firstNum == "" && i != endOfLine){
                firstNum = Character.toString(letter);
                txtNum = "";
                check = true;
            }
            else if(Character.isDigit(letter) && firstNum != "" && i != endOfLine){
                lastNum = Character.toString(letter);
                txtNum = "";
                check = true;
            }
            else if(i == endOfLine){
                if(firstNum == "" && Character.isDigit(letter)){
                    firstNum = Character.toString(letter);
                    lastNum = firstNum;
                }
                else if(firstNum != "" && lastNum == "" && !Character.isDigit(letter)){
                    lastNum = firstNum;
                }
                else if(firstNum != "" && Character.isDigit(letter)){
                    lastNum = Character.toString(letter);
                }
                newNum = firstNum + lastNum;
                numStringToInt = Integer.parseInt(newNum);
                System.out.println(numStringToInt);
                finalSum = finalSum + numStringToInt;
            }
            for(int j = i + 1; j < fileLine.length(); j++){
                if(check == true){
                    txtNum = "";
                    break;
                }

                count++;
                char tmpLetter = fileLine.charAt(j);
                txtNum += Character.toString(tmpLetter);

                if(firstNum == "" && numTxt.containsKey(txtNum)){
                    firstNum = numTxt.get(txtNum);
                    txtNum = "";
                    break;
                }
                else if(firstNum != "" && numTxt.containsKey(txtNum)){
                    lastNum = numTxt.get(txtNum);
                    txtNum = "";
                    break;
                }
                
                if(count > 3 || j == endOfLine){
                    txtNum = "";
                    break;
                }
            }
        }
    }
}
