package edu.cmu.lloyddsilva;


public class SpiralPrint {
	public static void main(String[] args) {
		int[][] output = getSpiralMatrix(5);

		for (int i = 0; i < output[0].length; i++) {
			for (int j = 0; j < output.length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();

		}
	}

	public static int[][] getSpiralMatrix(int len) {
		int[][] output = new int[len][len];

		int total = len * len;
		int num = 1;

		int pos = 0;
		int level = 0;

		int x = 0;
		int y = len - 1;

		// 0-3
		// 1-2

		// x = 0 y = 3
		while (x < len / 2) {
			pos = x;
			level = x;

			// top
			while (pos <= y) {
				output[level][pos++] = num++;
			}

			// level==0; post ==4;
			level++;
			pos--;

			// level ==1 , pos == 3

			// right level 0-len-level, pos costant
			while (level <= y) {
				output[level++][pos] = num++;
			}
			// level == 4; pos ==3;
			level--;
			pos--;

			// level == 3, pos == 2;

			// bottom
			while (pos >= x) {
				output[level][pos--] = num++;
			}

			// level ==3, pos== -1
			pos++;
			level--;
			// level ==2, pos == 0

			// left
			while (level > x) {
				output[level--][pos] = num++;
			}

			x++; // 1 1
			y--; // 3 1

		}

		if (x == y) {
			output[x][y] = num++;
		}

		return output;
	}

}

// 1 2 3
// 8 9 4
// 7 6 5

// 1 2 3 4
// 12 13 14 5
// 11 16 15 6
// 10 9 8 7