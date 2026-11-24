class Solution {
    private long gcd(long a, long b) {
        while (b != 0L) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            long currentProd = 1L;
            long currentGcd = nums[i];
            long currentLcm = nums[i];

            for (int j = i; j < n; j++) {
                if (currentProd > 1000000000000L / nums[j]) {
                    currentProd = 2000000000000L;
                } else {
                    currentProd *= nums[j];
                }

                if (j > i) {
                    currentGcd = gcd(currentGcd, nums[j]);
                    currentLcm = lcm(currentLcm, nums[j]);
                }

                if (currentProd == currentLcm * currentGcd) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return maxLen;
    }
}