import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TestConnect
{
  public static void main(String[] paramArrayOfString)
  {
    try
    {
      Socket localSocket = new Socket(InetAddress.getByName("127.0.0.1"), 1508);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localSocket.getInputStream()));
      PrintWriter localPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(localSocket.getOutputStream())), true);
      int i = 0;
      while (i++ < 5)
      {
        System.out.println(i + ".isClosed():" + localSocket.isClosed());
        System.out.println(i + ".isOutputShutdown():" + localSocket.isOutputShutdown());
        System.out.println(i + ".checkError():" + localPrintWriter.checkError());
        if ((!localSocket.isClosed()) && (localSocket.isConnected()))
          System.out.println(i + "处于连接状态!");
        else
          System.out.println(i + "处于非连接状态!");
        localPrintWriter.println("TEST");
        localPrintWriter.println("END");
        Thread.currentThread();
        Thread.sleep(1000L);
      }
      localBufferedReader.close();
      localPrintWriter.close();
      Thread.currentThread();
      Thread.sleep(1000L);
      System.out.println(i + ".isClosed():" + localSocket.isClosed());
      System.out.println(i + ".isOutputShutdown():" + localSocket.isOutputShutdown());
      System.out.println(i + ".checkError():" + localPrintWriter.checkError());
      if ((!localSocket.isClosed()) && (localSocket.isConnected()))
        System.out.println(i + "处于连接状态!");
      else
        System.out.println(i + "处于非连接状态!");
      localSocket.close();
      System.out.println(i + ".isClosed():" + localSocket.isClosed());
      System.out.println(i + ".isOutputShutdown():" + localSocket.isOutputShutdown());
      System.out.println(i + ".checkError():" + localPrintWriter.checkError());
      if ((!localSocket.isClosed()) && (localSocket.isConnected()))
        System.out.println(i + "处于连接状态!");
      else
        System.out.println(i + "处于非连接状态!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     TestConnect
 * JD-Core Version:    0.6.0
 */