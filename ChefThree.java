package pbj;

public class ChefThree implements Runnable{
	private Table table;
	
	public ChefThree(Table table) {
		this.table = table;
	}
	

	public void run() {
		while(true){
		System.out.println(Thread.currentThread().getName() + " is ready to make sandwich.");
		table.chefThreeEat();
			 
        try {
            Thread.sleep(1000); // change to 100 to see difference
        } catch (InterruptedException e) {}
		}
	}

}
