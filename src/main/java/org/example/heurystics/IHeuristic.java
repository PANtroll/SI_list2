package org.example.heurystics;

import org.example.Board;

public interface IHeuristic {

    public int marksBoard(Board board, int player);


    public static int countPionsOnBoard(Board board, int player){
        int sum = 0;
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                sum += board.getField(col, row) == player ? 1 : 0;
            }
        }
        return sum;
    }
}
