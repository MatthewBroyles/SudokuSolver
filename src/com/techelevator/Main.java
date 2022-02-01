package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[][] Grid;
    private static int totalIterations;
    public static void main(String[] args) {
	// write your code here
//        Grid = new int[][] {
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//        };
//        Grid = new int[][] {
//                {8 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,0 ,3 ,6 ,0 ,0 ,0 ,0 ,0 },
//                {0 ,7 ,0 ,0 ,9 ,0 ,2 ,0 ,0 },
//                {0 ,5 ,0 ,0 ,0 ,7 ,0 ,0 ,0 },
//                {0 ,0 ,0 ,0 ,4 ,5 ,7 ,0 ,0 },
//                {0 ,0 ,0 ,1 ,0 ,0 ,0 ,3 ,0 },
//                {0 ,0 ,1 ,0 ,0 ,0 ,0 ,6 ,8 },
//                {0 ,0 ,8 ,5 ,0 ,0 ,0 ,1 ,0 },
//                {0 ,9 ,0 ,0 ,0 ,0 ,4 ,0 ,0 },
//        };
        Grid = new int[][] {
                {0 ,0 ,5 ,3 ,0 ,0 ,0 ,0 ,0 },
                {8 ,0 ,0 ,0 ,0 ,0 ,0 ,2 ,0 },
                {0 ,7 ,0 ,0 ,1 ,0 ,5 ,0 ,0 },
                {4 ,0 ,0 ,0 ,0 ,5 ,3 ,0 ,0 },
                {0 ,1 ,0 ,0 ,7 ,0 ,0 ,0 ,6 },
                {0 ,0 ,3 ,2 ,0 ,0 ,0 ,8 ,0 },
                {0 ,6 ,0 ,5 ,0 ,0 ,0 ,0 ,9 },
                {0 ,0 ,4 ,0 ,0 ,0 ,0 ,3 ,0 },
                {0 ,0 ,0 ,0 ,0 ,9 ,7 ,0 ,0 },
        };
        System.out.println("Is the grid valid: " + validateGrid(Grid));
        System.out.println("Is the grid complete?: " + isComplete(Grid));
        System.out.println("Oh god please");
        System.out.println((solver()));
        printGrid();
        System.out.println("totalIterations: "+totalIterations);
    }
    public static boolean solver(){
        totalIterations++;

            printGrid();
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                //    System.out.println("Checking [" + x + "][" + y + "]: " + base[x][y]);
                    if (Grid[x][y] == 0) {
                        for (int i = 1; i < 10; i++) {
                            Grid[x][y] = i;
                            if(validateGrid(Grid)){
                                if(solver()){
                                    return true;
                                } else{
                                    Grid[x][y] = 0;
                                }
                            }
                            Grid[x][y] = 0;
                        }
                        return false;
                    }
                }
            }
            return true;

    }

    public static void printGrid(){
        for(int i = 0; i<9; i++){
            System.out.println(Arrays.toString(Grid[i]));
        }
        System.out.println();
    }

    public static boolean validColumn(int[][] base){
        int[][] transposed = new int[9][9];
        for(int x = 0; x<9; x++){
            for(int y = 0; y<9; y++){
                transposed[y][x] = base[x][y];
            }
        }
        return validate(transposed);
    }

    public static boolean validRow(int[][] base){
        return validate(base);
    }

    public static boolean validSquare(int[][] base){
        int[][] transposed = transposeValidToSquares(base);
        return validate(transposed);
    }

    public static boolean validate(int[][] transposed){

        for(int x=0; x<9; x++){
            boolean oneFound = false;
            boolean twoFound = false;
            boolean threeFound = false;
            boolean fourFound = false;
            boolean fiveFound = false;
            boolean sixFound = false;
            boolean sevenFound = false;
            boolean eightFound = false;
            boolean nineFound = false;
            for(int y = 0; y<9; y++){
                if(transposed[x][y] == 1){
                    if(oneFound){
                        return false;
                    }
                    oneFound = true;
                } else if(transposed[x][y] == 2){
                    if(twoFound){
                        return false;
                    }
                    twoFound = true;
                } else if(transposed[x][y] == 3){
                    if(threeFound){
                        return false;
                    }
                    threeFound = true;
                } else if(transposed[x][y] == 4){
                    if(fourFound){
                        return false;
                    }
                    fourFound = true;
                } else if(transposed[x][y] == 5){
                    if(fiveFound){
                        return false;
                    }
                    fiveFound = true;
                } else if(transposed[x][y] == 6){
                    if(sixFound){
                        return false;
                    }
                    sixFound = true;
                } else if(transposed[x][y] == 7){
                    if(sevenFound){
                        return false;
                    }
                    sevenFound = true;
                } else if(transposed[x][y] == 8){
                    if(eightFound){
                        return false;
                    }
                    eightFound = true;
                } else if(transposed[x][y] == 9){
                    if(nineFound){
                        return false;
                    }
                    nineFound = true;
                }
            }
        }
        return true;
    }

    public static boolean validateGrid(int[][] base){
        if(validSquare(base) && validRow(base) && validColumn(base)){
            return true;
        } else{
            return false;
        }
    }
    public static boolean isComplete(int[][] base){
        for(int x = 0; x<9; x++){
            for(int y = 0; y<9; y++){
                if(base[x][y] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] transposeValidToSquares(int[][] base){
        int[][] Transposed = new int[][] {
                {base[0][0],base[0][1],base[0][2],base[1][0],base[1][1],base[1][2],base[2][0],base[2][1],base[2][2]},
                {base[3][0],base[3][1],base[3][2],base[4][0],base[4][1],base[4][2],base[5][0],base[5][1],base[5][2]},
                {base[6][0],base[6][1],base[6][2],base[7][0],base[7][1],base[7][2],base[8][0],base[8][1],base[8][2]},
                {base[0][3],base[0][4],base[0][5],base[1][3],base[1][4],base[1][5],base[2][3],base[2][4],base[2][5]},
                {base[3][3],base[3][4],base[3][5],base[4][3],base[4][4],base[4][5],base[5][3],base[5][4],base[5][5]},
                {base[6][3],base[6][4],base[6][5],base[7][3],base[7][4],base[7][5],base[8][3],base[8][4],base[8][5]},
                {base[0][6],base[0][7],base[0][8],base[1][6],base[1][7],base[1][8],base[2][6],base[2][7],base[2][8]},
                {base[3][6],base[3][7],base[3][8],base[4][6],base[4][7],base[4][8],base[5][6],base[5][7],base[5][8]},
                {base[6][6],base[6][7],base[6][8],base[7][6],base[7][7],base[7][8],base[8][6],base[8][7],base[8][8]}
        };
        return Transposed;
    }
}
