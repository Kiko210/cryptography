import java.util.*;
public class hill 
{
	public static void main(String args[])
	{
		char[]alpha={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the plain text: ");
		a=sc.next().toUpperCase();
		int[]plain=new int[a.length()];
		int k=0;
		for(int i=0;i<a.length();i++)
		{
			for(int j=0;j<alpha.length;j++)
			{
				if(a.charAt(i)==alpha[j])
				{
					plain[k]=j;
					k++;
					break;
				}
			}
		}
		System.out.println("Converted Plain text: ");
		for(int i=0;i<a.length();i++)
		{
			System.out.print(plain[i]+" ");
		}
	    System.out.println();
		System.out.println("Enter the dimension of key: ");
		int b=sc.nextInt();
		int[][]key=new int[b][b];
		System.out.println("Enter the elements of key: ");
		for(int i=0;i<b;i++)
		{
			for(int j=0;j<b;j++)
			{
				key[i][j]=sc.nextInt();
			}
		}
		System.out.println("Key: ");
		for(int i=0;i<b;i++)
		{
			for(int j=0;j<b;j++)
			{
				System.out.print(key[i][j]+ " ");
			}
			System.out.println();
		}
		//Encryption:
		int []temp;
		if((plain.length)%b!=0)
		{
			temp=new int[(plain.length)+b-(plain.length%b)];
		}
		else
		{
			temp=new int[plain.length];
		}
		for(int i=0;i<temp.length;i++)
		{
			if(i<plain.length)
			{
				temp[i]=plain[i];
			}
			else
			{
				temp[i]=0;//appending extra 0's.
			}
		}
		int []p=new int[b];
		int []cipher=new int[temp.length];
		for (int i = 0; i < temp.length; i += b) 
		{
            for (int j = 0; j < b; j++) 
            {
                p[j] = temp[i + j];
            }
            // Multiply key matrix with the plain text matrix
            for (int j = 0; j < b; j++) 
            {
                cipher[i + j] = 0;
                for (k = 0; k < b; k++) 
                {
                    cipher[i + j] += key[j][k] * p[k];
                }
                cipher[i + j] %= 26; // Modulo 26
            }
        }
        System.out.println("Encrypted message: ");
        for (int i = 0; i < cipher.length; i++) {
            System.out.print(alpha[cipher[i]] + " ");
        }
        sc.close();
	}
   
}

