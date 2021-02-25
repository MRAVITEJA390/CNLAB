import java.lang.*;
import java.util.Scanner;
public class ByteStuffing
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s;
		System.out.println("enter data:");
		s=sc.next();
		OnSender sd=new OnSender();
		sd.sender(s);
	}
}
class OnSender
{
	public void sender(String data)
	{
	for(int i=0;i<data.length();i++)
	{
		if(data.charAt(i)=='f' && i+3<=data.length())
		{
		if(data.substring(i,i+4).equals("flag"))
		{
			data=data.substring(0,i)+"esc"+data.substring(i,data.length());i+=6;
		}
		}	
		else if(data.charAt(i)=='e' &&i+2<=data.length())
		{
			if(data.substring(i,i+3).equals("esc"))
			{
				data=data.substring(0,i)
				+"esc"+data.substring(i,data.length());
				i+=5;
			}
		}
	}
	data="FH"+data+"TF";
	System.out.println("data at sender is:\n"+data);
	OnReceiver r=new OnReceiver();
	r.receiver(data);
	}
}
class OnReceiver
{
	public void receiver(String data)
	{
		data=data.substring(2,data.length()-2);
		for(int i=0;i<data.length();i++)
		{
			if(data.charAt(i)=='e' && data.length()>i+6 ||data.charAt(i)=='e' && data.length()>i+5)
			{
				if(data.substring(i,i+3).equals(data.substring(i+3,i+6)))
				{
					data=data.substring(0,i)
					+data.substring(i+3,data.length());
					i+=2;
				}
				else if(data.substring(i+3,i+7).equals("flag"))
				{
					data=data.substring(0,i)
					+data.substring(i+3,data.length());
					i+=3;
				}
			}
		}
		System.out.println("data at receiver is:\n"+data);
	}
}