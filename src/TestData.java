import java.util.ArrayList;
import java.util.List;

public class TestData {
    /**
     * вектор слов нетерминалов
     */
    private String [] states;
    /**
     * вектор слов терминалов
     */
    private String [] terminals;
    /**
     * матрица следущих состояний
     */
    private String [][] nextStates;
    /**
     * Список слов
     */
    private List<String> testStrings;

    /**
     * Метод-конструктор имеющий следующие аргументы
     * @param states
     * @param terminals
     * @param nextStates
     * @param testStrings
     */
    public TestData(String [] states, String [] terminals, String[][] nextStates, List<String> testStrings){
        this.states = states; this.terminals = terminals; this.nextStates = nextStates; this.testStrings = new ArrayList<>(testStrings);
    }

    /**
     * метод возвращающий вектор нетерминалов
     * @return
     */
    public String[] getStates() {
        return states;
    }

    /**
     * метод возвращающий терминалы
     * @return
     */
    public String[] getTerminals() {
        return terminals;
    }

    /**
     * метод возвращающий матрицу следующих состояний
     * @return
     */
    public String[][] getNextStates() {
        return nextStates;
    }

    /**
     * метод возвращающий список тестовых слов
     * @return
     */
    public List<String> getTestStrings() {
        return testStrings;
    }
}
