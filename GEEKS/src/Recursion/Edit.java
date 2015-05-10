package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Edit {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1=br.readLine();
		String s2=br.readLine();
		
		int steps=colorSequences(s1, s2);
		   System.out. println("Minimum edits required to convert "+s1+" into "+s2+" is "+steps+" by recursion\n"
		            );
		 
	}
	
			 public static int colorSequences(String input1,String input2)
			    {
			        // Base cases
			        int m=input1.length();
			        int n=input2.length();
					    if( m == 0 && n == 0 )
					        return 0;
					 
					    if( m == 0 )
					        return n;
					 
					    if( n == 0 )
					        return m;
					 
					    // Recurse
					  return  Minimum(colorSequences(input1.substring(0,m-1),input2)+1 ,
					  colorSequences(input1,input2.substring(0,n-1)) +1,
					    colorSequences(input1.substring(0,m-1),input2.substring(0,n-1))+(input1.charAt(m-1)==input2.charAt(n-1)?0:1));
					    
					 
					  
					}
					static int min(int a, int b) {
						   return a < b ? a : b;
						}
						 
						// Returns Minimum among a, b, c
						static int Minimum(int a, int b, int c)
						{
						    return min(min(a, b), c);
						}
					
					  
			    
		   

	

}
