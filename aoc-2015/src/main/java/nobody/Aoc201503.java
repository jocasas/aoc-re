package nobody;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class Aoc201503 {

    public char[][] logPosition(String str) {
        int len = str.length();
        char[][] arr = new char[len][len];
        System.out.println("Array Size; " + len + 'x' + len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] = '0'; // or any other character
            }
        }
        return arr;
    }

    public char[][] evaluateMovement(String str) throws FileNotFoundException {

        var arr = logPosition(str);
        int posX = arr.length / 2;
        int posY = arr[0].length / 2;
        arr[posX][posY] = '1'; //start punto
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '^' -> {
                    posX--;
                    switch (arr[posX][posY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[posX][posY] = '2';
                        default ->
                            arr[posX][posY] = '1';
                    }
                }
                case 'v' -> {
                    posX++;
                    switch (arr[posX][posY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[posX][posY] = '2';
                        default ->
                            arr[posX][posY] = '1';
                    }
                }
                case '<' -> {
                    posY--;
                    switch (arr[posX][posY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[posX][posY] = '2';
                        default ->
                            arr[posX][posY] = '1';
                    }
                }
                case '>' -> {
                    posY++;
                    switch (arr[posX][posY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[posX][posY] = '2';
                        default ->
                            arr[posX][posY] = '1';
                    }
                }
                default -> {
                    arr[posX][posY] = '0';
                }
            }
        }

        //visual 
        //for (char[] arr1 : arr) {
        //    for (int j = 0; j < arr1.length; j++) {
        //        System.out.print(arr1[j] + "");
        //   }
        //    System.out.println();
        //}
        return arr;
    }

    public char[][] evaluateBothMovements(String str) throws FileNotFoundException {
        int person = 0;
        var arr = logPosition(str);
        int posX = arr.length / 2, posY = arr[0].length / 2, posX2 = arr.length / 2, posY2 = arr[0].length / 2;
        arr[posX][posY] = '1'; //start punto
        int tempX = posX, tempY = posY;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '^' -> {
                    if (person == 0) {
                        posX--;
                        tempX = posX;
                        tempY = posY;
                        person++;
                    } else {
                        posX2--;
                        tempX = posX2;
                        tempY = posY2;
                        person--;
                    }
                    switch (arr[tempX][tempY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[tempX][tempY] = '2';
                        default ->
                            arr[tempX][tempY] = '1';
                    }
                }
                case 'v' -> {
                    if (person == 0) {
                        posX++;
                        tempX = posX;
                        tempY = posY;
                        person++;
                    } else {
                        posX2++;
                        tempX = posX2;
                        tempY = posY2;
                        person--;
                    }
                    switch (arr[tempX][tempY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[tempX][tempY] = '2';
                        default ->
                            arr[tempX][tempY] = '1';
                    }
                }
                case '<' -> {
                    if (person == 0) {
                        posY--;
                        tempX = posX;
                        tempY = posY;
                        person++;
                    } else {
                        posY2--;
                        tempX = posX2;
                        tempY = posY2;
                        person--;
                    }
                    switch (arr[tempX][tempY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[tempX][tempY] = '2';
                        default ->
                            arr[tempX][tempY] = '1';
                    }
                }
                case '>' -> {
                    if (person == 0) {
                        posY++;
                        tempX = posX;
                        tempY = posY;
                        person++;
                    } else {
                        posY2++;
                        tempX = posX2;
                        tempY = posY2;
                        person--;
                    }
                    switch (arr[tempX][tempY]) {
                        case '2' -> {
                            continue;
                        }
                        case '1' ->
                            arr[tempX][tempY] = '2';
                        default ->
                            arr[tempX][tempY] = '1';
                    }
                }
                default -> {
                    arr[tempX][tempY] = '0';
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        //print del output para ver el array bien
        PrintStream fileOut = new PrintStream("./out.txt");
        PrintStream originalOut = System.out;
        System.setOut(fileOut);
        //Path path = Paths.get(movement.txt").toAbsolutePath();
        var str = new String(Files.readAllBytes(Paths.get("aoc-2015/movement.txt")));
        Aoc201503 aoc = new Aoc201503(); // Instance de Aoc201501
        var array = aoc.evaluateMovement(str);
        var array2 = aoc.evaluateBothMovements(str);

        System.setOut(originalOut);

        int countZero = 0, countZero2 = 0;
        int countOne = 0, countOne2 = 0;
        int countTwo = 0, countTwo2 = 0;

        for (char[] array1 : array) {
            for (int j = 0; j < array1.length; j++) {
                switch (array1[j]) {
                    case '0' -> {
                        countZero++;

                    }
                    case '1' -> {
                        countOne++;

                    }
                    case '2' -> {
                        countTwo++;

                    }
                }
            }
        }
        for (char[] array1 : array2) {
            for (int j = 0; j < array1.length; j++) {
                switch (array1[j]) {
                    case '0' -> {

                        countZero2++;
                    }
                    case '1' -> {

                        countOne2++;
                    }
                    case '2' -> {

                        countTwo2++;
                    }
                }
            }
        }

        System.out.println("First Part ");
        System.out.println("Number of 0s: " + countZero);
        System.out.println("Number of 1s: " + countOne);
        System.out.println("Number of 2s: " + countTwo);
        int atLeastOnePresent = countOne + countTwo;
        System.out.println("At least 1 present: " + atLeastOnePresent);

        System.out.println("-----Second Part-----");
        System.out.println("Number of 0s: " + countZero2);
        System.out.println("Number of 1s: " + countOne2);
        System.out.println("Number of 2s: " + countTwo2);
        int atLeastOnePresent2 = countOne2 + countTwo2;
        System.out.println("At least 1 present: " + atLeastOnePresent2);

        System.out.println("END");
    }
}
