package team7;

import java.util.*;

public class Dijkstra extends RunSearch {

    public Dijkstra(List<AdjacencyMatrix> list) {
        super(list);
    }

    @Override
    public void searchFunction(AdjacencyMatrix m) {
        dijkstra(m, 1);
    }

    private void dijkstra(AdjacencyMatrix m, int start) {
        // Adjust start index for zero-based indexing
        start = start - 1;

        // Priority queue for selecting minimum distance nodes
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // Initialize tracking arrays
        boolean[] visited = new boolean[m.size];
        int[] distances = new int[m.size];
        int[] predecessors = new int[m.size];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1);

        distances[start] = 0;
        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            // Directly use adjacency matrix row for neighbors
            for (int neighbor = 0; neighbor < m.size; neighbor++) {
                int weight = m.matrix[currentNode][neighbor];

                if (weight > 0 && !visited[neighbor]) {
                    int newDistance = currentDistance + weight;
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        predecessors[neighbor] = currentNode;
                        pq.add(new int[] { neighbor, newDistance });
                    }
                }
            }
        }

        printResult(start, distances, predecessors);
    }

    private void printResult(int start, int[] distances, int[] predecessors) {
        System.out.println("시작점: " + (start + 1));

        for (int i = 0; i < distances.length; i++) {
            if (i == start) continue;

            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("정점 [" + (i + 1) + "] : 도달 불가");
            } else {
                List<Integer> path = reconstructPath(predecessors, start, i);

                System.out.println("정점 [" + (i + 1) + "] : " +
                        path.stream()
                                .map(String::valueOf)
                                .collect(java.util.stream.Collectors.joining(" - ")) +
                        ", 길이: " + distances[i]);
            }
        }
    }

    private List<Integer> reconstructPath(int[] predecessors, int start, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        while (current != -1 && current != start) {
            path.add(0, current + 1);
            current = predecessors[current];
        }

        path.add(0, start + 1);
        return path;
    }
}