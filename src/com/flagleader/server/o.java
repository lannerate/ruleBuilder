package com.flagleader.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

class o extends a
{
  protected BufferedReader e = new BufferedReader(new InputStreamReader(this.a.getInputStream(), "UTF-8"));
  protected PrintWriter f = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.a.getOutputStream(), "UTF-8")), true);

  public o(Socket paramSocket, String paramString)
  {
    super(paramSocket, paramString);
    start();
  }

  public void run()
  {
    try
    {
      while ((!this.c) && (!RuleServer.a))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        String str;
        while (true)
        {
          str = this.e.readLine();
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
              break;
            }
            if ((str.equals("SHUTDOWNALL")) || (str.equals("SHUTDOWNALL\r\n")))
            {
              RuleServer.e();
              break;
            }
            this.f.println(a(str));
            this.f.println("END");
            this.f.flush();
          }
          else
          {
            if (str.equals("SHUTDOWN"))
            {
              this.c = true;
              break;
            }
            this.f.println(a(str));
            this.f.println("END");
            this.f.flush();
          }
        }
        else
        {
          if ((this.f.checkError()) || (this.e.read() == -1))
            break;
          sleep(10L);
        }
      }
      if (this.c)
        this.a.setSoLinger(true, 0);
      this.e.close();
      this.f.close();
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
 * Qualified Name:     com.flagleader.server.o
 * JD-Core Version:    0.6.0
 */