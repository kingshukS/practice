package com.kingshuk.tests;

public class OddThread extends Thread {
 int limit;
 PrintOddEve sharedPrinter;
 public OddThread(int limit, PrintOddEve sharedPrinter)
 {
     this.limit = limit;
     this.sharedPrinter = sharedPrinter;

 }
 @Override
 public void run() {
     int OddNumber =1 ;
     while (OddNumber<= limit) {
      sharedPrinter.printOdd(OddNumber);
      OddNumber=OddNumber+2;
     }
 }
}
