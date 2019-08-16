package session8;


public class ticketResThread extends Thread {
	Bus b;
	String[] names;
	String [] tn;
	int toBook;
	int numBooked;
	public ticketResThread(Bus b,int numBooked,int toBook,String []tn) {
		this.tn=tn;
		this.b=b;
		this.numBooked=numBooked;
		this.toBook=toBook;
	}
	synchronized int reserveTix(int num,String [] tNames) {
		names=new String[num];
		if(b.getNumLeft()>=num) {
			b.setNumLeft(b.getNumLeft()-num);
		}
		else {
			System.out.println("Can't reserve tickets");
			return 0;
		}
		names=tNames;
		return num;
	}
	public void run() {
		numBooked+=reserveTix(toBook,tn);
	}
}
