package pbj;

import java.util.*;

public class Agent implements Runnable{

private Set<Integer> selected; //to make sure two like ingredients are not placed on the table
private Table table;

public Agent(Table table){
	this.table = table;
	selected = new HashSet<Integer>();
}

//Selects two different ingredients randomly and places them in the selected set
private void selectIngredients(){
	while(selected.size()<3){
	 int select = 1 + (int)(Math.random() * 3);  //chooses a random number between 1-3
	 selected.add(select);
	}
	 
}

public void run() {
	for(int j = 1; j<=20;j++){ //places ingredients on the table 20 times
		selectIngredients();
		for(int i:selected){
		 table.feed(i);
		}
		
	}
	
}



}
