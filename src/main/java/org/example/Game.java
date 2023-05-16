package org.example;

import org.example.heurystics.CenterPions;
import org.example.heurystics.CountPions;
import org.example.heurystics.OutsidePions;
import org.example.strategy.IStrategy;

import java.util.List;

public class Game {
    private Board board = new Board();

    public Game(){
    }

    public Game(Board board) {
        this.board = board;
    }

    public void startGame(){
        MinMax minMax = new MinMax(new CenterPions());
        Node result = minMax.performMinMax(board, 0, 1);
        System.out.println(result);
        System.out.println("Visited nodes: " + MinMax.nodesCounter);
        System.out.println(result.getBestValue() > 0 ? "You Win! :)" : "You Lost :(");

    }

    public boolean MakeMove(int player, List<Move> moves, IStrategy strategy){

        if(moves.isEmpty()){
            return false;
        }
        Move moveToPerform = strategy.chooseMove(moves);
        board.performMove(moveToPerform, player);
        return true;
    }
}
