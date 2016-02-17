package pbj;

public class test {

public static void main(String[] args)
{
    Thread agent,chefOne,chefTwo,chefThree;
   
    Table table = new Table();
	
    agent = new Thread(new Agent(table),"Agent");
    chefOne = new Thread(new ChefOne(table),"Chef one");
    chefTwo = new Thread(new ChefTwo(table),"Chef two");
    chefThree = new Thread(new ChefThree(table),"Chef three");
    agent.start();
    chefOne.start();
    chefTwo.start();
    chefThree.start();
}

}
