import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IO {
    private String [][] matrOfTransAndOut = null;
    private String [] states;
    private String [] terminals;

    private String [][] nextStates;
    public boolean input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите нетерминальные символы (состояния) через пробел");
            String str = br.readLine();
            states = str.trim().toUpperCase().split(" ");
            System.out.println(Arrays.toString(states));
            System.out.println("Введите терминальные символы (входные воздействия) через пробел");
            String str2 = br.readLine();
            terminals = str2.trim().toLowerCase().split(" ");
            System.out.println(Arrays.toString(terminals));
            matrOfTransAndOut = new String [terminals.length + 1][states.length + 1];
            nextStates = new String[matrOfTransAndOut.length - 1][matrOfTransAndOut.length - 1];
            insertStates(states);
            insertTerminals(terminals);
            System.out.println("Введите все состояния инцидентные данной через пробел.");
            String str3;
            String [] sts;
            for (int i = 1; i < matrOfTransAndOut[0].length; i++) {
                System.out.print(matrOfTransAndOut[0][i] + " = ");
                str3 = br.readLine();
                sts = str3.trim().toUpperCase().split(" ");
                for (int j = 1; j < matrOfTransAndOut.length; j++) {
                    try {
                        matrOfTransAndOut[j][i] = sts[j - 1];
                    }catch (ArrayIndexOutOfBoundsException e){
                        matrOfTransAndOut[j][i] = "-";
                    }
                }
            }
            print(matrOfTransAndOut);
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
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
                matrOfTransAndOut[j][i] =
                        next[j - 1][i - 1];
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
