package fa.dfa;

import fa.State;
import fa.dfa.TransitionMap;

import java.util.HashMap;


/**
 *  Represents a DFA state with all the state information: stat, final, and transition info
 *
 * @author Jost Leavell
 * @author AJ Trantham
 */
public class DFAState extends State {

    // should have a transition table which will map its transition on its possible inputs
    private TransitionMap table; //table used to store transitions
    private boolean startState;
    private boolean finalState;

    public DFAState(String name) {
        this.name = name;
        table = new TransitionMap();
        startState = false;
        finalState = false;
    }

    /**
     * Returns the state the symbol would transition to
     * @param symbol - next symbol in input string
     * @return - new state, null if it has not been added
     */
    public DFAState transition(char symbol){
        return table.getTran(symbol);
    }

    public void addTransition(char symbol, DFAState destState) {
        table.addTran(symbol,destState);
    }

    /**
     * Sets this state as the start state
     * @param bool - boolean saying whether this state is the start state
     */
    public void setStartState(boolean bool){
        startState = bool;
    }

    /**
     * Sets this state as a final state
     * @param bool - boolean saying whether this state is a final state
     */
    public void setFinalState(boolean bool){
        finalState = bool;
    }

    @Override
    public boolean isStartState() {
        return startState;
    }

    @Override
    public boolean isFinalState(){
        return finalState;
    }

}
