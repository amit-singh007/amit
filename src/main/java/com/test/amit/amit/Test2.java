package com.test.amit.amit;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test2 {
	
	private static ArrayList<Test> rangeList = new ArrayList<Test>();
	
	public static void main(String[] args) {
		
		//If the input Condition is
		Test a = new Test(94133,94133);
		Test b = new Test(94200,94299);
		Test c = new Test(94600,94699);
		
		Test2.AddRange(a);
		Test2.AddRange(b);
		Test2.AddRange(c);
	 
		
		showRange() ;
		
	}

	public static void AddRange(Test toAdd) {
		if(rangeList.size()==0)
			rangeList.add(toAdd);
		else {
			ListIterator<Test> iter = rangeList.listIterator();
			boolean add = true; 
			while( iter.hasNext()) {
				Test range = iter.next();	
				if(range.getLower()<=toAdd.getLower() && range.getUpper()>=toAdd.getUpper()) {
					add = false;
				}
				else if(range.getLower()>toAdd.getUpper() || range.getUpper()<toAdd.getLower()) {
					add = true;
				}
				else {
					if(range.getLower()<toAdd.getLower())
						toAdd.setLower(range.getLower());
					if(range.getUpper()>toAdd.getUpper())
						toAdd.setUpper(range.getUpper());
					iter.remove();
					add = true;
				}
			}
			if(add)
				rangeList.add(toAdd);
		}
		
   }
	
   public static void showRange() {
	   if(rangeList.size()>0) {
		   for(Test range :rangeList) {
			   System.out.println(range.toString());
		   }
	   }
	   
   }
   
   public static int size() {
	   return rangeList.size();
   }
   
   public static List<Test> getZipRanges() {
	   return rangeList;
   }
   
   
   public static void clear() {
	   rangeList.clear();
   }

}