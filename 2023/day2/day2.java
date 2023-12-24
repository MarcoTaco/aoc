import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {
    public static int finalAnswer = 0;
    public static void main(String[] args){
        String file = "./2023/day2/day2input.txt";

        // test file
        // String file = "./2023/day2/day2input-test.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = "";

            while((line = reader.readLine()) != null){
                processLine(line);
            }
        }catch(IOException e){
            System.out.println("error: " + e);
        }
        System.out.println(finalAnswer);

    }

    public static void processLine(String fileLine){
        // splitting everything into two sections. splitting in between the colon
        String[] sections = fileLine.split(":");

        String numBefore = sections[0].replaceAll("[^0-9]", "");

        int id = Integer.parseInt(numBefore);

        String numsAfter = sections[1];
        processGame(id, numsAfter);
    }

    public static void processGame(int id, String numsAfter){
        String[] game = numsAfter.split("\n");
        String gameNums = game[0];
        boolean check = true;

        String[] gamePulls = gameNums.split(";");

        for(String m : gamePulls){
            if(check == false){
                break;
            }

            String[] pulls = m.split(",");
            
            for(String a : pulls){
                String[] beforeSemi = a.split(" ");
                String colorNums = beforeSemi[1];
                int colorNum = Integer.parseInt(colorNums);
                String color = beforeSemi[2];    

                if(colorNum > 12 && color.contains("red")){
                    id = 0;
                    check = false;
                    break;
                }
                else if(colorNum > 13 && color.contains("green")){
                    id = 0;
                    check = false;
                    break;
                }
                else if(colorNum > 14 && color.contains("blue")){
                    id = 0;
                    check = false;
                    break;
                }
            }
        }
        finalAnswer += id;
    }
}
