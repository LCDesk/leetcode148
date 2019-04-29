package 经典148;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (stack.size() >= 2 && height[i] > height[stack.peek()]) {
                    int index = stack.pop();
                    int h = Math.min(height[stack.peek()], height[i]);
                    res += (i - stack.peek() - 1) * (h - height[index] < 0 ? 0 : h - height[index]);
                }
                if (height[i] == height[stack.peek()]) {
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[]{2, 0, 2}));

    }
}
