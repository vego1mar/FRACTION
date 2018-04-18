package pl.fraction.operators.basics;

import org.jetbrains.annotations.NotNull;

public class Rules {

    private char[][][] table;

    public Rules(OperationType type) {
        table = new char[10][10][2];
        populateRules(type);
    }

    private void populateRules(@NotNull OperationType type) {
        switch (type) {
            case ADDITION:
                populateByAdditionRules();
                break;
            case SUBTRACTION:
                populateBySubtractionRules();
                break;
            case MULTIPLICATION:
                populateByMultiplicationRules();
        }
    }

    private void populateByAdditionRules() {
        table[0][0][0] = '0';
        table[0][0][1] = '0';
        table[0][1][0] = '1';
        table[0][1][1] = '0';
        table[0][2][0] = '2';
        table[0][2][1] = '0';
        table[0][3][0] = '3';
        table[0][3][1] = '0';
        table[0][4][0] = '4';
        table[0][4][1] = '0';
        table[0][5][0] = '5';
        table[0][5][1] = '0';
        table[0][6][0] = '6';
        table[0][6][1] = '0';
        table[0][7][0] = '7';
        table[0][7][1] = '0';
        table[0][8][0] = '8';
        table[0][8][1] = '0';
        table[0][9][0] = '9';
        table[0][9][1] = '0';
        table[1][0][0] = '1';
        table[1][0][1] = '0';
        table[1][1][0] = '2';
        table[1][1][1] = '0';
        table[1][2][0] = '3';
        table[1][2][1] = '0';
        table[1][3][0] = '4';
        table[1][3][1] = '0';
        table[1][4][0] = '5';
        table[1][4][1] = '0';
        table[1][5][0] = '6';
        table[1][5][1] = '0';
        table[1][6][0] = '7';
        table[1][6][1] = '0';
        table[1][7][0] = '8';
        table[1][7][1] = '0';
        table[1][8][0] = '9';
        table[1][8][1] = '0';
        table[1][9][0] = '0';
        table[1][9][1] = '1';
        table[2][0][0] = '2';
        table[2][0][1] = '0';
        table[2][1][0] = '3';
        table[2][1][1] = '0';
        table[2][2][0] = '4';
        table[2][2][1] = '0';
        table[2][3][0] = '5';
        table[2][3][1] = '0';
        table[2][4][0] = '6';
        table[2][4][1] = '0';
        table[2][5][0] = '7';
        table[2][5][1] = '0';
        table[2][6][0] = '8';
        table[2][6][1] = '0';
        table[2][7][0] = '9';
        table[2][7][1] = '0';
        table[2][8][0] = '0';
        table[2][8][1] = '1';
        table[2][9][0] = '1';
        table[2][9][1] = '1';
        table[3][0][0] = '3';
        table[3][0][1] = '0';
        table[3][1][0] = '4';
        table[3][1][1] = '0';
        table[3][2][0] = '5';
        table[3][2][1] = '0';
        table[3][3][0] = '6';
        table[3][3][1] = '0';
        table[3][4][0] = '7';
        table[3][4][1] = '0';
        table[3][5][0] = '8';
        table[3][5][1] = '0';
        table[3][6][0] = '9';
        table[3][6][1] = '0';
        table[3][7][0] = '0';
        table[3][7][1] = '1';
        table[3][8][0] = '1';
        table[3][8][1] = '1';
        table[3][9][0] = '2';
        table[3][9][1] = '1';
        table[4][0][0] = '4';
        table[4][0][1] = '0';
        table[4][1][0] = '5';
        table[4][1][1] = '0';
        table[4][2][0] = '6';
        table[4][2][1] = '0';
        table[4][3][0] = '7';
        table[4][3][1] = '0';
        table[4][4][0] = '8';
        table[4][4][1] = '0';
        table[4][5][0] = '9';
        table[4][5][1] = '0';
        table[4][6][0] = '0';
        table[4][6][1] = '1';
        table[4][7][0] = '1';
        table[4][7][1] = '1';
        table[4][8][0] = '2';
        table[4][8][1] = '1';
        table[4][9][0] = '3';
        table[4][9][1] = '1';
        table[5][0][0] = '5';
        table[5][0][1] = '0';
        table[5][1][0] = '6';
        table[5][1][1] = '0';
        table[5][2][0] = '7';
        table[5][2][1] = '0';
        table[5][3][0] = '8';
        table[5][3][1] = '0';
        table[5][4][0] = '9';
        table[5][4][1] = '0';
        table[5][5][0] = '0';
        table[5][5][1] = '1';
        table[5][6][0] = '1';
        table[5][6][1] = '1';
        table[5][7][0] = '2';
        table[5][7][1] = '1';
        table[5][8][0] = '3';
        table[5][8][1] = '1';
        table[5][9][0] = '4';
        table[5][9][1] = '1';
        table[6][0][0] = '6';
        table[6][0][1] = '0';
        table[6][1][0] = '7';
        table[6][1][1] = '0';
        table[6][2][0] = '8';
        table[6][2][1] = '0';
        table[6][3][0] = '9';
        table[6][3][1] = '0';
        table[6][4][0] = '0';
        table[6][4][1] = '1';
        table[6][5][0] = '1';
        table[6][5][1] = '1';
        table[6][6][0] = '2';
        table[6][6][1] = '1';
        table[6][7][0] = '3';
        table[6][7][1] = '1';
        table[6][8][0] = '4';
        table[6][8][1] = '1';
        table[6][9][0] = '5';
        table[6][9][1] = '1';
        table[7][0][0] = '7';
        table[7][0][1] = '0';
        table[7][1][0] = '8';
        table[7][1][1] = '0';
        table[7][2][0] = '9';
        table[7][2][1] = '0';
        table[7][3][0] = '0';
        table[7][3][1] = '1';
        table[7][4][0] = '1';
        table[7][4][1] = '1';
        table[7][5][0] = '2';
        table[7][5][1] = '1';
        table[7][6][0] = '3';
        table[7][6][1] = '1';
        table[7][7][0] = '4';
        table[7][7][1] = '1';
        table[7][8][0] = '5';
        table[7][8][1] = '1';
        table[7][9][0] = '6';
        table[7][9][1] = '1';
        table[8][0][0] = '8';
        table[8][0][1] = '0';
        table[8][1][0] = '9';
        table[8][1][1] = '0';
        table[8][2][0] = '0';
        table[8][2][1] = '1';
        table[8][3][0] = '1';
        table[8][3][1] = '1';
        table[8][4][0] = '2';
        table[8][4][1] = '1';
        table[8][5][0] = '3';
        table[8][5][1] = '1';
        table[8][6][0] = '4';
        table[8][6][1] = '1';
        table[8][7][0] = '5';
        table[8][7][1] = '1';
        table[8][8][0] = '6';
        table[8][8][1] = '1';
        table[8][9][0] = '7';
        table[8][9][1] = '1';
        table[9][0][0] = '9';
        table[9][0][1] = '0';
        table[9][1][0] = '0';
        table[9][1][1] = '1';
        table[9][2][0] = '1';
        table[9][2][1] = '1';
        table[9][3][0] = '2';
        table[9][3][1] = '1';
        table[9][4][0] = '3';
        table[9][4][1] = '1';
        table[9][5][0] = '4';
        table[9][5][1] = '1';
        table[9][6][0] = '5';
        table[9][6][1] = '1';
        table[9][7][0] = '6';
        table[9][7][1] = '1';
        table[9][8][0] = '7';
        table[9][8][1] = '1';
        table[9][9][0] = '8';
        table[9][9][1] = '1';
    }

