package com.kingshuk.tests.graph;

import java.util.*;

class WordLadder2
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> queue = new ArrayDeque<>();

        ArrayList<String> startingList = new ArrayList<>();
        startingList.add(startWord);
        queue.add(startingList);

        ArrayList<String> deletionList = new ArrayList<>();
        deletionList.add(startWord);

        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(wordList));

        while (!queue.isEmpty())
        {
            int size = queue.size();
            set.removeAll(deletionList);
            deletionList.clear();
            for(int i = 0; i < size; i++)
            {
                ArrayList<String> iterationList = queue.poll();
                String word = iterationList.get(iterationList.size()-1);
                if(word.equals(targetWord))
                {
                    ans.add(iterationList);
                    continue;
                }
                for(int j = 0; j<word.length(); j++)
                {
                    char[] wordChars = word.toCharArray();
                    for(char ch = 'a'; ch<='z'; ch++)
                    {
                        wordChars[j] = ch;
                        String newWord = new String(wordChars);
                        if(set.contains(newWord))
                        {
                            ArrayList<String> newSequence = new ArrayList<>(iterationList);
                            newSequence.add(newWord);
                            queue.add(newSequence);
                            deletionList.add(newWord);
                        }
                    }
                }

            }
            if(ans.size() > 0)
                return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord = "der", targetWord= "dfs";

        ArrayList<ArrayList<String>> ans = new WordLadder2().findSequences(startWord, targetWord, wordList);
        for(ArrayList<String> l : ans)
        {
            System.out.println(l);
        }
    }
}