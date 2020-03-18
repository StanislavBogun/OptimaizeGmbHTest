package com.kloyt;

import java.util.Collection;

public class NumSaverService {

    private volatile static NumSaverService instance;

    private NumsSaver ns = NumsSaver.getInstance();

    public static NumSaverService getInstance() {
        if (instance == null) {
            synchronized (NumSaverService.class) {
                if (instance == null) {
                    instance = new NumSaverService();
                }
            }
        }
        return instance;
    }

    void addNum(Double num){
        ns.addNum(num);
    }

    void addNums(Collection<Double> arg){
        for (Double d : arg){
            addNum(d);
        }
    }

    public Double getMaxNum(){
        return ns.getMaxNum();
    }

    public Double getMinNum(){
       return ns.getMinNum();
    }

    public Double getAvg(){
        return ns.getAvg();
    }
}
