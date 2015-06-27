package DataStructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Aakansha Doshi
 *
 *
 */
public class CircularLinkList {
static Node start;	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub		
		CircularLinkList ob=new CircularLinkList();			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("\nEnter 1 for insertion at begining\nEnter 2 for display\nEnter 3 to delete at any position\nEnter 4 to insert at end\nEnter 5 to stop");
			int choice=Integer.parseInt(br.readLine().trim());
			switch(choice)
			{
			case 1:
				System.out.println("Enter the number to be inserted at begining ");
				int num=Integer.parseInt(br.readLine().trim());				
				ob.insertbegin(num);
				break;
			case 2:
				ob.display();
				break;
			case 3:
				System.out.println("Enter the position to be deleted");
				int pos=Integer.parseInt(br.readLine());
				if(!ob.delete(pos))
				System.out.println("Nothing to delete");
				break;
			case 4:
				System.out.println("Enter the number to be inserted at end ");
				num=Integer.parseInt(br.readLine().trim());				
				ob.insertend(num);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.print("\nEnter a valid key\n");
				
			}
			
		}

	}
	private void insertend(int num) {
		Node p=new Node();
		p.data=num;
		Node temp=start;
		if(start==null)
		{
			start=p;
			p.link=p;
		}
		else
		{
			while(temp.link!=start)
			{
				temp=temp.link;
			}
			temp.link=p;
			p.link=start;
		}
	}
	private int count()
	{
		Node p=start;
		int c=0;
		if(p!=null){
			while(p.link!=start)
			{
				c++;
				p=p.link;
			}
			c++;
		}
		return c;
	}
	private boolean  delete(int pos) {
	//Considering the first node inserted as the starting position		
		Node p=start;int del;
		int i=2;
		int c=count();
		if(pos>c)
		{
			System.out.println("Invalid index");
			return false;
		}
		if(c>0)
		{
			if(pos==1)		
			{
				pos=c+1;
				//System.out.println("pos= "+pos);
				start=p.link;//To start counting the nodes from 2nd node when first is deleted
				//System.out.println("p="+p.data);
				if(pos==2)
					start=null;
			}
			while(i<pos)
			{
				p=p.link;
				//System.out.println("p="+p.data+" "+pos);
				i++;
			}
		
			del=p.link.data;
			p.link=p.link.link;
			//System.out.println("end");
			
			System.out.println("The deleted node is "+del);
			return true;
		}
		else
		{
			
			return false;
		}
		
		
	}

	private  void display() {
		// TODO Auto-generated method stub
		Node p=start;
		//System.out.println(start.data);
		if(p!=null){
		while(p.link!=start)
		{
			System.out.print(p.data+"-->");
			p=p.link;
		}
		System.out.print(p.data+"\n");
		}
		else
		{
			System.out.println("Empty");
		}
	}

	private  void insertbegin(int num) {
		// TODO Auto-generated method stub
		Node p=new Node();
		p.data=num;
		p.link=start;
		Node temp=start;
		if(start==null)
		{
			System.out.println("inserted first");
			p.link=p;
		}
		else
		{
			while(temp.link!=start)
			{
				temp=temp.link;
			}
			temp.link=p;
		}
		start=p;
		//System.out.println(start.data);
		
		
		
	}	
	private class Node
	{
		int data;
		Node link;
		
	}

	}


