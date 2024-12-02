package team7;

import java.util.Arrays;
import java.util.List;

public class DFSBFS extends RunSearch {
    // 인접 행렬 리스트를 받는 생성자
    public DFSBFS(List<AdjacencyMatrix> list) {
        super(list);
    }

    // 깊이 우선 탐색(DFS)과 너비 우선 탐색(BFS) 수행
    @Override
    public void searchFunction(AdjacencyMatrix m) {
        dfs(m);
        bfs(m);
    }

    // 깊이 우선 탐색 메서드
    private void dfs(AdjacencyMatrix m) {
        // 스택, 방문 여부, 결과 문자열 초기화
        Stack s = new Stack(m.size);
        boolean[] visited = new boolean[m.size];
        StringBuilder sb = new StringBuilder();

        // 시작 노드 설정 (0번 노드)
        s.push(0);
        visited[0] = true;
        sb.append(s.peek() + 1).append(" ");

        while (!s.isEmpty()) {
            // 현재 노드의 인접 노드 행 조회
            int[] row = m.getRow(s.peek());
            boolean foundUnvisited = false;

            // 인접한 미방문 노드 탐색
            for (int i = 0; i < m.size; i++) {
                if (row[i] == 1 && !visited[i]) {
                    s.push(i);
                    visited[i] = true;
                    sb.append(s.peek() + 1).append(" ");
                    foundUnvisited = true;
                    break;
                }
            }

            // 더 이상 탐색할 노드가 없으면 현재 노드 제거
            if (!foundUnvisited) {
                s.pop();
            }
        }

        // 결과 출력 형식 변환
        String str = sb.toString().trim().replaceAll(" ", " - ");
        System.out.println("깊이 우선 탐색");
        System.out.println(str);
    }

    // 너비 우선 탐색 메서드
    private void bfs(AdjacencyMatrix m) {
        // 큐, 방문 여부, 결과 문자열 초기화
        Queue q = new Queue(m.size);
        boolean[] visited = new boolean[m.size];
        StringBuilder sb = new StringBuilder();

        // 시작 노드 설정 (0번 노드)
        q.enqueue(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            // 현재 노드 처리 및 결과 문자열에 추가
            int current = q.dequeue();
            sb.append(current + 1).append(" ");

            // 현재 노드의 인접 노드 행 조회
            int[] row = m.getRow(current);

            // 인접한 미방문 노드 탐색 및 큐에 추가
            for (int i = 0; i < m.size; i++) {
                if (row[i] == 1 && !visited[i]) {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
        }

        // 결과 출력 형식 변환
        String str = sb.toString().trim().replaceAll(" ", " - ");
        System.out.println("너비 우선 탐색");
        System.out.println(str);
    }
}