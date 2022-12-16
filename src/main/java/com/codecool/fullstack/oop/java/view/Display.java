package com.codecool.fullstack.oop.java.view;
import com.codecool.fullstack.oop.java.view.Board;

import static com.codecool.fullstack.oop.java.utils.Color.*;



public class Display {


    public Display() {

    }

    public void printMenu() {
        System.out.println("BattleshipJBK is starting........ ");
        System.out.println(" \n" +
                "▀█████████▄     ▄████████     ███         ███      ▄█          ▄████████    ▄████████    ▄█    █▄     ▄█     ▄███████▄ \n" +
                "  ███    ███   ███    ███ ▀█████████▄ ▀█████████▄ ███         ███    ███   ███    ███   ███    ███   ███    ███    ███ \n" +
                "  ███    ███   ███    ███    ▀███▀▀██    ▀███▀▀██ ███         ███    █▀    ███    █▀    ███    ███   ███▌   ███    ███ \n" +
                " ▄███▄▄▄██▀    ███    ███     ███   ▀     ███   ▀ ███        ▄███▄▄▄       ███         ▄███▄▄▄▄███▄▄ ███▌   ███    ███ \n" +
                "▀▀███▀▀▀██▄  ▀███████████     ███         ███     ███       ▀▀███▀▀▀     ▀███████████ ▀▀███▀▀▀▀███▀  ███▌ ▀█████████▀  \n" +
                "  ███    ██▄   ███    ███     ███         ███     ███         ███    █▄           ███   ███    ███   ███    ███        \n" +
                "  ███    ███   ███    ███     ███         ███     ███▌    ▄   ███    ███    ▄█    ███   ███    ███   ███    ███        \n" +
                "▄█████████▀    ███    █▀     ▄████▀      ▄████▀   █████▄▄██   ██████████  ▄████████▀    ███    █▀    █▀    ▄████▀    ");

    }

    public void printMessages(String message) {
        System.out.println(message);
    }

    public void printMainMenuOptions() {
        System.out.println("Press:\n" +
                "\t 1 - Play\n" +
                "\t 2 - Print game rolls\n" +
                "\t 3 - Exit game\n");
    }

    public void printExitMessage() {
        System.out.println("Have a nice day ahead!");

    }
    public void gameRules() {
        System.out.println("Each ship must be placed horizontally or vertically across grid spaces—not diagonally—and the ships can't hang off the grid. \n" +
                "Ships can touch each other, but they can't occupy the same grid space.\n" +
                "You cannot change the position of the ships after the game begins.\n");
    }

    public void printBoard(Board board) {
        System.out.print("    ");

        for (int i = 0; i < board.getSizeX(); i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int row = 0; row < board.getSizeX(); row++) {
            if (row < 10) {
                System.out.print(row + "   ");
            } else {
                System.out.print(row);
            }

            for (int col = 0; col < board.getSizeY(); col++) {
                switch (board.getSquare(row, col).getCharacter()) {
                    case 'O':
                        System.out.print(BLUE_BACKGROUND + "  " + RESET + " ");
                        break;
                    case 'H':
                        System.out.print(RED_BACKGROUND + "  " + RESET + " ");
                        break;
                    case 'S':
                        System.out.print(YELLOW_BACKGROUND + "  " + RESET + " ");
                        break;
                    case 'E':
                        System.out.print(CYAN_BACKGROUND + "  " + RESET + " ");
                        break;
                    case 'M':
                        System.out.print(BLACK_BACKGROUND + "  " + RESET + " ");
                        break;
                }

            }
            System.out.println();

        }
    }
}



