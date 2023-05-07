package org.example;

import java.sql.Array;

public class Main {
    public static void main(String[] args) {

        int[][] b = new int[][] {
                {0, 0, 0, 0 ,0 ,0 ,0, 0},
                {0, 0, 0, 0 ,0 ,0 ,0, 0},
                {0, 0, 0, 0 ,0 ,0 ,0, 0},
                {0, 0, 0, 1 ,2 ,0 ,0, 0},
                {0, 0, 0, 2 ,1 ,0 ,0, 0},
                {0, 0, 0, 0 ,0 ,0 ,0, 0},
                {0, 0, 0, 0 ,0 ,0 ,0, 0},
                {0, 0, 0, 0 ,0 ,0 ,0, 0},};

        Board board = new Board(b);

        System.out.println(board.getMoveForPlayerOne());
    }
}