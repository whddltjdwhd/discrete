package team7;

public class Main {
    public static void main(String[] args) {
        Input1Reader reader1 = new Input1Reader("res/input1.txt");
        Input2Reader reader2 = new Input2Reader("res/input2.txt");

        RunSearch dfsbfs = new DFSBFS(reader1.getList());
        RunSearch dijkstra = new Dijkstra(reader2.getList());

        System.out.println("1. 그래프 탐방 수행 결과");
        dfsbfs.run();

        System.out.println("2. 최단 경로 구하기 수행 결과");
        dijkstra.run();
    }
}
