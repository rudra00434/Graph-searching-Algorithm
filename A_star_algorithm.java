import java.util.*;

class Node implements Comparable<Node> {
    int row, col;
    int g; // cost from start
    int h; // heuristic cost to goal
    Node parent;

    Node(int row, int col, int g, int h, Node parent) {
        this.row = row;
        this.col = col;
        this.g = g;
        this.h = h;
        this.parent = parent;
    }

    int f() {
        return g + h;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.f(), other.f());
    }
}

public class A_star_algorithm {
    static int[][] grid = {
        {0, 0, 0, 0, 0},
        {1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0}
    };

    static int rows = grid.length;
    static int cols = grid[0].length;

    static int[] dRow = {-1, 1, 0, 0}; // Up, Down, Left, Right
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) {
        Node start = new Node(0, 0, 0, heuristic(0, 0, 4, 4), null);
        Node goal = new Node(4, 4, 0, 0, null);

        List<Node> path = aStarSearch(start, goal);

        if (path != null) {
            System.out.println("Path of A* is found:");
            for (Node n : path) {
                System.out.println("(" + n.row + ", " + n.col + ")");
            }
        } else {
            System.out.println("Path of A* not found.");
        }
    }

    static List<Node> aStarSearch(Node start, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        boolean[][] closedSet = new boolean[rows][cols];

        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.row == goal.row && current.col == goal.col) {
                return reconstructPath(current);
            }

            closedSet[current.row][current.col] = true;

            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dRow[i];
                int newCol = current.col + dCol[i];

                if (isValid(newRow, newCol, closedSet)) {
                    int gCost = current.g + 1;
                    int hCost = heuristic(newRow, newCol, goal.row, goal.col);
                    Node neighbor = new Node(newRow, newCol, gCost, hCost, current);

                    openSet.add(neighbor);
                }
            }
        }
        return null;
    }

    static boolean isValid(int row, int col, boolean[][] closedSet) {
        return row >= 0 && row < rows && col >= 0 && col < cols &&
               grid[row][col] == 0 && !closedSet[row][col];
    }

    static int heuristic(int row, int col, int goalRow, int goalCol) {
        // Manhattan Distance
        return Math.abs(row - goalRow) + Math.abs(col - goalCol);
    }

    static List<Node> reconstructPath(Node goal) {
        List<Node> path = new ArrayList<>();
        Node current = goal;
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }
}
