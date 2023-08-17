package graph;

import java.util.*;

class WordLadder1
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(startWord, 1));
        set.remove(startWord);
        while (!queue.isEmpty())
        {
            Pair pair = queue.poll();
            String word = pair.word;
            int distance = pair.distance;

            if(word.equals(targetWord))
                return distance;
            for(int i = 0; i<word.length(); i++)
            {
                char[] wordChars = word.toCharArray();
                for(char ch = 'a'; ch<='z'; ch++)
                {
                    wordChars[i] = ch;
                    String newWord = new String(wordChars);
                    if(set.contains(newWord))
                    {
                       queue.add(new Pair(newWord, distance+1));
                       set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    class Pair{
        String word;
        int distance;

        Pair(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        String[] wordList = {"geek", "gefk"};
        String startWord = "geek", targetWord= "gefk";
        System.out.println(new WordLadder1().wordLadderLength(startWord, targetWord, wordList));
    }
}