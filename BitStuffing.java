import java.lang.*;
import java.util.Scanner;
public class BitStuffing
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s,delli;
		System.out.println("enter data:");
		s=sc.next();
		System.out.println("enter dellimeter:");
		delli=sc.next();
		BitStuffingSender bs=new BitStuffingSender();
		bs.sender(s,delli);
	}
}
class BitStuffingSender
{
	void sender(String data,String delli)
	{
		int dl=delli.length();
		String temp;
		if(delli.charAt(dl-1)=='0')
		{
			temp=delli.substring(0,dl-1)+"10";
		}
		else
		{
			temp=delli.substring(0,dl-1)+"01";
		}
		for(int i=0;i<data.length()-dl-1;i++)
		{
			String data1=data.substring(i,i+dl);
			if(data1.equals(delli))
			{
				data=data.substring(0,i)
				+temp+data.substring(i+dl,data.length());
				i+=dl;
			}
		}
		System.out.println("data at sender is:"+data);
		BitStuffingReceiver br=new BitStuffingReceiver();
		br.receiver(data,temp);
	}
}
class BitStuffingReceiver
{
	void receiver(String data,String delli)
	{
		int dl=delli.length(),tl;
		String temp;
		temp=delli.substring(0,dl-2)+delli.substring(delli.length()-1,delli.length());
		tl=temp.length();
		for(int i=0;i<data.length()-dl-1;i++)
		{
			String data1=data.substring(i,i+dl);
			if(data1.equals(delli))
			{
				data=data.substring(0,i)+temp+data.substring(i+dl,data.length());
				i+=tl;
				i--;
			}
		}
		System.out.println("data at receiver is:"+data);
	}
}