import java.util.ArrayList;
import java.util.List;

public class TestData {
    private String [] states;
    private String [] terminals;
    private String [][] nextStates;
    private List<String> testStrings;
    public TestData(String [] states, String [] terminals, String[][] nextStates, List<String> testStrings){
        this.states = states; this.terminals = terminals; this.nextStates = nextStates; this.testStrings = new ArrayList<>(testStrings);
    }
    public String[] getStates() {
        return states;
    }
    public void setStates(String[] states) {
        this.states = states;
    }
    public String[] getTerminals() {
        return terminals;
    }
    public void setTerminals(String[] terminals) {
        this.terminals = terminals;
    }
    public String[][] getNextStates() {
        return nextStates;
    }
    public void setNextStates(String[][] nextStates) {
        this.nextStates = nextStates;
    }
    public List<String> getTestStrings() {
        return testStrings;
    }
    public void setTestStrings(List<String> testStrings) {
        this.testStrings = testStrings;
    }
}
