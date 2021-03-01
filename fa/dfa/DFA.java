package fa.dfa;

import fa.FAInterface;
import fa.State;

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;

public class DFA implements DFAInterface, FAInterface {
    private LinkedHashSet<DFAState> finalStates;
    private LinkedHashSet<DFAState> states; // hold each state including start or final state in the DFA
    private DFAState startState;      // there should only be a single start state
    private LinkedHashSet<Character> symbols;

    public DFA() {
        finalStates = new LinkedHashSet<DFAState>();
        states = new LinkedHashSet<DFAState>();
        symbols = new LinkedHashSet<Character>();
        startState = null;
    }


    @Override
    public boolean accepts(String s) {

        int spoint = 0; //index pointer on s
        DFAState statePoint = startState;//current state pointer
        int slength = s.length(); //length of s

        while(slength != spoint){
    //        System.out.println(s);
		char symb = s.charAt(spoint); //get symbol at the s pointer
            statePoint = statePoint.transition(symb);
            if(statePoint == null){
    //            System.out.println("Outputting false 1");
		return false;
            }
            spoint++;
        }
//        statePoint = statePoint.transition((char) s.substring(spoint));
        if (!statePoint.isFinalState()){
//                System.out.println("Outputting false 2");
		return false;
        }else {
  //          	System.out.println("Outputting true");
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
        //System.out.println("New start state" + name);
	    startState = new DFAState(name);
        startState.setStartState(true);
	this.states.add(startState);
    }

    @Override
    public void addState(String name) {
//        System.out.println("New Regular state" + name);
	    DFAState newState = new DFAState(name);
        this.states.add(newState);
    }

    @Override
    public void addFinalState(String name) {
//        System.out.println("New final state" + name);
	    DFAState newFinalState = new DFAState(name);
        newFinalState.setFinalState(true);
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
//        	System.out.println("States: " + states);
	   	    states.append(stateIterator.next().getName() + " ");
        }
        dfaStr.append("Q = {" + states + "}");

        // add symbols
        StringBuilder lang = new StringBuilder();
        Iterator<Character> langIterator = this.symbols.iterator();
        while (langIterator.hasNext()) {
//          System.out.println("Lang: " + lang.toString());
		    lang.append(langIterator.next().toString() + " ");
        }
        dfaStr.append("\nSigma = { " + lang + "}\n");

        //transition table delta
        langIterator = this.symbols.iterator();
        stateIterator = this.states.iterator();
        dfaStr.append("delta = \n");
        dfaStr.append("\t\t");
        while (langIterator.hasNext()) {
            dfaStr.append(langIterator.next().toString() + "\t");
        }
        dfaStr.append("\n");
        while(stateIterator.hasNext()) {
            langIterator = this.symbols.iterator();
            DFAState currState = stateIterator.next();
            dfaStr.append("\t" + currState.getName() + "\t");
            // transition on each symbol
            while(langIterator.hasNext()) {
                char symb = langIterator.next();
                DFAState transState = currState.transition(symb);
                dfaStr.append(transState.getName() + "\t");
            }
            dfaStr.append("\n");
        }

        // start state
        dfaStr.append("q0 = " + startState.getName());

        // final states
        Iterator<DFAState> finalStatesIterator = this.finalStates.iterator();
        dfaStr.append("\nF = { ");
        while (finalStatesIterator.hasNext()) {
             dfaStr.append(finalStatesIterator.next() + " ");
        }
        dfaStr.append("}");


        return dfaStr.toString();
    }
}
