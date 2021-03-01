package fa.dfa;

import fa.FAInterface;
import fa.State;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFA implements DFAInterface, FAInterface {
    private HashSet<DFAState> finalStates;
    private HashSet<DFAState> states; // hold each state including start or final state in the DFA
    private DFAState startState;      // there should only be a single start state
    private HashSet<Character> symbols;

    public DFA() {
        finalStates = new HashSet<DFAState>();
        states = new HashSet<DFAState>();
        symbols = new HashSet<Character>();
        startState = null;
    }


    @Override
    public boolean accepts(String s) {

        int spoint = 0; //index pointer on s
        DFAState statePoint = startState;//current state pointer
        int slength = s.length(); //length of s

        while(slength != spoint){
            char symb = s.charAt(spoint); //get symbol at the s pointer
            statePoint = statePoint.transition(symb);
            if(statePoint == null){
                return false;
            }
            spoint++;
        }
//        statePoint = statePoint.transition((char) s.substring(spoint));
        if (!statePoint.isFinalState()){
            return false;
        }else {
            return true;
        }
    }
//TODO: this thing
    @Override
    public State getToState(DFAState from, char onSymb) {
        return null;
    }

    @Override
    public void addStartState(String name) {
        startState = new DFAState(name);
        this.states.add(startState);
    }

    @Override
    public void addState(String name) {
        DFAState newState = new DFAState(name);
        this.states.add(newState);
    }

    @Override
    public void addFinalState(String name) {
        DFAState newFinalState = new DFAState(name);
        this.states.add(newFinalState);
        this.finalStates.add(newFinalState);
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        DFAState originState = this.getStateByName(fromState);
        DFAState destState = this.getStateByName(toState);

        originState.addTransition(onSymb, destState);

        // update symbols if new Symb is seen, don't need to check if sym is in the language as HashSet only adds if it isn't in the set
        symbols.add(onSymb);

    }

    @Override
    public Set<? extends State> getStates() {
        return states;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }

    @Override
    public State getStartState() {
        return startState;
    }

    @Override
    public Set<Character> getABC() {
        return symbols;
    }

    private DFAState getStateByName(String name) {
        DFAState state = null;
        boolean found = false;
        Iterator<DFAState> iterator = this.states.iterator();
        while(iterator.hasNext() && !found) {
            state = iterator.next();
            if (state.getName().equals(name)) {
                found = true;
            }
        }
        return state;
    }

    @Override
    public String toString() {

        StringBuilder dfaStr = new StringBuilder();

        // add states
        StringBuilder states = new StringBuilder();
        states.append(" ");
        Iterator<DFAState> stateIterator = this.states.iterator();
        while (stateIterator.hasNext()) {
            states.append(stateIterator.next().getName() + " ");
        }
        dfaStr.append("Q = {" + states + "}");

        // add symbols
        StringBuilder lang = new StringBuilder();
        Iterator<Character> langIterator = this.symbols.iterator();
        while (langIterator.hasNext()) {
            lang.append(langIterator.next().toString() + " ");
        }
        dfaStr.append("\nSigma = { " + lang + "}");


        return dfaStr.toString();
    }
}
