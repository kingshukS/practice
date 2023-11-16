package com.kingshuk.tests.JustPractice;


import java.util.ArrayList;

class Interval{
    int buy,sell;
}
public class StockBuySellMultiple {

    static void maxProfit(int[] arr, int n){
        if(n==1)
            return;
        int count = 0;
        ArrayList<Interval> al = new ArrayList<>();

        int i =0;
        while(i<n-1)
        {
            if(i<n-1 && arr[i] >= arr[i+1])
            {
                i++;
            }
            if(i == n-1)
                break;

            Interval e = new Interval();
            e.buy = i++;     //to jump to next iteration ,0 is added to buy and then inc to 1

            if(i<n-1 && arr[i] >= arr[i-1])
            {
                i++;
            }

            e.sell = i-1;

            al.add(e);

            count++;
        }

        if(count==0)
        {
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        }
        else
        {
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + al.get(j).buy
                        + "        "
                        + "Sell on day : " + al.get(j).sell);
        }

    }
    public static void main(String[] args)
    {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        int n = arr.length;
        maxProfit(arr,n);
    }
}
