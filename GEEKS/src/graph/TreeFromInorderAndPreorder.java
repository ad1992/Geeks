package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeFromInorderAndPreorder {
	static int preindex=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		char in[]=new char[n];
		char pre[]=new char[n];
		
		String s;
		StringTokenizer st;
		if((s=br.readLine())!=null)
		{
			st=new StringTokenizer(s);
			
			String preorder=st.nextToken();
			String inorder=st.nextToken();
			for(int i=0;i<n;i++)
			{
				in[i]=inorder.charAt(i);
				pre[i]=preorder.charAt(i);
				
			}
			Tree root=buildTree(in,pre,0,n-1);
			postorder(root);
		}

	}

	private static void postorder(Tree root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		postorder(root.llink);
		
		postorder(root.rlink);
		System.out.println(root.data);
		
	}

	private static Tree buildTree(char[] in, char[] pre, int start, int end) {
		// TODO Auto-generated method stub
		
		if(start>end)	
		
			return null;
		
		Tree tnode=create(pre[preindex++]);
		if(start==end)
			return tnode;
		int inindex=search(in,start,end,tnode.data);
		System.out.println("start"+start+"end"+end+"preindex"+preindex+" data "+tnode.data);
		
		tnode.llink=buildTree(in,pre,start,inindex-1);
		tnode.rlink=buildTree(in, pre, inindex+1, end);
		return  tnode;
		
	}

	private static Tree create(char c) {
		// TODO Auto-generated method stub
		
		return new Tree(c);
	}

	private static int search(char[] in, int start, int end, char data) {
		// TODO Auto-generated method stub
		for(int i=start;i<=end;i++)
		{
			if(in[i]==data)
			{
				return i;
			}
		}
		return -1;
		
	}

}
class Tree
{
	
	char data;
	Tree llink=null;
	Tree rlink=null;
	public Tree(char i) {
		// TODO Auto-generated constructor stub
		data=i;
		llink=rlink=null;
		
	}
	
}