package Problems_On_Hashmaps;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {
        String[][] board = {{"5","3",".",".","7",".","6",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"}
                ,{"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."}
                ,{".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};// false

        System.out.println(isValidSudoku(board));
    }

    static public boolean isValidSudoku(String[][] board) {

        // For each row
        for(int i = 0; i < board.length; i++) {
            HashSet<String> set = new HashSet<>();

            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ".") continue;

                if(set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        // For each col
        for(int i = 0; i < board.length; i++) {
            HashSet<String> set = new HashSet<>();

            for(int j = 0; j < board[i].length; j++) {
                if(board[j][i].equals(".")) continue;

                if(set.contains(board[j][i])) {
                    return false;
                }

                set.add(board[j][i]);

            }
        }

        // For each grid
        for(int i = 0; i < board.length; i=i+3) {
            for(int j = 0; j < board[i].length; j=j+3) {

                boolean grid = checkGrid(board, i, j);

                if(!grid) return false;
            }
        }

        return true;
    }

    static public boolean checkGrid(String[][] grid, int iIndex, int jIndex) {
        HashSet<String> set = new HashSet<>();

        for(int i = iIndex; i <= iIndex+2; i++) {
            for(int j = jIndex; j <= jIndex+2; j++) {
                if(grid[i][j].equals(".")) continue;

                if(set.contains(grid[i][j])) {
                    return false;
                }

                set.add(grid[i][j]);
            }
        }
        return true;
    }
}
