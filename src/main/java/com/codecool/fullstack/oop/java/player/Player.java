package com.codecool.fullstack.oop.java.player;

import com.codecool.fullstack.oop.java.ship.Ship;
import com.codecool.fullstack.oop.java.view.Board;
import com.codecool.fullstack.oop.java.view.Square;
import com.codecool.fullstack.oop.java.view.SquareStatus;

import java.util.List;
import java.util.Scanner;

public class Player {

    private List<Ship> ships;
    private int remainingShips = 0;
    private Board board;

    public Player(List<Ship> ships,Board board) {
        this.ships = ships;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public int numberOfSquaresOfShips(List<Ship> ships) {
        int sumOfAllSquares = 0;
        for (Ship ship : ships) {
            sumOfAllSquares += ship.getShipType().label;
        }
        return sumOfAllSquares;
    }





    public boolean  handleShot(int x, int y) {
        for( Ship ship : ships) {
            for(Square square : ship.getFields()) {

                if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.SHIP)) {
                    square.setSquareStatus(SquareStatus.HIT);
                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("You hit a ship!");
                    return true;
                } else if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.HIT)){
                    square.setSquareStatus(SquareStatus.HIT);
                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
                    System.out.println("Already Hit");
                    return  false;
                }
            }
        }
        board.getSquare(x,y).setSquareStatus(SquareStatus.MISSED);
        System.out.println("Miss!");
        return  false;
    }

}