package team7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input1Reader {
    List<AdjacencyMatrix> list = new ArrayList<>();

    public List<AdjacencyMatrix> getList() {
        return list;
    }

    public Input1Reader(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                // 노드의 개수 입력
                int nodeCount = scanner.nextInt();
                scanner.nextLine();
                // 이차원 배열 생성
                int[][] matrix = new int[nodeCount][nodeCount];

                for (int i = 1; i <= nodeCount; i++) {
                    // 한 줄 읽고 공백 기준 분할
                    String str = scanner.nextLine();
                    String[] nodes = str.split(" ");
                    // 인접 행렬의 행 번호, 인덱스 번호에 맞게 1 감소
                    int row = Integer.parseInt(nodes[0]) - 1;

                    for (int j = 1; j < nodes.length; j++) {
                        // 인접한 노드를 열번호로 설정
                        int col = Integer.parseInt(nodes[j]) - 1;
                        matrix[row][col] = 1;
                    }
                }

                list.add(new AdjacencyMatrix(matrix));
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }
}
