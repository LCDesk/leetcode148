package 经典148;

public class GasStation {

    //暴力破解
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int earn = 0;
                int spend = 0;
                earn += gas[i];
                spend += cost[i];
                for (int j = i + 1; j - i < len; j++) {
                    int cur = index(j, len);
                    spend += cost[cur];
                    earn += gas[cur];
                    if (earn < spend) {
                        break;
                    }
                }
                if (earn >= spend) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int index(int i, int len) {
        return i % len;
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int end = 0;
        int start = gas.length - 1;
        int sum = gas[start] - cost[start];
        while (end < start) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }

        return sum >= 0 ? start : -1;
    }


    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] gas = {5, 1, 2, 3, 4};

        int[] cost = {4, 4, 1, 5, 1};
        System.out.println(g.canCompleteCircuit(gas, cost));
    }

}
