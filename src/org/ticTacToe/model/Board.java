package org.ticTacToe.model;

import java.util.Arrays;
import java.util.Observable;

public class Board extends Observable {
    private final int dim;
    private TicTac[][] data;

    public Board() {
        this.dim = 3;
        this.data = new TicTac[getDim()][getDim()];
        reset();
    }

    public TicTac[][] getData() {
        return data;
    }

    public TicTac getData(int x, int y) {
        return data[x][y];
    }

    public void setData(int x, int y, TicTac val) {
        this.data[x][y] = val;
        setChanged();
        notifyObservers();
    }

    public int getDim() {
        return dim;
    }

    public void reset() {
        for (TicTac[] row : data) { // wyłuskanie rządka, nie indeksu
            Arrays.fill(row, TicTac.EMPTY); // zajebista sprawa {klasa Arrays rulez)
        }
        setChanged();
        notifyObservers();
    }

    public boolean isPossible() {
        for (int x = 0; x < 2; ++x) {
            for (int y = 0; y < 2; ++y) {
                if (getData(x, y) == TicTac.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWinner(TicTac token) {
        if (getData(0, 0).equals(token)) {
            if (getData(0, 1).equals(token)) {
                return getData(0, 2).equals(token);
            }
        } else if (getData(1, 0).equals(token)) {
            if (getData(1, 1).equals(token)) {
                return getData(1, 2).equals(token);
            }
        } else if (getData(2, 0).equals(token)) {
            if (getData(2, 1).equals(token)) {
                return getData(2, 2).equals(token);
            }
        } else if (getData(0, 0).equals(token)) {
            if (getData(1, 0).equals(token)) {
                return getData(2, 0).equals(token);
            }
        } else if (getData(0, 1).equals(token)) {
            if (getData(1, 1).equals(token)) {
                return getData(2, 1).equals(token);
            }
        } else if (getData(0, 2).equals(token)) {
            if (getData(1, 2).equals(token)) {
                return getData(2, 2).equals(token);
            }
        } else if (getData(0, 0).equals(token)) {
            if (getData(1, 1).equals(token)) {
                return getData(2, 2).equals(token);
            }
        } else if (getData(2, 2).equals(token)) {
            if (getData(1, 1).equals(token)) {
                return getData(0, 0).equals(token);
            }
        }
        return false;
    }
}

