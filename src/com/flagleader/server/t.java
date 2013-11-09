package com.flagleader.server;

import com.flagleader.util.EncryptTransfer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

class t extends a
{
  protected BufferedReader e = new BufferedReader(new InputStreamReader(this.a.getInputStream(), "UTF-8"));
  protected PrintWriter f = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.a.getOutputStream(), "UTF-8")), true);

  public t(Socket paramSocket, String paramString)
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
        int i = 0;
        while (true)
        {
          String str1 = this.e.readLine();
          if (str1 == null)
            break;
          if (str1.equals("END"))
          {
            localStringBuffer.delete(localStringBuffer.length() - 2, localStringBuffer.length());
            if (!localStringBuffer.toString().equals("TEST"))
              break;
            localStringBuffer.setLength(0);
            i = 1;
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
          else if (ServerProperty.a().e() == 2)
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
              this.f.println(a(str2));
            else if (ServerProperty.a().e() == 2)
              this.f.println(EncryptTransfer.zip(a(str2)));
            else
              this.f.println(EncryptTransfer.encryptZip(a(str2)));
            this.f.println("END");
            this.f.flush();
          }
          else
          {
            if (str2.equals("SHUTDOWN"))
            {
              this.c = true;
              break;
            }
            if (bool)
              this.f.println(a(str2));
            else if (ServerProperty.a().e() == 2)
              this.f.println(EncryptTransfer.zip(a(str2)));
            else
              this.f.println(EncryptTransfer.encryptZip(a(str2)));
            this.f.println("END");
            this.f.flush();
          }
        }
        else
        {
          if ((this.f.checkError()) || (this.e.read() == -1))
            break;
          sleep(5L);
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
 * Qualified Name:     com.flagleader.server.t
 * JD-Core Version:    0.6.0
 */