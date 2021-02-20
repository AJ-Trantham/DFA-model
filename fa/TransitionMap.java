package fa;

import java.util.HashMap;

public class TransitionMap {

    // wrapper for HashMap and will hold the Transitions
    private HashMap<String,State> transitionTable; // used string since it since HasMap requires an Object

    public TransitionMap() {

        transitionTable = new HashMap();

    }

    /**
     * Adds a transition from the current state to a new one
     * @param key - the symbol we are transitioning with
     * @param value - the new state
     */
    public void addTran(String key, String value){
        //we can add an array or something instead of just 1 value when we do a dfa

        if(transitionTable.putIfAbsent(key, value) == null) { //adds the value and key to the hash table. null if they do not already exist
            System.out.println("Transition [" + key + ", " + value + "] added");
        } else {
            System.out.println("Transition [" + key + ", " + value + "] already exists.");
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
