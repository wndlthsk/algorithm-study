class Solution {
    public String solution(String s) {
        String[] splited = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String sp: splited) {
            int num = Integer.parseInt(sp);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        System.out.println(min + " " + max);

        return min + " " + max;

//         List<Integer> nums = new ArrayList<>();
//         for (String sp: splited) {
//             nums.add(Integer.parseInt(sp));
//         }
//         // System.out.println(nums);
//         Collections.sort(nums);
//         // System.out.println(nums);

//         String answer = Integer.toString(nums.get(0)) + " " + Integer.toString(nums.get(nums.size()-1));

//         return answer;
    }
}