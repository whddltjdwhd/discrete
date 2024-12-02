package team7;

public class Main {
    public static void main(String[] args) {
        Input1Reader reader1 = new Input1Reader("res/input1.txt");
        Input2Reader reader2 = new Input2Reader("res/input2.txt");

        Search s = new Search(reader1.getList());
        s.run();
    }
}
