package problems;

import java.util.Scanner;

public class AbsPermutation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		mainloop: for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] position = new int[n];
			/*
			 * Not Possible print -1
			 * 
			 * i > k + 1 and i > n -k
			 */
			for (int i = 1; i  < k; i++) {
				if (i + k > n) {
					System.out.println("-1");
					continue mainloop;
				}
			}
			/**
			 * Only one case possible then fit to array.
			 */
			for (int j = n - k; j <= n; j++) {
				int pos = j - k;
				if (pos > 0) {
					if (position[pos - 1] == 0) {
						position[pos - 1] = j;
					} else {
						System.out.println("-1");
						continue mainloop;
					}
				}
			}

			for (int i = 1; i <= k; i++) {
				int pos = i + k;
				if (position[pos - 1] == 0) {
					position[pos - 1] = i;
				} else {
					System.out.println("-1");
					continue mainloop;
				}
			}
			/**
			 * Both Cases
			 */
			for (int i = k + 1; i < n - k; i++) {
				int pos1 = Math.abs(i - k);
				int pos2 = i + k;

				if (position[pos1 - 1] == 0 && position[pos2 - 1] != 0) {
					position[pos1 - 1] = i;
				} else if (position[pos1 - 1] != 0 && position[pos2 - 1] == 0) {
					position[pos1 - 1] = i;
				} else if (position[pos1 - 1] != 0 && position[pos2 - 1] != 0) {
					System.out.println("-1");
				} else {
					position[pos1 - 1] = i;
				}
			}
			for (int i = 0; i < position.length; i++) {
				System.out.print(position[i] + " ");
			}
			System.out.println();
		}
	}
}
