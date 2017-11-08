import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Главный класс для запуска программы
 */
public class Main {
    /**
     * главный метод запуска программы.
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Инициализирует список данных взятый из класса Store
         * для каждого элемента списка создается экземпляр класса Perform
         * инициализированный созданной матрицей в классе IODemo
         * при помощи метода input(); а далее вызывается список тестовых слов
         * и проверяется в экземпляре класса Perform при помощи внутренних утилит
         */
//        List<TestData> dataList = new Store().getTestDataList();
//        dataList.forEach(list -> {
//            Perform perform = new Perform(new IODemo(list).input());
//            list.getTestStrings().forEach(perform::setWord);
//        });
        /**
         * Инициализирует класс IO, затем созданную матрицу переходов и выходов
         * передает в метод inputWord
         */
        IO io = new IO();
        inputWord(io.getMatrOfTransAndOut());


    }

    /**
     * Метод позволяет с клавиатуры ввести проверочные слова
     * где они будут проверены в классе Perform и выданн вердикт о
     * принадлежности слова к языку
     * @param matrTransAndOuts - матрица перехов и выходов
     */
    private static void inputWord(String[][] matrTransAndOuts){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        String s = "н";
        Perform perform = new Perform(matrTransAndOuts);
        do{
            System.out.println("Введите проверочное слово,\n" +
                                "желательно чтобы оно заканчивалось на символ окончания строки,\n" +
                                "в данном случае это - '$'");
            try {
                string = br.readLine();
                perform.setWord(string);
                System.out.println("Будут ли еще примеры? (д/н)");
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!s.equalsIgnoreCase("н"));
    }
}
