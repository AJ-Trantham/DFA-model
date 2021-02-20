package fa.dfa;

import fa.State;
import fa.TransitionMap;

public class DFAState extends State {

        // should have a transition table which will map its transition on its possible inputs
    private TransitionMap table; //table used to store transitions

    public DFAState(){
        table = new TransitionMap();
    }

    /**
     * Returns the state the symbol would transition to
     * @param symbol - next symbol in input string
     * @return - new state, null if it has not been added
     */
    public State transition(String symbol){
        return table.getTran(symbol);
    }
}
