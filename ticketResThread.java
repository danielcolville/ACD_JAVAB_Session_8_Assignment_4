package session8;

import java.util.Scanner;

public class ticketResThread extends Thread {
	Bus b;
	String[] names;
	int numBooked;
	public ticketResThread(Bus b,int numBooked) {
		this.b=b;
		this.numBooked=numBooked;
	}
	synchronized int reserveTix(int num,Scanner sc) {
		names=new String[num];
		if(b.getNumLeft()>=num) {
			b.setNumLeft(b.getNumLeft()-num);
		}
		else {
			System.out.println("Can't reserve tickets");
			return 0;
		}
		for(int i=0;i<num;i++) {
			System.out.println("Enter name for next ticket:");
			names[i]=sc.next();
		}
		return num;
	}
	public void run() {
		Scanner sc=new Scanner(System.in);
		
			
		synchronized(this) {
			System.out.println("How many tickets do you want?");
			
			int num=sc.nextInt();
		
			numBooked+=reserveTix(num,sc);
			notify();
		}
		
	}
}
