package com.bnp.kata.DEV1085.object;

public class Cell {
    private char character;
    private String x;
    private String y;

    public Cell(char character) {
        this.character = character;
    }

    public Cell(char character, String x, String y) {
        this.character = character;
        this.x = x;
        this.y = y;
    }

    public Cell() {

    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
