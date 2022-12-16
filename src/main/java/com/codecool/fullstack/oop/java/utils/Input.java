package com.codecool.fullstack.oop.java.utils;

import com.codecool.fullstack.oop.java.ship.Ship;
import com.codecool.fullstack.oop.java.ship.ShipType;
import com.codecool.fullstack.oop.java.view.Board;
import com.codecool.fullstack.oop.java.view.Square;
import com.codecool.fullstack.oop.java.view.SquareStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Input {
    private Scanner scanner = new Scanner(System.in);
    private List<Board> boards = new ArrayList<>();
    int choice;
    List<Integer> CoordinatesAndShipType = new ArrayList<>();

    public List<Board> getBoards() {
        generateBoard();
        return boards;
    }

    public Input() {

    }


    public int getIntegerMenuOption() {
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;

    }

    private List<Integer> AskCoordForShipAndType() {
        this.CoordinatesAndShipType = new ArrayList<>();
        System.out.println("select row :");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("select col: ");
        int col = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select ship: \n" + "1. CARRIER Eagle \n" + "2. CRUISER Aurora" + "\n" + "3. BATTLESHIP Alabama \n"
                + "4. DESTROYER Shimakaze\n" + "5. SUBMARINE Nautilius \n");
        int shipType = scanner.nextInt();
        CoordinatesAndShipType.add(row);
        CoordinatesAndShipType.add(col);
        CoordinatesAndShipType.add(shipType);
        return CoordinatesAndShipType;

    }

    public Ship createShip(int player) {
        int GamePlayer = player + 1;
        Square shipPart;
        Ship ship;
        System.out.println("Player " + GamePlayer + " place Ship");
        CoordinatesAndShipType = AskCoordForShipAndType();
        int row = CoordinatesAndShipType.get(0);
        int col = CoordinatesAndShipType.get(1);
        int shipType = CoordinatesAndShipType.get(2);
        shipPart = new Square(row, col, SquareStatus.SHIP);
        ship = new Ship(new ArrayList<>(), ShipType.values()[shipType - 1]);
        boards.get(player).placeShip(shipPart, ship);
        return ship;
    }


    public void generateBoard() {
        System.out.println("select height: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("select width: ");
        int y = scanner.nextInt();
        Board board1 = new Board(x, y);
        Board board2 = new Board(x, y);
        boards.add(board1);
        boards.add(board2);

    }

    public int[] shoot(int player) {
        int GamePlayer = player + 1;
        System.out.println("Player " + GamePlayer + " shoot");
        System.out.println("select row :");
        int row = scanner.nextInt();
        row--;
        scanner.nextLine();
        System.out.println("select col: ");
        int col = scanner.nextInt();
        col--;
        return new int[]{row, col};
    }


}