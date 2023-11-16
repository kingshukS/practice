package com.kingshuk.tests.AmazonQues;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogs {
    static String[] reorderLogFiles(String[] logs)  {
        boolean[] isLetterArr = new boolean[logs.length];   //scan to see if log contains letter
        int lenLetter = 0;
        for(int i = 0;i<logs.length;i++){
            boolean isLetter = Character.isLetter(logs[i].charAt(logs[i].length()-1));
            if(isLetter) lenLetter++;
            isLetterArr[i] = isLetter;
        }
        System.out.println(lenLetter);
        String[] ans = new String[logs.length];
        for(int i = 0,j=0,k=lenLetter;i<logs.length;i++){   //two pointer to move log
            if(isLetterArr[i]){                             //move letter in position j
                ans[j] = logs[i];
                j++;
            }else{                                          //move digits in position k
                ans[k] = logs[i];
                k++;
            }
        }
        Arrays.sort(ans,0,lenLetter,new Comparator<String>(){// sort only the log contains letter
            public int compare(String s1, String s2){
                int i1 = s1.indexOf(' '), i2 = s2.indexOf(' ');
                String id1 = s1.substring(0,i1),id2 = s2.substring(0,i2);
                String word1 = s1.substring(i1), word2 = s2.substring(i2);
                if(!word1.equals(word2)) return word1.compareTo(word2);//if words not the same, compare word1 word2
                else return id1.compareTo(id2);                      //if word is the same, then compare id1, id2
            }
        });
        return ans;
    }

    public static void main(String[] args)
    {
        String[] logs = {"dig1 8 1 5 1","let4 art zero","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] output = reorderLogFiles(logs);
        for(int i =0;i<output.length;i++)
        {
            System.out.println(output[i]);
        }
    }
}
