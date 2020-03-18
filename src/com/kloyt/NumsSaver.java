package com.kloyt;

import java.util.concurrent.CopyOnWriteArrayList;

public class NumsSaver {

    private volatile static NumsSaver instance;

    private CopyOnWriteArrayList<Double> nums = new CopyOnWriteArrayList<>();
    private Double maxNum;
    private Double minNum;
    private Double avg;

    private NumsSaver() {}

    public static NumsSaver getInstance() {
        if (instance == null) {
            synchronized (NumsSaver.class) {
                if (instance == null) {
                    instance = new NumsSaver();
                }
            }
        }
        return instance;
    }

    public Double getMaxNum(){
        return maxNum;
    }

    public Double getMinNum(){
        return minNum;
    }

    public Double getAvg(){
        return avg;
    }

    public void addNum(Double number){
        if(number != null) {
            nums.add(number);
            updateMaxNum(number);
            updateMinNum(number);
            updateAvg();
        }
    }

    private void updateMaxNum(Double num){
        if(maxNum == null){
            maxNum = num;
        } else if(num > maxNum){
            maxNum = num;
        }
    }

    private void updateMinNum(Double num){
        if(minNum == null){
            minNum = num;
        } else if(num < minNum){
            minNum = num;
        }
    }

    private void updateAvg(){
        double sum = 0;
        for (double num: nums) {
            sum+=num;
        }
        avg = sum/nums.size();
    }

    public void clear(){
        nums.clear();
        maxNum = null;
        minNum = null;
        avg = null;
    }
}
