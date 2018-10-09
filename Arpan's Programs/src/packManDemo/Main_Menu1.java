package packManDemo;

import javax.swing.border.EmptyBorder;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;

public class Main_Menu1 implements LineListener
{
	private static final long serialVersionUID = 1L;
	
	static boolean Soundflag=true; //to alternatively play two different menu musics
	
	 public void update(LineEvent event)  // Detects an event on Line(sound playing)
	 {
         if (event.getType() == LineEvent.Type.STOP) //If the sound playing has stopped
         {
        	 this.playMenuMusic();       	 //play next sound
         }
	 }
	
	void playMenuMusic()
	{	
		String path="";
		if(Soundflag)
		{
			path="sounds/MainMenuMusic1.wav";
			Soundflag=false;
		}
		else
		{
			path="sounds/MainMenuMusic2.wav";
			Soundflag=true;
		}
		
		Clip clip=null;

		try {
		      File file = new File(path);
		      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		      clip = AudioSystem.getClip();
		      clip.open(stream);
		      clip.start();
		      stream.close();
		 
		    } catch (Exception ex) {
		      System.out.println(ex.getMessage());
		    }
		
		clip.addLineListener(this);
		
	}
	

	public static void main(String[] args)
    {
		
		  Main_Menu1 ob=new Main_Menu1();
		
		  ob.playMenuMusic();

          JFrame frame=new JFrame();
 		
          frame.setResizable(false);
	
          frame.setSize(1200,790);
  		
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          frame.setTitle("Main Menu");  
          
          JLabel background=new JLabel(new ImageIcon("Images/MainMenuBackground1.png"));
          
          background.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200))); //Set location of label
          
          background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS)); //Use Box Layout to order buttons vertically
          
          JButton button_NewGame = new JButton("New Game");
          
          JButton button_LevelSelect = new JButton("Level Select");
          
          JButton button_Multiplayer = new JButton("Multiplayer");
          
          JButton button_Leaderboards = new JButton("Leaderboards");
          
          JButton button_Credits = new JButton("Credits");
           
          JButton button_Exit = new JButton("Exit");
                    
          
          //Mouse click event
          
          button_NewGame.addActionListener(new ActionListener() 
          {
        		      public void actionPerformed(ActionEvent arg0) 
        		      {
        		        //On click do this
        		      }
        		      
          });
          
          button_LevelSelect.addActionListener(new ActionListener() 
          {
      		      public void actionPerformed(ActionEvent arg0) 
      		      {
      		        //On click do this
      		      }
      		      
      	  });
          
          button_Multiplayer.addActionListener(new ActionListener() 
          {
      		      public void actionPerformed(ActionEvent arg0) 
      		      {
      		        //On click do this
      		      }
      		      
      	  });
          
          button_Leaderboards.addActionListener(new ActionListener() 
          {
  		      public void actionPerformed(ActionEvent arg0) 
  		      {
  		        //On click do this
  		      }
  		      
          });
          
          button_Credits.addActionListener(new ActionListener() 
          {
  		      public void actionPerformed(ActionEvent arg0) 
  		      {
  		        //On click do this
  		      }
  		      
          });
   
          button_Exit.addActionListener(new ActionListener() 
          {
  		      public void actionPerformed(ActionEvent arg0) 
  		      {
  		        //On click do this
  		      }
  		      
          });
          
          
          //Mouse hover event
          
          button_NewGame.addMouseListener(new java.awt.event.MouseAdapter()
          {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) 
        	    {
        	    	try {
        			      File file = new File("sounds/Button Hover.wav");
        			      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
        			      Clip clip = AudioSystem.getClip();
        			      clip.open(stream);
        			      clip.start();
        			      stream.close();
        			 
        			    } catch (Exception ex) {
        			      System.out.println(ex.getMessage());
        			    }
        	    	
        	    	
        	    	button_NewGame.setBackground(Color.WHITE);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	    	button_NewGame.setBackground(UIManager.getColor("control"));
        	    }
        	});
          
          button_LevelSelect.addMouseListener(new java.awt.event.MouseAdapter()
          {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) 
        	    {
        	    	try {
        			      File file = new File("sounds/Button Hover.wav");
        			      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
        			      Clip clip = AudioSystem.getClip();
        			      clip.open(stream);
        			      clip.start();
        			      stream.close();
        			 
        			    } catch (Exception ex) {
        			      System.out.println(ex.getMessage());
        			    }
        	    	
        	    	
        	    	button_LevelSelect.setBackground(Color.WHITE);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	    	button_LevelSelect.setBackground(UIManager.getColor("control"));
        	    }
        	});
          
          
          button_Multiplayer.addMouseListener(new java.awt.event.MouseAdapter()
          {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) 
        	    {
        	    	try {
        			      File file = new File("sounds/Button Hover.wav");
        			      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
        			      Clip clip = AudioSystem.getClip();
        			      clip.open(stream);
        			      clip.start();
        			      stream.close();
        			 
        			    } catch (Exception ex) {
        			      System.out.println(ex.getMessage());
        			    }
        	    	
        	    	
        	    	button_Multiplayer.setBackground(Color.WHITE);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	    	button_Multiplayer.setBackground(UIManager.getColor("control"));
        	    }
        	});
          
          button_Leaderboards.addMouseListener(new java.awt.event.MouseAdapter()
          {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) 
        	    {
        	    	try {
        			      File file = new File("sounds/Button Hover.wav");
        			      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
        			      Clip clip = AudioSystem.getClip();
        			      clip.open(stream);
        			      clip.start();
        			      stream.close();
        			 
        			    } catch (Exception ex) {
        			      System.out.println(ex.getMessage());
        			    }
        	    	
        	    	
        	    	button_Leaderboards.setBackground(Color.WHITE);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	    	button_Leaderboards.setBackground(UIManager.getColor("control"));
        	    }
        	});
          
          button_Credits.addMouseListener(new java.awt.event.MouseAdapter()
          {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) 
        	    {
        	    	try {
        			      File file = new File("sounds/Button Hover.wav");
        			      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
        			      Clip clip = AudioSystem.getClip();
        			      clip.open(stream);
        			      clip.start();
        			      stream.close();
        			 
        			    } catch (Exception ex) {
        			      System.out.println(ex.getMessage());
        			    }
        	    	
        	    	
        	    	button_Credits.setBackground(Color.WHITE);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	    	button_Credits.setBackground(UIManager.getColor("control"));
        	    }
        	});
          
          button_Exit.addMouseListener(new java.awt.event.MouseAdapter()
          {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) 
        	    {
        	    	try {
        			      File file = new File("sounds/Button Hover.wav");
        			      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
        			      Clip clip = AudioSystem.getClip();
        			      clip.open(stream);
        			      clip.start();
        			      stream.close();
        			 
        			    } catch (Exception ex) {
        			      System.out.println(ex.getMessage());
        			    }
        	    	
        	    	
        	    	button_Exit.setBackground(Color.WHITE);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	    	button_Exit.setBackground(UIManager.getColor("control"));
        	    }
        	});
          
          button_NewGame.setFont(button_NewGame.getFont().deriveFont(Font.BOLD, 20)); //Set button size by changing fonts
          
          button_LevelSelect.setFont(button_NewGame.getFont().deriveFont(Font.BOLD, 20));
          
          button_Multiplayer.setFont(button_NewGame.getFont().deriveFont(Font.BOLD, 20));
          
          button_Leaderboards.setFont(button_NewGame.getFont().deriveFont(Font.BOLD, 20));
          
          button_Credits.setFont(button_NewGame.getFont().deriveFont(Font.BOLD, 20));
          
          button_Exit.setFont(button_NewGame.getFont().deriveFont(Font.BOLD, 20));
          
          
          
          
          
          button_NewGame.setAlignmentX(Component.CENTER_ALIGNMENT); //Set button alignment to center
          
          button_LevelSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
          
          button_Multiplayer.setAlignmentX(Component.CENTER_ALIGNMENT);
          
          button_Leaderboards.setAlignmentX(Component.CENTER_ALIGNMENT);
          
          button_Credits.setAlignmentX(Component.CENTER_ALIGNMENT);
          
          button_Exit.setAlignmentX(Component.CENTER_ALIGNMENT);
             
          background.add(button_NewGame);
          
          background.add(Box.createRigidArea(new Dimension(0, 60)));  //Add an invisible component to create a vertical spacing between two adjacent buttons in the panel
         
          background.add(button_LevelSelect);
          
          background.add(Box.createRigidArea(new Dimension(0, 60)));
          
          background.add(button_Multiplayer);
          
          background.add(Box.createRigidArea(new Dimension(0, 60)));
          
          background.add(button_Leaderboards);
          
          background.add(Box.createRigidArea(new Dimension(0, 60)));
          
          background.add(button_Credits);
          
          background.add(Box.createRigidArea(new Dimension(0, 60)));
          
          background.add(button_Exit);
       
          frame.add(background);

          frame.setVisible(true);
          
    }
	
	static void animationPath()
	{
		int maze[][]=new int[1000][800];
		
		maze[480][560]=1;
		maze[480][600]=1;
		maze[480][520]=1;
		maze[360][520]=1;
		maze[400][520]=1;
		maze[440][520]=1;
		maze[520][520]=1;
		maze[560][520]=1;
		maze[600][520]=1;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

