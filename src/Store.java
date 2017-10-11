import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private List<TestData> testDataList = new ArrayList<>();
    Store(){
        testDataList.add(new TestData(
                new String[]{"F", "A", "B", "C", "D", "N"},
                new String[]{"0", "1", "$"},
                new String[][]{
                    {"C","B","A","-","F","-"},
                    {"A","F","-","D","C","-"},
                    {"N","-","-","-","-","-"}
                }, new ArrayList<>(Arrays.asList(
                    "11$", "1001", "010", "100001", "10000001",
                    "0111110", "011111110", "100", "111", "00",
                    "111001", "1001010", "11011101001","110111110100001"
                ))
        ));
        testDataList.add(new TestData(
                new String[]{"F", "A", "B", "C", "D", "E", "F", "G", "Z"},
                new String[]{"a", "b", "c", "$"},
                new String[][]{
                        {"D","D","D","Z","E","F","G","-","-"},
                        {"A","B","C","D","D","D","-","Z","-"},
                        {"-","-","-","Z","-","-","-","-","-"},
                        {"Z","-","-","-","-","-","-","-","-"}
                }, new ArrayList<>(Arrays.asList(
                        "", "dfdjhfsjfgsjgfjfgsjgfdjsfg", "abcaabbccc","bbbaababaaabbbba"
                ))
        ));
    }

    public List<TestData> getTestDataList() {
        return testDataList;
    }
}
