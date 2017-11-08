import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Perform {
    /**
     * матрица переходов и выходов
     */
    private String[][] matrOfTransAndOut;
    /**
     * вектор слова разбитого на символы
     */
    private String [] word;

    private int k = 0;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /**
     * метод-конструктор инициализирующий матрицу переходов и выходов
     * @param matrOfTransAndOut - матрица переходов и выходов
     */
    Perform(String[][] matrOfTransAndOut){
        this.matrOfTransAndOut = matrOfTransAndOut;
    }

    /**
     * метод поиска в столбце терминальных символов
     * @param term - массив терминалов
     * @return - возвращет индекс элемента в столбце,
     * возвращает -1 если такого элемента нет
     */
    private int findInCol(String term){
        for (int i = 1; i < matrOfTransAndOut.length; i++) {
            if(matrOfTransAndOut[i][0].equalsIgnoreCase(term)){
                return i;
            }
        }
        return -1;
    }

    /**
     * метод поиска в строке нетерминальных символов
     * @param state - массив нетерминалов
     * @return - возвращет индекс элемента в столбце,
     * возвращает -1 если такого элемента нет
     */
    private int findInRow(String state){
        for (int i = 1; i < matrOfTransAndOut[0].length; i++) {
            if(matrOfTransAndOut[0][i].equalsIgnoreCase(state)){
                return i;
            }
        }
        return -1;
    }

    /**
     * метод поиска в матрице
     * @param term - аргумент поиска в столбце терминалов
     * @param state - аргумент поиска в строке нетерминалов
     * @return - возвращает истину если проведен полный поиск и слово
     * окончилось на символ $, иначе если при поиске в матрице появился символ "-"
     * возвращается ложь.
     */
    private boolean findInMatrix(String term, String state){
        int i = findInCol(term);
        if(i == -1){
            error("Таких терминальных символов не существует");
            return false;
        }
        int j = findInRow(state);
        String s = matrOfTransAndOut[i][j];
        try{
            k++;
            if(s.equalsIgnoreCase(matrOfTransAndOut[0][matrOfTransAndOut[0].length - 1])){
                success();
                return true;
            }
            if(s.equalsIgnoreCase("-")){
                error("Такое слово не может существовать");
                return false;
            }
            findInMatrix(word[k], s);
        }catch (ArrayIndexOutOfBoundsException e){
            error("End of line");
        }
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Метод устанавливает некоторое слово для поиска, предварительно добавив
     * к нему символ окончания строки если такогового нет и разбив
     * его на массив символов, а затем передав первый символ в метод поиска
     * по матрице перезодов и выходов
     * @param word - некоторое слово
     */
    public void setWord(String word) {
        k = 0;
        if(!word.contains("$")){
            this.word = (word + "$").split("");
        }else {
            this.word = word.split("");
        }
        findInMatrix(this.word[k],"F");
    }

    /**
     * Метод печатает сообщение об ошибке
     * @param str - сообщение об ошибке
     */
    private void error(String str){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(Arrays.toString(this.word) + " " + str);
    }

    /**
     * Метод печатает сообщение подтверждающее наличие слова относящееся
     * к регулярной грамматике
     */
    private void success(){
        System.out.println(Arrays.toString(this.word) + " => Successful");
    }
}
