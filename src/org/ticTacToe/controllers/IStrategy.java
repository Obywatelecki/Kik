package org.ticTacToe.controllers;

import org.ticTacToe.model.Board;
import org.ticTacToe.model.TicTac;

public interface IStrategy {

    boolean makeMove(Board board, TicTac ticTac);
    String getName();

}
