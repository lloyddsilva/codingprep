package edu.cmu.lloyddsilva;

/*
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 */

public class CompareVersions {
	public static void main(String[] args) {

		System.out.println(compareVersion("1", "0"));
		System.out.println(compareVersion("1", "1.1"));
		System.out.println(compareVersion("1.2", "1.1"));
		System.out.println(compareVersion("1.2", "1.2.1"));
		
		
	}
	
	public static int compareVersion(String version1, String version2) {
		
		//Only 1 version
		if(!version1.contains(".") && !version2.contains(".")) {
			int v1 = Integer.parseInt(version1);
			int v2 = Integer.parseInt(version2);
			
			if(v1>v2) return 1;
			else if (v2>v1) return -1;
			else return 0;
		}
		
		//multiple version levels
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int levels = Math.max(v1.length, v2.length);
		
		for(int i=0; i< levels; i++) {
			int v1int =0;
			int v2int =0;
			
			if(i<v1.length) 
				v1int = Integer.parseInt(v1[i]);
			
			if(i<v2.length) 
				v2int = Integer.parseInt(v2[i]);
			
			if(v1int>v2int) return 1;
			else if (v2int>v1int) return -1;
		}
		
		return 0;
	}
}
