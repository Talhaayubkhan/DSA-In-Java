package Question;

public class RatInMaze {
    public static void findPaths(int maze[][]) {
        int N = maze.length;

        // Create a solution matrix to store the path
        int solution[][] = new int[N][N];

        // If a solution exists, call the solveMaze function and print the solution
        if (solveMaze(maze, 0, 0, solution, N)) {
            printSol(solution);
        } else {
            System.out.println("Solution does not exist");
        }
    }

    // Function to recursively solve the maze path using backtracking
    public static boolean solveMaze(int maze[][], int x, int y, int solution[][], int N) {
        // Base case: If the current cell is the destination
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1; // Mark the destination cell as part of the solution
            return true; // Return true to indicate a successful path
        }

        // Check if the current cell is a valid path
        if (isSafe(maze, x, y, N)) {
            // Mark the current cell as part of the solution path
            solution[x][y] = 1;

            // Right Move: Try moving right
            if (solveMaze(maze, x, y + 1, solution, N)) {
                return true; // If a path is found, return true
            }

            // Down Move: Try moving down
            if (solveMaze(maze, x + 1, y, solution, N)) {
                return true; // If a path is found, return true
            }

            // If neither right nor down move leads to the destination, backtrack
            solution[x][y] = 0; // Mark the current cell as not part of the solution
        }

        return false; // Return false to indicate no path from this cell
    }

    // Function to check if a cell is a valid path
    public static boolean isSafe(int maze[][], int x, int y, int N) {
        return (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1);
    }

    // Function to print the solution matrix
    public static void printSol(int[][] solution) {
        int N = solution.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };

        findPaths(maze); // Find and print paths in the maze
    }
}
