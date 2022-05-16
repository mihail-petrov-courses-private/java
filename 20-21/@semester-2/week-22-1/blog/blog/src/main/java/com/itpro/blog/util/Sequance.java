package com.itpro.blog.util;

public class Sequance {

    private static int sequanceCounter = 0;

    public static int next() {
        return sequanceCounter++;
    }
}
