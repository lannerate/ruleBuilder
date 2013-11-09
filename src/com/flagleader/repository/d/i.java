package com.flagleader.repository.d;

import com.flagleader.repository.h;
import com.flagleader.repository.m;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.StringTokenizer;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;

public class i
  implements l
{
  FTPClient a = null;
  private Thread g = null;
  String b;
  int c = 21;
  String d;
  String e;
  boolean f = false;

  public i(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.b = paramString1;
    this.c = paramInt;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramBoolean;
  }

  i()
  {
  }

  public String a(String paramString1, String paramString2)
  {
    String str = g();
    if (str.length() > 0)
      return str;
    try
    {
      try
      {
        a(paramString1.substring(0, paramString1.lastIndexOf("/")));
      }
      catch (Exception localException1)
      {
      }
      f().d(u.a("upload.ftp", new String[] { paramString1 }));
      b(paramString2, paramString1);
      this.a.stat(paramString1);
      f().d(u.a("uploadfinish.ftp", new String[] { paramString1 }));
    }
    catch (Exception localException2)
    {
      return u.a("ftpUploadFile.error", new String[] { localException2.getLocalizedMessage() });
    }
    return "";
  }

  private boolean b(String paramString1, String paramString2)
  {
    int i = 0;
    int j = 0;
    while (j < 5)
      try
      {
        this.a.setFileType(0);
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramString1.getBytes());
        this.a.storeFile(paramString2, localByteArrayInputStream);
        localByteArrayInputStream.close();
        return true;
      }
      catch (Throwable localThrowable1)
      {
        i = 0;
        if (j >= 4)
          throw new k(localThrowable1);
        if ((this.a != null) && (this.a.isConnected()))
        {
          try
          {
            this.a.disconnect();
          }
          catch (Throwable localThrowable2)
          {
          }
          this.a = null;
        }
        try
        {
          Thread.currentThread();
          Thread.sleep(30000L);
        }
        catch (Exception localException)
        {
        }
        g();
        j++;
      }
    return false;
  }

  private boolean a(File paramFile, String paramString, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    while (j < 5)
      try
      {
        if (paramFile.exists())
        {
          if (paramBoolean)
            this.a.setFileType(2);
          else
            this.a.setFileType(0);
          FileInputStream localFileInputStream = new FileInputStream(paramFile);
          this.a.storeFile(paramString, localFileInputStream);
          localFileInputStream.close();
          return true;
        }
      }
      catch (Throwable localThrowable1)
      {
        if (!paramFile.exists())
          return false;
        i = 0;
        if (j >= 4)
          throw new k(localThrowable1);
        if ((this.a != null) && (this.a.isConnected()))
        {
          try
          {
            this.a.disconnect();
          }
          catch (Throwable localThrowable2)
          {
          }
          this.a = null;
        }
        try
        {
          Thread.currentThread();
          Thread.sleep(30000L);
        }
        catch (Exception localException)
        {
        }
        g();
        j++;
      }
    return false;
  }

  public String a(String paramString, File paramFile, boolean paramBoolean)
  {
    String str = g();
    if (str.length() > 0)
      return str;
    try
    {
      try
      {
        a(paramString.substring(0, paramString.lastIndexOf("/")));
      }
      catch (Exception localException1)
      {
      }
      f().d(u.a("upload.ftp", new String[] { paramString }));
      a(paramFile, paramString, paramBoolean);
      this.a.stat(paramString);
      f().d(u.a("uploadfinish.ftp", new String[] { paramString }));
    }
    catch (Exception localException2)
    {
      return u.a("ftpUploadFile.error", new String[] { localException2.getLocalizedMessage() });
    }
    return "";
  }

  private void a(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "/");
    String str = "";
    while (localStringTokenizer.hasMoreTokens())
    {
      str = str + "/" + localStringTokenizer.nextToken();
      try
      {
        if (str.length() <= 1)
          continue;
        this.a.makeDirectory(str);
      }
      catch (FTPConnectionClosedException localFTPConnectionClosedException)
      {
        g();
      }
      catch (IOException localIOException)
      {
      }
    }
  }

  private String g()
  {
    if ((this.a != null) && (this.a.isConnected()))
      try
      {
        this.a.pwd();
        return "";
      }
      catch (Exception localException)
      {
        a();
        this.a = null;
      }
    this.a = new FTPClient();
    this.a.setControlEncoding(SystemUtils.FILE_ENCODING);
    this.a.addProtocolCommandListener(new j(this));
    try
    {
      f().d(u.a("connect.ftp", new String[] { this.b }));
      if (this.c == 21)
        this.a.connect(this.b);
      else
        this.a.connect(this.b, this.c);
      int i = this.a.getReplyCode();
      if (!FTPReply.isPositiveCompletion(i))
      {
        this.a.disconnect();
        return u.a("ftpReject.error");
      }
    }
    catch (SocketException localSocketException)
    {
      if (this.a.isConnected())
        try
        {
          this.a.disconnect();
        }
        catch (IOException localIOException3)
        {
        }
      return u.a("ftpNet.error");
    }
    catch (IOException localIOException1)
    {
      if (this.a.isConnected())
        try
        {
          this.a.disconnect();
        }
        catch (IOException localIOException4)
        {
        }
      return u.a("ftpConnection.error");
    }
    try
    {
      f().d(u.a("login.ftp", new String[] { this.d }));
      if (!this.a.login(this.d, this.e))
      {
        this.a.logout();
        return u.a("ftpUser.error");
      }
    }
    catch (IOException localIOException2)
    {
      return u.a("ftp.error", new String[] { localIOException2.getMessage() });
    }
    return "";
  }

  public void a()
  {
    if ((this.a != null) && (this.a.isConnected()))
    {
      try
      {
        if (this.g != null)
          this.g.interrupt();
      }
      catch (Exception localException)
      {
      }
      try
      {
        this.a.disconnect();
      }
      catch (IOException localIOException)
      {
      }
    }
  }

  public Thread b()
  {
    return this.g;
  }

  public void a(Thread paramThread)
  {
    this.g = paramThread;
  }

  public synchronized boolean c()
  {
    return this.g != null;
  }

  public void d()
  {
    if ((this.a != null) && (this.a.isConnected()))
      try
      {
        this.a.stat();
      }
      catch (IOException localIOException)
      {
        a();
        this.a = null;
      }
  }

  public boolean e()
  {
    return this.a == null;
  }

  protected h f()
  {
    return m.a().j();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.i
 * JD-Core Version:    0.6.0
 */