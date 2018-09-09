package ChallengePrograms;
import java.awt.*;
import java.applet.*;

/*
<applet code="AppletBanner" width=300 height=50>
<param name=message value="ArpRocks">
</applet>
*/


public class AppletBanner extends Applet implements Runnable
{
	
	String msg;
	Thread t;
	int state;
	volatile boolean stopFlag;
	
	
	
	public void init()
	{
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
	}
	
	public void start()
	{
			if(msg==null)
			{
				msg="Message not found.";
			}
			
			msg="   "+msg;
			t=new Thread(this);
			stopFlag=false;
			t.start();
	}
	
public void run()
{
	while(true)
	{
		try
		{
			repaint();
			Thread.sleep(250);
			if(stopFlag)
			{
				break;
			}
		}
		catch(InterruptedException e){}
	}
}

	public void stop()
	{
		stopFlag=true;
		t=null;
	}

	public void paint(Graphics g)
	{
		char ch;
	
		ch=msg.charAt(0);
		msg=msg.substring(1, msg.length());
		msg+=ch;
		g.drawString(msg, 50, 100);

	}
		
}

