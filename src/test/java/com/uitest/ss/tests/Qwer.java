package com.uitest.ss.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Qwer {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        int i = 39;

        int count = 0;

        Iterator<Integer> iterator;
        iterator = set.iterator();
        Object [] arr;

        while(iterator.hasNext()) {
            iterator = set.iterator();
            arr = set.toArray();
            for (int j = 0; i < 100&& count < arr.length; j++) {
                System.out.println(arr[count]);
                count++;
            }
            set.add(i++);
        }
    }
}
