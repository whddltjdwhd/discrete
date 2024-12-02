package team7;

import java.util.*;

public class Dijkstra extends RunSearch {

    // 인접 행렬 리스트를 사용하는 생성자
    public Dijkstra(List<AdjacencyMatrix> list) {
        super(list);
    }

    // 검색 함수 오버라이드 (시작 노드를 1로 고정)
    @Override
    public void searchFunction(AdjacencyMatrix m) {
        dijkstra(m, 1);
    }

    // 다익스트라 알고리즘 핵심 메서드
    private void dijkstra(AdjacencyMatrix m, int start) {
        // 0부터 시작하는 인덱스로 조정
        start = start - 1;

        // 최소 거리 노드 선택을 위한 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // 알고리즘 추적을 위한 배열들 초기화
        boolean[] visited = new boolean[m.size];  // 방문 노드 체크
        int[] distances = new int[m.size];        // 최단 거리 저장
        int[] predecessors = new int[m.size];     // 경로 추적용 이전 노드 저장

        // 거리는 최대값, 이전 노드는 -1로 초기화
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, -1);

        // 시작 노드 거리는 0으로 설정
        distances[start] = 0;
        pq.add(new int[] { start, 0 });

        // 모든 노드 방문할 때까지 반복
        while (!pq.isEmpty()) {
            // 현재 최단 거리 노드 선택
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // 이미 방문한 노드면 건너뛰기
            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            // 모든 인접 노드 탐색
            for (int neighbor = 0; neighbor < m.size; neighbor++) {
                int weight = m.matrix[currentNode][neighbor];

                // 연결된 간선이고 방문하지 않은 노드만 처리
                if (weight > 0 && !visited[neighbor]) {
                    int newDistance = currentDistance + weight;

                    // 더 짧은 경로 발견 시 거리 및 이전 노드 갱신
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        predecessors[neighbor] = currentNode;
                        pq.add(new int[] { neighbor, newDistance });
                    }
                }
            }
        }

        // 결과 출력
        printResult(start, distances, predecessors);
    }

    // 결과 출력 메서드
    private void printResult(int start, int[] distances, int[] predecessors) {
        System.out.println("시작점: " + (start + 1));

        for (int i = 0; i < distances.length; i++) {
            // 시작 노드 제외
            if (i == start) continue;

            // 도달 불가능한 노드 처리
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("정점 [" + (i + 1) + "] : 도달 불가");
            } else {
                // 경로 재구성
                List<Integer> path = reconstructPath(predecessors, start, i);

                // 경로와 거리 출력
                System.out.println("정점 [" + (i + 1) + "] : " +
                        path.stream()
                                .map(String::valueOf)
                                .collect(java.util.stream.Collectors.joining(" - ")) +
                        ", 길이: " + distances[i]);
            }
        }
    }

    // 경로 재구성 메서드
    private List<Integer> reconstructPath(int[] predecessors, int start, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        // 이전 노드를 추적하며 경로 재구성
        while (current != -1 && current != start) {
            path.add(0, current + 1);  // 노드 번호를 리스트 앞에 추가
            current = predecessors[current];
        }

        // 시작 노드 추가
        path.add(0, start + 1);
        return path;
    }
}