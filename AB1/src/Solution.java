import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Solution {
	
	public static void main(String[] args) {
		System.out.println(doesCircleExist("LGLGLGLG"));
		Scanner in = new Scanner(System.in);
	}

	public static String doesCircleExist1(String commands) {
		//doesn't go anywhere
		if(!commands.contains("G"))
			return "YES";
		else {
			//Check if any of these sequences exist LRRR, LLLL, RLLL, RRRR with a constant number of Gs in between
			
			boolean p1 = Pattern.matches("LG+LG+LG+LG+", commands);
			boolean p2 = Pattern.matches("LG+RG+RG+RG+", commands);
			boolean p3 = Pattern.matches("RG+LG+LG+LG+", commands);
			boolean p4 = Pattern.matches("RG+RG+RG+RG+", commands);
			
			if(p1 || p2 || p3 || p4) {
				return "YES";
			}
			
		}
		//char[] commandChars = commands.toCharArray();
		
		
		return "NO";
		
	}
	
	
	public static String doesCircleExist(String commands) {
		if(!commands.contains("G"))
			return "YES";
		
		char dir = 'N'; //N, E, S, W
		int x = 0;
		int y = 0;
		
		Location initLocation = new Location(x,y,dir);
		HashSet<Location> locs = new HashSet<Location>();
		locs.add(initLocation);
		
		char[] commandChars = commands.toCharArray();
		for(int i=0; i< commandChars.length; i++ ){
			if(commandChars[i] == 'G') {
				if(dir == 'N') {
					x--;
					Location temp = new Location(x, y, dir);
					if(locs.contains(temp)) {
						return "YES";
					} else {
						locs.add(temp);
					}
				} else if(dir == 'E') {
					y++;
					Location temp = new Location(x, y, dir);
					if(locs.contains(temp)) {
						return "YES";
					} else {
						locs.add(temp);
					}
				} else if(dir == 'S') {
					x++;
					Location temp = new Location(x, y, dir);
					if(locs.contains(temp)) {
						return "YES";
					} else {
						locs.add(temp);
					}
				} else if(dir == 'W') {
					y--;
					Location temp = new Location(x, y, dir);
					if(locs.contains(temp)) {
						return "YES";
					} else {
						locs.add(temp);
					}
				}
 				
				
			} else if(commandChars[i] == 'L') {
				if(dir == 'N') {
					dir = 'W';
				} else if(dir == 'E') {
					dir = 'N';
				} else if(dir == 'S') {
					dir = 'E';
				} else if(dir == 'W') {
					dir = 'S';
				}
				
				
			} else if(commandChars[i] == 'R') {
				if(dir == 'N') {
					dir = 'E';
				} else if(dir == 'E') {
					dir = 'S';
				} else if(dir == 'S') {
					dir = 'W';
				} else if(dir == 'W') {
					dir = 'N';
				}
				
			}
		}
		
		
		return "NO";
		
	}
	
}
