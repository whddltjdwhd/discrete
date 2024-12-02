package team7;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DFSBFS extends RunSearch {
    public DFSBFS(List<AdjacencyMatrix> list) {
        super(list); // 부모 클래스 생성자 호출
    }

    @Override
    public void searchFunction(AdjacencyMatrix m) {
        dfs(m); // 깊이 우선 탐색
        bfs(m); // 너비 우선 탐색
    }

    private void dfs(AdjacencyMatrix m) {
        Stack s = new Stack(m.size);
        boolean[] visited = new boolean[m.size];
        StringBuilder sb = new StringBuilder();

        s.push(0);
        visited[0] = true;
        sb.append(s.peek() + 1).append(" ");

        while (!s.isEmpty()) {
            int[] row = m.getRow(s.peek());
            for (int i = 0; i < m.size; i++) {
                if (row[i] == 1 && !visited[i]) {
                    s.push(i);
                    visited[i] = true;
                    sb.append(s.peek() + 1).append(" ");
                    break;
                }
                if (i == m.size - 1)
                    s.pop();
            }
        }

        String str = sb.toString().trim().replaceAll(" ", " - ");
        System.out.println("깊이 우선 탐색");
        System.out.println(str);
    }

    private void bfs(AdjacencyMatrix m) {
        Queue q = new Queue(m.size);
        boolean[] visited = new boolean[m.size];
        StringBuilder sb = new StringBuilder();

        q.enqueue(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] row = m.getRow(q.peek());
            sb.append(q.dequeue() + 1).append(" ");
            for (int i = 0; i < m.size; i++) {
                if (row[i] == 1 && !visited[i]) {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
        }

        String str = sb.toString().trim().replaceAll(" ", " - ");
        System.out.println("너비 우선 탐색");
        System.out.println(str);
    }

}
