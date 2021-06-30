package com.tictactoe;

public class Check {
    public static char TX = 'X';
    public static char TO = 'O';
    public static int counterX = 0;
    public static int counterY = 0;


    public static char rows(char[][] field, int x) {

        counterX = 0;
        counterY = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[x][j] == TX) {
                counterX++;
            } else if (field[x][j] == TO) {
                counterY++;
            }
        }
        if (counterX == field.length) {
            return TX;
        }
        if (counterY == field.length) {
            return TO;
        }
        return '/';
    }


    public static char cols(char[][] field, int y) {
        counterX = 0;
        counterY = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][y] == TX) {
                counterX++;
            } else if (field[i][y] == TO) {
                counterY++;
            }
        }
        if (counterX == field.length) {
            return TX;
        }
        if (counterY == field.length) {
            return TO;
        }
        return '/';
    }


    public static char diagonal1(char[][] field, int x, int y) {
        counterX = 0;
        counterY = 0;

        if (x != field.length - y) {
            return '/';
        }

        for (int i = 0; i < field.length; i++) {
            if (field[i][field.length - 1 - i] == TX) {
                counterX++;
            } else if (field[i][field.length - 1 - i] == TO) {
                counterY++;
            }
            if (counterX == field.length) {
                return TX;
            }
            if (counterY == field.length) {
                return TO;
            }
        }
        return '/';
    }


    public static char diagonal2(char[][] field, int x, int y) {
        counterX = 0;
        counterY = 0;

        if (x != y) {
            return '/';
        }

        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == TX) {
                counterX++;
            } else if (field[i][i] == TO) {
                counterY++;
            }
            if (counterX == field.length) {
                return TX;
            }
            if (counterY == field.length) {
                return TO;
            }
        }
        return '/';
    }


    public static boolean deathheat(int count_endpoint, int SIZE) {
        return count_endpoint == SIZE * SIZE;
    }
}
