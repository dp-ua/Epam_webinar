package com.epam.webinar.lists;


import java.util.*;


//test the duration of operations
public class Demo {
    public static void main(String[] args) {
        List<Integer> listBLink = new LinkedList<>();
        List<Integer> listBArray = new ArrayList<>();

        List<Integer> listTwo = new TwoWayList<>();
        List<Integer> listArray = new TwoWayList<>();

        Map<String, Long> time = new LinkedHashMap<>();

        time.put("Start", Calendar.getInstance().getTimeInMillis());

        int size=10_000_000;
        int cropSize = size/10;

        for (int i = 0; i < size; i++) {
            listTwo.add(i);
//            if (i % cropSize == 0) time.put("add " + i + " to TwoWay", Calendar.getInstance().getTimeInMillis());
        }
        time.put("Fill TwoWay List", Calendar.getInstance().getTimeInMillis());

        for (int i = 0; i < size; i++) {
            listArray.add(i);
//            if (i % cropSize == 0) time.put("add " + i + " to Array", Calendar.getInstance().getTimeInMillis());
        }
        time.put("Fill MyArray List", Calendar.getInstance().getTimeInMillis());

        for (int i = 0; i < size; i++) {
            listBLink.add(i);
//            if (i % cropSize == 0) time.put("add " + i + " to Array", Calendar.getInstance().getTimeInMillis());
        }
        time.put("Fill Basic Linked List", Calendar.getInstance().getTimeInMillis());

        for (int i = 0; i < size; i++) {
            listBArray.add(i);
//            if (i % cropSize == 0) time.put("add " + i + " to Array", Calendar.getInstance().getTimeInMillis());
        }
        time.put("Fill Basic Array List", Calendar.getInstance().getTimeInMillis());




        long t = 0;
        for (Map.Entry<String, Long> pair : time.entrySet()) {
            if (t == 0) t = pair.getValue();
            long spent = pair.getValue() - t;
            t = pair.getValue();
            System.out.println(pair.getKey() + " "  + (spent == 0 ? "" : " time: " + spent + "ms"));
        }

    }
}
