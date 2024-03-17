package com.kingshuk.tests.DynamicProgramming;

import java.util.ArrayList;

import static com.kingshuk.tests.DynamicProgramming.MaximumNonAdjacentSum.maximumNonAdjacentSumTabulationSpaceOptimized;

public class HouseRobber {
	public static long houseRobber(int[] valueInHouse) {
		int n = valueInHouse.length;
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i = 0; i<n; i++)
		{
			if(i != 0) list2.add(valueInHouse[i]);
			if(i != n-1) list1.add(valueInHouse[i]);
		}
		return Math.max(maximumNonAdjacentSumTabulationSpaceOptimized(list1),
				maximumNonAdjacentSumTabulationSpaceOptimized(list2));
	}	
}