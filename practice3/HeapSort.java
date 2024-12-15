import java.util.*;

class HeapSort {
	public static void main(String[] args) {
		int min = 10;
		int max = 40;
		int len = 10;

		int[] arr = new int[len];
		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int len = arr.length;

		for (int i = len/2 - 1; i >= 0; i--) {
			heapify(arr, len, i);
		}

		// swap max at the 0 index with last element.
		for (int i = len - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	// max-heapify
	public static void heapify(int[] arr, int len, int index) {
		int largest = index;
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;

		if (leftChildIndex < len && arr[leftChildIndex] > arr[largest]) {
			largest = leftChildIndex;
		}

		if (rightChildIndex < len && arr[rightChildIndex] > arr[largest]) {
			largest = rightChildIndex;
		}

		if (largest != index) {
			swap(arr, index, largest);
			heapify(arr, len, largest);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}