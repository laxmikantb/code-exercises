package com.lax.codeexercise;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int n = 4;
		towerOfHanoi(n,"A","C","B"); // name of the rods a,b,c and number of disks 4
	}

	public static void towerOfHanoi(int n, String fromRod, String toRod, String auxRod) {
		if (n==1)
		{
			System.out.println("Move Disk " + n + " From Road " + fromRod + " ToRod " + toRod);
			return;
		}
		towerOfHanoi(n-1, fromRod,auxRod,toRod);
		System.out.println("Move Disk " + n + " From Road " + fromRod + " ToRod " + toRod);
		towerOfHanoi(n-1, auxRod,toRod,fromRod);
	}
}
