package org.example;

import org.example.heurystics.IHeuristic;

import java.util.List;

public class AlfaBeta {

    static int nodesCounter = 0;
    static int rejectedNodes = 0;

    private IHeuristic heuristic;

    public AlfaBeta(IHeuristic heuristic) {
        this.heuristic = heuristic;
    }

    public Node performAlfaBeta(Board board, int moves, int player, int alfa, int beta){
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
            bestValue = alfa;
            Node nextNode = performAlfaBeta(board.copyBoard(), moves, 2, alfa, beta);
            node = compareNodeForPlayerOne(board, moves, bestValue, nextNode);
        }
        else if(player == 1){
            bestValue = alfa;
            for(Move move : moveForPlayerOne){
                Node nextNode = performAlfaBeta(prepareBoard(board, move, 1), moves +1 , 2, bestValue, beta);
                node = compareNodeForPlayerOne(board, moves, bestValue, nextNode);
                bestValue = Math.max(node.getBestValue(), bestValue);
                if (beta <=bestValue) {
                    rejectedNodes++;
                    break;
                }
            }
        }
        else if(player == 2 && moveForPlayerTwo.isEmpty() && !moveForPlayerOne.isEmpty()){
            bestValue = beta;
            Node nextNode = performAlfaBeta(board.copyBoard(), moves, 1, alfa, beta);
            node = compareNodeForPlayerTwo(board, moves, bestValue, nextNode);

        }
        else if(player == 2){
            bestValue = beta;
            for(Move move : moveForPlayerTwo){
                Node nextNode = performAlfaBeta(prepareBoard(board, move, 2), moves +1, 1, alfa, bestValue);
                node = compareNodeForPlayerTwo(board, moves, bestValue, nextNode);
                bestValue = Math.min(node.getBestValue(), bestValue);
                if (bestValue <= alfa) {
                    rejectedNodes++;
                    break;
                }
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
