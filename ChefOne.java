package pbj;


public class ChefOne implements Runnable{
	private Table table;
	
	public ChefOne(Table table) {
		this.table = table;
	}
	
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName() + " is ready to make sandwich.");
			table.chefOneEat();
				 
            try {
                Thread.sleep(1000); // change to 100 to see difference
            } catch (InterruptedException e) {}
		}
	}

}
