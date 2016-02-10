package jack.algos.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VendorsWithMaxDuplicates {
	//itemCounts store the itemName and its count across the vendors
	public static HashMap<String, Integer> itemCounts = new HashMap<String, Integer>();
	//dupItems is the set of all duplicate items sold by vendors
	public static Set<String> dupItems = new HashSet<String>();
	//vendorItems is the hashmap of <vendorname, Set(items sold)>
	public static HashMap<String, Set<String>> vendorItems = new HashMap<String, Set<String>>();
	
	public static void main(String[] args) {
		String[] input = {"<V1, I1>", "<V2, I2>", "<V3, I4>", "<V1, I2>",
							"<V4, I5>","<V1, I3>","<V2, I3>","<V3, I5>"};
		
		parseInput(input);
		getVendorsWithMaxDuplicates();
	}
	
	/* This function is to parse the input to form hashmaps to store the data 
	 * in convenient form
	 * */
	public static void parseInput(String[] in) {
		int maxCount = 0;
		for(int i=0; i<in.length; i++) {
			//parse every <K,V> pair to get vendor name and item name
			String curr = in[i];
			curr = (String) curr.subSequence(1, curr.length()-1);
			String[] currSplit = curr.split(",");
			String itemName = currSplit[1].trim();
			String vendorName = currSplit[0].trim();
			
			//update itemCounts object
			int count = (itemCounts.get(itemName) == null) ? 0 : itemCounts.get(itemName);
			count++;
			itemCounts.put(itemName, count);
			
			//update vendorItems object
			 Set<String> tempItems = new HashSet<String>();
			 tempItems = (vendorItems.get(vendorName) == null) ? tempItems : 
				 vendorItems.get(vendorName);
			 tempItems.add(itemName);
			 vendorItems.put(vendorName, tempItems);
			 
			/*if(maxCount < count) {
				dupItems.clear();
				maxCount = count;
			}
			dupItems.add(itemName);
			*/
			 
			 if((count>1) && (!dupItems.contains(itemName))) 
				 dupItems.add(itemName);
		}
	}
	
	public static void getVendorsWithMaxDuplicates() {
		int maxCount = 0;
		Set<String> vendorNames = vendorItems.keySet();
		Iterator<String> vendorIterator = vendorNames.iterator();
		Set<String> maxVendors = new HashSet<String>();
		
		while(vendorIterator.hasNext()) {
			int count = 0;
			String currV = vendorIterator.next(); 
			Iterator<String> itemIterator = dupItems.iterator();
			while(itemIterator.hasNext()) {
				if(vendorItems.get(currV).contains(itemIterator.next()))
					count++;
			}
			if(count > maxCount) {
				maxVendors.clear();
				maxCount = count;
				maxVendors.add(currV);
			} else if (count == maxCount) {
				maxVendors.add(currV);
			}
		}
		System.out.println("Duplicate items are: " + dupItems);
		System.out.println("Vendors who has max number of duplicate items: " + maxVendors);
		System.out.println("These vendors have " + maxCount + " number of duplicate items");
	}
}
