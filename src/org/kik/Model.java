package org.kik;

public class Model {
    View view;
    int x;
    int y;
    final int dim = 3;
    enum XO {YES, NO, EMPTY}
    XO[][] board;

    public boolean isEmpty(int x, int y) {
        return true;
    }

    public void setBoard(int x, int y, XO board) {

    }
/*
    public XO[][] getBoard() {
        /// kod
    }
*/

    public void reset() {

    }

    public boolean aiWins() {
        return true;
    }

    public boolean manWins() {
        return true;
    }

    public boolean draw() {
        return true;
    }

    public void changed() {

    }
}
