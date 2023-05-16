package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = 0;
            }
        }
        this.board[3][3] = 1;
        this.board[3][4] = 2;
        this.board[4][3] = 1;
        this.board[4][4] = 2;
    }

    public Board(int[][] board) {
        this.board = board;
    }

    public List<Move> getMoveForPlayerOne(){
        Set<Move> moves = new HashSet<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(this.board[row][col] == 1){
                    if(col<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row, col+1))){// ->
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
                    if(row<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row+1, col))){ // \/
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
                    if(col>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row, col-1))){ // <-
                        for (int i = col-1; i >= 0; i--) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row, i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row, i) == null){
                                moves.add(new Move(row, i));
                                break;
                            }
                        }
                    }
                    if(row>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row-1, col))){ // ^
                        for (int i = row-1; i >= 0; i--) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, i, col))){
                                break;
                            }
                            if(isEnemyPion(row, col, i, col) == null){
                                moves.add(new Move(i, col));
                                break;
                            }
                        }
                    }
                    if(row<7 && col<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row+1, col+1))){ // -> \/
                        for (int i = 1; i < 7 - Math.max(row, col); i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row + i, col + i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row + i, col + i) == null){
                                moves.add(new Move(row + i, col + i));
                                break;
                            }
                        }
                    }
                    if(row>0 && col<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row-1, col+1))){ // <- \/
                        for (int i = 1; i < Math.min(row, 7 - col)+1; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row - i, col + i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row - i, col + i) == null){
                                moves.add(new Move(row - i, col + i));
                                break;
                            }
                        }
                    }
                    if(row<7 && col>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row+1, col-1))){ // -> ^
                        for (int i = 1; i < Math.min(7 - row, col)+1; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row + i, col - i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row + i, col - i) == null){
                                moves.add(new Move(row + i, col - i));
                                break;
                            }
                        }
                    }
                    if(row>0 && col>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row-1, col-1))){ // <- ^
                        for (int i = 1; i < Math.min(row, col)+1; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row - i, col - i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row - i, col - i) == null){
                                moves.add(new Move(row - i, col - i));
                                break;
                            }
                        }
                    }
                }
            }
        }

        return moves.stream().toList();
    }

    private Boolean isEnemyPion(int row1, int col1, int row2, int col2){
        if(this.board[row2][col2] == 0) return null;
        return (this.board[row1][col1] != (this.board[row2][col2]));
    }

    public List<Move> getMoveForPlayerTwo(){
        Set<Move> moves = new HashSet<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(this.board[row][col] == 2){
                    if(col<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row, col+1))){// ->
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
                    if(row<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row+1, col))){ // \/
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
                    if(col>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row, col-1))){ // <-
                        for (int i = col-1; i >= 0; i--) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row, i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row, i) == null){
                                moves.add(new Move(row, i));
                                break;
                            }
                        }
                    }
                    if(row>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row-1, col))){ // ^
                        for (int i = row-1; i >= 0; i--) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, i, col))){
                                break;
                            }
                            if(isEnemyPion(row, col, i, col) == null){
                                moves.add(new Move(i, col));
                                break;
                            }
                        }
                    }
                    if(row<7 && col<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row+1, col+1))){ // -> \/
                        for (int i = 1; i < 7 - Math.max(row, col); i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row + i, col + i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row + i, col + i) == null){
                                moves.add(new Move(row + i, col + i));
                                break;
                            }
                        }
                    }
                    if(row>0 && col<7 && Boolean.TRUE.equals(isEnemyPion(row, col, row-1, col+1))){ // <- \/
                        for (int i = 1; i < Math.min(row, 7 - col)+1; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row - i, col + i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row - i, col + i) == null){
                                moves.add(new Move(row - i, col + i));
                                break;
                            }
                        }
                    }
                    if(row<7 && col>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row+1, col-1))){ // -> ^
                        for (int i = 1; i < Math.min(7 - row, col)+1; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row + i, col - i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row + i, col - i) == null){
                                moves.add(new Move(row + i, col - i));
                                break;
                            }
                        }
                    }
                    if(row>0 && col>0 && Boolean.TRUE.equals(isEnemyPion(row, col, row-1, col-1))){ // <- ^
                        for (int i = 1; i < Math.min(row, col)+1; i++) {
                            if(Boolean.FALSE.equals(isEnemyPion(row, col, row - i, col - i))){
                                break;
                            }
                            if(isEnemyPion(row, col, row - i, col - i) == null){
                                moves.add(new Move(row - i, col - i));
                                break;
                            }
                        }
                    }
                }
            }
        }

        return moves.stream().toList();
    }

    public boolean performMove(Move move, int player){

        List<Move> moves;
        if(player==1) moves = getMoveForPlayerOne();
        else if(player==2) moves = getMoveForPlayerTwo();
        else return false;
        if(!moves.contains(move))
            return false;

        setField(move, player);
        int col = move.getColumn();
        int row = move.getRow();

        if(col<7){// ->
            List<Move> points = new ArrayList<>();
            for (int i = col+1; i < 8; i++) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, row, i))){
                    points.add(new Move(row, i));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, row, i))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        if(row<7){ // \/
            List<Move> points = new ArrayList<>();
            for (int i = row+1; i < 8; i++) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, i, col))){
                    points.add(new Move(i, col));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, i, col))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        if(col>0){ // <-
            List<Move> points = new ArrayList<>();
            for (int i = col-1; i >= 0; i--) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, row, i))){
                    points.add(new Move(row, i));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, row, i))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        if(row>0){ // ^
            List<Move> points = new ArrayList<>();
            for (int i = row-1; i >= 0; i--) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, i, col))){
                    points.add(new Move(i, col));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, i, col))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        if(row<7 && col<7){ // -> \/
            List<Move> points = new ArrayList<>();
            for (int i = 1; i < 8 - Math.max(row, col); i++) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, row + i, col + i))){
                    points.add(new Move(row + i, col + i));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, row + i, col + i))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        if(row>0 && col<7){ // <- \/
            List<Move> points = new ArrayList<>();
            for (int i = 1; i < Math.min(row, 7 - col)+1; i++) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, row - i, col + i))){
                    points.add(new Move(row - i, col + i));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, row - i, col + i))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        if(row<7 && col>0){ // -> ^
            List<Move> points = new ArrayList<>();
            for (int i = 1; i < Math.min(7 - row, col)+1; i++) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, row + i, col - i))){
                    points.add(new Move(row + i, col - i));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, row + i, col - i))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        if(row>0 && col>0){ // <- ^
            List<Move> points = new ArrayList<>();
            for (int i = 1; i < Math.min(row, col)+1; i++) {
                if(Boolean.TRUE.equals(isEnemyPion(row, col, row - i, col - i))){
                    points.add(new Move(row - i, col - i));
                }
                else if(Boolean.FALSE.equals(isEnemyPion(row, col, row - i, col - i))){
                    for( Move point : points){
                        changePionToEnemy(point.getRow(), point.getColumn());
                    }
                    break;
                }
                else break;
            }
        }
        return true;
    }

    public Board copyBoard(){
        Board newBoard = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newBoard.board[i][j] = this.board[i][j];
            }
        }
        return newBoard;
    }

    public boolean isBoardFull(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
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

    public void displayBoard() {
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
            System.out.println("-----------------------------");
        }
        System.out.println();
        System.out.println();
    }

    public int getField(int row, int column){
        return this.board[row][column];
    }
    public void setField(int row, int column, int value){
        this.board[row][column] = value;
    }
    public int getField(Move move){
        return this.board[move.getRow()][move.getColumn()];
    }
    public void setField(Move move, int value){
        this.board[move.getRow()][move.getColumn()] = value;
    }

    public void changePionToEnemy(int row, int column){
        this.board[row][column] = 3 - this.board[row][column];
    }

}
