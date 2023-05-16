package org.example;

public class Node {
    private int bestValue;
    private int bestMoves;
    private Board bestBoard;

    public Node(int bestValue, int bestMoves, Board bestBoard) {
        this.bestValue = bestValue;
        this.bestMoves = bestMoves;
        this.bestBoard = bestBoard;
    }

    public int getBestValue() {
        return bestValue;
    }

    public int getBestMoves() {
        return bestMoves;
    }

    public Board getBestBoard() {
        return bestBoard;
    }

    public void setBestValue(int bestValue) {
        this.bestValue = bestValue;
    }

    public void setBestMoves(int bestMoves) {
        this.bestMoves = bestMoves;
    }

    public void setBestBoard(Board bestBoard) {
        this.bestBoard = bestBoard;
    }

    @Override
    public String toString() {
        return "bestValue=" + bestValue +
                ", bestMoves=" + bestMoves +
                ", bestBoard=\n" + bestBoard +
                '\n';
    }
}
