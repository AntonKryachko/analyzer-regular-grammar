import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TestData> dataList = new Store().getTestDataList();
//        dataList.forEach(list -> {
//            System.out.println(Arrays.toString(list.getStates()));
//            System.out.println(Arrays.toString(list.getTerminals()));
//            System.out.println(Arrays.deepToString(list.getNextStates()));
//            list.getTestStrings().forEach(System.out::println);
//        });

        dataList.forEach(list -> {
            Perform perform = new Perform(new IODemo(list).input());
            list.getTestStrings().forEach(perform::setWord);
        });

//
//        Perform e = new Perform(new IODemo(dataList.get(1)).input());
//        dataList.get(1).getTestStrings().forEach(e::setWord);
    }
}
