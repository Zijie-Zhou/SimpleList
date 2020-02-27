package cse360assign2;
/**
 * The 2.0 version retains the rules inserted from the head of the list in the previous version. 
 * On this basis, the list becomes scalable. When the list is filled, the space is increased by 50%. 
 * When the remaining space of the list is more than 25%, its space is reduced.
 * 
 * @author Zijie Zhou
 * @version 2.0
 * class_ID 257
 * assignment_number 2
 */
public class Version_2 {

/**The main body of the list*/	
public int[] list;
/**A temporary array used when I change the length of the array*/
private int[] tmp;
/**The number of elements*/	    
private int count;
/**The size of array*/
private int n = 10;

/** This is a constructor 
 *Create an array which can hold 10 integers
 *Set the count to 0
 */   
public Version_2()
{
   list = new int[n];   	
   count = 0;
}
/**The method add a new element to the head of the List
 * When the list is filled, the space is increased by 50%
 * @param The integer you want to add
 */
public void add(int x)
{
    if(count == n)
	{
		tmp = new int[n];
		for(int i = 0;i < n;i++)
		{
			tmp[i] = list[i];
		}
		n = n + (n/2);
		list = new int[n];
		for(int i = 0;i < tmp.length;i++)
		{
			list[i+1] = tmp[i];			
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
    count ++;	
}
/**The method remove a exist element from the list
 * When the remaining space of the list is more than 25%, its space is reduced.
 * @param The integer you want to remove
 */
public void remove(int x)
{
	int q = search(x);

	if(q == count-1)
	{
	   count --;
	}
	else
	{
		for(int i = q; i <= count-2;i++)
		{
			list[i] = list[i+1];
		}
		count --;
	}
	if((n - count) > (n/4))
	{
		n = n - (n/4);
		tmp = new int[n];
		for(int i = 0;i < count;i++)
		{
			tmp[i] = list[i];
		}
		list = new int[n];
		for(int i = 0;i < count;i++)
		{
			list[i] = tmp[i];			
		}
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
	int q = -1;
	for(int i = 0; i < count; i++)
	{
		if(list[i] == x)
		{
			q = i;
		}
	}
	return q;
}

}