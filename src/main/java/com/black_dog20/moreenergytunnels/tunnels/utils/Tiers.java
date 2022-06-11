package com.black_dog20.moreenergytunnels.tunnels.utils;

public enum Tiers {
    ADVANCED(51_200),
    ELITE(409_600),
    ULTIMATE(3_270_000);

    private final int capacity;

    Tiers(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
