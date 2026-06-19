import java.io.*;

class Matrix {
    private double[][] array;

    public Matrix(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            int row = Integer.parseInt(reader.readLine());
            int col = Integer.parseInt(reader.readLine());
            int rowCount = 0;
            array = new double[row][col];
            while((line = reader.readLine()) != null) {
                String[] num = line.split(" ");
                for(int i = 0; i < array[0].length; i++) {
                    array[rowCount][i] = Double.parseDouble(num[i]);
                }
                rowCount++;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public Matrix(double[][] A) {
        int row = A.length;
        int col = A[0].length;

        array = new double[row][col];

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = A[i][j];
            }
        }
    }
    public void print() {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public boolean isDiagonal() {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if(i != j && array[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isUpper() {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if(i > j && array[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isLower() {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if(i < j && array[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public double[][] getMatrix() {
        return array;
    }
    public Matrix sum(Matrix A) {
        double[][] B = A.getMatrix();
        int row = B.length;
        int col = B[0].length;

        double[][] newMatrix = new double[row][col];

        for(int i = 0; i < newMatrix.length; i++) {
            for(int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = array[i][j] + B[i][j];
            }
        }
        return new Matrix(newMatrix);
    }
    public Matrix multiply(int c) {
        double[][] multiplied = new double[array.length][array[0].length];

        for(int i = 0; i < multiplied.length; i++) {
            for(int j = 0; j < multiplied[i].length; j++) {
                multiplied[i][j] = c * array[i][j];
            }
        }
        return new Matrix(multiplied);
    }
    public Matrix matrixMultiply(Matrix A) {
        double[][] B = A.getMatrix();
        int colA = array[0].length;
        int rowB = B.length;
        double[][] newArray = new double[array.length][B[0].length];
        if(colA == rowB) {
            for(int i = 0; i < array.length; i++) {
                int k = 0;
                int length = B[0].length;
                while(k < length) {
                    double sum = 0;
                    for(int j = 0; j < array[i].length; j++) {
                        sum += array[i][j] * B[j][k];
                    }
                    newArray[i][k] = sum;
                    k++;
                }
            }
        } else {
            throw new IllegalArgumentException("Matrix dimensions do not for multiplication ");
        }       
        return new Matrix(newArray);
    }
}