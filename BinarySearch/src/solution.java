import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int front = i + 1, last = nums.length - 1;
			while (front < last) {
				int sum = nums[i] + nums[front] + nums[last];
				if (sum > target) {
					last--;
				} else if (sum == target)
					return 0;
				else if (sum < target)
					front++;
				if (Math.abs(sum - target) < Math.abs(result - target))
					result = sum;
			}
		}
		return result;
	}

	public List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

	public int[] rotate(int[] num, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int number : num) {
			list.add(number);
		}
		// System.out.println(list);
		for (int i = 0; i < k; i++) {
			int topNum = list.removeLast();
			list.addFirst(topNum);
		}
		for (int i = 0; i < num.length; i++) {
			int numberAdd = list.removeFirst();
			num[i] = numberAdd;
		}
		return num;
	}

	public boolean isIso(String a, String b) {
		boolean result = false;
		if (a.length() != b.length()) {
			return result;
		}
		HashMap<Character, Character> Map = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			Character aCharacter = a.charAt(i);
			Character bCharacter = b.charAt(i);
			if (!Map.containsKey(aCharacter))
				if (!Map.containsValue(bCharacter)) {

					Map.put(aCharacter, bCharacter);
				} else if (bCharacter != Map.get(aCharacter)) {
					return result;
				}
		}
		return true;
	}

	public void merge(int[] A, int m, int[] B, int n) {
		for (int i = 0; i < n; i++) {
			A[m + i] = B[i];
		}
		Arrays.sort(A);
	}

	public boolean isValid(String s) {

		if (s.length() < 2)
			return false;
		HashMap<Character, Character> pairs = new HashMap<>();
		LinkedList<Character> test = new LinkedList<>();
		pairs.put('(', ')');
		pairs.put('[', ']');
		pairs.put('{', '}');
		for (int i = 0; i < s.length(); i++) {
			if (pairs.get(test.peek()) == (Character) s.charAt(i + 1)) {
				test.pop();
				i++;
			}
			test.add(s.charAt(i));
		}
		return test.isEmpty();
	}

	public int binarySearch(int[] nums, int target) {
		// write your code here
		if (nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (target < nums[mid]) {
				end = mid;
			} else if (target > nums[mid]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[start] == target)
			return start;
		else if (nums[end] == target) {
			return end;
		}
		return -1;
	}

	public int[] searchRange(int[] A, int target) {
		if (A.length == 0)
			return new int[] { -1, -1 };
		int start = 0, end = A.length - 1;
		int[] result = new int[2];
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target)
				end = mid;
			else if (A[mid] < target) {
				mid = start;
			} else {
				mid = end;
			}
		}
		if (A[start] == target) {
			result[0] = start;
		} else if (A[end] == target) {
			result[0] = end;
		} else {
			return new int[] { -1, -1 };
		}
		start = 0;
		end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target)
				start = mid;
			else if (A[mid] < target) {
				mid = start;
			} else {
				mid = end;
			}
		}
		if (A[end] == target) {
			result[1] = end;
		} else {
			result[1] = start;
		}

		return result;
	}

	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int[] numss = new int[nums.length + 1];
		System.arraycopy(nums, 0, numss, 0, nums.length);
		numss[nums.length] = target;
		Arrays.sort(numss);
		int start = 0, end = numss.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (numss[mid] == target) {
				end = mid;
			} else if (numss[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (numss[start] == target)
			return start;
		else if (numss[end] == target) {
			return end;
		} else {
			return -1;
		}
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int start = 0, end = matrix[0].length * matrix.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int row = mid / matrix[0].length;
			int col = mid % matrix[0].length;
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (matrix[start / matrix[0].length][start % matrix[0].length] != target
				&& matrix[end / matrix[0].length][end % matrix[0].length] != target)
			return false;
		return true;
	}

	public boolean searchMatrix1(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		for (int i = 0; i < matrix.length; i++) {
			if (existElement(matrix[i], target)) {
				return true;
			}
		}
		return false;
	}

	private boolean existElement(int[] is, int target) {
		if (is.length == 0) {
			return false;
		}
		int start = 0, end = is.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (is[mid] == target)
				return true;
			else if (is[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (is[start] == target || is[end] == target)
			return true;
		return false;
	}

	public int findMin(int[] nums) {
		if (nums.length == 0)
			return 0;
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				start = mid;
			} else if (nums[mid] == nums[end]) {
				--end;
			} else {
				end = mid;
			}
		}
		return Math.min(nums[start], nums[end]);
	}

	public int searchPivot(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int result = -1;
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target && target <= nums[start])
				start = mid;
			else if (nums[mid] > target && target >= nums[start]) {
				end = mid;
			} else if (target >= nums[start] && target > nums[mid]) {
				end = mid;
			} else if (target <= nums[start] && target < nums[mid]) {
				start = mid;
			}
		}
		if (nums[start] == target)
			return start;
		else if (nums[end] == target) {
			return end;
		}
		return result;
	}

	public void recoverRotatedSortedArray(List<Integer> nums) {
		if (nums.size() == 0 || nums.size() == 1) {
			return;
		}
		int start = 0, end = nums.size() - 1, pointRotate = 0;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums.get(mid) == nums.get(end))
				end--;
			else if (nums.get(mid) < nums.get(end)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums.get(start) < nums.get(end))
			pointRotate = start;
		else
			pointRotate = end;
		swapArray(nums, 0, pointRotate - 1);
		swapArray(nums, pointRotate, nums.size() - 1);
		swapArray(nums, 0, nums.size() - 1);
		System.out.println(nums);
	}

	public List<Integer> swapArray(List<Integer> nums, int start, int end) {
		while (start <= end) {
			int temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
			start++;
			end--;
		}
		return nums;
	}

	public void rotateString(char[] str, int offset) {
		if (str.length == 0 || str.length == 1)
			return;
		offset = offset % str.length;
		StringBuilder sBuilder = new StringBuilder();
		for (int i = str.length - offset; i < str.length; i++) {
			sBuilder.append(str[i]);
		}
		for (int k = 0; k < str.length - offset; k++) {
			sBuilder.append(str[k]);
		}
		for (int j = 0; j < str.length; j++)
			str[j] = sBuilder.charAt(j);
	}

	public String reverseWords(String s) {
		if (s.length() < 2) {
			return s;
		}
		String[] strings = s.trim().split(" ");
		if (strings.length == 0)
			return s;
		StringBuilder sBuilder = new StringBuilder();
		for (int i = strings.length - 1; i >= 0; i--) {
			sBuilder.append(strings[i] + " ");
		}
		String returnStr = sBuilder.toString();
		returnStr.substring(0, returnStr.length() - 1);
		return returnStr;
	}

	public int strStr(String source, String target) {
		if (source == null) {
			return -1;
		}
		else if (source.length() < target.length())
			return -1;
		else if (source.equals("") && target.equals(""))
			return 0;
		else {
			if (source.contains(target)) {
				return source.indexOf(target);
			}
			else
				return -1;
		}
	}
}