package problems;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfArraysToOrder = in.nextInt();

		while (numberOfArraysToOrder > 0) {
			int length = in.nextInt();

			Integer[] requiredorder = new Integer[length];
			for (int scanIndex = 0; scanIndex < length; scanIndex++) {
				requiredorder[scanIndex] = in.nextInt();
			}
			Integer[] startingorder = new Integer[length];
			for (int i = 0; i < startingorder.length; i++) {
				startingorder[i] = i + 1;
			}
			
			Integer[] numberOfSwaps = new Integer[length];
			Arrays.fill(numberOfSwaps, 0);

			int startIndex;
			int temp = -1;
			boolean tooChaotic = false;
			mainLoop: for (int index = requiredorder.length - 1; index > 0; index--) {
				startIndex =    Arrays.asList(startingorder).indexOf(requiredorder[index]);
				while (!requiredorder[index].equals(startingorder[index])) {
					temp = startingorder[startIndex];
					startingorder[startIndex] = startingorder[startIndex + 1];
					startingorder[startIndex + 1] = temp;
					int swappedElement = startingorder[startIndex];
					if (numberOfSwaps[swappedElement - 1] < 2) {
						numberOfSwaps[swappedElement - 1] = numberOfSwaps[swappedElement - 1] + 1;
					} else {
						tooChaotic = true;
						break mainLoop;
					}
					startIndex++;
				}
			}
			if (tooChaotic) {
				System.out.println("Too chaotic");
			} else {
				System.out.println(Arrays.stream(numberOfSwaps).mapToInt(i -> i).sum());
			}
		}
		numberOfArraysToOrder--;
	}
}
