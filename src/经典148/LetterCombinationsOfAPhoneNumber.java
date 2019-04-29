package 经典148;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        return process(digits, 0);
    }

    public ArrayList<String> process(String digits, int i) {
        if (i == digits.length()) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> list = process(digits, i + 1);
        List<String> mapper = generateList(digits.charAt(i));
        ArrayList<String> res = new ArrayList<>();
        for (String m : mapper) {
            for (String l : list) {
                res.add(m + l);
            }
        }
        return res;
    }

    private List<String> generateList(char ch) {
        List<String> list = new ArrayList<>();
        if (ch < '7') {
            for (int i = (ch - '0' - 2) * 3; i < (ch - '0' - 1) * 3; i++) {
                list.add((char) (i + 'a') + "");
            }
        } else if (ch == '7') {
            list.add("p");
            list.add("q");
            list.add("r");
            list.add("s");
        } else if (ch == '8') {
            list.add("t");
            list.add("u");
            list.add("v");
        } else {
            list.add("w");
            list.add("x");
            list.add("y");
            list.add("z");
        }
        return list;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        l.letterCombinations("23");
    }

}
