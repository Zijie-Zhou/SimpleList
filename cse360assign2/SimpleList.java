package cse360assign2;
/**
 * Version 3.0 is still a list of elements that can be added and removed. 
 * When the space is full, the space is increased by 50%, and if it is less than 25%, it is reduced. 
 * But it adds three new methods append (), first/last (), size () on the basis of version 2.0. 
 * The append method can add elements from the tail, first can return the first element, and size can return the available space.
 * 
 * @author Zijie Zhou
 * @version 3.0
 * class_ID 257
 * assignment_number 2
 */
public class SimpleList {
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
	public SimpleList()
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
	/**The method add a new element to the end of the List
	 * When the list is filled, the space is increased by 50%
	 * @param The integer you want to add
	 */
	public void append(int x)
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
				list[i] = tmp[i];			
			}
			list[count] = x;
		}
		else
		{
			list[count] = x;
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
	/**
	 * The method return the first element in the list
	 * @return the first element
	 */
	public int first()
	{
		if(count == 0)
		{return -1; }
		else
		{
		   return list[0];
		}
	}
	/**
	 * The method return the last element in the list
	 * @return the last element
	 */
	public int last()
	{
		if(count == 0)
		{return -1; }
		else
		{
		   return list[count-1];
		}
	}
	/**
	 * The method will return how much space remain in the list currently.
	 * @return The current number of possible locations
	 */
	public int size()
	{
		return (n-count);
	}
}
