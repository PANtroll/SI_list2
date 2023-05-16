package org.example;

import org.example.strategy.Center;
import org.example.strategy.Random;

import java.sql.Array;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            //   A  B  C  D  E  F  G  H
//                {2, 2, 2, 1 ,1 ,1 ,1, 1}, //1
//                {2, 2, 2, 2 ,2 ,0 ,1, 1}, //2
//                {2, 2, 2, 0 ,2 ,1 ,1, 1}, //3
//                {2, 2, 2, 2 ,1 ,1 ,1, 1}, //4
//                {2, 2, 2, 2 ,1 ,0 ,1, 1}, //5
//                {2, 2, 2, 2 ,1 ,1 ,2, 1}, //6
//                {2, 2, 1, 1 ,1 ,1 ,1, 1}, //7
//                {2, 1, 1, 1 ,1 ,1 ,1, 1}, //8

                {0, 1, 0, 1 ,1 ,1 ,0, 0}, //1
                {2, 2, 2, 2 ,2 ,2 ,2, 0}, //2
                {2, 2, 1, 2 ,1 ,1 ,1, 2}, //3
                {2, 2, 2, 2 ,1 ,1 ,1, 2}, //4
                {1, 2, 1, 2 ,1 ,2 ,1, 2}, //5
                {0, 1, 2, 2 ,2 ,2 ,1, 2}, //6
                {1, 1, 1, 2 ,2 ,1 ,1, 0}, //7
                {0, 0, 2, 2 ,2 ,2 ,1, 0}, //8


//                {2, 2, 0, 0 ,0 ,0 ,1, 1}, //1
//                {2, 2, 0, 0 ,0 ,0 ,1, 1}, //2
//                {2, 2, 0, 0 ,0 ,1 ,1, 1}, //3
//                {2, 2, 2, 2 ,1 ,1 ,1, 1}, //4
//                {2, 2, 2, 2 ,1 ,0 ,1, 1}, //5
//                {2, 2, 2, 2 ,1 ,1 ,2, 1}, //6
//                {2, 2, 1, 1 ,1 ,1 ,1, 1}, //7
//                {2, 1, 1, 1 ,1 ,1 ,1, 1}, //8
        };

        Board board = new Board(matrix);
        Game game = new Game(board);

        long time = new Date().getTime();
        game.startGame();
        System.out.println("Time: " + (new Date().getTime() - time));
    }
}