package session8;

public class ReserveTicketsMain {
	volatile static int remainingTix;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bus g=new Bus(10,10,"Green");
		Bus r=new Bus(20,20,"Red");
		int bookedSeats=0;
		ticketResThread t1=new ticketResThread(g,bookedSeats,2,new String[]{"abv","aaa"});
		ticketResThread t2=new ticketResThread(g,bookedSeats,1, new String[]{"lo"});
		ticketResThread t3=new ticketResThread(r,bookedSeats,1,new String[]{"tl"});
		ticketResThread t4=new ticketResThread(r,bookedSeats,3,new String[]{"def","ghi","lmn"});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		
		System.out.println((g.getMax()-g.getNumLeft())+" tickets purchased on the "+g.getRouteName()+" line");
		System.out.println((r.getMax()-r.getNumLeft())+" tickets purchased on the "+r.getRouteName()+" line");
		
	}

}
