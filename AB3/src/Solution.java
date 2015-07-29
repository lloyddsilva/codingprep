import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String rowCols = in.nextLine();
        StringTokenizer strc = new StringTokenizer(rowCols, ",");
        
        int rows = Integer.parseInt(strc.nextToken().trim());
        int cols = Integer.parseInt(strc.nextToken().trim());
        
        int[][] data = new int[rows][cols];
        
        for(int i=0; i< rows; i++) {
            String input = in.nextLine();
            StringTokenizer st = new StringTokenizer(input, ",");
            for(int j=0; j<cols; j++) {
                data[i][j] = Integer.parseInt(st.nextToken().trim());
            }
        }
        
        ArrayList<Integer> output = spiralOrder(data);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<output.size(); i++)
        {
        	sb.append(output.get(i) + ",");
        }
        sb.setLength(sb.length()-1);
        
        System.out.println(sb.toString());
        
        
    }
    
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> order = new ArrayList<Integer>();
    	
    	if(matrix == null || matrix.length == 0 ) 
    		return order;
    	
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	
    	int rowpos = 0;
    	int colpos = 0;
    	
    	while(rows > 0 && cols > 0) {
    		
    		if(rows == 1) {
    			for(int i=0; i<cols; i++) {
    				order.add(matrix[rowpos][colpos++]);
    			}
    			return order;
    		} else if(cols == 1) {
    			for(int i=0; i<rows; i++) {
    				order.add(matrix[rowpos++][colpos]);
    			}
    			return order;
    		}
    		
    		//top row 0,0 -> 0, col-1
    		for(int i=0; i<cols-1; i++) {
    			order.add(matrix[rowpos][colpos++]);
    		}
    		
    		
    		//right 0, col-1 -> row-1, col-1
    		for(int i=0; i<rows-1; i++) {
    			order.add(matrix[rowpos++][colpos]);
    		}
    		
    		
    		//bottom row-1, col-1 -> row-1, 0
    		for(int i=0; i<cols-1; i++){
    			order.add(matrix[rowpos][colpos--]);
    		}
    		
    		
    		//left row-1, 0 -> 0,0
    		for(int i=0; i<rows-1; i++) {
    			order.add(matrix[rowpos--][colpos]);
    		}
    		
    		rowpos++;
    		colpos++;
    		
    		rows = rows-2;
    		cols = cols-2;
    		
    	}
    	
    	return order;
    	
    	
    }
}