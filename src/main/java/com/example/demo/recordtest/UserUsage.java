package com.example.demo.recordtest;

import java.util.List;

public class UserUsage{

    static List<TestUser> userList = List.of(
        new TestUser("Aung1","aung@gmail"),
        new TestUser("Aung2","aung@gmail"),
        new TestUser("Aung3","aung@gmail")
    );

    public static void main(String[] args) {
         try {
            userList.stream()
                .map(TestUser::name)
                .map(String::toUpperCase)
                .filter(n -> n.equalsIgnoreCase("AUNG3"))
                .forEach(UserUsage::display);
         } catch (Exception e) {
            e.printStackTrace();
         }
    }

    static void display(String name){
        System.out.println("Name : " + name);
    }
}


