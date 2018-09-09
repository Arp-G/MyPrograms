package ChallengePrograms;
import java .io.*;

public class MutiThreadDemo
{
    public static void main(String args[])
    {
        MyThread obj=new MyThread();
    }
}


class MyThread implements Runnable
{
  int n;
  MyThread()
  {
    n=30;
    Thread t=new Thread(this,"Demo");
    t.start();
  }
  
  public void run()
  {
    for(int i=1;i<=n;i++)
    {
      System.out.println(i);
      try
      {
        Thread.sleep(100);
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
  }
}