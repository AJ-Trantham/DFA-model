package fa.dfa;

public class DFAStartState extends DFAState {
    public DFAStartState(String name) {
        super(name);
    }

    @Override
    public boolean isStartState() {
        return true;
    }
}
