package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aakansha Doshi
 *
 */
public class MergeSortLinkList {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		MergeSortLinkList ob=new MergeSortLinkList();	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println("Enter the size of linklist");	
		int size=Integer.parseInt(br.readLine());		
		System.out.println("Enter the numbers");
		Node start=null;	
		
		while(size-->0)
		{
			int num=Integer.parseInt(br.readLine().trim());
			if(start==null)
			{
				start=new Node(num);
			}
			else{
			start.insert(num,start);
			}
		}
		System.out.println("The original linklist--->");
		start.display();
		Node star=ob.mergeSort(start);
		System.out.println("final sorted linklist--->");
		star.display();
	}

	private Node mergeSort(Node start) {
		Node head=start;
		if(head==null||head.link==null){
			//System.out.println("null");
			return head;		
		}		
		Node mid=divide(head);	
		Node l=head;
		Node r=mid.link;
		mid.link=null;
		Node left=mergeSort(l);	
		Node right=mergeSort(r);	
		//uncomment to view the left and right divisions of linklist
		//if(left!=null)
		//left.display();
		//if(right!=null)
		//right.display();
		Node merge=sortmerge(left,right);			
		return merge;
		
	}

	private Node sortmerge(Node a, Node b) {
		// TODO Auto-generated method stub
		Node temp=null;	
		
		while(a!=null&&b!=null)
		{
			if(a.data<=b.data)
			{
				if(temp==null)
				{
					temp=new Node(a.data);
					
					
				}
				else
				{					
									
					temp.insert(a.data, temp);
					//System.out.println("temp.data="+temp.data);
					
				}
				a=a.link;
				
			}
			else
			{
				if(temp==null)
				{
					temp=new Node(b.data);
					
					
				}
				else
				{
					
					
					temp.insert(b.data, temp);
					//System.out.println("temp.data="+temp.data);
					
				}
				b=b.link;
				
			}
			
				
			}
			while(a!=null)
			{
				
				if(temp==null)
				{
					temp=new Node(a.data);
				
					
				}
				else
				{
					
					
					temp.insert(a.data, temp);
					//System.out.println("temp.data="+temp.data);
					
				}
				
				a=a.link;
			
				
			}
			while(b!=null)
			{
				
				if(temp==null)
				{
					temp=new Node(b.data);
				
					
				}
				else
				{
					
					
					temp.insert(b.data, temp);
					//System.out.println("temp.data="+temp.data);
					
				}
				
				b=b.link;
			
				
			}
			return temp;
		}
		
	

	private Node divide(Node head) {
		// TODO Auto-generated method stub
		Node mid=null;
		Node fast=null;
		Node slow=null;
		if(head==null||head.link==null)
		{
			mid=null;
			System.out.println("aas");
			
		}
		else
		{
			slow=head;
			fast=head.link;
			while(fast!=null)
			{
				fast=fast.link;
				if(fast!=null)
				{
					slow=slow.link;
					fast=fast.link;							
							
				}
			}
			
			mid=slow;
			//slow.link=null;
			
		}
		return mid;
		
		
	}

	
	 
}	

class Node
{
	int data;
	Node link;
	Node(int num)
	{
		link=null;
		data=num;
	}
	void display() {
		
		Node p=this;
		if(p!=null){
		while(p.link!=null)
		{
			System.out.print(p.data+"-->");
			p=p.link;
		}
		System.out.print(p.data+"\n");
		}
		
	}
	void insert(int num,Node start) {
		// inserting the nodes at end
		Node p=new Node(num);
		Node p1=start;
		if(start==null)
		{
			start=p;
		}
		else if(start.link==null)
		{
			start.link=p;
		}
		else
		{
			while(p1.link!=null)
			{
				p1=p1.link;
			}
			p1.link=p;
		}
		
		
	}
}
