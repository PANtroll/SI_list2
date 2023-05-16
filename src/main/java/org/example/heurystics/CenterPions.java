package org.example.heurystics;

import org.example.Board;

public class CenterPions implements IHeuristic{
    @Override
    public int marksBoard(Board board, int player) {
        int sumPoints = 0;
        int sumPions = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(board.getField(row, col) != 0) sumPions++;
                if(row == 3 || row == 4 || col == 3 || col == 4){
                    sumPoints += board.getField(row, col) == player ? 7 : -7;
                }
                if(row == 2 || row == 5 || col == 2 || col == 5){
                    sumPoints += board.getField(row, col) == player ? 5 : -5;
                }
                if(row == 1 || row == 6 || col == 1 || col == 6){
                    sumPoints += board.getField(row, col) == player ? 3 : -3;
                }
                if(row == 0 || row == 7 || col == 0 || col == 7){
                    sumPoints += board.getField(row, col) == player ? 1 : -1;
                }
            }
        }
        if(sumPions == 64)
            return sumPoints > 0 ? 1000 : -1000;
        return sumPoints;
    }
}
