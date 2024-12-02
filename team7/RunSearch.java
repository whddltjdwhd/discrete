package team7;

import java.util.List;

public abstract class RunSearch {
    protected List<AdjacencyMatrix> list;

    public RunSearch(List<AdjacencyMatrix> list) {
        this.list = list;
    }

    public abstract void searchFunction(AdjacencyMatrix m);

    public void run() {
        int i = 1;
        // 모든 연결 그래프에 대해서 탐색 실시
        for (var m : this.list) {
            System.out.println("그래프 [ " + i++ + " ]");
            System.out.println("----------------------------");
            searchFunction(m); // 추상 메소드 호출을 통해 그래프 탐색 실시
            System.out.println("============================\n");
        }
    }
}
