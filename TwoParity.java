import java.lang.*;
import java.util.Scanner;
public class TwoParity
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter rows:");
		int num=sc.nextInt();
		String s[]=new String[num];
		for(int i=0;i<num;i++)
		{
			System.out.println("enter data:");
			s[i]=sc.next();
		}
		AtSender sen=new AtSender();
		sen.sender(s);
	}
}
class AtSender
{
	public void sender(String s[])
	{
		int check;
		//calculating row data wise
		int rowparity=0,ones=0;
		for(int i=0;i<s.length;i++)
		{
			ones=0;
			for(int j=0;j<s[i].length();j++)
			{
				if(s[i].charAt(j)=='1')
				{
					ones+=1;
				}
			}
			if(ones%2!=0)
			{
				rowparity+=1;
			}
		}
		//calculating column data wise
		int colparity=0,colones=0;
		for(int i=0;i<s[0].length();i++)
		{
			colones=0;
			for(int j=0;j<s.length;j++)
			{
				if(s[j].charAt(i)=='1')
				{
					colones+=1;
				}
			}
			if(colones%2!=0)
			{
				colparity+=1;
			}
		}
		if(colparity%2==0 && rowparity%2==0)
		{
			check=0;
		}
		else if(colparity%2!=0 && rowparity%2!=0)
		{
			check=1;
		}
		else
		{
			check=2;
		}
		AtReceiver rec=new AtReceiver();
		rec.receiver(s,check);
	}
}
class AtReceiver
{
	public void receiver(String s[],int abc)
	{
		int check;
		//calculating row data wise
		int rowparity=0,ones=0;
		for(int i=0;i<s.length;i++)
		{
			ones=0;
			for(int j=0;j<s[i].length();j++)
			{
				if(s[i].charAt(j)=='1')
				{
					ones+=1;
				}
			}
			if(ones%2!=0)
			{
				rowparity+=1;
			}
		}
		//calculating column data wise
		int colparity=0,colones=0;
		for(int i=0;i<s[0].length();i++)
		{
			colones=0;
			for(int j=0;j<s.length;j++)
			{
				if(s[j].charAt(i)=='1')
				{
					colones+=1;
				}
			}
			if(colones%2!=0)
			{
				colparity+=1;
			}
		}
		if(colparity%2==0 && rowparity%2==0)
		{
			check=0;
		}
		else if(colparity%2!=0 && rowparity%2!=0)
		{
			check=1;
		}
		else
		{
			check=2;
		}
		if(check==abc)
		{
			System.out.println("no error:");
		}
		else
		{
			System.out.println("error");
		}
	}
}