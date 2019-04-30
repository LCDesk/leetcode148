package 经典148;

public class JosephProblem {
    public int getResult(int n, int m) {
        // write code here
        int i = 1;
        int newID = 0;
        while (++i <= n) {
            newID = (newID + m) % i;
        }
        return newID + 1;
    }
}
