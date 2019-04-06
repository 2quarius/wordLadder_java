package com.sixplus.demo;
/*
如果将词典导入数据库，则新建一个名为Dictionary的类，
利用application.yaml配置数据库，
WordLadder类的english则换为Dictionary对象，
doFind函数内部english的相应操作也应替换
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLadder {
    public static Map<String, Integer> english = new HashMap<String, Integer>();
    public static String start, dest;

    WordLadder(){}
    public WordLadder(String start,String dest)
    {
        this.start = start;
        this.dest = dest;
    }
    public static String doFind() {
        WordLadder object = new WordLadder();
        read_english();
        Queue<ArrayList<String>> ladderqueue = new LinkedList<ArrayList<String>>();
        ArrayList<String> ladders = new ArrayList<String>();
        ladders.add(object.start);
        ((LinkedList<ArrayList<String>>) ladderqueue).addLast(ladders);
        object.english.put(object.start, 0);
        while (ladderqueue.size() != 0) {
            ArrayList<String> laddertmp = ladderqueue.element();
            if (laddertmp.get(laddertmp.size() - 1).equals(object.dest)) {
                return show_ans(laddertmp);
            }
            String temp = laddertmp.get(laddertmp.size() - 1);
            for (Integer i = 0; i < temp.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    StringBuilder strBuilder = new StringBuilder(temp);
                    strBuilder.setCharAt(i, j);
                    temp = strBuilder.toString();
                    if (object.english.containsKey(temp)) {
                        if (object.english.get(temp) == 1) {
                            ArrayList<String> copy = new ArrayList<String>(laddertmp);
                            copy.add(temp);
                            ((LinkedList<ArrayList<String>>) ladderqueue).add(copy);
                            object.english.replace(temp, 1, 0);
                        }
                    }
                }
                StringBuilder strBuilder = new StringBuilder(temp);
                strBuilder.setCharAt(i, laddertmp.get(laddertmp.size() - 1).charAt(i));
                temp = strBuilder.toString();
            }
            ((LinkedList<ArrayList<String>>) ladderqueue).pop();
        }

        return "No Ladder\n";
    }

    public static void read_english() {
        while (true) {
            try {
                BufferedReader bf = new BufferedReader(new FileReader("/Users/sixplus/Downloads/lab2/WordLadder/EnglishWords.txt"));
                String temp_word;
                while ((temp_word = bf.readLine()) != null) {
                    english.put(temp_word, 1);
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static String show_ans(ArrayList<String> ans) {
        StringBuilder answer = new StringBuilder("Found Ladder:");
        answer.append(ans.get(0));
        for(Integer i = 1; i < ans.size(); i++){
            answer.append("->");
            answer.append(ans.get(i));
        }
        answer.append("\n");
        return answer.toString();
    }
}
