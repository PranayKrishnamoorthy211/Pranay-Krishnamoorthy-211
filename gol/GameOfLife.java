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

                 int neighborX = x + i;
                int neighborY = y + j;

                if (neighborX < 0) neighborX += rows;
                if (neighborX >= rows) neighborX -= rows;
                if (neighborY < 0) neighborY += cols;
                if (neighborY >= cols) neighborY -= cols;

                count += board[neighborX][neighborY];
            }
        }
        return count;
    }

    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit = board.length;
        
        int wrappedX = x % xLimit;
        if (wrappedX < 0) wrappedX += xLimit;

        int wrappedY = y % yLimit;
        if (wrappedY < 0) wrappedY += yLimit;
        
        return board[wrappedX][wrappedY];
    }

    public int[][] get() {
        return board;
    }
    
    public void print() {
        System.out.print("\n ");
        for (int y = 0; y < board.length; y++) {
            System.out.print(y % 10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x % 10);
            for (int y = 0; y < board[x].length; y++) {
                System.out.print(board[x][y] == 1 ? "⬛" : "⬜");
            }
        }
        System.out.println();
    }
}
