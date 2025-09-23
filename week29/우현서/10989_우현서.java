import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// n개 수가 주어졌을 때 오름차순으로 정렬해라
// 1 ≤ N ≤ 10,000,000

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        List<Integer> nums = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            nums.add(Integer.parseInt(br.readLine()));
//        }
//        nums.sort(Integer::compareTo);
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append(nums.get(i)).append("\n");
//        }
//        System.out.println(sb.toString());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

}