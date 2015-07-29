import java.util.Arrays;
import java.util.Scanner;


public class Solution {
	
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		int[][] cases = new int[t][2];
//		
//		for(int i=0; i<t; i++) {
//			cases[i][0] = in.nextInt();
//			cases[i][1] = in.nextInt();
//		}
//		
//		for(int i=0; i<t; i++) {
//			System.out.println(getWays(cases[i][0], cases[i][1]));
//		}
//		
//	}
//	
//	public static int getWays(int rows, int cols) {
//		return 0;
//	}
	
	int md=1000000007;
	int[][] ways = new int[1001][1001];
	int[][] waysRestrict = new int[1001][1001];
	public Solution(){
		for(int[] w : ways) Arrays.fill(w, -1);
		for(int[] w : waysRestrict) Arrays.fill(w, -1);
	}
	
	public int solve(int n, int m)
	{
		if (ways[n][m] != -1) return ways[n][m];
		long ans;
		if (m==1) ans = 1;
		else if (n==1){
			if (m<=4) {
				ans = 2*solve(1,m-1);
			}
			else {
				ans = solve(1,m-1);
				ans = (ans + solve(1,m-2))%md;
				ans = (ans + solve(1,m-3))%md;
				ans = (ans + solve(1,m-4))%md;
			}
		}
		else{
			ans = 1; int one = solve(1,m);
			for (int i=0; i<n; i++) ans = (ans * one)%md;
		}
		ways[n][m] = (int)ans;
		return ways[n][m];
	}
	
	public int solveRestrict(int n, int m)
	{
		if (waysRestrict[n][m] != -1) return waysRestrict[n][m];
		long ans;
		if (m==1) ans = 1;
//		else if (n==1) ans = solve(n,m);
		else {
			ans = solve(n,m);
			for (int i=1; i<m; i++) {
				long a = solve(n,i);
				a = (a*solveRestrict(n,m-i))%md;
				ans -= a;
				if (ans<0) ans+=md;
			}
		}
		waysRestrict[n][m] = (int)ans;
		return waysRestrict[n][m];
	}
	
	
	public static void main (String[] args) {
		Solution o = new Solution();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int a, b;
			a = sc.nextInt(); b = sc.nextInt();
			System.out.println(o.solveRestrict(a,b));
		}
		sc.close();
	}

}
