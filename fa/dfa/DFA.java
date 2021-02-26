package fa.dfa;

import fa.FAInterface;
import fa.State;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFA implements DFAInterface, FAInterface {
    private HashSet<DFAState> finalStates;
    private HashSet<DFAState> states; // hold each state that is not a start or final state in the DFA
    private DFAState startState;      // there should only be a single start state
    private HashSet<String> language;

    public DFA() {
        finalStates = new HashSet<DFAState>();
        states = new HashSet<DFAState>();
        language = new HashSet<String>();
        startState = null;
    }


    @Override
    public boolean accepts(String s) {

        // need current state pointer to walk through string
        return false;
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        return null;
    }

    @Override
    public void addStartState(String name) {
        startState = new DFAStartState(name);
        this.states.add(startState);
    }

    @Override
    public void addState(String name) {
        DFAState newState = new DFAState(name);
        this.states.add(newState);
    }

    @Override
    public void addFinalState(String name) {
        DFAState newFinalState = new DFAFinalState(name);
        this.states.add(newFinalState);
        this.finalStates.add(newFinalState);
    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        DFAState originState = this.getStateByName(fromState);
        DFAState destState = this.getStateByName(toState);
        String symb = String.valueOf(onSymb);
        originState.addTransition(symb, destState);

        // update language if new Symb is seen, don't need to check if sym is in the language as HashSet only adds if it isn't in the set
        language.add(symb);

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
        return null;
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

        // add languages
        StringBuilder lang = new StringBuilder();
        Iterator<String> langIterator = this.language.iterator();
        while (langIterator.hasNext()) {
            lang.append(langIterator.next().toString() + " ");
        }
        dfaStr.append("\nSigma = { " + lang + "}");


        return dfaStr.toString();
    }
}
