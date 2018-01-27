package org.ticTacToe.model;

import javax.xml.ws.Action;
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


}
