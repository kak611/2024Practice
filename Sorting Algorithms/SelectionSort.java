import java.util.Arrays;
import java.util.Random;

class SelectionSort {
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

	public static void sort(int[] arr, int left, int right) {
		for (int i = left; i < right; i++) {
			int min = i;
			for (int j = i + 1; j <= right; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			if (i != min) {
				swap(arr, i, min);
			}
		}
				
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
