import java.util.Arrays;
import java.util.Random;

class MergeSort {
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
		if (left >= right) return;

		int mid = left + (right - left)/2;

		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		// merge1(arr, left, mid, right);
		merge2(arr, left, mid, right);
	}

	public static void merge1(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];

		int i = left, j = mid + 1, k = 0;

		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else if (arr[i] > arr[j]) {
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		for (int m = left; m <= right; m++) {
			arr[m] = temp[m - left];
		}
	}

	public static void merge2(int[] arr, int left, int mid, int right) {
		int len1 = (mid - left) + 1;
		int len2 = right - mid;

		int[] temp1 = new int[len1];
		int[] temp2 = new int[len2];

		for (int i = left; i <= mid; i++) {
			temp1[i - left] = arr[i];
		}

		for (int j = mid + 1; j <= right; j++) {
			temp2[j - (mid + 1)] = arr[j];
		}

		int i = 0, j = 0, k = left;
		while (i < len1 && j < len2) {
			if (temp1[i] < temp2[j]) {
				arr[k++] = temp1[i++];
			} else {
				arr[k++] = temp2[j++];
			}
		}

		while (i < len1) {
			arr[k++] = temp1[i++];
		}

		while (j < len2) {
			arr[k++] = temp2[j++];
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
