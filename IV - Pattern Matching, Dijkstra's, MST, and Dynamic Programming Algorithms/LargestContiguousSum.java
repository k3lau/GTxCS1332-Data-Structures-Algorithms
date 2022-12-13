import java.util.ArrayList;

public class LargestContiguousSum {
  static int largestContiguousSum(int[] arr) {
    int maxSum = 0;
    for (int i = 0; i < arr.length; i++) {
      ArrayList<Integer> sum = new ArrayList<>();
      sum.add(arr[i]);
      if (maxSum < arr[i]) {
        maxSum = arr[i];
      }
      for (int j = i + 1; j < arr.length; j++) {
        int newInt = sum.get(j - i - 1) + arr[j];
        sum.add(newInt);
        if (maxSum < newInt) {
          maxSum = newInt;
        }
      }
    }
    return maxSum;
  }

  public static void main(String[] args) throws Exception {
    int[] arr = { -1, 2, -1, 4, -3, 1, 3 };
    System.out.println(largestContiguousSum(arr));
  }
}
