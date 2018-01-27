package org.ticTacToe.views;

import org.ticTacToe.model.Board;
import org.ticTacToe.model.TicTac;

import java.util.Observable;
import java.util.Observer;

public class ShowBoard implements Observer {

    public String prepare(Board board) {
        StringBuilder result = new StringBuilder("");
        TicTac[][] data = board.getData();
        for (TicTac[] row : data) {
            result.append('\n');
            for (TicTac field : row) {
                result
                        .append("| ")
                        .append(field.getMark())
                        .append(" ");
            }

            result.append("| ");

        }
        return result.toString();
    }

    public void show(Board board) {
        System.out.println(prepare(board));
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (!(observable instanceof Board)) return;
        Board board = (Board) observable;
        show(board);
    }
}
