class Solution {
    public int maximumLength(int[] nums) {
        int k = 2; // Define the modulus value
        int[][] frequency = new int[k][k]; // Initialize a 2D array to hold frequency counts
        int maxLength = 0; // Variable to store the maximum length found

        for (int num : nums) { // Iterate over the elements in nums array
            num %= k; // Calculate modulo of num with k
            for (int j = 0; j < k; ++j) { // Iterate over each possible value modulo k
                int y = (j - num + k) % k; // Calculate the required complement to make a sum divisible by k
                frequency[num][y] = frequency[y][num] + 1; // Update the frequency table with current element
                maxLength = Math.max(maxLength, frequency[num][y]); // Update the maximum length found
            }
        }
        return maxLength; // Return the maximum length of subarray found
    }
}
