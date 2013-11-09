package com.flagleader.manager.e;

import com.flagleader.engine.RuleServiceException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class g
{
  URLConnection a = null;
  String b;

  public g(String paramString)
  {
    this.b = paramString;
  }

  public String a()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public String b(String paramString)
  {
    try
    {
      URLConnection localURLConnection = c();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localURLConnection.getOutputStream());
      byte[] arrayOfByte = paramString.getBytes();
      localGZIPOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      localGZIPOutputStream.close();
      StringBuffer localStringBuffer = new StringBuffer();
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(new BufferedInputStream(localURLConnection.getInputStream()));
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localGZIPInputStream));
      for (String str1 = localBufferedReader.readLine(); str1 != null; str1 = localBufferedReader.readLine())
        localStringBuffer.append(str1);
      localGZIPInputStream.close();
      localBufferedReader.close();
      String str2 = localStringBuffer.toString();
      return str2;
    }
    catch (Exception localException)
    {
      throw new RuleServiceException(localException);
    }
    finally
    {
      b();
    }
    throw localObject;
  }

  public void b()
  {
    try
    {
      this.a.getInputStream().close();
      this.a.getOutputStream().close();
    }
    catch (Exception localException)
    {
    }
  }

  public URLConnection c()
  {
    try
    {
      URL localURL = new URL(this.b);
      URLConnection localURLConnection = localURL.openConnection();
      localURLConnection.setDoInput(true);
      localURLConnection.setDoOutput(true);
      localURLConnection.setUseCaches(true);
      localURLConnection.setDefaultUseCaches(false);
      return localURLConnection;
    }
    catch (Exception localException)
    {
    }
    throw new RuleServiceException(localException);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.g
 * JD-Core Version:    0.6.0
 */