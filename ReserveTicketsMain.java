package session8;

public class ReserveTicketsMain {
	volatile static int remainingTix;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bus g=new Bus(10,10,"Green");
		Bus r=new Bus(20,20,"Red");
		int bookedSeats=0;
		ticketResThread t1=new ticketResThread(g,bookedSeats);
		ticketResThread t2=new ticketResThread(g,bookedSeats);
		ticketResThread t3=new ticketResThread(r,bookedSeats);
		ticketResThread t4=new ticketResThread(r,bookedSeats);
		t1.start();
		
		
		
		synchronized(t1) {
			try {
				t1.wait();
				t2.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized(t2) {
			try {
				t2.wait();
				t3.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized(t3) {
			try {
				t3.wait();
				t4.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized(t4) {
			try {
				t4.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println((g.getMax()-g.getNumLeft())+" tickets purchased on the "+g.getRouteName()+" line");
		System.out.println((r.getMax()-r.getNumLeft())+" tickets purchased on the "+r.getRouteName()+" line");
		
	}

}
