package org.study;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l1 = {1,1,2,2,3};
		int[] l2 = {1,2,2,4,5};
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		for(int i=0; i<l1.length;i++) {
			list1.add(l1[i]);
		}
		for(int i=0; i<l2.length;i++) {
			list2.add(l2[i]);
		}
		
		ArrayList<Integer> unionList = new ArrayList<Integer>();
		ArrayList<Integer> interList = new ArrayList<Integer>();


		for(int str : list1) {
			int num = 0;
            if(list2.contains(str)) {
            	 unionList.add(str);
                list2.remove(str);
                
                num++;
                System.out.println("contains: "+str+" , num:"+num+" list2.contains(str):"+list2.contains(str));
            }
           
            System.out.println(str+ " ");
        }
        //unionList.addAll(list2);
        
        System.out.println();
        for(int str : unionList) {
        	System.out.print(str+" ");
        }
	/*
    for(int str : list1) {
        if(list2.contains(str)) {
            interList.add(str);
            list2.remove(str);
        }
    }
*/

	}

}
