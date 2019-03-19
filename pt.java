import java.io.*;
import java.util.*;
import java.math.*;
class pt
{
	static Scanner z=new Scanner(System.in);
	static Random rand=new Random();
	
	// to make copy of an array
	static void arrcpy(int a[][],int b[][])
	{
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				a[i][j]=b[i][j];
	}
	
	//to compare two arrays if they are equal
	static int cmp(int a[][],int b[][])
	{
		int i;
		ab:for( i=0;i<4;i++)
			for(int j=0;j<4;j++)
				if(a[i][j]!=b[i][j])break ab;
		if(i==4)
			return 0;
		else
			return 1;
	}
	
	//check if 2048 if formed
	static int game(int a[][])
	{
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				if(a[i][j]==2048)return 1;
		return 0;	
	}
	
	//to check if array is filled
	static int filled(int a[][])
	{
		int i,j;
		ab:for(i=0;i<4;i++)
			for(j=0;j<4;j++)
				if(a[i][j]==0)break ab;
		if(i==4)
			return 1;
		else
			return 0;
	}
	
	//to fill a position randomly after a move
	static void fill(int a[][])
	{
		
		while(true)
		{
			int x=rand.nextInt(3);
			int y=rand.nextInt(3);
			if(a[x][y]==0)
			{
				int c=rand.nextInt(4);
				if(c==4)
					a[x][y]=4;
				else
					a[x][y]=2;
				break;
			}
		}
	}
	
    //up move	
	static int up(int a[][])
	{
		int r,c,x,i=0;
		int arr[][]=new int[4][4];
		arrcpy(arr,a);
		int b[][]=a.clone();
		for(c=0;c<=3;c++)
		{
			for(r=0;r<=3;r++)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=r-1;i>=0 && b[i][c]==0;i--);
					b[i+1][c]=x;
					if(i!=r-1)b[r][c]=0;
				}
			}
		}
		for(c=0;c<=3;c++)
		{
			for(r=0;r<=2;r++)
			{
				if(b[r][c]==b[r+1][c])
				{
					b[r][c]*=2;
					b[r+1][c]=0;
				}
			}
		}
		for(c=0;c<=3;c++)
		{
			for(r=0;r<=3;r++)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=r-1;i>=0 && b[i][c]==0;i--);
					b[i+1][c]=x;
					if(i!=r-1)b[r][c]=0;
				}
			}
		}
		if(game(b)==1)
			return 2;
		if(cmp(arr,b)==1 && filled(b)==1)
			return 1;
		else if(cmp(arr,b)==1){fill(b);		
		print(b);}return 0;
	}
	
	//down move
	static int down(int a[][])
	{
		int r,c,x,i=0;
		int arr[][]=new int[4][4];
		arrcpy(arr,a);
		int b[][]=a.clone();
		for(c=3;c>=0;c--)
		{
			for(r=3;r>=0;r--)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=r+1;i<=3 && b[i][c]==0;i++);
					b[i-1][c]=x;
					if(i!=r+1)b[r][c]=0;
				}
			}
		}
		for(c=0;c<=3;c++)
		{
			for(r=3;r>=1;r--)
			{
				if(b[r][c]==b[r-1][c])
				{
					b[r][c]*=2;
					b[r-1][c]=0;
				}
			}
		}
		for(c=3;c>=0;c--)
		{
			for(r=3;r>=0;r--)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=r+1;i<=3 && b[i][c]==0;i++);
					b[i-1][c]=x;
					if(i!=r+1)b[r][c]=0;
				}
			}
		}
		if(game(b)==1)
			return 2;
		if(cmp(arr,b)==1 && filled(b)==1)
			return 1;
		else if(cmp(arr,b)==1){fill(b);		
		print(b);}return 0;
	}
	
	//left move
	static int left(int  a[][])
	{
		int c=0,r=0,i=0,x=0;
		int arr[][]=new int[4][4];
		arrcpy(arr,a);
		int b[][]=a.clone();
		for(r=0;r<=3;r++)
		{
			for(c=0;c<=3;c++)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=c-1;i>=0 && b[r][i]==0;i--);
					b[r][i+1]=x;
					if(i!=c-1)b[r][c]=0;
				}
			}
		}
		for(r=0;r<=3;r++)
		{
			for(c=0;c<=2;c++)
			{
				if(b[r][c]==b[r][c+1])
				{
					b[r][c]*=2;
					b[r][c+1]=0;
				}
			}
		}
		for(r=0;r<=3;r++)
		{
			for(c=0;c<=3;c++)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=c-1;i>=0 && b[r][i]==0;i--);
					b[r][i+1]=x;
					if(i!=c-1)b[r][c]=0;
				}
			}
		}
		if(game(b)==1)
			return 2;
		if(cmp(arr,b)==1 && filled(b)==1)
			return 1;
		else if(cmp(arr,b)==1){fill(b);		
		print(b);}return 0;
	}
	
	//right move
	static int right(int  a[][])
	{
		int c=0,r=0,i=0,x=0;
		int arr[][]=new int[4][4];
		arrcpy(arr,a);
		int b[][]=a.clone();
		for(r=0;r<=3;r++)
		{
			for(c=3;c>=0;c--)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=c+1;i<=3 && b[r][i]==0;i++);
					b[r][i-1]=x;
					if(i!=c+1)b[r][c]=0;
				}
			}
		}
		for(r=0;r<=3;r++)
		{
			for(c=3;c>=1;c--)
			{
				if(b[r][c]==b[r][c-1])
				{
					b[r][c]*=2;
					b[r][c-1]=0;
				}
			}
		}
		for(r=0;r<=3;r++)
		{
			for(c=3;c>=0;c--)
			{
				x=b[r][c];
				if(x!=0)
				{
					for(i=c+1;i<=3 && b[r][i]==0;i++);
					b[r][i-1]=x;
					if(i!=c+1)b[r][c]=0;
				}
			}
		}
		if(game(b)==1)
			return 2;
		if(cmp(arr,b)==1 && filled(b)==1)
			return 1;
		else if(cmp(arr,b)==1){fill(b);		
		print(b);}return 0;
	}	
	
	//to input the move of the user	
	static int choice(int a[][])
	{
		System.out.println("Enter\nu:Up\nd:Down\nr:Right\nl:Left\n");
		char ch=(z.next()).charAt(0);
		switch(ch)
		{
			case 'u':return up(a);
			case 'd':return down(a);
			case 'r':return right(a);
			case 'l':return left(a);
		}	
			return -1;
	}
	//to print array
	static void print(int a[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print("\t"+a[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String ar[])
	{
		
		int arr[][]=new int[4][4];
		int x=rand.nextInt(3);
		int y=rand.nextInt(3);
		int i,j;
		arr[x][y]=2;
		while(true)
		{
			i=rand.nextInt(3);
			j=rand.nextInt(3);
			if(i==x && j==y);
			else
				break;
		}
		arr[i][j]=2;
		//printing the array randomly filled at two positions
		print(arr);
		System.out.println();
		//game begins until ends
		while(true)
		{
			int c=choice(arr);
			if(c==0)continue;
			else if(c==2)
			{
				System.out.println("YOU WON");
				break;
			}
			else 
			{
				System.out.println("YOU LOST");
				break;
			}
		}
	}
}

			
		
		
		