    private void populateBySubtractionRules() {
        table[0][0][0] = '0';
        table[0][0][1] = '0';
        table[0][1][0] = '0';
        table[0][1][1] = '1';
        table[0][2][0] = '8';
        table[0][2][1] = '1';
        table[0][3][0] = '7';
        table[0][3][1] = '1';
        table[0][4][0] = '6';
        table[0][4][1] = '1';
        table[0][5][0] = '5';
        table[0][5][1] = '1';
        table[0][6][0] = '4';
        table[0][6][1] = '1';
        table[0][7][0] = '3';
        table[0][7][1] = '1';
        table[0][8][0] = '2';
        table[0][8][1] = '1';
        table[0][9][0] = '1';
        table[0][9][1] = '1';
        table[1][0][0] = '1';
        table[1][0][1] = '0';
        table[1][1][0] = '0';
        table[1][1][1] = '0';
        table[1][2][0] = '9';
        table[1][2][1] = '1';
        table[1][3][0] = '8';
        table[1][3][1] = '1';
        table[1][4][0] = '7';
        table[1][4][1] = '1';
        table[1][5][0] = '6';
        table[1][5][1] = '1';
        table[1][6][0] = '5';
        table[1][6][1] = '1';
        table[1][7][0] = '4';
        table[1][7][1] = '1';
        table[1][8][0] = '3';
        table[1][8][1] = '1';
        table[1][9][0] = '2';
        table[1][9][1] = '1';
        table[2][0][0] = '2';
        table[2][0][1] = '0';
        table[2][1][0] = '1';
        table[2][1][1] = '0';
        table[2][2][0] = '0';
        table[2][2][1] = '0';
        table[2][3][0] = '9';
        table[2][3][1] = '1';
        table[2][4][0] = '8';
        table[2][4][1] = '1';
        table[2][5][0] = '7';
        table[2][5][1] = '1';
        table[2][6][0] = '6';
        table[2][6][1] = '1';
        table[2][7][0] = '5';
        table[2][7][1] = '1';
        table[2][8][0] = '4';
        table[2][8][1] = '1';
        table[2][9][0] = '3';
        table[2][9][1] = '1';
        table[3][0][0] = '3';
        table[3][0][1] = '0';
        table[3][1][0] = '2';
        table[3][1][1] = '0';
        table[3][2][0] = '1';
        table[3][2][1] = '0';
        table[3][3][0] = '0';
        table[3][3][1] = '0';
        table[3][4][0] = '9';
        table[3][4][1] = '1';
        table[3][5][0] = '8';
        table[3][5][1] = '1';
        table[3][6][0] = '7';
        table[3][6][1] = '1';
        table[3][7][0] = '6';
        table[3][7][1] = '1';
        table[3][8][0] = '5';
        table[3][8][1] = '1';
        table[3][9][0] = '4';
        table[3][9][1] = '1';
        table[4][0][0] = '4';
        table[4][0][1] = '0';
        table[4][1][0] = '3';
        table[4][1][1] = '0';
        table[4][2][0] = '2';
        table[4][2][1] = '0';
        table[4][3][0] = '1';
        table[4][3][1] = '0';
        table[4][4][0] = '0';
        table[4][4][1] = '0';
        table[4][5][0] = '9';
        table[4][5][1] = '1';
        table[4][6][0] = '8';
        table[4][6][1] = '1';
        table[4][7][0] = '7';
        table[4][7][1] = '1';
        table[4][8][0] = '6';
        table[4][8][1] = '1';
        table[4][9][0] = '5';
        table[4][9][1] = '1';
        table[5][0][0] = '5';
        table[5][0][1] = '0';
        table[5][1][0] = '4';
        table[5][1][1] = '0';
        table[5][2][0] = '3';
        table[5][2][1] = '0';
        table[5][3][0] = '2';
        table[5][3][1] = '0';
        table[5][4][0] = '1';
        table[5][4][1] = '0';
        table[5][5][0] = '0';
        table[5][5][1] = '0';
        table[5][6][0] = '9';
        table[5][6][1] = '1';
        table[5][7][0] = '8';
        table[5][7][1] = '1';
        table[5][8][0] = '7';
        table[5][8][1] = '1';
        table[5][9][0] = '6';
        table[5][9][1] = '1';
        table[6][0][0] = '6';
        table[6][0][1] = '0';
        table[6][1][0] = '5';
        table[6][1][1] = '0';
        table[6][2][0] = '4';
        table[6][2][1] = '0';
        table[6][3][0] = '3';
        table[6][3][1] = '0';
        table[6][4][0] = '2';
        table[6][4][1] = '0';
        table[6][5][0] = '1';
        table[6][5][1] = '0';
        table[6][6][0] = '0';
        table[6][6][1] = '0';
        table[6][7][0] = '9';
        table[6][7][1] = '1';
        table[6][8][0] = '8';
        table[6][8][1] = '1';
        table[6][9][0] = '7';
        table[6][9][1] = '1';
        table[7][0][0] = '7';
        table[7][0][1] = '0';
        table[7][1][0] = '6';
        table[7][1][1] = '0';
        table[7][2][0] = '5';
        table[7][2][1] = '0';
        table[7][3][0] = '4';
        table[7][3][1] = '0';
        table[7][4][0] = '3';
        table[7][4][1] = '0';
        table[7][5][0] = '2';
        table[7][5][1] = '0';
        table[7][6][0] = '1';
        table[7][6][1] = '0';
        table[7][7][0] = '0';
        table[7][7][1] = '0';
        table[7][8][0] = '9';
        table[7][8][1] = '1';
        table[7][9][0] = '8';
        table[7][9][1] = '1';
        table[8][0][0] = '8';
        table[8][0][1] = '0';
        table[8][1][0] = '7';
        table[8][1][1] = '0';
        table[8][2][0] = '6';
        table[8][2][1] = '0';
        table[8][3][0] = '5';
        table[8][3][1] = '0';
        table[8][4][0] = '4';
        table[8][4][1] = '0';
        table[8][5][0] = '3';
        table[8][5][1] = '0';
        table[8][6][0] = '2';
        table[8][6][1] = '0';
        table[8][7][0] = '1';
        table[8][7][1] = '0';
        table[8][8][0] = '0';
        table[8][8][1] = '0';
        table[8][9][0] = '9';
        table[8][9][1] = '1';
        table[9][0][0] = '9';
        table[9][0][1] = '0';
        table[9][1][0] = '8';
        table[9][1][1] = '0';
        table[9][2][0] = '7';
        table[9][2][1] = '0';
        table[9][3][0] = '6';
        table[9][3][1] = '0';
        table[9][4][0] = '5';
        table[9][4][1] = '0';
        table[9][5][0] = '4';
        table[9][5][1] = '0';
        table[9][6][0] = '3';
        table[9][6][1] = '0';
        table[9][7][0] = '2';
        table[9][7][1] = '0';
        table[9][8][0] = '1';
        table[9][8][1] = '0';
        table[9][9][0] = '0';
        table[9][9][1] = '0';
    }

