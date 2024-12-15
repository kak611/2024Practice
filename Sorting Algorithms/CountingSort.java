import java.util.Arrays;
import java.util.Random;

class CountingSort {
	public static void main(String[] args) {
		int min = 1;
		int max = 5;
		int length = 10;
		int[] arr = new int[length];

		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	// Time Complexity: O(n + k), where n is the number of elements and k is the range of the input values.
	// Space Complexity: O(k) for the count array.
	private static void sort(int[] arr, int left, int right) {
		// step1: find minVal, maxVal
		int minVal = arr[0];
		int maxVal = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < minVal) {
				minVal = arr[i];
			}

			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
		}

		System.out.println("minVal: " + minVal + ", maxVal: " + maxVal);

		// step2: create count array with range maxVal + 1;
		int[] countArr = new int[maxVal + 1];

		// step3: update countArr with number of occurrences of each value from original array and add those occurrences in the countArray with index as value
		for (int i = 0; i < arr.length; i++) {
			countArr[arr[i]]++;
		}


		// step4: update original array with the occurrences in sorted order
		// note: there is another method called 'cumulative count'. Advantages of Cumulative Count is it ensure stability in the sorting algorithm.
		int k = 0;
		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] > 0) {
				while (countArr[i] != 0) {
					arr[k++] = i;
					countArr[i]--;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}