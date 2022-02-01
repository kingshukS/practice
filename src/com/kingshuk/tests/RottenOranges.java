package com.kingshuk.tests;

import java.util.HashSet;
import java.util.Set;

public class RottenOranges {

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);

	}

	private static int rotOranges(int[][] arr) {
		Set<String> fresh = new HashSet<>();
		Set<String> rotten = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j]==1)
					fresh.add(""+i+j);
				else if(arr[i][j]==2)
					rotten.add(""+i+j);
			}
		}
		
		int minutes = 0;
		int[][] directions = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		
		while(fresh.size()>0) {
			Set<String> infected = new HashSet<>();
			
			for(String s : rotten) {
				int i = s.charAt(0)-'0';
				int j = s.charAt(1)-'0';
				
				for(int[] dir : directions) {
					int nextI = i+dir[0];
					int nextJ = j+dir[1];
					if(fresh.contains(""+nextI+nextJ)) {
						fresh.remove(""+nextI+nextJ);
						infected.add(""+nextI+nextJ);
					}
				}
			}
			
			if(infected.size()==0)
				return -1;
			minutes++;
			rotten = infected;
		}
		return minutes;
	}

}
