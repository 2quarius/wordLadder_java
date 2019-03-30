import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class wordLadder {
    public static Map<String,Integer> english = new HashMap<String, Integer>();
    public static String start,dest;
    public static void main(){
        wordLadder object = new wordLadder();
        read_english();
        input_words();
        Queue<ArrayList<String>> ladderqueue = new LinkedList<ArrayList<String>>();
        ArrayList<String> ladders = new ArrayList<String>();
        ladders.add(object.start);
        ((LinkedList<ArrayList<String>>) ladderqueue).addLast(ladders);
        object.english.put(object.start,0);
        while (ladderqueue.size()!=0){
            ArrayList<String> laddertmp = ladderqueue.element();
            if (laddertmp.get(laddertmp.size()-1).equals(object.dest)){
                show_ans(laddertmp);
                return ;
            }
            String temp = laddertmp.get(laddertmp.size()-1);
            for (Integer i = 0; i < temp.length(); i++)
            {
                for (char j = 'a'; j <= 'z'; j++)
                {
                    StringBuilder strBuilder = new StringBuilder(temp);
                    strBuilder.setCharAt(i,j);
                    temp = strBuilder.toString();
                    if (object.english.containsKey(temp)){
                        if (object.english.get(temp)==1){
                            ArrayList<String> copy = new ArrayList<String>(laddertmp);
                            copy.add(temp);
                            ((LinkedList<ArrayList<String>>) ladderqueue).add(copy);
                            object.english.replace(temp,1,0);
                        }
                    }
                }
                StringBuilder strBuilder = new StringBuilder(temp);
                strBuilder.setCharAt(i,laddertmp.get(laddertmp.size()-1).charAt(i));
                temp = strBuilder.toString();
            }
            ((LinkedList<ArrayList<String>>) ladderqueue).pop();
        }

        System.out.println("No ladder\n");
        return ;
    }
    public static void read_english(){
        while (true){
            try {
                BufferedReader bf = new BufferedReader(new FileReader("/Users/sixplus/Downloads/lab2/WordLadder/EnglishWords.txt"));
                String temp_word;
                while ((temp_word = bf.readLine()) != null){
                    english.put(temp_word,1);
                }
                break;
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    public static void input_words(){
        System.out.println("Enter start word (enter ':q' to quit):");
        Scanner sc = new Scanner(System.in);
        start = sc.next();
        if (start == ":q")
        {
            System.exit(0);
        }
        System.out.println("Enter destination word:");
        dest = sc.next();
    }
    public static void show_ans(ArrayList<String> ans)
    {
        System.out.print("Found ladder:");
        System.out.print(ans.get(0));
        for (Integer i = 1; i < ans.size(); i++)
        {
            System.out.print("->");
            System.out.print(ans.get(i));
        }
        System.out.println();
        System.out.println();
    }
}
