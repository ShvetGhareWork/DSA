import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        // int result = MazePath(4, 4);
        // MazePathPrintDiagonal("", 3, 3);
        // ArrayList<String> resultArraylist = MazePathArray("", 3, 3);
        // System.out.println(result);
        // System.out.println(resultArraylist);
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        // MazeWithObstaclesDiagonal("", 0, 0, maze);
        // boolean[][] visited = new boolean[maze.length][maze[0].length];
        MazeAllowAllDirections("", 0, 0, maze);
    }

    static int MazePath(int row, int col){
        if(row == 1 || col == 1)
            return 1;
        
        int left = MazePath(row - 1, col);
        int right = MazePath(row, col - 1);
        return left + right;
    }

    static void MazePathPrint(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1)
            MazePathPrint(p + 'D', row - 1, col);
        
        if(col > 1)
            MazePathPrint(p + 'R', row, col - 1);
    }
    static void MazePathPrintDiagonal(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1 && col > 1 && row == col)
            MazePathPrint(p + 'S', row - 1, col - 1);

        if(row > 1)
            MazePathPrint(p + 'V', row - 1, col);

        if(col > 1)
            MazePathPrint(p + 'H', row, col - 1);

    }

    static ArrayList<String> MazePathArray(String p, int row, int col){
        if(row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        

        if(row > 1){
            list.addAll(MazePathArray(p + 'D', row - 1, col));
        }

        if(col > 1){
            list.addAll(MazePathArray(p + 'R', row, col - 1));
        }

        return list;
    }

    static void MazeWithObstacles(String p, int row, int col, boolean[][] maze){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

       if(maze[row][col] == true) // Obstacle
            return;

        if(row < maze.length - 1)
            MazeWithObstacles(p + 'D', row + 1, col, maze);
        
        if(col < maze[0].length - 1)
            MazeWithObstacles(p + 'R', row, col + 1, maze);
    }
    static void MazeWithObstaclesDiagonal(String p, int row, int col, boolean[][] maze){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

       if(maze[row][col] == true) // Obstacle
            return;

        if(row < maze.length - 1)
            MazeWithObstacles(p + 'D', row + 1, col, maze);
        
        if(col < maze[0].length - 1)
            MazeWithObstacles(p + 'R', row, col + 1, maze);

        if(row < maze.length - 1 && col < maze[0].length - 1 && row == col)
            MazeWithObstaclesDiagonal(p + 'S', row + 1, col + 1, maze);
    }

    static void MazeAllowAllDirections(String p, int row, int col, boolean[][] maze){
         if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }



       if(!maze[row][col]) // Obstacle
            return;

        maze[row][col] = false; // Mark as visited

        if(row < maze.length - 1)
            MazeAllowAllDirections(p + 'D', row + 1, col, maze);
        
        if(col < maze[0].length - 1)
            MazeAllowAllDirections(p + 'R', row, col + 1, maze);

        if (row > 0) // Up
        MazeAllowAllDirections(p + 'U', row - 1, col, maze);
        

        if (col > 0)  // Left
            MazeAllowAllDirections(p + 'L', row, col - 1, maze);

        // if(row < maze.length - 1 && col < maze[0].length - 1 && row == col)
        //     MazeWithObstaclesDiagonal(p + 'S', row + 1, col + 1, maze);

        // Backtracking
        maze[row][col] = true; // Unmark as visited
    }
}