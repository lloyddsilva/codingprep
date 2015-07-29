

public class Location {
	int x;
	int y;
	char dir;
	
	public Location(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public boolean equals(Location loc) {
		return this.x == loc.x && this.y == loc.y && this.dir == loc.dir;
	}
}
