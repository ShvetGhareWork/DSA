public class Nqueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        int result = queens(board, 0);
        System.out.println(result);
    }

    static int queens(boolean[][] board, int row){
        if(row == board.length){
            printBoard(board);
            return 1;
        }

        int count = 0;
        // Placing the queen and checking for the next row
        for(int col = 0; col < board.length; col++){
            // Place the queen if it is safe to place.
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

   

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check the column
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
             }
        }

        // Check the left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j]){
                return false;
            }
        }

        // Check the right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j]){
                return false;
            }
        }

        return true;
    }

    private static void printBoard(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}