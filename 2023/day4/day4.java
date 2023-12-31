import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class day4 {
    public static int finalCount = 0;

    public static void main(String[] args){
        String file = "./2023/day4/day4input.txt";

        String testFile = "./2023/day4/day4input-test.txt";

        int finalAnswer = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(testFile))){
            String line = "";

            while((line = reader.readLine()) != null){
               String[] sections = line.split("\\|");
               String gameNumsSection = sections[0];
               String playingNums = sections[1];
               
               String[] numSections = gameNumsSection.split(":");
               String winningNums = numSections[1];

               processGame(winningNums, playingNums);

               finalAnswer += finalCount;
            }
        }catch(IOException e){
            System.out.println("Error: " + e);
        }
        System.out.println(finalAnswer);
    }

    public static void processGame(String winningNums, String playingNums){
        HashMap<String, Integer> winningMap = new HashMap<String, Integer>();
        
        int count = 0;
        int space = 0;

        /*
         * THIS IS A NOTE: !!!!
         * i figured the arrays are storing some spaces for the numbers that only have 1 digit. i will need to fix that when
         * i get back
         */

        String[] winNums = winningNums.split(" ");
        String[] playNums = playingNums.split(" ");
        
        for(String s : winNums){
            if(space == 0){

            }
            else{
                winningMap.put(s, 0);
            }
            space++;
            System.out.println("t: " + s);
        }
        // System.out.println(winningMap);

        for(int i = 0; i < playNums.length; i++){
            if(winningMap.get(playNums[i]) != null){
                System.out.println(playNums[i]);
                count++;
            }
        }
        // System.out.println("Card count: " + count);
        
        int num = 0;

        for(int i = 1; i <= count; i++){
            if(i < 2){
                num = i;
            }
            else{
                num *= 2;
            }
        }
        // System.out.println("game: " + num);
        finalCount = num;
    }
}
