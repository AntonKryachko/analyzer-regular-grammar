package old;

import java.util.Arrays;

public class Words {
    private String word;
    private String ACCEPT_WORD = " - подподает под правило";
    private String DENY_WORD = " - не подподает под правило";

    Words(){}
    private String createMatchPattern(String matchPattern){
        if (matchPattern.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        char[] chars = matchPattern.toCharArray();
        sb.append("[");
        for(char c: chars){
            sb.append(c);
            sb.append("|");
        }
        sb.append("]+");
        sb.deleteCharAt(sb.length() - 3);
        return sb.toString();
    }
    public String isCorrectWord(){
        System.out.println("Введеное слово: " + word);
        StringBuilder sb;
        char[] chars = word.toCharArray();
        int i = 0;
        while(i < chars.length){
            if(chars[i] == '0') {
                sb = new StringBuilder();
                sb.append(chars[i]);
                i++;
                int count = 0;
                if (chars[i] == '1') {
                    sb.append(chars[i]);
                    i++;
                    while (chars[i] == '1') {
                        sb.append(chars[i]);
                        count++;
                        i++;
                    }
                    sb.append(chars[i]);
                    if(chars[i] != '0'){
                        return sb.toString() + "" + DENY_WORD + "" +
                                " т.к. последний элемент в данном правиле не 0";
                    }
                    if (count % 2 != 0) {
                        return sb.toString() + "" + DENY_WORD + "" +
                                " т.к. четное число едениц";
                    }
                } else {
                    return sb.toString() + "" + DENY_WORD + "" +
                            " т.к. в теле слова не только единицы";
                }
                System.out.println(sb.toString() + "" + ACCEPT_WORD);
            }else if(chars[i] == '1'){
                sb = new StringBuilder();
                sb.append(chars[i]);
                i++;
                int count = 0;
                if (chars[i] == '0') {
                    sb.append(chars[i]);
                    i++;
                    while (chars[i] == '0') {
                        sb.append(chars[i]);
                        count++;
                        i++;
                    }
                    sb.append(chars[i]);
                    if(chars[i] != '1'){
                        return sb.toString() + "" + DENY_WORD + "" +
                                " т.к. последний элемент в данном правиле не 1";
                    }
                    if (count % 2 == 0) {
                        return sb.toString() + "" + DENY_WORD + "" +
                                " т.к. нечетное число нулей";
                    }
                } else if(chars[i] == '1'){
                    sb.append(chars[i]);
                }else {
                    return sb.toString() + "" + DENY_WORD + "" +
                            " т.к. в теле слова не только нули";
                }
                System.out.println(sb.toString() + "" + ACCEPT_WORD);
            }
            i++;
    }
        return "";
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
            this.word = word.trim();
    }
    @Override
    public String toString() {
        return "old.Words{" +
                "word='" + word + '\'' +
                ", ACCEPT_WORD='" + ACCEPT_WORD + '\'' +
                ", DENY_WORD='" + DENY_WORD + '\'' +
                '}';
    }
}
