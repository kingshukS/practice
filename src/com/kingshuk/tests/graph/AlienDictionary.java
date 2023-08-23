package com.kingshuk.tests.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AlienDictionary
{
    public static void main(String[] args) {
        String[] dict = new String[]{"baa","abcd","abca","cab","cada"};
        System.out.println(new AlienDictionary().findOrder(dict, 5,4));
    }
    public String findOrder(String [] dict, int N, int K)
    {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<K; i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<N-1; i++)
        {
            String str1 = dict[i];
            String str2 = dict[i+1];
            int minLen = Math.min(str1.length(), str2.length());
            for(int j = 0; j<minLen; j++)
            {
               if(str1.charAt(j) != str2.charAt(j))
               {
                   adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                   break;
               }
            }
        }
        
        List<Integer> toposort = toposort(K, adj);
        StringBuilder s = new StringBuilder();
        for(int k : toposort)
        {
            char ch = (char)(k + ((int)'a'));
            s.append(ch);
        }
        return s.toString();
    }
    
    private List<Integer> toposort(int V, List<List<Integer>> adj)
    {
        int[] indegrees = new int[V];
        
        for(int i = 0; i<V; i++)
        {
            for(int x : adj.get(i))
            {
                indegrees[x]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<V; i++)
        {
            if(indegrees[i] == 0)
                queue.add(i);
        }
        
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            list.add(node);
            for(int x : adj.get(node))
            {
                indegrees[x]--;
                if(indegrees[x] == 0)
                    queue.add(x);
            }
        }
        
        return list;
    }
}