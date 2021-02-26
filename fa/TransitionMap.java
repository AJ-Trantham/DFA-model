package fa;

import fa.dfa.DFAState;
import java.util.HashMap;

// wrapper for HashMap, TransitionMap will be held by State Objects and the TransitionMap will hold transitions to other states
public class TransitionMap {

    private HashMap<String,State> transitionTable; // used string since it since HasHMap requires an Object - on String map to Next State State

    public TransitionMap() {
        transitionTable = new HashMap<String,State>();
    }

    /**
     * Adds a transition from the current state to a new one
     * @param key - the symbol we are transitioning with
     * @param destState - the new state
     */
    public void addTran(String key, State destState){
        //we can add an array or something instead of just 1 value when we do a dfa
        if(transitionTable.putIfAbsent(key, destState) == null) { //adds the value and key to the hash table. null if they do not already exist
            System.out.println("Transition [" + key + ", " + destState.getName() + "] added");
        } else {
            System.out.println("Transition [" + key + ", " + destState.getName() + "] already exists.");
            System.out.println("Check if we actually have a DFA.");
        }
    }

    /**
     * Finds the transition associated with a symbol, and returns the new state
     * @param key - transition symbol
     * @return - new state, or null if the transition has not been added
     */
    public State getTran(String key){
        return transitionTable.get(key);//retrieves state from hashtable and returns it
    }

}
