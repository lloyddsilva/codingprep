package edu.cmu.lloyddsilva;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	LinkedHashMap<Integer, Integer> lhm; 
	
	
	public LRUCache(int capacity) {
		lhm = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > capacity;
			}
		};
        
    }
    
    public int get(int key) {
        return lhm.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        lhm.put(key,value);
    }
}
