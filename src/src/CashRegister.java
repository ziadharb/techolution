package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CashRegister {
	
	ArrayList<Integer> prices = new ArrayList<Integer>();
	public static float pricesTotal=0;
	Map<Integer, Integer> priceMap = new HashMap<Integer, Integer>();
	
	
	public CashRegister() {
	}
	
	// - Receives an integer (total price) for tracking.
	public void ringUp(int price) {
		prices.add(price);
		Collections.sort(prices);
		System.out.println(prices);
		pricesTotal += price;
		
		addPriceToMap(price);
		
	}

	public void addPriceToMap(int price){
		int count = priceMap.containsKey(price) ? priceMap.get(price) : 0;
		priceMap.put(price, count + 1);
	}
	
	public void clear(){
		pricesTotal = 0;
		prices.clear();
		priceMap.clear();
	}
	
	// - Returns the max (int) of all integers seen so far.
	public int getMax() {
		return prices.get(prices.size()-1);
//		int maxPrice=0;
//		
//		for (int x=0;x< prices.size();x++) {
//			if(prices.get(x) > maxPrice)
//				maxPrice = prices.get(x);			
//		}
		
//		return maxPrice;		
	}
	
	// - Returns the min (int) of all integers seen so far.
	public int getMin() {
		return prices.get(0);

//		int minPrice=0;
//		
//		for (int x=0;x< prices.size();x++) {
//			if(prices.get(x) < minPrice)
//				minPrice = prices.get(x);			
//		}
//		
//		return minPrice;			
	}
	
	// - Returns the mean (float) of all integers seen so far.
	public float getMean() {
		float mean;
		mean = (pricesTotal/prices.size());
		return mean;
	}
	
	// - Returns the mode (most frequent) (int) of all integers seen so far.
	public int getMode() {
//		int frequency=0;
//		int mostFrequentKey=0;
//		int mostFrequentValue=0;
//
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		
//		
//		for (int x=0; x< prices.size();x++) {
//			for (int y=0; y< prices.size();y++) {
//				if(prices.get(x) == prices.get(y)) {
//					frequency +=1;
//				}
//			}
//			map.put(prices.get(x), frequency);
//			frequency = 0;
//		}
		
//		for (Integer key : map.keySet())
//		{
//		    if (map.get(key) > mostFrequentValue) {
//		    	mostFrequentKey = key;
//		    	mostFrequentValue = map.get(key);
//		    }
//		    
//		}
		
		return Collections.max(priceMap.entrySet(), Map.Entry.comparingByValue()).getKey();		
	}

}
