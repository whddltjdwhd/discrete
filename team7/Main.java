package team7;

public class Main {
    public static void main(String[] args) {
        Input1Reader reader1 = new Input1Reader("res/input1.txt");
        Input2Reader reader2 = new Input2Reader("res/input2.txt");

        RunSearch dfsbfs = new DFSBFS(reader1.getList());
        RunSearch dijkstra = new Dijkstra(reader2.getList());
        dfsbfs.run();
        dijkstra.run();
    }
}
