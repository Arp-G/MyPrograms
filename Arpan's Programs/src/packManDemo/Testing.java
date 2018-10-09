package packManDemo;

public class Testing 
{
	public static void main(String args[])
	{
		PlayerData tmp=new PlayerData("Test",java.time.LocalDateTime.now().toString());		
		tmp.setScore(10);
		StartingCountDown.control(tmp,1);
	}
}
