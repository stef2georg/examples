package com.epam.heap.dump;

import java.util.HashMap;
import java.util.Map;

public class OutOfMemoryMain {

    public static void main(String[] args) {
        Map<Integer, Object> map = new HashMap<>();
        for (int index = 0; index < Integer.MAX_VALUE; index++) {
            map.put(index, new long[index]);
        }
    }

}
