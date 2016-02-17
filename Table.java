package pbj;


public class Table { 
    private boolean bread = false;
    private boolean penutButter = false;
    private boolean jam = false;
    private boolean chefOneCanEat = false;
    private boolean chefTwoCanEat = false;
    private boolean chefThreeCanEat = false;
    private String ingredientName = null;
    private int count =0;
    
    //@param integer corresponding to the ingredient specified by the agent
    public synchronized void feed(Object i){
    	while(hasContents()|| count == 20){
    		try{
    			wait();
    		}
    		catch(InterruptedException e){
    			return;
    		}
    	}
    		
    		placeIngredients((int)i);
    		System.out.println(Thread.currentThread().getName() + " has placed " + ingredientName +" on the table");
    	if(hasContents()){
    		notifyAll();
    		}
    }
    
    public synchronized void chefOneEat(){
    	 while (!hasContents()|| !chefOneCanEat) {
             try {
                 wait();
             } catch (InterruptedException e) {
                 return;
             }
         }
    	 System.out.println("Chef one made and ate a sandwich");
    	 System.out.println("End of iteration: " + count++ + "\n");
    	 clearTable();
         notifyAll();  
    }
    
    public synchronized void chefTwoEat(){
    	while (!hasContents()|| !chefTwoCanEat) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
	   	 System.out.println("Chef two made and ate a sandwich");
    	 System.out.println("End of iteration: " + count+++ "\n");
	   	 clearTable();
	     notifyAll(); 
    }
    
    public synchronized void chefThreeEat(){
    	while (!hasContents()|| !chefThreeCanEat) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
	   	 System.out.println("Chef three made and ate a sandwich");
    	 System.out.println("End of iteration: " + count++ + "\n");

	   	 clearTable();
	     notifyAll(); 
    }
    

    private boolean hasContents(){
    	if(bread&&penutButter){
    		chefOneCanEat = true;
    		return true;
    	}
    	if(bread&&jam){
    		chefTwoCanEat = true;
    		return true;
    	}
    	if(penutButter&&jam){
    		chefThreeCanEat = true;
    		return true;
    	}
    	return false;	
    }
    
    //matches the int with the  ingredient and checks if an input is valid. 
    private boolean placeIngredients(int i){
    	if(i==1){
    		bread = true;
    		ingredientName = "Bread";
    		return true;
    	}
    	if(i==2){
    		penutButter = true;
    		ingredientName = " Penut Butter";
    		return true;
    	}
    	if(i==3){
    		jam = true;
    		ingredientName = "Jam";
    		return true;
    	}
    	return false;
    }
    private void clearTable(){
    	bread = false;
    	penutButter = false;
    	jam = false;
    	
    	chefOneCanEat = false;
    	chefTwoCanEat = false;
    	chefThreeCanEat = false;
    } 
    
		
}
