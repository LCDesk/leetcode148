package 经典148;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    //这种递归生成不了所有的括号组合
    @Deprecated
    public List<String> generateParenthesis1(int n) {
        if (n == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> list = generateParenthesis1(n - 1);
        Set<String> res = new HashSet<>();
        for (String s : list) {
            res.add("()" + s);
            res.add("(" + s + ")");
            res.add(s + "()");
        }
        return new ArrayList<>(res);
    }

    //使用深搜
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int n) {
        process(2 * n, 0, "");
        return res;
    }

    private void process(int n, int count, String str) {
        if (count < 0) {
            return;
        }
        if (n == 0) {
            if (count == 0) {
                res.add(str);
            }
        } else {
            process(n - 1, count - 1, str + ")");
            process(n - 1, count + 1, str + "(");
        }
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }

}
