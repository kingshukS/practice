package com.kingshuk.tests;

public class EvenThread extends Thread{
int limit;
PrintOddEve sharedPrinter;
public EvenThread(int limit, PrintOddEve sharedPrinter)
{
    this.limit= limit;
    this.sharedPrinter = sharedPrinter;
}

@Override
    public void run()
{
    int EvenNumber = 2;
    while (EvenNumber<=limit)
    {
        sharedPrinter.printEven(EvenNumber);
        EvenNumber = EvenNumber+2;
    }
}
}
