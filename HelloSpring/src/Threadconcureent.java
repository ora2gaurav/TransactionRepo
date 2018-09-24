
class Threadcls{
	int i;
	Integer chance;
	Threadcls(int i,int chnace){this.i=i;this.chance=chnace;}
	public void printzero() throws InterruptedException
	{   while(true){
		synchronized(this)
		{
		
		while(chance!=1)
		  wait();
		System.out.println("0");
		chance=chance==2?3:2;
		notifyAll();
		}
	}
		}
	public void printodd() throws InterruptedException
	{      while(true){
		synchronized(this)
		{
		while(chance!=2)
		  wait();
		System.out.println(i+1);
		i++;
		chance=1;
		notifyAll();
		}
	}
		}
	public void printeven() throws InterruptedException
	{      while(true){
		synchronized(this)
		{
		while(chance!=3)
		  wait();
		System.out.println(i+1);
		i++;
		chance=1;
		notifyAll();
		}
	}
		}
	
	
}
class threademo extends Thread{
	public void run() {
		System.out.println("HI THEONLN");
	}
}

public class Threadconcureent {

	
	public static void main(String[] args) throws InterruptedException {
	  
		threademo tq=new threademo();
		tq.start();
		Thread.currentThread().join();
	/*	final Threadcls  th=new Threadcls(0,1);
	    
	    
		Thread t1=new Thread(new Runnable(){
			public void run ()
			{ try{
				th.printzero();
				}
			
			catch(Exception e){e.printStackTrace();}
				
			}
			
		});
		
		Thread t2=new Thread(new Runnable(){
			public void run ()
			{
				try{
					th.printodd();
					}
				
				catch(Exception e){e.printStackTrace();}
					
			}
			
		});
		Thread t3=new Thread(new Runnable(){
			
			public void run ()
			{
				try{
					th.printeven();
					}
				
				catch(Exception e){e.printStackTrace();}
					
			}
			
		});
		
		t1.run();t2.start();t3.start();
	t1.join();*/
	}

}
