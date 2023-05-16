package org.example;

import org.example.Board;
import org.example.Move;
import org.example.heurystics.CountPions;
import org.example.heurystics.IHeuristic;

import java.util.List;

public class MinMax {

    static int nodesCounter = 0;

    private IHeuristic heuristic;

    public MinMax(IHeuristic heuristic) {
        this.heuristic = heuristic;
    }

    public Node performMinMax(Board board, int moves, int player){
        int bestValue;
        Node node = null;
        nodesCounter++;
        List<Move> moveForPlayerOne = board.getMoveForPlayerOne();
        List<Move> moveForPlayerTwo = board.getMoveForPlayerTwo();
        if(board.isBoardFull() || (moveForPlayerOne.isEmpty() && moveForPlayerTwo.isEmpty())){
            bestValue = heuristic.marksBoard(board, 1);
            System.out.println(nodesCounter + "\t" + moves);
            return new Node(bestValue, moves, board);
        }
        if(player == 1 && moveForPlayerOne.isEmpty() && !moveForPlayerTwo.isEmpty()){
            bestValue = Integer.MIN_VALUE;
            Node nextNode = performMinMax(board.copyBoard(), moves, 2);
            node = compareNodeForPlayerOne(board, moves, bestValue, nextNode);
        }
        else if(player == 1){
            bestValue = Integer.MIN_VALUE;
            for(Move move : moveForPlayerOne){
                Node nextNode = performMinMax(prepareBoard(board, move, 1), moves +1 , 2);
                node = compareNodeForPlayerOne(board, moves, bestValue, nextNode);
            }
        }
        else if(player == 2 && moveForPlayerTwo.isEmpty() && !moveForPlayerOne.isEmpty()){
            bestValue = Integer.MAX_VALUE;
            Node nextNode = performMinMax(board.copyBoard(), moves, 1);
            node = compareNodeForPlayerTwo(board, moves, bestValue, nextNode);

        }
        else if(player == 2){
            bestValue = Integer.MAX_VALUE;
            for(Move move : moveForPlayerTwo){
                Node nextNode = performMinMax(prepareBoard(board, move, 2), moves +1, 1);
                node = compareNodeForPlayerTwo(board, moves, bestValue, nextNode);
            }
        }
        return node;
    }

    private static Node compareNodeForPlayerTwo(Board board, int moves, int bestValue, Node nextNode) {
        Node node;
        if(nextNode.getBestValue() == bestValue && nextNode.getBestMoves() > moves){
            node = new Node(bestValue, moves, board);
        }
        else if(nextNode.getBestValue() < bestValue){
            node = nextNode;
        }
        else{
            node = new Node(bestValue, moves, board);
        }
        return node;
    }

    private static Node compareNodeForPlayerOne(Board board, int moves, int bestValue, Node nextNode) {
        Node node;
        if(nextNode.getBestValue() == bestValue && nextNode.getBestMoves() > moves){
            node = new Node(bestValue, moves, board);
        }
        else if(nextNode.getBestValue() > bestValue){
            node = nextNode;
        }
        else{
            node = new Node(bestValue, moves, board);
        }
        return node;
    }

    private Board prepareBoard(Board board, Move move, int player){
        Board newBoard = board.copyBoard();
        newBoard.performMove(move, player);
        return newBoard;
    }

}
