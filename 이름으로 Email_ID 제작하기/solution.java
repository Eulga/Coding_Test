package com.example;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String abc = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        C = C.toLowerCase();

        List<String> aList = new ArrayList<>();
        HashMap<String, Integer> aMap = new HashMap<>();
        for(String a : abc.replaceAll("-", "").toLowerCase().split(", ")) {
            String name = "";
            String emailName = "";
            
            for(String c : a.split(" ")) {
                name = c;
                emailName += name.charAt(0);
            }
            if(name.length() > 8) emailName += name.substring(1, 8);

            else emailName += name.substring(1, name.length());

            aMap.put(emailName, aMap.getOrDefault(emailName, 0) + 1);

            if(aMap.get(emailName) > 1) emailName += aMap.get(emailName);
            aList.add(emailName);
        }

        String answer = "";
        int i = 0;
        for(String a : abc.split(", ")) {
            answer += a+" <" + aList.get(i++) + "@" + C + ".com>, ";
        }
        
        System.out.println(answer.replaceAll("(, $)", ""));
    }
}
