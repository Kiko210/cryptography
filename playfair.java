import java.util.*;
public class playfair
{
	public static void main(String args[])
	{
		String a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the plain text: ");//no space
		a=sc.next().toUpperCase();
		System.out.println("Enter the key: ");
		b=sc.next().toUpperCase();
		char[]key=b.toCharArray();
		char[]alpha={'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(int i=0;i<b.length();i++)
		{
			for(int j=0;j<alpha.length;j++)
			{
				if(key[i]==alpha[j])
				{
					alpha[j]='0';
					break;
				}
			}
		}
		//Playfair Square:
		char [][]square=new char[5][5];
		int ind1=0,ind2=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(ind1<b.length())
				{
					square[i][j]=key[ind1];
					ind1++;
				}
				else
				{
					if(alpha[ind2]!='0')
					{
						square[i][j]=alpha[ind2];
						ind2++;
					}
					else
					{
						ind2++;
						j--;
					}
				}
			}
		}
		System.out.println("Reference Table: ");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(square[i][j]);
			}
			System.out.println();
		}
		//Encryption:
		char []temp;String z="";
		for(int i=0;i<a.length();i+=2)
		{
			if(i+1<a.length()) 
			{
				if(a.charAt(i)!=a.charAt(i+1))
				{
					z=z+a.charAt(i)+a.charAt(i+1);
				}
				else
				{
					z=z+a.charAt(i)+"X"+a.charAt(i+1);
				}
			}
			else
			{
				z=z+a.charAt(i);
			}
		}
		if(z.length()%2!=0)
		{
			z=z+"X";
			temp=z.toCharArray();
			System.out.println("Intermediate text: "+z);
		}
		else
		{
			temp=z.toCharArray();
			System.out.println("Intermediate text: "+z);
		}
		String cipher="";
		for(int i=0;i<temp.length;i+=2)
		{
			char x= temp[i];
			char y=temp[i+1];
			cipher=traverse(x,y,square,cipher);
		}
		System.out.println("Encrypted text: "+cipher);
		sc.close();
	}
	public static String traverse(char x,char y,char[][]square,String cipher)
	{
		int x1=0,x2=0,y1=0,y2=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(x=='J')
				{
					if(square[i][j]=='I')
					{
						x1=i;x2=j;
					}
				}
				if(y=='J')
				{
					if(square[i][j]=='I')
					{
						y1=i;y2=j;
					}
				}
				if(square[i][j]==x)
				{
					x1=i;x2=j;
				}
				if(square[i][j]==y)
				{
					y1=i;y2=j;
				}
			}
		}
		if(x1==y1)//same row
		{
			x2=(x2+1)%5;
			y2=(y2+1)%5;
			x=square[x1][x2];
			y=square[y1][y2];
			cipher=cipher+x+y;
		}
		else if(x2==y2)//same column
		{
			x1=(x1+1)%5;
			y1=(y1+1)%5;
			x=square[x1][x2];
			y=square[y1][y2];
			cipher=cipher+x+y;
		}
		else
		{
			x=square[x1][y2];
			y=square[y1][x2];
			cipher=cipher+x+y;
		}
		return cipher;
	}
}



