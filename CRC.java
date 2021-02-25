import java.lang.*;
import java.util.Scanner;
public class CRC
{
	public static void main(String args[])
	{
		String m,mdup,n,crc="";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter m:");
		m=sc.next();
		mdup=m;
		System.out.println("enter n:");
		n=sc.next();
		for(int i=1;i<=n.length()-1;i++)
		{
			crc+="0";
		}
		m+=crc;
		//calculating original crc
		for(int i=0;i<mdup.length();i++)
		{
			if(m.charAt(i)=='1')
			{
				for(int j=i;j<i+n.length();j++)
				{
					if(m.charAt(j)==n.charAt(j-i))
					{
						m=m.substring(0,j)+"0"+m.substring(j+1,m.length());
					}
					else
					{
						m=m.substring(0,j)+"1"+m.substring(j+1,m.length());
					}
				}
			}
			System.out.println(m);
		}
		crc=m.substring(m.length()-3,m.length());
		AtReceiver rec=new AtReceiver();
		rec.receiver(n,mdup,crc);
	}
}
class AtReceiver
{
	void receiver(String n,String m,String crc)
	{
		String mdup=m,check="";
		m+=crc;
		for(int i=1;i<=crc.length();i++)
		{
			check+="0";
		}
		//calculating original crc
		for(int i=0;i<mdup.length();i++)
		{
			if(m.charAt(i)=='1')
			{
				for(int j=i;j<i+n.length();j++)
				{
					if(m.charAt(j)==n.charAt(j-i))
					{
						m=m.substring(0,j)+"0"+m.substring(j+1,m.length());
					}
					else
					{
						m=m.substring(0,j)+"1"+m.substring(j+1,m.length());
					}
				}
			}
		}
		crc=m.substring(m.length()-3,m.length());
		if(crc.equals(check))
		{
			System.out.println("no error");
		}
		else
		{
			System.out.println("error");
		}
	}
}