import java.util.Arrays;
import java.util.List;

public class IODemo {
    public IODemo(TestData testData){
        this.states = testData.getStates();
        this.terminals = testData.getTerminals();
        this.nextStates = testData.getNextStates();
    }
    public void setMatrOfTransAndOut(String[][] matrOfTransAndOut) {
        this.matrOfTransAndOut = matrOfTransAndOut;
    }
    public IODemo(){}
    private String [][] matrOfTransAndOut;
    private String [] states;
    private String [] terminals;
    private String [][] nextStates;
    public String [][] input() {
        System.out.println("Нетерминальные символы (состояния):");
        print(states);
        System.out.println("Терминальные символы (входные воздействия):");
        print(terminals);
        matrOfTransAndOut = new String [terminals.length + 1][states.length + 1];
        insertStates(states);
        insertTerminals(terminals);
        System.out.println("Матрица переходов и выходов");
        insertNextStates(nextStates);
        print(matrOfTransAndOut);
        System.out.println();
        return matrOfTransAndOut;
    }
    private void insertStates(String[] states){
        matrOfTransAndOut[0][0] = " ";
        for (int i = 1; i <= states.length; i++) {
            matrOfTransAndOut[0][i] = states[i - 1];
        }
    }
    private void insertTerminals(String[] terminals){
        for (int i = 1; i <= terminals.length; i++) {
            matrOfTransAndOut[i][0] = terminals[i - 1];
        }
    }
    private void insertNextStates(String[][] next){
        for (int i = 1; i < matrOfTransAndOut[0].length; i++) {
            for (int j = 1; j < matrOfTransAndOut.length; j++) {
                matrOfTransAndOut[j][i] = next[j - 1][i - 1];
            }
        }
    }
    public void print(String[][] matr){
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void print(String[] vect){
        System.out.println(Arrays.toString(vect));
    }
    public String[][] getMatrOfTransAndOut() {
        return matrOfTransAndOut;
    }
    public String[] getStates() {
        return states;
    }
    public String[] getTerminals() {
        return terminals;
    }
    public String[][] getNextStates() {
        return nextStates;
    }
}
