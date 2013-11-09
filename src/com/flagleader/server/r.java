package com.flagleader.server;

import com.flagleader.engine.MessageUtil;
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

class r extends Thread
{
  private Socket a;
  private String b;
  private boolean c = false;
  private BufferedReader d;
  private PrintWriter e;

  public r(Socket paramSocket, String paramString)
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
      while ((!this.c) && (!RuleThreadServer.a))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        String str;
        while (true)
        {
          str = this.d.readLine();
          if (str == null)
            break;
          if (str.equals("END"))
          {
            if (!localStringBuffer.toString().equals("TEST"))
              break;
            localStringBuffer.setLength(0);
            continue;
          }
          localStringBuffer.append(str);
        }
        if (localStringBuffer.length() > 0)
        {
          str = localStringBuffer.toString();
          if (this.a.getInetAddress().getHostAddress().equals("127.0.0.1"))
          {
            if (str.equals("SHUTDOWN"))
            {
              this.c = true;
            }
            else if ((str.equals("SHUTDOWNALL")) || (str.equals("SHUTDOWNALL\r\n")))
            {
              RuleThreadServer.f();
            }
            else
            {
              this.e.println(a(str));
              this.e.println("END");
            }
          }
          else if (str.equals("SHUTDOWN"))
          {
            this.c = true;
          }
          else
          {
            this.e.println(a(str));
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
 * Qualified Name:     com.flagleader.server.r
 * JD-Core Version:    0.6.0
 */