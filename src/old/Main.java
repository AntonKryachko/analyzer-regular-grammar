package old;

public class Main {
    public static void main(String[] args) {
        Words words = new Words();
        words.setWord("010011100110");
        System.out.println(words.isCorrectWord());
        words.setWord("001");
        System.out.println(words.isCorrectWord());
        words.setWord("100111010");
        System.out.println(words.isCorrectWord());
        words.setWord("000");
        System.out.println(words.isCorrectWord());
        words.setWord("010");
        System.out.println(words.isCorrectWord());
        words.setWord("0110");
        System.out.println(words.isCorrectWord());
    }
}
