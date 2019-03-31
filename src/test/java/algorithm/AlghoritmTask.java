package algorithm;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AlghoritmTask {

    /**
     * Exercise 1. A 3x3 grid is filled with digits (0 ≤ d ≤ 9). Example of the grid:
     5 2 2
     0 3 6
     4 4 1
     The sum of each row, and each column, and each diagonal has the value 9. Implement a Java
     method which effectively calculates a number of ways filling a 3x3 grid with the digits (0 ≤ d ≤ 9)
     so that each row, each column, and both diagonals have the same sum.
     */

    private static final String fileNameToSaveResult = String.format("result%s.txt", Helper.userTimeStampParam(true, true, true, true, true, true));
    private static final String pathToFileOSX = "src/test/java/algorithm/";
    private static final String finalPath = pathToFileOSX + fileNameToSaveResult;

    //creates string with n-th zeros
    private static String generateZerosString(int numberOfZeros){
        StringBuilder stringBuffer = new StringBuilder("");
        for (int i = 1; i <= numberOfZeros; i++){
            stringBuffer.append("0");
        }
        return stringBuffer.toString();
    }

    //generate String array of 9 digits
    private static String[] generateString9Digits(int i){
        int length = Integer.toString(i).length();
        String zeros = generateZerosString(9 - length);
        String line = zeros + Integer.toString(i);
        String[]result = (line).split("");
        return result;
    }

    //convert line with 9 digits to Matrix 3x3
    public static int[][] generateMatrix(String[]array){
        int[][]result = new int[3][3];
        int xC, yC;
        for (int i = 0; i < 9; i++){
            xC = (i%3);
            yC = Math.round(i/3);
            result[yC][xC] = Integer.parseInt(array[i]);
        }
        return result;
    }

    public static void writeResultToFile(String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(finalPath, true));
        writer.append(line);
        writer.close();
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        writeResultToFile("STARTED at " + LocalDateTime.now().toString() + "\n");
        int size = 999999999;
        List<Result>listofResults = new ArrayList<Result>();
        for (int i =0; i<=size;i++){
            String[]arr = generateString9Digits(i);
            int[][]arrInt = generateMatrix(arr);
            Matrix matrix = new Matrix(arrInt);
            int equalSum = matrix.diagonalAndLineCalculation();//sum of all diagonals and rows or -1 if they are different
            if (equalSum!=(-1)){
                listofResults.add(new Result(equalSum, matrix));
                String lineResult = matrix.toStringFlat();
                writeResultToFile(lineResult + "\n");
                log.info("RESULT DETECTED = {}", matrix.toString());
            }
            if (i%1000000==0) log.info("iteratedLine={} numberOfWays={}", matrix.toString(), listofResults.size());//to see process in console
        }
        writeResultToFile("FINISHED at " + LocalDateTime.now().toString());
        log.info("NUMBER OF WAYS is {}", listofResults.size());
    }
}