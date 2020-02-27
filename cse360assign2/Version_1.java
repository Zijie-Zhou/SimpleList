package cse360assign2;
/**
 * This class is the implementation of an ADT called SimpleList.
 * We can add elements to the head of list, and remove any elements
 * The remaining elements will automatically fill the gaps
 * @author Zijie Zhou
 * @version 1.0
 * class_ID 257
 * assignment_number 1
 */
public class Version_1 {

/**The main body of the list*/	
public int[] list;
/**The number of elements*/	    
private int count;

/** This is a constructor 
 *Create an array which can hold 10 integers
 *Set the count to 0
 */   
public Version_1()
{
   list = new int[10];   	
   count = 0;
}
/**The method add a new element to the head of the List
 * @param The integer you want to add
 */
public void add(int x)
{
	if(count == 0)
	{
		list[0] = x;
	}
	else if(count == 10)
	{
		for(int i = 9;i>=1;i--)
		{
			list[i] = list[i-1];
		}
		list[0] = x;
	}
	else
	{
		for(int i = count;i>=1;i--)
		{
			list[i] = list[i-1];
		}
		list[0] = x;
	}
	if(count != 10)
	{
	count ++;
	}
}
/**The method remove a exist element from the list
 * @param The integer you want to remove
 */
public void remove(int x)
{
	int n = search(x);

	if(n == count-1)
	{
	   count --;
	}
	else
	{
		for(int i = n; i <= count-2;i++)
		{
			list[i] = list[i+1];
		}
		count --;
	}
	
}
/**The method give back the number of elements
 * @return The number of elements
 */
public int count()
{
	return count;
}
/**The method produce the string of whole list
 * @return The string of whole list
 */
public String toString()
{
	String s = "";
	for(int i = 0;i < count; i++)
	{
		s = s + list[i]+ " ";
	}
	return s;
}
/**The method produce the string of whole list
 * @param The integer you want to found in the list
 * @return The index of the parameter
 */
public int search(int x)
{
	int n = -1;
	for(int i = 0; i < 10; i++)
	{
		if(list[i] == x)
		{
			n = i;
		}
	}
	return n;
}
}