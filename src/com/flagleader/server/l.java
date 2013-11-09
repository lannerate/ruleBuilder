package com.flagleader.server;

import com.flagleader.util.EncryptTransfer;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

class l extends a
{
  protected InputStream e = new DataInputStream(new BufferedInputStream(this.a.getInputStream()));
  protected OutputStream f = new DataOutputStream(this.a.getOutputStream());

  public l(Socket paramSocket, String paramString)
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
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] arrayOfByte = new byte[1024];
        int i = 0;
        int j = 0;
        while ((i = this.e.read(arrayOfByte)) != -1)
        {
          j += i;
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
          if (i != 1024)
            break;
          localByteArrayOutputStream.write(-1);
        }
        if (j > 0)
        {
          String str = EncryptTransfer.unZipByte(localByteArrayOutputStream.toByteArray());
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
            if (str.equals("TEST"))
            {
              this.f.flush();
            }
            else
            {
              this.f.write(EncryptTransfer.zipByte(a(str)));
              this.f.flush();
            }
          }
          else
          {
            if (str.equals("SHUTDOWN"))
            {
              this.c = true;
              break;
            }
            if (str.equals("TEST"))
            {
              this.f.flush();
            }
            else
            {
              this.f.write(EncryptTransfer.zipByte(a(str)));
              this.f.flush();
            }
          }
        }
        else
        {
          if ((this.a.isInputShutdown()) || (this.a.isOutputShutdown()))
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
 * Qualified Name:     com.flagleader.server.l
 * JD-Core Version:    0.6.0
 */