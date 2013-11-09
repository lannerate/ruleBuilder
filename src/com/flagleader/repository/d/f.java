package com.flagleader.repository.d;

import com.flagleader.repository.m;
import com.flagleader.util.TempID;
import it.sauronsoftware.ftp4j.FTPClient;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.StringTokenizer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.lang.SystemUtils;

public class f
  implements l
{
  FTPClient a = null;
  private Thread g = null;
  String b;
  int c = 21;
  String d;
  String e;
  boolean f = false;

  public f(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.b = paramString1;
    this.c = paramInt;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramBoolean;
  }

  f()
  {
  }

  public String a(String paramString1, String paramString2)
  {
    String str1 = g();
    if (str1.length() > 0)
      return str1;
    try
    {
      try
      {
        b(paramString1.substring(0, paramString1.lastIndexOf("/")));
      }
      catch (Exception localException1)
      {
      }
      f().d(u.a("upload.ftp", new String[] { paramString1 }));
      String str2 = paramString1 + "." + TempID.newShortTempID() + ".tmp";
      b(paramString2, str2);
      try
      {
        this.a.deleteFile(paramString1);
      }
      catch (Exception localException3)
      {
      }
      this.a.rename(str2, paramString1);
      f().d(u.a("uploadfinish.ftp", new String[] { paramString1 }));
    }
    catch (Exception localException2)
    {
      String str3 = u.a("ftpUploadFile.error", new String[] { localException2.getLocalizedMessage() });
      return str3;
    }
    finally
    {
      a();
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
        this.a.setType(1);
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramString1.getBytes());
        this.a.upload(paramString2, localByteArrayInputStream, 0L, 0L, null);
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
            this.a.disconnect(true);
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
            this.a.setType(2);
          else
            this.a.setType(1);
          FileInputStream localFileInputStream = new FileInputStream(paramFile);
          this.a.upload(paramString, localFileInputStream, 0L, 0L, null);
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
            this.a.disconnect(true);
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
    String str1 = g();
    if (str1.length() > 0)
      return str1;
    try
    {
      try
      {
        b(paramString.substring(0, paramString.lastIndexOf("/")));
      }
      catch (Exception localException1)
      {
      }
      f().d(u.a("upload.ftp", new String[] { paramString }));
      String str2 = paramString + "." + TempID.newShortTempID() + ".tmp";
      a(paramFile, str2, paramBoolean);
      try
      {
        this.a.deleteFile(paramString);
      }
      catch (Exception localException3)
      {
      }
      this.a.rename(str2, paramString);
      f().d(u.a("uploadfinish.ftp", new String[] { paramString }));
    }
    catch (Exception localException2)
    {
      String str3 = u.a("ftpUploadFile.error", new String[] { localException2.getLocalizedMessage() });
      return str3;
    }
    finally
    {
      a();
    }
    return "";
  }

  private boolean a(String paramString)
  {
    try
    {
      Date localDate = this.a.modifiedDate(paramString);
      return (localDate != null) && (localDate.getTime() > 0L);
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private void b(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, "/");
    String str = "";
    if (this.a == null)
      g();
    while (localStringTokenizer.hasMoreTokens())
    {
      str = str + "/" + localStringTokenizer.nextToken();
      try
      {
        if ((str.length() <= 1) || (a(str)))
          continue;
        this.a.createDirectory(str);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }

  private String g()
  {
    if ((this.a != null) && (this.a.isConnected()))
      try
      {
        this.a.sendCustomCommand("PWD");
        return "";
      }
      catch (Exception localException1)
      {
        a();
        this.a = null;
      }
    this.a = new FTPClient();
    this.a.setCharset(SystemUtils.FILE_ENCODING);
    this.a.addCommunicationListener(new g(this));
    try
    {
      if (!this.f)
      {
        this.a.connect(this.b, this.c);
      }
      else
      {
        X509TrustManager[] arrayOfX509TrustManager = { new h(this) };
        SSLContext localSSLContext = null;
        try
        {
          localSSLContext = SSLContext.getInstance("SSL");
          localSSLContext.init(null, arrayOfX509TrustManager, new SecureRandom());
          SSLSocketFactory localSSLSocketFactory = localSSLContext.getSocketFactory();
          this.a.setSSLSocketFactory(localSSLSocketFactory);
          this.a.setSecurity(1);
        }
        catch (KeyManagementException localKeyManagementException)
        {
          localKeyManagementException.printStackTrace();
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          localNoSuchAlgorithmException.printStackTrace();
        }
        this.a.connect(this.b, this.c);
      }
    }
    catch (Exception localException2)
    {
      if ((this.a != null) && (this.a.isConnected()))
        try
        {
          this.a.disconnect(true);
        }
        catch (Exception localException4)
        {
        }
      return u.a("ftpNet.error");
    }
    try
    {
      this.a.login(this.d, this.e);
    }
    catch (Exception localException3)
    {
      return u.a("ftp.error", new String[] { localException3.getMessage() });
    }
    return "";
  }

  public void a()
  {
    if ((this.a != null) && (this.a.isConnected()))
      try
      {
        this.a.disconnect(true);
        this.a = null;
      }
      catch (Exception localException)
      {
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
        this.a.sendCustomCommand("PWD");
      }
      catch (Exception localException)
      {
        a();
        this.a = null;
      }
  }

  public boolean e()
  {
    return this.a == null;
  }

  protected com.flagleader.repository.h f()
  {
    return m.a().j();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.f
 * JD-Core Version:    0.6.0
 */