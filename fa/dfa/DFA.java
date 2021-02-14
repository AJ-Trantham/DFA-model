package fa.dfa;

import fa.FAInterface;
import fa.State;

import java.util.Set;

public class DFA implements DFAInterface, FAInterface {
    //TODO: need a member variable pointingn to the start state
    // TODO: need set of final states - member variable as accessed by accepts

    // TODO:  and Set of States - remember states will each hold there own transition table so the DFA does not need a transtion table only the states do


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
