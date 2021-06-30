package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static int SIZE = 3;
    public static char TX = 'X';
    public static char TO = 'O';
    public static char[][] field = new char[SIZE][SIZE];
    public static boolean game = true;
    public static int count_endpoint = 0;

    public static void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = ' ';
            }
        }
        count_endpoint = 0;
    }


    public static void printBoard() {
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == SIZE - 1) {
                    System.out.print(" " + field[i][j] + " \n");
                } else {
                    System.out.print(" " + field[i][j] + " |");
                }
            }

            if (i < SIZE - 1) {
                System.out.print("---");
                int k = 1;
                while (k <= SIZE - 1) {
                    System.out.print("+---");
                    k++;
                }

                System.out.println();

            }
        }
    }


    public static void tictactoe() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Player 1 enter your name");
        String player1 = scan.nextLine();
        System.out.println("Player 2 enter your name");
        String player2 = scan.nextLine();

        System.out.println();

        char currentPlayer = TX;
        System.out.println(player1 + ", choose X position: ");

        while (game) {
            int x = 0;
            int o = 0;

            try {
                x = Integer.parseInt(scan.nextLine());
                o = Integer.parseInt(scan.nextLine());
                System.out.println(x);
                System.out.println(o);

                if (field[x][o] != TX && field[x][o] != TO) {
                    field[x][o] = currentPlayer;
                } else {
                    System.out.println("field is busy");
                    continue;
                }
                if (currentPlayer == TX) {
                    currentPlayer = TO;
                    System.out.println(player2 + ", choose O position: ");
                } else {
                    currentPlayer = TX;
                    System.out.println(player1 + ", choose X position: ");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("wrong position");
            } catch (InputMismatchException e) {
                System.out.println("insert number");
            } catch (NumberFormatException e) {
                System.out.println("insert number");
            }

            printBoard();
            count_endpoint++;
            char rows, cols, diagonal1, diagonal2;
            rows = Check.rows(field, x);
            cols = Check.cols(field, o);
            diagonal1 = Check.diagonal1(field, x, o);
            diagonal2 = Check.diagonal2(field, x, o);

            if (rows == TX || cols == TX || diagonal1 == TX || diagonal2 == TX) {
                System.out.println("The winner is " + player1);
                continueGame();
            } else if (rows == TO || cols == TO || diagonal1 == TO || diagonal2 == TO) {
                System.out.println("The winner is " + player2);
                continueGame();
            }
            if (Check.deathheat(count_endpoint, SIZE)) {
                System.out.println("Deathheat");
                continueGame();
            }


        }
    }

    public static void continueGame() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Want to play again ?");
        System.out.println("Type 'Y' or 'N'");
        String answer = scan.nextLine();
        switch (answer) {
            case ("Y"):
                clearBoard();
                tictactoe();
            case ("N"):
                game = false;
                //System.exit(0);
                break;
            default:
                System.out.println("enter Y or N");
                continueGame();
        }

    }


    public static void instruction() {
        System.out.println("Welcome to TicTacToe game");
        System.out.println();
        System.out.println("Enter position to place X or O");
        System.out.println("dividing by SPACE");
        System.out.println();
        System.out.println("List of positions:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == SIZE - 1) {
                    System.out.print(" " + i + j + " \n");
                } else {
                    System.out.print(" " + i + j + " |");
                }
            }
            if (i < SIZE - 1) {
                System.out.print("----");
                int k = 1;
                while (k <= SIZE - 1) {
                    System.out.print("+----");
                    k++;
                }
                System.out.println();
            }
        }
        System.out.println();
    }


}
