package org.example.strategy;

import org.example.Move;

import java.util.List;

public class Random implements IStrategy{
    @Override
    public Move chooseMove(List<Move> moves) {
        java.util.Random r = new java.util.Random();
        return moves.get(r.nextInt(moves.size()));
    }
}
