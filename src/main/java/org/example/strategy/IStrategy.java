package org.example.strategy;

import org.example.Move;

import java.util.List;

public interface IStrategy {

    public Move chooseMove(List<Move> moves);

}
