import java.util.Random;
import java.util.Arrays;

class QuickSort {
	public static void main(String[] args) {
		int min = 10;
		int max = 50;
		int length = 10;

		int[] arr = new int[length];
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		System.out.println(Arrays.toString(arr));
		// sortH(arr, 0, arr.length - 1);
		sortL(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sortH(int[] arr, int left, int right) {
		if (left >= right) return;

		int pivotIndex = partitionH(arr, left, right);
		sortH(arr, left, pivotIndex);
		sortH(arr, pivotIndex + 1, right);
	}

	public static int partitionH(int[] arr, int left, int right) {
		int mid = (right - left)/2 + left;
		int pivot = arr[mid];

		int i = left - 1;
		int j = right + 1;
		int k = left;

		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);

			if (i >= j) return j;
			swap(arr, i, j);
		}
	}

	public static void sortL(int[] arr, int left, int right) {
		if (left >= right) return;

		int pivotIndex = partitionL(arr, left, right);
		sortL(arr, left, pivotIndex - 1);
		sortL(arr, pivotIndex + 1, right);
	}

	public static int partitionL(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left;

		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i , right);
		return i;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}