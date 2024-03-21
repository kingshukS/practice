package com.kingshuk.tests.hundredDaysChallenge.day1;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellToMaximizeProfit {
    public static void main ( String[] args ) {
        int[] price = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;
        findMaxProfitForMultipleTxns ( price, n );
    }

    private static void findMaxProfitForMultipleTxns ( int[] price, int n ) {
        if ( n == 1 )
            return;
        List<Interval> txnList = new ArrayList<> ();
        int i = 0, count = 0;
        while (i < n - 1) {
            while (i < n - 1 && price[i + 1] <= price[i])
                i++;
            if ( i == n - 1 )
                break;
            Interval e = new Interval ();
            e.buy = i++;
            while (i < n && price[i] > price[i - 1])
                i++;
            e.sell = i - 1;
            txnList.add ( e );
            count++;
        }
        if ( count == 0 )
            System.out.println ( "There is no day when buying the stock will make profit" );
        else {
            int maxProfit = 0;
            for ( int j = 0; j < count; j++ ) {
                System.out.println ( "Buy on day: " + txnList.get ( j ).buy + " Sell on day : " + txnList.get ( j ).sell );
                maxProfit += ( price[txnList.get ( j ).sell] - price[txnList.get ( j ).buy] );
            }
            System.out.println ( "Maximum Profit: " + maxProfit );
        }
    }

    static class Interval {
        int buy;
        int sell;
    }
}
