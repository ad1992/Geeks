package DataStructures;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author Aakansha Doshi
 *
 */
public class CircularLinkList {
static Node start;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		CircularLinkList ob=new CircularLinkList();	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("\nEnter 1 for insertion\nEnter 2 for display\n");
			int choice=Integer.parseInt(br.readLine().trim());
			switch(choice)
			{
			case 1:
				int num=Integer.parseInt(br.readLine().trim());				
				ob.insert(num);
				break;
			case 2:
				
				ob.display();
				break;
			
			default:
				System.exit(0);;
				
			}
			
		}

	}

	private  void display() {
		// TODO Auto-generated method stub
		Node p=start;
		//System.out.println(start.data);
		while(p.link!=start)
		{
			System.out.print(p.data+"-->");
			p=p.link;
		}
		System.out.print(p.link.data+"\n");
		
	}

	private  void insert(int num) {
		// TODO Auto-generated method stub
		Node p=new Node();
		p.data=num;
		p.link=start;
		Node temp=start;
		if(start==null)
		{
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
		System.out.println(start.data);
		
		
		
	}	
	private class Node
	{
		int data;
		Node link;
		
	}

	}


