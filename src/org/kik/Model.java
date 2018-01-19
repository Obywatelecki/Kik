package org.kik;

public class Model {
    View view;
    int x;
    int y;
    final int dim = 3;
    enum XO {YES, NO, EMPTY}
    XO[][] board;

    public boolean isEmpty(int x, int y) {

        //TODO

        return true;
    }

    public void setBoard(int x, int y, XO board) {

        //TODO

    }
/*
    public XO[][] getBoard() {

        //TODO

    }
*/

    public void reset() {

        //TODO

    }

    public boolean aiWins() {

        //TODO

        return true;
    }

    public boolean manWins() {

        //TODO

        return true;
    }

    public boolean draw() {

        //TODO

        return true;
    }

    public void changed() {

        //TODO

    }
}
