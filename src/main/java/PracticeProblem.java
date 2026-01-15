public class PracticeProblem {
    public static int[] bubbleSort(double[] nums) {
    int swaps = 0;
    int steps = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < nums.length - 1 - i; j++) {
            steps += 1;
            if (nums[j] > nums[j + 1]) {
                double temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
                swaps += 3;
                swapped = true;
            }
        }
       	 if (!swapped) {
			break;
		}
	}
    	return new int[]{swaps, steps};
	}

    public static int[] selectionSort(double[] nums) {
    int swaps = 0;
    int steps = 0;

    for (int i = 0; i < nums.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < nums.length; j++) {
            steps += 1;
            if (nums[j] < nums[minIndex]) {
              	minIndex = j;
               	swaps += 1;
            }
        }
        double temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
        swaps += 3;
    	}
    	return new int[]{swaps, steps};
	}
    public static int[] insertionSort(double[] nums) {
    int swaps = 0;
    int steps = 0;
    for (int i = 1; i < nums.length; i++) {
       	 double key = nums[i];
       	 swaps += 1;

     	 int j = i - 1;

       	 while (j >= 0 && nums[j] > key) {
          	  steps += 1; 
          	  nums[j + 1] = nums[j];
          	  swaps += 1; 
           	 j--;
        	}
        	nums[j + 1] = key;
        	swaps += 1; 
    	}
    	return new int[]{swaps, steps};
	}

  	public static String leastSwaps(double[] nums) {
    	double[] a = java.util.Arrays.copyOf(nums, nums.length);
    	double[] b = java.util.Arrays.copyOf(nums, nums.length);
    	double[] c = java.util.Arrays.copyOf(nums, nums.length);

    	int[] bubble = bubbleSort(a);
    	int[] insertion = insertionSort(b);
    	int[] selection = selectionSort(c);
    	int min = bubble[0];
    	String best = "Bubble";
    	if (insertion[0] < min || (insertion[0] == min && "Insertion".compareTo(best) < 0)) {
        	min = insertion[0];
        	best = "Insertion";
    	}
    	if (selection[0] < min || (selection[0] == min && "Selection".compareTo(best) < 0)) {
        	min = selection[0];
        	best = "Selection";
    	}
    	return best;
	}
	public static String leastIterations(double[] nums) {
    	double[] a = java.util.Arrays.copyOf(nums, nums.length);
    	double[] b = java.util.Arrays.copyOf(nums, nums.length);
    	double[] c = java.util.Arrays.copyOf(nums, nums.length);
    	int[] bubble = bubbleSort(a);
    	int[] insertion = insertionSort(b);
    	int[] selection = selectionSort(c);
    	int min = bubble[1];
    	String best = "Bubble";
    	if (insertion[1] < min || (insertion[1] == min && "Insertion".compareTo(best) < 0)) {
        	min = insertion[1];
        	best = "Insertion";
    	}
    	if (selection[1] < min || (selection[1] == min && "Selection".compareTo(best) < 0)) {
        	min = selection[1];
        	best = "Selection";
    	}
    	return best;
	}
}