import java.util.*;
public class DijkstraAlgorithm {

    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int start) {
        int numVertices = graph.size();
        int[] distances = new int[numVertices];
        int[] previous = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);

        distances[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (current.distance > distances[u]) {
                continue;
            }

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    previous[v] = u;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        printResults(start, distances, previous);
    }

    private static void printResults(int start, int[] distances, int[] previous) {
        System.out.println("Shortest paths from start node " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.print("To " + i + ": ");
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("No path");
            } else {
                System.out.print("Distance = " + distances[i] + ", Path = ");
                List<Integer> path = new ArrayList<>();
                int current = i;
                while (current != -1) {
                    path.add(current);
                    current = previous[current];
                }
                Collections.reverse(path);
                for (int j = 0; j < path.size(); j++) {
                    System.out.print(path.get(j) + (j == path.size() - 1 ? "" : " -> "));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Simple Graph
        System.out.println("--- Test Case 1: Simple Graph ---");
        List<List<Edge>> graph1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph1.add(new ArrayList<>());
        graph1.get(0).add(new Edge(1, 2));
        graph1.get(0).add(new Edge(2, 5));
        graph1.get(1).add(new Edge(2, 1));
        graph1.get(1).add(new Edge(3, 7));
        graph1.get(2).add(new Edge(3, 3));
        dijkstra(graph1, 0);
        System.out.println();

        // Test Case 2: Direct path is not the shortest
        System.out.println("--- Test Case 2: Direct Path is Not the Shortest ---");
        List<List<Edge>> graph2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph2.add(new ArrayList<>());
        graph2.get(0).add(new Edge(1, 1));
        graph2.get(0).add(new Edge(2, 10));
        graph2.get(1).add(new Edge(2, 2));
        graph2.get(1).add(new Edge(3, 5));
        graph2.get(2).add(new Edge(3, 1));
        dijkstra(graph2, 0);
        System.out.println();

        // Test Case 3: Graph with disconnected nodes
        System.out.println("--- Test Case 3: Graph with Disconnected Nodes ---");
        List<List<Edge>> graph3 = new ArrayList<>();
        for (int i = 0; i < 5; i++) graph3.add(new ArrayList<>());
        graph3.get(0).add(new Edge(1, 2));
        graph3.get(1).add(new Edge(2, 3));
        // Node 3 and 4 are not reachable from 0
        graph3.get(3).add(new Edge(4, 1));
        dijkstra(graph3, 0);
        System.out.println();

        // Test Case 4: Larger and more complex graph
        System.out.println("--- Test Case 4: Larger and More Complex Graph ---");
        List<List<Edge>> graph4 = new ArrayList<>();
        for (int i = 0; i < 6; i++) graph4.add(new ArrayList<>());
        graph4.get(0).add(new Edge(1, 10));
        graph4.get(0).add(new Edge(2, 15));
        graph4.get(1).add(new Edge(3, 12));
        graph4.get(1).add(new Edge(5, 15));
        graph4.get(2).add(new Edge(4, 10));
        graph4.get(3).add(new Edge(4, 2));
        graph4.get(3).add(new Edge(5, 1));
        graph4.get(5).add(new Edge(4, 5));
        dijkstra(graph4, 0);
        System.out.println();

        // Test Case 5: Graph with a cycle
        System.out.println("--- Test Case 5: Graph with a Cycle ---");
        List<List<Edge>> graph5 = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph5.add(new ArrayList<>());
        graph5.get(0).add(new Edge(1, 1));
        graph5.get(1).add(new Edge(2, 2));
        graph5.get(2).add(new Edge(3, 3));
        graph5.get(2).add(new Edge(1, 1)); // Cycle back to node 1
        dijkstra(graph5, 0);
        System.out.println();
    }
}


