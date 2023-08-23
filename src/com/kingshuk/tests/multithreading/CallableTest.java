package com.kingshuk.tests.multithreading;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableTest implements Callable<Integer> {

    private int number;

    CallableTest(int number)
    {
        this.number = number;
    }


    @Override
    public Integer call() throws Exception {
        int result = 1;
        if(number == 0 || number == 1)
        {
            result =  1;
        }
        else{
            for(int i = 2;i<number;i++)
            {
                result = result * (number);
            }
        }
        System.out.println("Result for number - " + number + " -> " + result);
        return result;
    }

    public static void main(String args[])
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();
        Random number = new Random();
        for(int i = 0;i<4;i++)
        {
            int number1 = number.nextInt(10);
            CallableTest factorial = new CallableTest(number1);   //callable object
            Future<Integer> future = executor.submit(factorial);
            resultList.add(future);
        }

        for(Future<Integer> future1 : resultList)
        {
            try
            {
                System.out.println("Factorial for is : "+future1.get() + " And Task done is " + future1.isDone());
            }
            catch (Exception e){
            e.printStackTrace();
            }

        }

        executor.shutdown();
    }
}
