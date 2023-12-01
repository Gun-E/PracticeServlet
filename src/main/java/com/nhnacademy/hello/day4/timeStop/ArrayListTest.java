package com.nhnacademy.hello.day4.timeStop;

import com.nhnacademy.hello.day4.timeStop.PerformanceTestable;
import com.nhnacademy.hello.day4.timeStop.StopWatch;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest implements PerformanceTestable {

    @StopWatch
    @Override
    public void test() {
        List<Integer> integerList = new ArrayList<>();
        for(int i=0; i<100000000; i++){
            integerList.add(i);
        }
    }
}