import java.util.Arrays;
import java.util.Random;

class HeapSort {
	public static void main(String[] args) {
		int min = 10;
		int max = 40;
		int length = 10;

		int[] arr = new int[length];
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr) {
        int len = arr.length;

        // Build the heap (rearrange the array)
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }

        // One by one, extract elements from the heap
        for (int i = len - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

	// Max-heapify function
    private static void heapify(int[] arr, int len, int index) {
        int largest = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // Check if left child exists and is greater than root
        if (leftChildIndex < len && arr[leftChildIndex] > arr[largest]) {
            largest = leftChildIndex;
        }

        // Check if right child exists and is greater than root
        if (rightChildIndex < len && arr[rightChildIndex] > arr[largest]) {
            largest = rightChildIndex;
        }

        // If the largest is not the root, swap and heapify the affected subtree
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