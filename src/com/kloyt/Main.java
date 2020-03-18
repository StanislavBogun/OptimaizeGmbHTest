package com.kloyt;

import com.sun.corba.se.impl.orbutil.threadpool.ThreadPoolImpl;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        NumSaverService nss = NumSaverService.getInstance();

        int countThread = (int) Math.round((Math.random() * 200) - 100);

        Thread task1 = new Thread(){
            @Override
            public void run() {
                int count = (int) Math.round((Math.random() * 5000.));
                ArrayList<Double> arr = new ArrayList<>();

                while (count > 0)
                {
                    double addedNum = (double) Math.round((Math.random() * 10000)-5000);
                    System.out.println(addedNum);
                    arr.add(addedNum);
                    count--;
                }

                nss.addNums(arr);
            }
        };

        Thread task2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                    System.out.println("Avg = " + nss.getAvg());
                    System.out.println("Max = " + nss.getMaxNum());
                    System.out.println("Min = " + nss.getMinNum());

                        sleep( Math.round((Math.random() * 5000)) );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        task1.start();
        task2.start();
    }
}
