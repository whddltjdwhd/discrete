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
        for (var m : this.list) {
            System.out.println("그래프 [ " + i++ + " ]");
            System.out.println("----------------------------");
            searchFunction(m); // 추상 메서드 호출
            System.out.println("============================\n");
        }
    }
}
