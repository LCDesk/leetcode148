package 经典148;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int i = 0; i < str.length; i++) {
            if (!"".equals(str[i])) {
                if (".".equals(str[i])) {
                    continue;
                }
                if ("..".equals(str[i])) {
                    if ("/".equals(sb.toString())) {
                        continue;
                    }
                    int lastIndex = sb.lastIndexOf("/");
                    int secondIndex = sb.substring(0, lastIndex).lastIndexOf("/");
                    sb.delete(secondIndex, lastIndex);
                } else {
                    sb.append(str[i]).append("/");
                }
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        s.simplifyPath("/a//b////c/d//././/..");
    }


}
