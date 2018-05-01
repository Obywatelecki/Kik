package org.fsm;
import Action.FSMAction;
import FSM.FSM;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Example1 {
    public static void testFSM() {
        try {
            FSM f = null;
            try {
                f = new FSM("C:\\Users\\Tomasz Panecki\\Downloads\\easyfsm-master\\src\\config\\config.xml", new FSMAction() {
                    @Override
                    public boolean action(String curState, String message, String nextState, Object args) {
                        javax.swing.JOptionPane.showMessageDialog(null, curState + ":" + message + " : " + nextState);
                        /*
                         * Here we can implement our login of how we wish to handle
                         * an action
                         */
                        return true;
                    }
                });
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVELEFT");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVE");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVERIGHT");
            System.out.println(f.getCurrentState());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            testFSM();
        } catch (Exception ex) {
            Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
