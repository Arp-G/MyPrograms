package ChallengePrograms;

public class AnimalKingdom
{
	public static void main(String args[])
	{
		
	
	Animal node1=new Animal("Mammals",100);
	
	Animal node2=new Animal("Herbivours",75);
	
	Animal node3=new Animal("Carnivour",80);
	
	Animal node4=new Animal("Goat",20);
	
	Animal node5=new Animal("Elephant",65);
	
	Animal node6=new Animal("Cat",50);
	
	Animal node7=new Animal("Tiger",45);
	
	Animal node8=new Animal("Lion",40);
	
	Animal node9=new Animal("Snake",35);
	
	Animal node10=new Animal("Rattle Snake",15);
	
	Animal node11=new Animal("Boa",18);
	
	node1.LeftChild = node2;
	
	node1.RightChild = node3;
	
	node2.LeftChild = node4;
	
	node2.RightChild = node5;
	
	node3.LeftChild = node6;
	
	node3.RightChild = node9;
	
	node6.LeftChild = node7;
	
	node6.RightChild = node8;
	
	node9.LeftChild = node10;
	
	node9.RightChild = node11;
	
	Tree_Builder<Animal> obj=new Tree_Builder<Animal>();
	
	obj.startBuild(node1);
}
	
}

class Animal implements Drawable<Animal>
{
	Animal LeftChild;
	
	Animal RightChild;
	
	String Name="";
	
	int LifeSpan=0;
	
	int count=0;
	
	Animal(String Name,int LifeSpan)
	{
		this.Name=Name;
		
		this.LifeSpan=LifeSpan;
	}
	
	public Animal GetLeftChild()
	{
		return LeftChild;
	}
	
	public Animal GetRightChild()
	{
		return RightChild;
	}
	
	public String Print()
	{
		return this.Name+" -- "+this.LifeSpan;
	}
	
	public void setCount(int count)
	{
		this.count=count;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public Animal SetLeftChild()
	{
		Animal tmp=new Animal("BAD ANIMAL",0);
		
		this.LeftChild=tmp;
		
		return tmp;
	}
	
	public Animal SetRightChild()
	{
		Animal tmp=new Animal("BAD ANIMAL",0);
		
		this.RightChild=tmp;
		
		return tmp;
	}
	
	public boolean IsRedundant()
	{
		if(this.Name.equals("BAD ANIMAL") && this.LifeSpan==0) return true;
		else return false;
	}
	
	
}