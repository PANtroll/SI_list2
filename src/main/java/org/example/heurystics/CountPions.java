package org.example.heurystics;

import org.example.Board;

public class CountPions implements IHeuristic{

    public int marksBoard(Board board, int player){

        int scoreOfPlayer = IHeuristic.countPionsOnBoard(board, player);
        int scoreOfOpponent = IHeuristic.countPionsOnBoard(board, 3 - player);
        if(scoreOfPlayer + scoreOfOpponent == 64)
            return scoreOfPlayer > scoreOfOpponent ? 100 : -100;
        return scoreOfPlayer - scoreOfOpponent;
    }


}
