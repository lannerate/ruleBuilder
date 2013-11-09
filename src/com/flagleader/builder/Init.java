package com.flagleader.builder;

import com.flagleader.a.a.r;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import org.apache.commons.lang.SystemUtils;

public class Init
{
  public static void a()
  {
    File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "cpuid.dll");
    localFile.getParentFile().mkdirs();
    if (!localFile.exists())
      try
      {
        FileUtil.writeFile(localFile.getAbsolutePath(), r.b(b()));
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
  }

  public static String b()
  {
    String str;
    if (c().startsWith("windows"))
      str = e();
    else
      str = d();
    if (str == null)
      str = System.getProperty("os.name");
    return str;
  }

  public static String c()
  {
    return System.getProperty("os.name").toLowerCase();
  }

  public static String d()
  {
    String str1 = null;
    BufferedReader localBufferedReader = null;
    Process localProcess = null;
    try
    {
      localProcess = Runtime.getRuntime().exec("ifconfig eth0");
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      String str2 = null;
      int i = -1;
      while ((str2 = localBufferedReader.readLine()) != null)
      {
        i = str2.toLowerCase().indexOf("hwaddr");
        if (i < 0)
          continue;
        str1 = str2.substring(i + "hwaddr".length() + 1).trim();
        break;
      }
    }
    catch (IOException localIOException1)
    {
      localIOException1.printStackTrace();
    }
    finally
    {
      try
      {
        if (localBufferedReader != null)
          localBufferedReader.close();
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
      }
      localBufferedReader = null;
      localProcess = null;
    }
    return str1;
  }

  public static String e()
  {
    String str1 = null;
    BufferedReader localBufferedReader = null;
    Process localProcess = null;
    label155: 
    try
    {
      localProcess = Runtime.getRuntime().exec("ipconfig /all");
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      String str2 = null;
      int i = -1;
      while ((str2 = localBufferedReader.readLine()) != null)
      {
        i = str2.toLowerCase().indexOf("physical address");
        if (i < 0)
          continue;
        i = str2.indexOf(":");
        if (i < 0)
          break;
        str1 = str2.substring(i + 1).trim();
        break label155;
      }
    }
    catch (IOException localIOException1)
    {
      localIOException1.printStackTrace();
    }
    finally
    {
      try
      {
        if (localBufferedReader != null)
          localBufferedReader.close();
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
      }
      localBufferedReader = null;
      localProcess = null;
    }
    return str1;
  }

  public static void main(String[] paramArrayOfString)
  {
    String str1 = c();
    System.out.println(str1);
    String str2;
    if (str1.startsWith("windows"))
    {
      str2 = b();
      System.out.println(str2);
    }
    else
    {
      str2 = d();
      System.out.println(str2);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.Init
 * JD-Core Version:    0.6.0
 */