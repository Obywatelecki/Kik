package org.ticTacToe.controllers;
import org.ticTacToe.model.Board;
import org.ticTacToe.model.TicTac;
import java.util.Scanner;

public class ControllerHuman implements IStrategy {

    {
        System.out.println("Podaj imie gracza:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        setName(name);
        System.out.println("Grasz jako " + name);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean makeMove(Board board, TicTac playerSymbol) {
        System.out.println("Grasz jako " + name + ", a Twoj symbol to: "+ playerSymbol);

        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Wiersz...");
                x = scanner.nextInt();
                System.out.println("Kolumna...");
                y = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Nie dziala!");
            }

            if (board.getData(x, y) == TicTac.EMPTY) {
                board.setData(x, y, playerSymbol);
                return true;
            }
        }
    }

}
