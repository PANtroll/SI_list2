package org.example.strategy;

import org.example.Move;

import java.util.List;

public class Center implements IStrategy{
    @Override
    public Move chooseMove(List<Move> moves) {
        Move resultMove = moves.get(0);
        for(Move move : moves){
            if (move.getRow() - move.getColumn() < resultMove.getRow() - resultMove.getColumn())
                resultMove = move;
        }
        return resultMove;
    }
}
