class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            Integer secondIndex = count.get(target - arr[i]);

            if (secondIndex != null && secondIndex != i) {
                return new int[]{i, secondIndex};
            }
        }

        return new int[]{};
    }
}