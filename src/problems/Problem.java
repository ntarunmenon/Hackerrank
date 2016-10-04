package problems;

import java.util.Scanner;

public class Problem {

	private static int[] inputArray;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfProblems = sc.nextInt(); 
		
		while(numberOfProblems > 0){
			if(numberOfProblems == 5000 - 50){
				int x = 0;
				x= x++;
			}
			numberOfProblems--;
			int size = sc.nextInt();
			int m = sc.nextInt();
			int currentPosition = 0;
			boolean won = true;
			inputArray = new int[size];
			for (int index = 0; index < inputArray.length; index++) {
				inputArray[index] = sc.nextInt();
			}
			
			while (currentPosition <= size - 1) {
				if (canAdvanceByIndex(currentPosition, m)) {
					currentPosition = currentPosition + m;
					continue;
				} else if (canAdvanceByIndex(currentPosition, 1)) {
					currentPosition = currentPosition + 1;
					continue;
				} else if (canAdvanceByIndex(currentPosition, -1) && canAdvanceByIndex(currentPosition - 1, m)) {
					currentPosition = currentPosition + m;
					continue;
				}
				won = false;
				break;
			}
			System.out.println(won ? "YES":"NO");
		}
		

	}
	private static boolean canAdvanceByIndex(int currentPosition, int m) {
		if(currentPosition + m < inputArray.length && currentPosition + m > 0 &&inputArray[currentPosition + m] == 0){
			return true;
		}else if(currentPosition + m > inputArray.length){
			return true;
		}
		return false;
	}
}
