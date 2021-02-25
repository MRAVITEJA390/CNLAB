import java.lang.*;
import java.util.Scanner;
public class SingleParity
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter parity bits:");
		String s=sc.next();
		AtSender sen=new AtSender();
		sen.sender(s);
	}
}
class AtSender
{
	void sender(String data)
	{
		String parity;
		int count=0;
		for(int i=0;i<data.length();i++)
		{
			if(data.charAt(i)=='1')count++;
		}
		if(count%2==0)
		{
			parity="0";
		}
		else
		{
			parity="1";
		}
		data=data+parity;
		System.out.println("data at sender:"+data);
		AtReceiver r=new AtReceiver();
		r.receiver(data);
	}
}
class AtReceiver
{
	void receiver(String data)
	{
		int count=0,i;
		String parity;
		for(i=0;i<data.length()-1;i++)
		{
			if(data.charAt(i)=='1')count++;
		}
		if(count%2==0)
		{
			parity="0";
		}
		else
		{
			parity="1";
		}
		if(parity.equals(data.substring(i,i+1)))
		{
			System.out.println("no error");
		}
		else
		{
			System.out.println("error");
		}
	}
}