package algorithm;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Matrix {
    private int[][]arr;

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */

    public int diagonalAndLineCalculation(){ //returns sum of rows or -1 - in case if sum of rows and diagonals is different
        int[][]arrLocal = this.arr;
        int properSum = 0;

        //calculating horizontal rows
        for (int i = 0; i <=2;i++){
            int sum = 0;
            for (int j = 0; j <=2; j++)
                sum =sum + arrLocal[i][j];
            if (i == 0) properSum = sum;//defining sum which we compare
            if (sum!=properSum) return -1;
        }

        //calculating vertical rows
        for (int i = 0; i <=2;i++){
            int sum = 0;
            for (int j = 0; j <=2; j++)
                sum =sum + arrLocal[j][i];
            if (sum!=properSum) return -1;
        }

        //calculating diagonal1
        int sum = 0;
        for (int i = 0; i <=2;i++)
            sum =sum + arrLocal[i][i];
        if (sum!=properSum) return -1;

        //calculating diagonal2
        sum = 0;
        for (int i = 0; i <=2;i++) sum =sum + arrLocal[2-i][i];
        if (sum!=properSum) return -1;

        return properSum;
    }

    //print matrix as a line
    public String toStringFlat() { //toString
        int heightSize = this.arr.length;
        int widthSize = this.arr[0].length;
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0 ; i < heightSize; i ++)
            for (int j = 0; j < widthSize; j++){
                stringBuffer.append(this.arr[i][j]);
                if (j==(widthSize - 1)) stringBuffer.append("\n");
                else stringBuffer.append(" ");
            }
        return stringBuffer.toString();
    }

    //print matrix view
    @Override
    public String toString(){ //
        int heightSize = this.arr.length;
        int widthSize = this.arr[0].length;
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0 ; i < heightSize; i ++)
            for (int j = 0; j < widthSize; j++){
                stringBuffer.append(this.arr[i][j]);
                stringBuffer.append(" ");
            }
        return stringBuffer.toString();
    }
}