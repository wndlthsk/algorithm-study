import java.util.*;

public class Main {
    static int k;
    static String[] signs;
    static boolean[] vis = new boolean[10];
    static List<String>  ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new String[k];
        for (int i = 0; i < k; i++) {
            signs[i] = sc.next();
        }
        dfs(0, "");
        Collections.sort(ans);
        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
    }

    static void dfs(int depth, String num) {
        if (depth == k + 1) {
            ans.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (vis[i]) {
                continue;}
            if (depth == 0 || check(num.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                vis[i] = true;
                dfs(depth + 1, num + i);
                vis[i] = false;
            }
        }
    }

    static boolean check(int a, int b, String op) {
        if (op.equals("<")) {
            return a < b;
        }
        if (op.equals(">")) {
            return a > b;
        }
        return false;
    }
}
