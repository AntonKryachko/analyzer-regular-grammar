import java.util.Arrays;

public class Perform {
    private String[][] matrOfTransAndOut;
    private String [] word;
    private int k = 0;
    Perform(String[][] matrOfTransAndOut){
        this.matrOfTransAndOut = matrOfTransAndOut;
    }
    private int findInRow(String term){
        for (int i = 1; i < matrOfTransAndOut.length; i++) {
            if(matrOfTransAndOut[i][0].equalsIgnoreCase(term)){
                return i;
            }
        }
        return -1;
    }
    private int findInCol(String state){
        for (int i = 1; i < matrOfTransAndOut[0].length; i++) {
            if(matrOfTransAndOut[0][i].equalsIgnoreCase(state)){
                return i;
            }
        }
        return -1;
    }
    private boolean findInMatrix(String term, String state){
        int i = findInRow(term);
        if(i == -1){
            error("Таких терминальных символов не существует");
            return false;
        }
        int j = findInCol(state);
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
    public void setWord(String word) {
        k = 0;
        if(!word.contains("$")){
            this.word = (word + "$").split("");
        }else {
            this.word = word.split("");
        }
        findInMatrix(this.word[k],"F");
    }
    private void error(String str){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(Arrays.toString(this.word) + " " + str);
    }
    private void success(){
        System.out.println(Arrays.toString(this.word) + " => Successful");
    }
}
