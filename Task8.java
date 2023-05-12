import java.util.Arrays;
import java.util.Stack;

public class DijkstraAlgorithm {
    private static final int NUM_VERTICES = 5;

    public static void main(String[] args) {
        int[][] graph = {
                {-1, 1, -1, 1, 1},
                {-1, -1, 1, -1, -1},
                {-1, -1, -1, -1, 1},
                {-1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1}
        };
        int sourceNode = 0;

        int[] distances = new int[NUM_VERTICES];
        int[] parents = new int[NUM_VERTICES];
        boolean[] visited = new boolean[NUM_VERTICES];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        distances[sourceNode] = 0;

        for (int i = 0; i < NUM_VERTICES - 1; i++) {
            int currentVertex = getVertexWithMinDistance(distances, visited);
            visited[currentVertex] = true;
            for (int j = 0; j < NUM_VERTICES; j++) {
                int edgeWeight = graph[currentVertex][j];
                if (edgeWeight != -1 && !visited[j]) {
                    int newDistance = distances[currentVertex] + edgeWeight;
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                        parents[j] = currentVertex;
                    }
                }
            }
        }

        printShortestPaths(distances, parents);
    }

    private static int getVertexWithMinDistance(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;
        for (int i = 0; i < NUM_VERTICES; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minVertex = i;
            }
        }
        return minVertex;
    }

    private static void printShortestPaths(int[] distances, int[] parents) {
        char[] nodes = new char[]{'A', 'B', 'C', 'D', 'E'};
        for (char node : nodes) {
            int index = node - 'A';
            System.out.printf("Shortest distance from source to %c is %d, path: ", node, distances[index]);
            Stack<Character> path = new Stack<>();
            int current = index;
            path.push(node);
            while (parents[current] != -1) {
                path.push((char) (parents[current] + 'A'));
                current = parents[current];
            }
            while (!path.empty()) {
                System.out.print(path.pop() + " ");
            }
            System.out.println();
        }
    }
}