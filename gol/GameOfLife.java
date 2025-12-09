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

    public void run(int turns) {
        while (turns-- > 0) {
            step();
        }
    }

     public void step() {
        print();
        int rows = board.length;
        int cols = board.length;
        int[][] nextBoard = new int[rows][cols];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                int neighbors = countNeighbors(x, y);

                if (board[x][y] == 1) {
                    nextBoard[x][y] = (neighbors >= 2 && neighbors <= 3) ? 1 : 0;
                } else {
                    nextBoard[x][y] = (neighbors == 3) ? 1 : 0;
                }
            }
        }
        this.board = nextBoard;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;
        int rows = board.length;
        int cols = board.length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;