import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mean {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = new int[] {4,5,1,2,3};
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(3);
		//System.out.println(solution.letterCombinations("23"));
		//System.out.println(solution.isIso("ab", "bb"));
		//solution.merge(array, 6, array, 6);
		//System.out.println(solution.searchInsert(array,5));
		int [][] matrix = new int [][] {{1,3}};
		//System.out.println(solution.searchPivot(array, 1));
		//solution.recoverRotatedSortedArray(list);
		System.out.println(solution.reverseWords("    "));
		System.exit(0);
	}
}