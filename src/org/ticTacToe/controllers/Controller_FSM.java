package org.ticTacToe.controllers;

import Action.FSMAction;
import FSM.FSM;
import org.junit.Before;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller_FSM {

    private String _configFileName = "resource/configFSM_whiteBegins.xml";

    @Before
    public void readConfig(){};

    @Test
    public void controll_FSM() throws org.xml.sax.SAXException {
        try {
            FSM f = new FSM(this.getClass().getClassLoader().getResourceAsStream(_configFileName), new FSMAction() {
                @Override
                public boolean action(String curState, String message, String nextState, Object args) {
                    System.out.println("Action: " + curState + ":" + message + " : " + nextState);
                    return true;
                }
            });

            System.out.println(f.getCurrentState());
            f.ProcessFSM("GO");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVE");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVE");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("FULL");
            System.out.println(f.getCurrentState());
        } catch (ParserConfigurationException | IOException ex) {
            Logger.getLogger(org.fsm.Example4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
