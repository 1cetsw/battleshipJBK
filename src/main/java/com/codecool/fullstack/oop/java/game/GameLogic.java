package com.codecool.fullstack.oop.java.game;

import com.codecool.fullstack.oop.java.player.Player;
import com.codecool.fullstack.oop.java.ship.Ship;
import com.codecool.fullstack.oop.java.utils.Input;
import com.codecool.fullstack.oop.java.view.Board;
import com.codecool.fullstack.oop.java.view.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    private Scanner scanner = new Scanner(System.in);
    private List<Ship> shipsPlayer1 = new ArrayList<>();
    private List<Ship> shipsPlayer2 = new ArrayList<>();
    List<Board> boardP1 ;
    List<Board> boardP2 ;




    public void addShipsToEmptyBoard(){
        Input board1 = new Input();
        Input board2 = new Input();
        boardP1 = board1.getBoards();
        boardP2 = board2.getBoards();
        Board boardPLayer1 = boardP1.get(0);
        Board boardPLayer2 = boardP2.get(0);

        for(int i = 0; i<2 ; i ++) {
            Ship one = board1.createShip(0);
            while (one.isPlacementOk(one, shipsPlayer1,boardPLayer1) == false) {
                one = board1.createShip(0);
            }
            shipsPlayer1.add(one);
        }
        for(int i = 0; i<2 ; i ++) {
            Ship one = board2.createShip(1);
            while (one.isPlacementOk(one, shipsPlayer2,boardPLayer2) == false) {
                one = board2.createShip(1);
            }
            shipsPlayer2.add(one);
        }

        Player player1 = new Player(shipsPlayer1,boardPLayer2);
        Player player2 = new Player(shipsPlayer2,boardPLayer1);
        Boolean gameOn = true;
        Display display = new Display();
        display.printBoard(boardPLayer1);
        display.printBoard(boardPLayer2);
        int numberOfShipsPlayer1 = player1.numberOfSquaresOfShips(shipsPlayer1);
        int numberOfShipsPlayer2 = player2.numberOfSquaresOfShips(shipsPlayer2);
        System.out.println(numberOfShipsPlayer1+ " player 1");
        System.out.println(numberOfShipsPlayer2+ " player 2");
        System.out.println("Press Enter to continue");
        scanner.nextLine();
        display.clearscreen();
        while(gameOn) {
            int[] ShootCoordinates ;
            display.printBoard(player1.getBoard());
            ShootCoordinates = board1.shoot(0);
            if(player1.handleShot(ShootCoordinates[0],ShootCoordinates[1])) {
                display.printBoard(player1.getBoard());
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                display.clearscreen();
                numberOfShipsPlayer2--;
            } else {
                display.printBoard(player1.getBoard());
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                display.clearscreen();
            }
            if (numberOfShipsPlayer2 == 0) {
                display.printBoard(player1.getBoard());
                System.out.println("player 1 wins!");
                break;
            }
            display.printBoard(player2.getBoard());
            ShootCoordinates = board2.shoot(1);
            if(player2.handleShot(ShootCoordinates[0],ShootCoordinates[1])) {
                display.printBoard(player2.getBoard());
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                display.clearscreen();
                numberOfShipsPlayer1--;
            }  else {
                display.printBoard(player2.getBoard());
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                display.clearscreen();
            }
            if(numberOfShipsPlayer1 == 0) {
                display.printBoard(player2.getBoard());
                System.out.println("player 2 wins!");
                break;
            }
        }
    }
}