import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Данный класс служит для универсального ввода значений
 */
public class IO {
    private String [][] matrOfTransAndOut = null;
    private String [] states;
    private String [] terminals;
    private String [][] nextStates;

    /**
     * При вызове конструктора следом вызывается метод input
     */
    public IO(){
        input();
    }

    /**
     * Метод позволяет ввести с клавиатуры нетерминальные, терминальные символы
     * матрицу следущих состояний, где посредством методов insertStates() и insertTerminals()
     * заполняется матрица переходов и выходов, при окончании заполнения печатается получившеяся матрица
     * @return
     */
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
            System.out.println("Введите все состояния инцидентные данной через пробел.\n" +
                                "если у вершины нет инцедентности при воздействии определенного терминала\n" +
                                "необходимо ввести '-'");
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
    /**
     * Вставляет в матрицу переходов и выходов нетерминальные символы
     * место на координатах (0;0) остается пустое,
     * а по координатам (0; 1),(0; 2) и последующие после него по порядку
     * согласно переданному сначению заполняется.
     * @param states - массив нетерминалов
     */
    private void insertStates(String[] states){
        matrOfTransAndOut[0][0] = " ";
        for (int i = 1; i <= states.length; i++) {
            matrOfTransAndOut[0][i] = states[i - 1];
        }
    }
    /**
     * Вставляет в матрицу переходов и выходов терминальные символы
     * место на координатах (0;0) остается пустое,
     * а по координатам (1; 0),(2; 0) и последующие после него по порядку
     * согласно переданному сначению заполняется.
     * @param terminals - массив терминалов
     */
    private void insertTerminals(String[] terminals){
        for (int i = 1; i <= terminals.length; i++) {
            matrOfTransAndOut[i][0] = terminals[i - 1];
        }
    }
    /**
     * Заполняется матрица переходов и выходов матрицей следующих состояний
     * начиная с места (1;1) переданной матрицей следующих состояний
     * @param next - матрица следующих состояний
     */
    private void insertNextStates(String[][] next){
        for (int i = 1; i < matrOfTransAndOut[0].length; i++) {
            for (int j = 1; j < matrOfTransAndOut.length; j++) {
                matrOfTransAndOut[j][i] =
                        next[j - 1][i - 1];
            }
        }
    }
    /**
     * Печатает на экран переданную матрицу
     * @param matr - матрица слов
     */
    public void print(String[][] matr){
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                System.out.print(matr[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * Печатает на экран переданный вектор
     * @param vect - вектор слов
     */
    public void print(String[] vect){
        System.out.println(Arrays.toString(vect));
    }
    /**
     * Метод возвращает матрицу переходов и выходов
     * @return
     */
    public String[][] getMatrOfTransAndOut() {
        return matrOfTransAndOut;
    }
    /**
     * Метод возвращает вектор нетерминальных символов
     * @return
     */
    public String[] getStates() {
        return states;
    }
    /**
     * Метод возвращает вектор терминалов
     * @return
     */
    public String[] getTerminals() {
        return terminals;
    }
    /**
     * Метод возвращает матрицу следующих состояний
     * @return
     */
    public String[][] getNextStates() {
        return nextStates;
    }
}
