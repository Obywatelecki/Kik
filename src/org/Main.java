package org;

import Action.FSMAction;
import FSM.FSM;
import org.ticTacToe.controllers.ControllerHuman;
import org.ticTacToe.controllers.IStrategy;
import org.ticTacToe.model.Board;
import org.ticTacToe.model.TicTac;
import org.ticTacToe.views.ShowBoard;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public FSM getFsm() throws SAXException, IOException, ParserConfigurationException {

        String _configFileName = "resource/configFSM_whiteBegins.xml";

        FSM f = new FSM(this.getClass().getClassLoader().getResourceAsStream(_configFileName), new FSMAction() {
            @Override
            public boolean action(String curState, String message, String nextState, Object args) {
                return true;
            }
        });
        return f;
    }

    public static IStrategy PlayerFactory(String what) {
        if (what.equalsIgnoreCase("man")) {
            return new ControllerHuman();
        }
        return null;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        Main app = new Main();
        FSM fsm = app.getFsm();
        fsm.ProcessFSM("GO");

        Board board = new Board();

        IStrategy player1 = PlayerFactory("man");
        IStrategy player2 = PlayerFactory("man");

        ShowBoard showBoard = new ShowBoard();
        board.addObserver(showBoard);

//        for (int x = 0; x < 3; ++x) {
//            for (int y = 0; y < 3; ++y) {
//                board.setData(x,y,TicTac.TIC);
//            }
//        }

        while (true) {
            switch (fsm.getCurrentState()) {
                case "P1":
                    assert player1 != null;
                    player1.makeMove(board, TicTac.TAC);
                    fsm.ProcessFSM("MOVE");
                    break;
                case "P2":
                    assert player2 != null;
                    player2.makeMove(board, TicTac.TIC);
                    fsm.ProcessFSM("MOVE");
                    break;
                case "STOP":
                    System.out.println("Koniec!");
                    return;
                default:
                    board.reset();
                    System.out.println("Nie bagnla!: " + fsm.getCurrentState());
                    fsm.ProcessFSM("START");
            }
            if (!board.isPossible()) {
                System.out.println("Restujemy gre....");
                fsm.ProcessFSM("FULL");

            } else if (board.isWinner(TicTac.TIC)) {
                assert player2 != null;
                System.out.println("Wygral " + player2.getName());
                fsm.ProcessFSM("FULL");
            } else if (board.isWinner(TicTac.TAC)) {
                assert player1 != null;
                System.out.println("Wygral " + player1.getName());
                fsm.ProcessFSM("FULL");
            }
        }
    }
}