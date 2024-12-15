import java.util.Random;
import java.util.Arrays;

class InsertionSort {
	public static void main(String[] args) {
		int min = 5;
		int max = 30;
		int length = 10;
		Random random = new Random();
		int[] arr = new int[length];

		for (int i = 0; i < length; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int start, int end) {
		for (int i = start + 1; i <= end; i++) {
			int key = arr[i];
			int j = i-1;

			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}

			arr[j+1] = key;
		}
	}
}