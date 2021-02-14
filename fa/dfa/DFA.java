package fa.dfa;

import fa.FAInterface;
import fa.State;

import java.util.Set;

public class DFA implements DFAInterface, FAInterface {


    @Override
    public boolean accepts(String s) {
        return false;
    }

    @Override
    public State getToState(DFAState from, char onSymb) {
        return null;
    }

    @Override
    public void addStartState(String name) {

    }

    @Override
    public void addState(String name) {

    }

    @Override
    public void addFinalState(String name) {

    }

    @Override
    public void addTransition(String fromState, char onSymb, String toState) {

    }

    @Override
    public Set<? extends State> getStates() {
        return null;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        return null;
    }

    @Override
    public State getStartState() {
        return null;
    }

    @Override
    public Set<Character> getABC() {
        return null;
    }
}
