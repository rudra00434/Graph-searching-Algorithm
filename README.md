# Graph-searching-Algorithm
Data Structure and Algorithms
## Finding the Shortest Path: A Java Implementation of Dijkstra's Algorithm with 5 Test Cases

Dijkstra's algorithm is a cornerstone in graph theory and computer science, celebrated for its efficiency in finding the shortest paths from a single source vertex to all other vertices in a weighted graph. This article provides a comprehensive Java implementation of Dijkstra's algorithm, complete with five distinct test cases to illustrate its functionality and robustness in various scenarios.

The core of Dijkstra's algorithm is a greedy approach that maintains a set of visited vertices and iteratively selects the unvisited vertex with the smallest known distance from the source. It then updates the distances to its neighbors if a shorter path is found. To achieve an efficient implementation, a priority queue is often employed to store the vertices and their associated distances, allowing for quick retrieval of the vertex with the minimum distance.

The provided Java code utilizes an adjacency list to represent the graph, where each vertex maintains a list of its neighboring vertices and the corresponding edge weights. A PriorityQueue is used to optimize the process of selecting the next vertex to visit.

<h1>Explanation of Test Cases </h1>

The five test cases included in the main method are designed to verify the algorithm's correctness under different conditions:

Test Case 1: Simple Graph: This is a basic test to ensure the fundamental logic of the algorithm is sound. It calculates the shortest paths in a small, straightforward graph.

Test Case 2: Direct Path is Not the Shortest: This scenario is crucial for testing the core principle of Dijkstra's algorithm. There is a direct path from the start node to another node, but a longer, indirect path has a smaller total weight. The algorithm should correctly identify the indirect path as the shortest.

Test Case 3: Graph with Disconnected Nodes: This test demonstrates how the algorithm handles nodes that are unreachable from the source. The output will show "No path" for these disconnected nodes, confirming the algorithm correctly identifies the lack of a path.

Test Case 4: Larger and More Complex Graph: This case uses a graph with more vertices and edges to test the algorithm's performance and correctness on a more intricate network of paths.

Test Case 5: Graph with a Cycle: Dijkstra's algorithm is designed for graphs with non-negative edge weights, and it can handle cycles. This test includes a cycle to ensure that the algorithm does not get caught in an infinite loop and still finds the correct shortest paths.

Google Search Suggestions
Display of Search Suggestions is required when using Grounding with Google Search. Learn more
Dijkstra's algorithm in Java
Java code for Dijkstra's algorithm with adjacency list
Dijkstra's algorithm java implementation github
5 test cases for Dijkstra's algorithm
<h1>Here is the visual representation of Dijkstra's Algorithm</h1><img width="800 px" height="502 px" alt="d2-(1)" src="https://github.com/user-attachments/assets/1cfb7776-169b-4cc6-b209-12c225090d34" />
<img width ="800 px" height ="502 px" src="https://github.com/user-attachments/assets/d2e01b81-8299-4b94-8a0f-88d7d2ef47b3" />

<img width="538" height="284" alt="1_-MpmvcyfJbxvI_1jIt5lJA" src="https://github.com/user-attachments/assets/4dd4f7e6-f7b3-410b-8b98-865033d131dd" />


## 🚀 A* Pathfinding algorithm in Java

This project demonstrates the A* (A-star) pathfinding algorithm implemented in Java on a simple 2D grid. The program finds the shortest path from a start node to a goal node while avoiding obstacles.

📌 Features

Implements A* pathfinding with a Manhattan distance heuristic.

Works on a 2D grid (matrix).

Supports obstacles (cells marked as blocked).

Reconstructs and prints the shortest path step by step.

Easy-to-understand code for learning pathfinding algorithms.

🧠 How It Works

Grid Representation

0 → Free cell

1 → Obstacle

Algorithm

Uses a priority queue (min-heap) to always expand the lowest f = g + h node.

g = cost from start node

h = heuristic cost (Manhattan distance)

Explores neighbors in 4 directions (Up, Down, Left, Right).

Stops when the goal is reached.

Output

If a path exists, prints the sequence of (row, col) coordinates.

Otherwise, prints "No path found".
## Input Grid:
```
0 0 0 0 0
1 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 0 0
```

Start = (0,0)

Goal = (4,4)
## Output:
```
Path found:
(0, 0)
(0, 1)
(0, 2)
(1, 2)
(2, 2)
(2, 3)
(2, 4)
(3, 4)
(4, 4)
```
