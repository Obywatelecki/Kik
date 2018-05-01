package org.fsm; /**
 * Example4 Code exemplifies the usage of FSM with a XML configuration file specified
 * within the project as resource along with specific action function for a specific message
 * under specific state
 **/

import Action.FSMAction;
import FSM.FSM;
import jdk.internal.org.xml.sax.SAXException;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Example4 {

    private String _configFileName = "resource/config.xml";

    @Test

    public void TestExample4() throws org.xml.sax.SAXException {
        try {
            FSM f = new FSM(this.getClass().getClassLoader().getResourceAsStream(_configFileName), new FSMAction() {
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
            f.setAction("START", "MOVELEFT", new FSMAction() {
                @Override
                public boolean action(String curState, String message, String nextState, Object args) {
                    System.out.println("Customized moveLeft!");
                    return true;
                }
            });
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVELEFT");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVE");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVERIGHT");
            System.out.println(f.getCurrentState());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Example4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Example4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}