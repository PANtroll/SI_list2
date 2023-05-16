package org.example;

import java.util.Objects;

public class Move {

    private int row;
    private int column;

    public Move(int x, int y) {
        this.row = x;
        this.column = y;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return row == move.row && column == move.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Move(" + (row + 1) +
                " " + (column + 1) + ')';
    }
}
