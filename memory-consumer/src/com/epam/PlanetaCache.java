package com.epam;

import java.util.HashMap;
import java.util.Map;

public class PlanetaCache {
    private static final Map<PlanetaSinger, int[]> PLANETA_CACHE = new HashMap<>();

    public static void addSinger(PlanetaSinger singer) {
        PLANETA_CACHE.put(singer, new int[1]);
    }
}
