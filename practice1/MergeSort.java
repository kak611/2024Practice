import java.util.Arrays;
import java.util.Random;

class MergeSort {
	public static void main(String[] args) {
		int min = 10;
		int max = 50;
		int len = 10;
		int[] arr = new int[len];
		Random random = new Random();

		for (int i = 0; i < len; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int left, int right) {
		if (left >= right) return;
		int len = arr.length;

		// update to max-heap
		for (int i = (len/2) - 1; i >= 0; i--) {
			heapify(arr, len, i);
		}

		for (int i = len - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	public static void heapify(int[] arr, int len, int index) {
		int leftIndex = (2 * index + 1);
		int rightIndex = (2 * index + 2);

		int largest = index;
		if (leftIndex < len && arr[leftIndex] > arr[largest]) {
			largest = leftIndex;
		}

		if (rightIndex < len && arr[rightIndex] > arr[largest]) {
			largest = rightIndex;
		}

		if (largest != index) {
			swap(arr, index, largest);
			heapify(arr, len, largest);
	    }
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}