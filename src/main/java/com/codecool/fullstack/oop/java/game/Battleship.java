package com.codecool.fullstack.oop.java.game;


import com.codecool.fullstack.oop.java.game.Game;
import com.codecool.fullstack.oop.java.utils.Input;
import com.codecool.fullstack.oop.java.view.Display;

public class Battleship {
    private Display display;
    private Game game = new Game();
    private Input input;


    public Battleship() {
        display = new Display();
    }

    public void Start() {
        display.printMenu();
        mainMenu();
    }

    public void mainMenu() {
        int choice;
        boolean exit = false;
        input = new Input();

        while (!exit) {

            display.printMainMenuOptions();
            System.out.println("Enter your choice: ");
            System.out.println();
            choice = input.getIntegerMenuOption();
            switch (choice) {
                case 1: //play game
                    display.printMessages("You chose to play game ");
                    game.addShipsToEmptyBoard();

                    break;
                case 2: //print rules
                    display.printMessages("\033[H\033[2J");
                    System.out.flush();
                    display.gameRules();
                    break;
                case 3: //exxit
                    display.printMessages("Exit");
                    exitGame();
                    break;
            }
        }

    }

    public void exitGame() {
        display.printExitMessage();
        System.exit(0);
    }


}