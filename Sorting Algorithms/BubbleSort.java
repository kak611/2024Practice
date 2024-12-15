import java.util.Arrays;
import java.util.Random;

class BubbleSort {
	public static void main(String[] args) {
		int min = 10;
		int max = 40;
		int length = 10;
		int[] arr = new int[length];

		Random random = new Random();
		for (int i = 0; i <  length; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));
	}

	/* Bubble sort */
    private void sort(int[] nums, int left, int right) {
        //  0, 1, 2, 3, 4
        // [5, 3, 8, 4, 2]
        for (int i = left; i < right; i++) {
            // for i = 0, j = 0 to 3
            // for i = 1, j = 0 to 2
            // for i = 2, j = 0 to 1
            // ...
            // bubble up largest element to the end
            for (int j = left; j < right - i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
    }
}
