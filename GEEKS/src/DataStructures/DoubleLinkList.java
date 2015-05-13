package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Aakansha Doshi
 *
 */
public class DoubleLinkList {
static DoubleNode start;	
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		DoubleLinkList ob = new DoubleLinkList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("\nEnter 1 for insertion at begining\nEnter 2 for display"
					+ "\nEnter 3 to delete at any position\nEnter 4 to insert at end\n Enter 5 to reverse");
			int choice = Integer.parseInt(br.readLine().trim());
			switch (choice) {
			case 1:
				System.out
						.println("Enter the number to be inserted at begining ");
				int num = Integer.parseInt(br.readLine().trim());
				ob.insertbegin(num);
				break;
			case 2:
				ob.display();
				break;
			case 3:
				System.out.println("Enter the position to be deleted");
				int pos = Integer.parseInt(br.readLine());
				if (!ob.delete(pos))
					System.out.println("Nothing to delete");
				break;
			case 4:
				System.out.println("Enter the number to be inserted at end ");
				num = Integer.parseInt(br.readLine().trim());
				ob.insertend(num);
				break;
			case 5:
				reverse();
				ob.display();
				break;
			default:
				System.exit(0);
				;

			}

		}

	}

	private static void reverse() {
		// TODO Auto-generated method stub
		DoubleNode p1,temp=null;
		if(start!=null&&start.rlink!=null){
		
		p1=start;
		while(p1!=null)
		{
			temp=p1.llink;
			p1.llink=p1.rlink;
			p1.rlink=temp;
			p1=p1.llink;
		}
		start=temp.llink;
		
		
		}
		
		
		
	}

	private void insertend(int num) {

		DoubleNode temp = start;
		DoubleNode p = new DoubleNode(num);
		if (start == null) {
			start = p;
		} else {
			while (temp.rlink != null) {
				temp = temp.rlink;
			}
			temp.rlink = p;
			p.llink = temp;

		}

	}

	private boolean delete(int pos) {
		// TODO Auto-generated method stub
		int i = 2, del;
		DoubleNode p = start;
		if (start == null) {
			return false;
		} else if (pos == 1) {
			del = start.data;
			start = start.rlink;
			if (start != null)
				start.llink = null;

		} else {
			while (i < pos) {
				p = p.rlink;
				i++;
			}
			del = p.rlink.data;
			p.rlink = p.rlink.rlink;
			if(p.rlink!=null)
			p.rlink.llink = p;

		}
		System.out.println("The deleted node is " + del);
		return true;
	}

	private void display() {
		// TODO Auto-generated method stub
		DoubleNode p = start;
		// System.out.println(start.data);
		if (p != null) {
			while (p.rlink != null) {
				System.out.print(p.data + "-->");
				p = p.rlink;
			}
			System.out.print(p.data + "\n");
		} else {
			System.out.println("Empty");
		}

	}

	private void insertbegin(int num) {
		DoubleNode p = new DoubleNode(num);
		if (start == null)
			start = p;
		else {
			p.rlink = start;
			start.llink = p;
			start = p;
		}

	}

	private class DoubleNode {
		int data;
		DoubleNode llink;
		DoubleNode rlink;

		public DoubleNode(int num) {
			data = num;
			llink = rlink = null;
		}
	}
}
