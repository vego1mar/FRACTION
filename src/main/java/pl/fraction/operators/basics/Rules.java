package pl.fraction.operators.basics;

import org.jetbrains.annotations.NotNull;

public class Rules {

    private char[][][] rules;

    public Rules(RulesType type) {
        rules = new char[10][10][2];
        populateRules(type);
    }

    private void populateRules(@NotNull RulesType type) {
        switch (type) {
            case ADDITION:
                populateAdditionRules();
        }
    }

    private void populateAdditionRules() {
        rules[0][0][0] = '0';
        rules[0][0][1] = '0';
        rules[0][1][0] = '1';
        rules[0][1][1] = '0';
        rules[0][2][0] = '2';
        rules[0][2][1] = '0';
        rules[0][3][0] = '3';
        rules[0][3][1] = '0';
        rules[0][4][0] = '4';
        rules[0][4][1] = '0';
        rules[0][5][0] = '5';
        rules[0][5][1] = '0';
        rules[0][6][0] = '6';
        rules[0][6][1] = '0';
        rules[0][7][0] = '7';
        rules[0][7][1] = '0';
        rules[0][8][0] = '8';
        rules[0][8][1] = '0';
        rules[0][9][0] = '9';
        rules[0][9][1] = '0';
        rules[1][0][0] = '1';
        rules[1][0][1] = '0';
        rules[1][1][0] = '2';
        rules[1][1][1] = '0';
        rules[1][2][0] = '3';
        rules[1][2][1] = '0';
        rules[1][3][0] = '4';
        rules[1][3][1] = '0';
        rules[1][4][0] = '5';
        rules[1][4][1] = '0';
        rules[1][5][0] = '6';
        rules[1][5][1] = '0';
        rules[1][6][0] = '7';
        rules[1][6][1] = '0';
        rules[1][7][0] = '8';
        rules[1][7][1] = '0';
        rules[1][8][0] = '9';
        rules[1][8][1] = '0';
        rules[1][9][0] = '0';
        rules[1][9][1] = '1';
        rules[2][0][0] = '2';
        rules[2][0][1] = '0';
        rules[2][1][0] = '3';
        rules[2][1][1] = '0';
        rules[2][2][0] = '4';
        rules[2][2][1] = '0';
        rules[2][3][0] = '5';
        rules[2][3][1] = '0';
        rules[2][4][0] = '6';
        rules[2][4][1] = '0';
        rules[2][5][0] = '7';
        rules[2][5][1] = '0';
        rules[2][6][0] = '8';
        rules[2][6][1] = '0';
        rules[2][7][0] = '9';
        rules[2][7][1] = '0';
        rules[2][8][0] = '0';
        rules[2][8][1] = '1';
        rules[2][9][0] = '1';
        rules[2][9][1] = '1';
        rules[3][0][0] = '3';
        rules[3][0][1] = '0';
        rules[3][1][0] = '4';
        rules[3][1][1] = '0';
        rules[3][2][0] = '5';
        rules[3][2][1] = '0';
        rules[3][3][0] = '6';
        rules[3][3][1] = '0';
        rules[3][4][0] = '7';
        rules[3][4][1] = '0';
        rules[3][5][0] = '8';
        rules[3][5][1] = '0';
        rules[3][6][0] = '9';
        rules[3][6][1] = '0';
        rules[3][7][0] = '0';
        rules[3][7][1] = '1';
        rules[3][8][0] = '1';
        rules[3][8][1] = '1';
        rules[3][9][0] = '2';
        rules[3][9][1] = '1';
        rules[4][0][0] = '4';
        rules[4][0][1] = '0';
        rules[4][1][0] = '5';
        rules[4][1][1] = '0';
        rules[4][2][0] = '6';
        rules[4][2][1] = '0';
        rules[4][3][0] = '7';
        rules[4][3][1] = '0';
        rules[4][4][0] = '8';
        rules[4][4][1] = '0';
        rules[4][5][0] = '9';
        rules[4][5][1] = '0';
        rules[4][6][0] = '0';
        rules[4][6][1] = '1';
        rules[4][7][0] = '1';
        rules[4][7][1] = '1';
        rules[4][8][0] = '2';
        rules[4][8][1] = '1';
        rules[4][9][0] = '3';
        rules[4][9][1] = '1';
        rules[5][0][0] = '5';
        rules[5][0][1] = '0';
        rules[5][1][0] = '6';
        rules[5][1][1] = '0';
        rules[5][2][0] = '7';
        rules[5][2][1] = '0';
        rules[5][3][0] = '8';
        rules[5][3][1] = '0';
        rules[5][4][0] = '9';
        rules[5][4][1] = '0';
        rules[5][5][0] = '0';
        rules[5][5][1] = '1';
        rules[5][6][0] = '1';
        rules[5][6][1] = '1';
        rules[5][7][0] = '2';
        rules[5][7][1] = '1';
        rules[5][8][0] = '3';
        rules[5][8][1] = '1';
        rules[5][9][0] = '4';
        rules[5][9][1] = '1';
        rules[6][0][0] = '6';
        rules[6][0][1] = '0';
        rules[6][1][0] = '7';
        rules[6][1][1] = '0';
        rules[6][2][0] = '8';
        rules[6][2][1] = '0';
        rules[6][3][0] = '9';
        rules[6][3][1] = '0';
        rules[6][4][0] = '0';
        rules[6][4][1] = '1';
        rules[6][5][0] = '1';
        rules[6][5][1] = '1';
        rules[6][6][0] = '2';
        rules[6][6][1] = '1';
        rules[6][7][0] = '3';
        rules[6][7][1] = '1';
        rules[6][8][0] = '4';
        rules[6][8][1] = '1';
        rules[6][9][0] = '5';
        rules[6][9][1] = '1';
        rules[7][0][0] = '7';
        rules[7][0][1] = '0';
        rules[7][1][0] = '8';
        rules[7][1][1] = '0';
        rules[7][2][0] = '9';
        rules[7][2][1] = '0';
        rules[7][3][0] = '0';
        rules[7][3][1] = '1';
        rules[7][4][0] = '1';
        rules[7][4][1] = '1';
        rules[7][5][0] = '2';
        rules[7][5][1] = '1';
        rules[7][6][0] = '3';
        rules[7][6][1] = '1';
        rules[7][7][0] = '4';
        rules[7][7][1] = '1';
        rules[7][8][0] = '5';
        rules[7][8][1] = '1';
        rules[7][9][0] = '6';
        rules[7][9][1] = '1';
        rules[8][0][0] = '8';
        rules[8][0][1] = '0';
        rules[8][1][0] = '9';
        rules[8][1][1] = '0';
        rules[8][2][0] = '0';
        rules[8][2][1] = '1';
        rules[8][3][0] = '1';
        rules[8][3][1] = '1';
        rules[8][4][0] = '2';
        rules[8][4][1] = '1';
        rules[8][5][0] = '3';
        rules[8][5][1] = '1';
        rules[8][6][0] = '4';
        rules[8][6][1] = '1';
        rules[8][7][0] = '5';
        rules[8][7][1] = '1';
        rules[8][8][0] = '6';
        rules[8][8][1] = '1';
        rules[8][9][0] = '7';
        rules[8][9][1] = '1';
        rules[9][0][0] = '9';
        rules[9][0][1] = '0';
        rules[9][1][0] = '0';
        rules[9][1][1] = '1';
        rules[9][2][0] = '1';
        rules[9][2][1] = '1';
        rules[9][3][0] = '2';
        rules[9][3][1] = '1';
        rules[9][4][0] = '3';
        rules[9][4][1] = '1';
        rules[9][5][0] = '4';
        rules[9][5][1] = '1';
        rules[9][6][0] = '5';
        rules[9][6][1] = '1';
        rules[9][7][0] = '6';
        rules[9][7][1] = '1';
        rules[9][8][0] = '7';
        rules[9][8][1] = '1';
        rules[9][9][0] = '8';
        rules[9][9][1] = '1';
    }

    public char getRule(char operand1, char operand2, char resultType) {
        if (Character.isDigit(operand1) && Character.isDigit(operand2) && (resultType == '0' || resultType == '1')) {
            return rules[operand1 - '0'][operand2 - '0'][resultType - '0'];
        }

        return '0';
    }
}
