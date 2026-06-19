class TestMatrix {
    public static void main(String[] args) {
        // Create two matrices
        double[][] data1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] data2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        // Initialize Matrix objects
        Matrix A = new Matrix(data1);
        Matrix B = new Matrix(data2);

        // Print the original matrices
        System.out.println("Matrix A:");
        A.print();

        System.out.println("\nMatrix B:");
        B.print();

        // Multiply A * B
        Matrix C = A.matrixMultiply(B);

        System.out.println("\nMatrix C = A * B:");
        C.print();

        // Test scalar multiplication
        Matrix D = A.multiply(2);
        System.out.println("\nMatrix D = A * 2:");
        D.print();

        // Test sum
        double[][] data3 = {
            {1, 1, 1},
            {1, 1, 1}
        };
        Matrix E = new Matrix(data3);
        Matrix F = A.sum(E);
        System.out.println("\nMatrix F = A + E:");
        F.print();

        // Test diagonal, upper, lower
        double[][] diag = {
            {1, 0, 0},
            {0, 2, 0},
            {0, 0, 3}
        };
        Matrix G = new Matrix(diag);
        System.out.println("\nMatrix G is diagonal? " + G.isDiagonal());
        System.out.println("Matrix G is upper? " + G.isUpper());
        System.out.println("Matrix G is lower? " + G.isLower());
    }
}