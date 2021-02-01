import static java.lang.System.out;

public class ForLoopFunction {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 5, 7, 3, 11};
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		out.println(sum);
		
		// Recursive call, iterative process
		out.println(getSum(array));
		
		// Recursive call, recursive process
		out.println(getSumRecur(array));
	}

	public static int getSum(int[] array) {
		return forLoopIter(0, array, 0);
	}
	
	public static int forLoopIter(int i, int[] array, int currentSum) {
		if (i < array.length)
			return forLoopIter(i + 1, array, currentSum + array[i]);
		else
			return currentSum;
	}
	
	public static int getSumRecur(int[] array) {
		return recursiveSum(0, array);
	}
	
	public static int recursiveSum(int i, int[] array) {
		if (i < array.length)
			return array[i] + recursiveSum(i + 1, array);
		else
			return 0;
	}
}
