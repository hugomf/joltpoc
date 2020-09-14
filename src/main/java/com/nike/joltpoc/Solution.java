package com.nike.joltpoc;

import java.util.Arrays;

class Solution {

    public int solution(String S) {
        
        String[] listWords = S.split("[,?.!]+");
        Arrays.stream(listWords).forEach(System.out::println);
        //List<Integer> longs = Arrays.stream(listWords).map((str) -> str.trim().split(" ").length).collect(Collectors.toList());
        return Arrays.stream(listWords).map((str) -> str.trim().split(" ").length).max(Integer::compareTo).get();
        //longs.forEach(System.out::println);
    }

}