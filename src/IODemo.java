import java.util.Arrays;
import java.util.List;

/**
 * Данный класс является примером использования
 * данной программы
 */
public class IODemo {
    /**
     * матрица переходов и выходов.
     */
    private String [][] matrOfTransAndOut;
    /**
     * массив - состояний (нетерминальных символов).
     */
    private String [] states;
    /**
     * массив - входных воздействий (терминальных символов).
     */
    private String [] terminals;
    /**
     * матрица следующих состояний
     */
    private String [][] nextStates;
    /**
     * Конструктор. Получает экземпляр объекта TestData
     * и назначает полям текущего класса некоторые значения.
     * @param testData - объект с предварительно заполненными данными
     */
    public IODemo(TestData testData){
        this.states = testData.getStates();
        this.terminals = testData.getTerminals();
        this.nextStates = testData.getNextStates();
    }

    /**
     * Устанавливает переданное значение в матрицу
     * переходов и выходов.
     * @param matrOfTransAndOut
     */
    public void setMatrOfTransAndOut(String[][] matrOfTransAndOut) {
        this.matrOfTransAndOut = matrOfTransAndOut;
    }

    /**
     * Перегруженный пустой конструктор
     */
    public IODemo(){}

    /**
     * Инициализирует матрицу переходов и выходов и возвращает ее.
     * @return - возвращает матрицу переходов и выходов
     */
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
                matrOfTransAndOut[j][i] = next[j - 1][i - 1];
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
