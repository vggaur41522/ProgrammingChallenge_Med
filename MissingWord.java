package test;

import java.util.ArrayList;
import java.util.Arrays;

public class MissingWord {

	public MissingWord() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inp = "I am using hackerrank to improve Coding";
		String compStr = "am hackerrank to improve";
		String[] inpArr = inp.split(" ");
		String[] compStrArr = compStr.split(" ");
		//ArrayList<String> arrLstInp = new  ArrayList(Arrays.asList(inpArr));
		int count = 0,i=0,j=0;
		
		
		
		while(j<inpArr.length && i<compStrArr.length)
		{
			while(i<compStrArr.length)
			{
				if(compStrArr[i].equals(inpArr[j]))
				{
					j++;
					i++;
				}
				else
				{
					System.out.println(inpArr[j]);
					j++;
				}
				
			}
			if((i==compStrArr.length) && (j<inpArr.length))
			{
				System.out.println(inpArr[j]);
			}
		}
		
		

	}

}
