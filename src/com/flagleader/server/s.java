package com.flagleader.server;

import com.flagleader.engine.MessageUtil;
import com.flagleader.util.EncryptTransfer;
import com.flagleader.xml.XMLReceiveBean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class s extends Thread
{
  private Socket a;
  private String b;
  private boolean c = false;
  private BufferedReader d;
  private PrintWriter e;

  public s(Socket paramSocket, String paramString)
  {
    this.a = paramSocket;
    this.d = new BufferedReader(new InputStreamReader(this.a.getInputStream()));
    this.e = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.a.getOutputStream())), true);
    this.b = paramString;
    start();
  }

  public String a(String paramString)
  {
    XMLReceiveBean localXMLReceiveBean2;
    try
    {
      XMLReceiveBean localXMLReceiveBean1 = new XMLReceiveBean(paramString);
      RuleThreadServer.d.executeReceive(new k(localXMLReceiveBean1, this.b));
      localXMLReceiveBean2 = new XMLReceiveBean();
      localXMLReceiveBean2.setSuccessInfo("received");
      if (ServerProperty.a().h() >= 0)
        ServerProperty.a().a(ServerProperty.a(localXMLReceiveBean1), this.b);
      return localXMLReceiveBean2.getContent();
    }
    catch (Throwable localThrowable)
    {
      localXMLReceiveBean2 = new XMLReceiveBean();
      localXMLReceiveBean2.setErrorInfo(localThrowable.getMessage(), localThrowable.getLocalizedMessage());
      String str = MessageUtil.format("rulereceiveerror.text", new String[] { this.b, paramString, localThrowable.getLocalizedMessage() });
      LogFactory.getLog("ruleengine").info(str);
    }
    return localXMLReceiveBean2.getContent();
  }

  public void run()
  {
    try
    {
      while ((!this.c) && (!RuleServer.a))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        while (true)
        {
          String str1 = this.d.readLine();
          if (str1 == null)
            break;
          if (str1.equals("END"))
          {
            localStringBuffer.delete(localStringBuffer.length() - 2, localStringBuffer.length());
            if (!localStringBuffer.toString().equals("TEST"))
              break;
            localStringBuffer.setLength(0);
            continue;
          }
          localStringBuffer.append(str1).append("\r\n");
        }
        if (localStringBuffer.length() > 0)
        {
          boolean bool = localStringBuffer.toString().startsWith("<");
          String str2 = null;
          if ((bool) || (localStringBuffer.toString().startsWith("SHUTDOWN")))
            str2 = localStringBuffer.toString();
          else if (RuleThreadServer.d.getStreamtype() == 2)
            str2 = EncryptTransfer.unZip(localStringBuffer.toString());
          else
            str2 = EncryptTransfer.decryptZip(localStringBuffer.toString());
          if (this.a.getInetAddress().getHostAddress().equals("127.0.0.1"))
          {
            if (str2.equals("SHUTDOWN"))
            {
              this.c = true;
              break;
            }
            if ((str2.equals("SHUTDOWNALL")) || (str2.equals("SHUTDOWNALL\r\n")))
            {
              RuleServer.e();
              break;
            }
            if (bool)
              this.e.println(a(str2));
            else if (RuleThreadServer.d.getStreamtype() == 2)
              this.e.println(EncryptTransfer.zip(a(str2)));
            else
              this.e.println(EncryptTransfer.encryptZip(a(str2)));
            this.e.println("END");
          }
          else
          {
            if (str2.equals("SHUTDOWN"))
            {
              this.c = true;
              break;
            }
            if (bool)
              this.e.println(a(str2));
            else if (RuleThreadServer.d.getStreamtype() == 2)
              this.e.println(EncryptTransfer.zip(a(str2)));
            else
              this.e.println(EncryptTransfer.encryptZip(a(str2)));
            this.e.println("END");
          }
        }
        else
        {
          if ((this.e.checkError()) || (this.d.read() == -1))
            break;
          sleep(10L);
        }
      }
      if (this.c)
        this.a.setSoLinger(true, 0);
      this.d.close();
      this.e.close();
    }
    catch (Exception localException)
    {
      try
      {
        this.a.close();
      }
      catch (IOException localIOException1)
      {
      }
    }
    finally
    {
      try
      {
        this.a.close();
      }
      catch (IOException localIOException2)
      {
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.s
 * JD-Core Version:    0.6.0
 */