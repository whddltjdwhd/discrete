package team7;

import java.util.Arrays;

public class AdjacencyMatrix {
    int[][] matrix;
    final int size;

    public AdjacencyMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
    }

    public int[] getRow(int index) {
        if (index < 0 || index >= size) {
            System.out.println("잘못된 범위입니다.");
            return null;
        }

        return matrix[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("size : " + size + "\n");

        // Add column headers
        sb.append("   ");
        for (int i = 0; i < size; i++)
            sb.append(String.format("%3d", i));
        sb.append("\n");

        // Add row headers and values
        for (int i = 0; i < size; i++) {
            sb.append(String.format("%3d", i)); // Row header
            for (int j = 0; j < size; j++)
                sb.append(String.format("%3d", matrix[i][j]));
            sb.append("\n");
        }

        return sb.toString();
    }
}
