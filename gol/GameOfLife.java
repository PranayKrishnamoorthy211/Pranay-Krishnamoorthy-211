package gol;

import java.util.Arrays;

public class GameOfLife implements Board {

    private int[][] board;

    public GameOfLife(int x, int y) {
        this.board = new int[x][y];
    }

    public void set(int startX, int startY, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, this.board[startX + i], startY, data[i].length);
        }
    }