    private void populateByMultiplicationRules() {
        table[0][0][0] = '0';
        table[0][0][1] = '0';
        table[0][1][0] = '0';
        table[0][1][1] = '0';
        table[0][2][0] = '0';
        table[0][2][1] = '0';
        table[0][3][0] = '0';
        table[0][3][1] = '0';
        table[0][4][0] = '0';
        table[0][4][1] = '0';
        table[0][5][0] = '0';
        table[0][5][1] = '0';
        table[0][6][0] = '0';
        table[0][6][1] = '0';
        table[0][7][0] = '0';
        table[0][7][1] = '0';
        table[0][8][0] = '0';
        table[0][8][1] = '0';
        table[0][9][0] = '0';
        table[0][9][1] = '0';
        table[1][0][0] = '0';
        table[1][0][1] = '0';
        table[1][1][0] = '1';
        table[1][1][1] = '0';
        table[1][2][0] = '2';
        table[1][2][1] = '0';
        table[1][3][0] = '3';
        table[1][3][1] = '0';
        table[1][4][0] = '4';
        table[1][4][1] = '0';
        table[1][5][0] = '5';
        table[1][5][1] = '0';
        table[1][6][0] = '6';
        table[1][6][1] = '0';
        table[1][7][0] = '7';
        table[1][7][1] = '0';
        table[1][8][0] = '8';
        table[1][8][1] = '0';
        table[1][9][0] = '9';
        table[1][9][1] = '0';
        table[2][0][0] = '0';
        table[2][0][1] = '0';
        table[2][1][0] = '2';
        table[2][1][1] = '0';
        table[2][2][0] = '4';
        table[2][2][1] = '0';
        table[2][3][0] = '6';
        table[2][3][1] = '0';
        table[2][4][0] = '8';
        table[2][4][1] = '0';
        table[2][5][0] = '0';
        table[2][5][1] = '1';
        table[2][6][0] = '2';
        table[2][6][1] = '1';
        table[2][7][0] = '4';
        table[2][7][1] = '1';
        table[2][8][0] = '6';
        table[2][8][1] = '1';
        table[2][9][0] = '8';
        table[2][9][1] = '1';
        table[3][0][0] = '0';
        table[3][0][1] = '0';
        table[3][1][0] = '3';
        table[3][1][1] = '0';
        table[3][2][0] = '6';
        table[3][2][1] = '0';
        table[3][3][0] = '9';
        table[3][3][1] = '0';
        table[3][4][0] = '2';
        table[3][4][1] = '1';
        table[3][5][0] = '5';
        table[3][5][1] = '1';
        table[3][6][0] = '8';
        table[3][6][1] = '1';
        table[3][7][0] = '1';
        table[3][7][1] = '2';
        table[3][8][0] = '4';
        table[3][8][1] = '2';
        table[3][9][0] = '7';
        table[3][9][1] = '2';
        table[4][0][0] = '0';
        table[4][0][1] = '0';
        table[4][1][0] = '4';
        table[4][1][1] = '0';
        table[4][2][0] = '8';
        table[4][2][1] = '0';
        table[4][3][0] = '2';
        table[4][3][1] = '1';
        table[4][4][0] = '6';
        table[4][4][1] = '1';
        table[4][5][0] = '0';
        table[4][5][1] = '2';
        table[4][6][0] = '4';
        table[4][6][1] = '2';
        table[4][7][0] = '8';
        table[4][7][1] = '2';
        table[4][8][0] = '2';
        table[4][8][1] = '3';
        table[4][9][0] = '6';
        table[4][9][1] = '3';
        table[5][0][0] = '0';
        table[5][0][1] = '0';
        table[5][1][0] = '5';
        table[5][1][1] = '0';
        table[5][2][0] = '0';
        table[5][2][1] = '1';
        table[5][3][0] = '5';
        table[5][3][1] = '1';
        table[5][4][0] = '0';
        table[5][4][1] = '2';
        table[5][5][0] = '5';
        table[5][5][1] = '2';
        table[5][6][0] = '0';
        table[5][6][1] = '3';
        table[5][7][0] = '5';
        table[5][7][1] = '3';
        table[5][8][0] = '0';
        table[5][8][1] = '4';
        table[5][9][0] = '5';
        table[5][9][1] = '4';
        table[6][0][0] = '0';
        table[6][0][1] = '0';
        table[6][1][0] = '6';
        table[6][1][1] = '0';
        table[6][2][0] = '2';
        table[6][2][1] = '1';
        table[6][3][0] = '8';
        table[6][3][1] = '1';
        table[6][4][0] = '4';
        table[6][4][1] = '2';
        table[6][5][0] = '0';
        table[6][5][1] = '3';
        table[6][6][0] = '6';
        table[6][6][1] = '3';
        table[6][7][0] = '2';
        table[6][7][1] = '4';
        table[6][8][0] = '8';
        table[6][8][1] = '4';
        table[6][9][0] = '4';
        table[6][9][1] = '5';
        table[7][0][0] = '0';
        table[7][0][1] = '0';
        table[7][1][0] = '7';
        table[7][1][1] = '0';
        table[7][2][0] = '4';
        table[7][2][1] = '1';
        table[7][3][0] = '1';
        table[7][3][1] = '2';
        table[7][4][0] = '8';
        table[7][4][1] = '2';
        table[7][5][0] = '5';
        table[7][5][1] = '3';
        table[7][6][0] = '2';
        table[7][6][1] = '4';
        table[7][7][0] = '9';
        table[7][7][1] = '4';
        table[7][8][0] = '6';
        table[7][8][1] = '5';
        table[7][9][0] = '3';
        table[7][9][1] = '6';
        table[8][0][0] = '0';
        table[8][0][1] = '0';
        table[8][1][0] = '8';
        table[8][1][1] = '0';
        table[8][2][0] = '6';
        table[8][2][1] = '1';
        table[8][3][0] = '4';
        table[8][3][1] = '2';
        table[8][4][0] = '2';
        table[8][4][1] = '3';
        table[8][5][0] = '0';
        table[8][5][1] = '4';
        table[8][6][0] = '8';
        table[8][6][1] = '4';
        table[8][7][0] = '6';
        table[8][7][1] = '5';
        table[8][8][0] = '4';
        table[8][8][1] = '6';
        table[8][9][0] = '2';
        table[8][9][1] = '7';
        table[9][0][0] = '0';
        table[9][0][1] = '0';
        table[9][1][0] = '9';
        table[9][1][1] = '0';
        table[9][2][0] = '8';
        table[9][2][1] = '1';
        table[9][3][0] = '7';
        table[9][3][1] = '2';
        table[9][4][0] = '6';
        table[9][4][1] = '3';
        table[9][5][0] = '5';
        table[9][5][1] = '4';
        table[9][6][0] = '4';
        table[9][6][1] = '5';
        table[9][7][0] = '3';
        table[9][7][1] = '6';
        table[9][8][0] = '2';
        table[9][8][1] = '7';
        table[9][9][0] = '1';
        table[9][9][1] = '8';
    }

    public char getRule(char operand1, char operand2, char resultType) {
        if (Character.isDigit(operand1) && Character.isDigit(operand2) && (resultType == '0' || resultType == '1')) {
            return table[operand1 - '0'][operand2 - '0'][resultType - '0'];
        }

        return '0';
    }
}
