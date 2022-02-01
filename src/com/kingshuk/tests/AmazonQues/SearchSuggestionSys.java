package com.kingshuk.tests.AmazonQues;

import java.util.*;

public class SearchSuggestionSys {
    static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> heap = new PriorityQueue<>(Collections.reverseOrder());
        //this is a max heap which stores min node as root
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i); //perform substring from first index to i, Eg: m,mo,mou,mous,mouse
            for (String product: products) {
                if (product.startsWith(t)) {  //startswith is a method which returns boolean after checking
                    // whether elements in list start with 0 to prefix ie t.
                    heap.offer(product); //add in heap if product list items staring with t
                }
                if (heap.size() > 3) { //don not add more than 3 suggestions for one prefix as per questions condition
                    heap.poll();
                }
            }

            LinkedList<String> temp = new LinkedList<>();
            while (!heap.isEmpty()) {
                temp.addFirst(heap.poll()); //results to the heap in opposite order
              //  eg. in heap it will be stored as monitor,moneypot,mobile
                //on polling it will polled in the same order ,but we want to add lexicographically
                //so we call add first ,so first monitor will be added ,then first to it moneypot and then mobile
            }
            result.add(temp); //add final list to result and return
        }
        return result;
    }

    public static void main(String args[])
    {
        String products[] = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> list = suggestedProducts(products,searchWord);
        System.out.println(list);
    }
}
