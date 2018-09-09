package appletPackage;
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
	
	public void init(String msg)
	{
		this.msg=msg;
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		start();
	}
	
	public void start()
	{
			
			if(msg==null)
			{
				msg="Message not found.";
			}
			t=new Thread(this);
			t.start();
	}
	
public void run()
{
		try
		{
			repaint();
			Thread.sleep(250);
		}
		catch(InterruptedException e){}
}

	public void paint(Graphics g)
	{
		g.drawString(msg, 50, 100);
	}
		
}

