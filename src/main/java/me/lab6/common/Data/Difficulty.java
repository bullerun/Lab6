package me.lab6.common.Data;

import java.io.Serializable;

public enum Difficulty implements Serializable {
    VERY_EASY,
    EASY,
    VERY_HARD,
    TERRIBLE;
    public static String allDifficulty(){
        StringBuilder allDifficulty = new StringBuilder();
        for (Difficulty i: Difficulty.values()) {
            allDifficulty.append(i).append(" ");
        }
        return allDifficulty.toString();
    }
}