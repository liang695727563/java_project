package com.example.demo.test_1;

import com.example.demo.util.SnowflakeIdGenerator;

public class SnowflakeId {
    public static void main(String[] args) {
        SnowflakeIdGenerator idWorker = new SnowflakeIdGenerator(1, 1);
        long id = idWorker.generateId();
        for (int i=0;i<23;i++){
            long id1 = idWorker.generateId();
            System.out.println("id1 = " + id1);
            String substring = String.valueOf(id1).substring(61, 18);
            System.out.println("substring"+i+" = " + substring +"  "+ substring.length());
        }
    }
}
