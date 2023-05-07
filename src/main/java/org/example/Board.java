package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int board [][];

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public Board() {
        this.board = new int[8][8];
    }

    public Board(int[][] board) {
        this.board = board;
    }

    public List<Move> getMoveForPlayerOne(){
        List<Move> moves = new ArrayList<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(this.board[row][col] == 1){//todo dla 8 kierunków
                    if(col<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row, col+1))){
                        for (int i = col+1; i < 8; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row, i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row, i) == null){
                                moves.add(new Move(row, i));
                                break;
                            }
                        }
                    }
                    if(row<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row+1, col))){
                        for (int i = row+1; i < 8; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, i, col))){
                                break;
                            }
                            if(isEnemyPion(row, col, i, col) == null){
                                moves.add(new Move(i, col));
                                break;
                            }
                        }
                    }
                    if(col>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row, col-1))){
                        for (int i = col-1; i > 0; i--) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row, i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row, i) == null){
                                moves.add(new Move(row, i));
                                break;
                            }
                        }
                    }
                    if(row>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row-1, col))){
                        for (int i = row-1; i > 0; i--) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, i, col))){
                                break;
                            }
                            if(isEnemyPion(row, col, i, col) == null){
                                moves.add(new Move(i, col));
                                break;
                            }
                        }
                    }
                }
            }
        }

        return moves;
    }

    private Boolean isEnemyPion(int row1, int col1, int row2, int col2){
        if(this.board[row2][col2] == 0) return null;
        return (this.board[row1][col1] != (this.board[row2][col2]));
    }

    public List<Move> getMoveForPlayerTwo(){



        return null;
    }

    @Override
    public String toString(){
        String string = "";
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                string += (this.board[row][col] == 0 ? " " : this.board[row][col]);
                if(col!=7){
                    string += (" | ");
                }
                else{
                    string += '\n';
                }
            }
        }
        return string;
    }

    private void displayBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                System.out.print(this.board[row][col] == 0 ? " " : this.board[row][col]);
                if(col!=7){
                    System.out.print(" | ");
                }
                else{
                    System.out.println();
                }
            }
        }
    }

}
