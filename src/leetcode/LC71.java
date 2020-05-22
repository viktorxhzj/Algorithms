package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC71 {
    public String simplifyPath(String path) {

        char[] str = path.toCharArray();

        Deque<String> stack = new LinkedList<>();
        StringBuilder bd;
        int k = 0;
        while (k < str.length) {
            switch (str[k]) {
                case '.':
                    bd = new StringBuilder();
                    int count = 0;
                    while (k < str.length && str[k] != '/') {
                        bd.append(str[k]);
                        if (str[k] == '.') count++;
                        k++;
                    }
                    switch (count) {
                        case 1:
                            if (bd.length() > 1) stack.addLast(bd.toString());
                            break;
                        case 2:
                            if (bd.length() > 2) stack.addLast(bd.toString());
                            else if (!stack.isEmpty()) stack.removeLast();
                            break;
                        default:
                            stack.addLast(bd.toString());
                            break;
                    }
                    break;
                case '/':
                    k++;
                    break;
                default:
                    bd = new StringBuilder();
                    while (k < str.length && str[k] != '/' && str[k] != '.') {
                        bd.append(str[k]);
                        k++;
                    }
                    stack.addLast(bd.toString());
                    break;
            }
        }
        if (stack.isEmpty()) return "/";


        bd = new StringBuilder();

        for (String s: stack) {
            bd.append('/');
            bd.append(s);
        }

        return bd.toString();
    }
}
