package fa.dfa;

import fa.State;
import fa.dfa.TransitionMap;

import java.util.HashMap;

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

//    private class TransitionMap {
//
//        private HashMap<String, State> transitionTable; // used string since HasHMap requires an Object - on String map to Next State State
//
//        public TransitionMap() {
//            transitionTable = new HashMap<String,State>();
//        }
//
//        /**
//         * Adds a transition from the current state to a new one
//         * @param key - the symbol we are transitioning with
//         * @param destState - the new state
//         */
//        public void addTran(char key, State destState){
//            //we can add an array or something instead of just 1 value when we do a dfa
//            if(transitionTable.putIfAbsent((String) key, destState) == null) { //adds the value and key to the hash table. null if they do not already exist
//                System.out.println("Transition [" + key + ", " + destState.getName() + "] added");
//            } else {
//                System.out.println("Transition [" + key + ", " + destState.getName() + "] already exists.");
//                System.out.println("Check if we actually have a DFA.");
//            }
//        }
//
//        /**
//         * Finds the transition associated with a symbol, and returns the new state
//         * @param key - transition symbol
//         * @return - new state, or null if the transition has not been added
//         */
//        public State getTran(String key){
//            return transitionTable.get(key);//retrieves state from hashtable and returns it
//        }
//
//    }

}
