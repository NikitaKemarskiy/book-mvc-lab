package com.nikita.model;

class IdGenerator {
    private static int current = 0;

    private IdGenerator() {}

    public static int getId() {
        return current++;
    }
}
