package com.flagleader.repository.a;

import com.flagleader.export.ExportAction;
import com.flagleader.repository.d.u;
import com.flagleader.util.RuleClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.List;

public class b
{
  private static String a = u.a("error.text");

  public static void a(String paramString, File paramFile)
  {
    try
    {
      if (paramFile.getParentFile() != null)
        paramFile.getParentFile().mkdirs();
      FileWriter localFileWriter = new FileWriter(paramFile);
      localFileWriter.write(paramString);
      localFileWriter.flush();
      localFileWriter.close();
    }
    catch (IOException localIOException)
    {
      throw new a("Error saving expressions class file : " + paramFile, localIOException);
    }
  }

  public String a(String paramString, File paramFile, ClassLoader paramClassLoader)
  {
    String str1 = "";
    if ((ExportAction.class.getClassLoader() instanceof URLClassLoader))
    {
      localObject = ((URLClassLoader)ExportAction.class.getClassLoader()).getURLs();
      for (i = 0; i < localObject.length; i++)
        str1 = str1 + URLDecoder.decode(localObject[i].getFile()) + ";";
    }
    else
    {
      str1 = System.getProperty("java.class.path");
    }
    Object localObject = RuleClassLoader.getInstance(paramString).getLoaderDirs();
    for (int i = 0; i < ((List)localObject).size(); i++)
      str1 = str1 + ";" + ((List)localObject).get(i);
    String str2 = System.getProperty("rules.compiler");
    if ((str2 == null) || (str2.length() == 0))
      try
      {
        Class localClass = null;
        if (paramClassLoader != null)
          localClass = new RuleClassLoader(paramClassLoader).loadClass("sun.tools.javac.Main");
        else
          localClass = RuleClassLoader.getInstance(paramString).loadClass("sun.tools.javac.Main");
        if (localClass == null)
          str2 = "javac";
      }
      catch (Exception localException)
      {
        str2 = "javac";
      }
    if ((str2 == null) || (str1.length() == 0))
      return a(paramString, paramFile, str1, paramClassLoader);
    return (String)a(paramFile, str1, str2);
  }

  protected String a(String paramString1, File paramFile, String paramString2, ClassLoader paramClassLoader)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramFile.getPath();
    arrayOfString[1] = "-classpath";
    arrayOfString[2] = paramString2;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      Class localClass = null;
      if (paramClassLoader != null)
        localClass = new RuleClassLoader(paramClassLoader).loadClass("sun.tools.javac.Main");
      else
        localClass = RuleClassLoader.getInstance(paramString1).loadClass("sun.tools.javac.Main");
      Constructor localConstructor = localClass.getConstructor(new Class[] { OutputStream.class, String.class });
      Method localMethod = localClass.getMethod("compile", new Class[] { [Ljava.lang.String.class });
      Object localObject = localConstructor.newInstance(new Object[] { localByteArrayOutputStream, arrayOfString[0] });
      localMethod.invoke(localObject, new Object[] { arrayOfString });
    }
    catch (Exception localException)
    {
      throw new a("error compiling report java source file : " + paramFile, localException);
    }
    if ((localByteArrayOutputStream.toString().indexOf("error") != -1) || (localByteArrayOutputStream.toString().indexOf(a) != -1))
      return localByteArrayOutputStream.toString();
    return null;
  }

  protected String a(File paramFile, String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = paramString2;
    arrayOfString[1] = "-classpath";
    arrayOfString[2] = paramString1;
    arrayOfString[3] = paramFile.getPath();
    try
    {
      Process localProcess = Runtime.getRuntime().exec(arrayOfString);
      InputStream localInputStream = localProcess.getErrorStream();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      int i = 0;
      do
      {
        i = localInputStream.read(arrayOfByte);
        if (i <= 0)
          continue;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      while (i >= 0);
      if ((localByteArrayOutputStream.toString().indexOf("error") != -1) || (localByteArrayOutputStream.toString().indexOf(a) != -1))
        return localByteArrayOutputStream.toString();
      return null;
    }
    catch (Exception localException)
    {
    }
    throw new a("Error compiling report java source file : " + paramFile, localException);
  }

  protected static byte[] a(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[10000];
      int i = 0;
      while ((i = localFileInputStream.read(arrayOfByte)) > 0)
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      localFileInputStream.close();
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
    }
    throw new a("Error reading class byte codes from compiled class file : " + paramFile, localException);
  }

  public static void a(Object paramObject, File paramFile)
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localFileOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localFileOutputStream.flush();
      localFileOutputStream.close();
    }
    catch (IOException localIOException)
    {
      throw new a("Error saving file : " + paramFile, localIOException);
    }
  }

  public static boolean a(String paramString)
  {
    return (paramString.endsWith(".jav")) || (paramString.endsWith(".java"));
  }

  public static boolean b(String paramString)
  {
    return paramString.endsWith(".jsp");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.a.b
 * JD-Core Version:    0.6.0
 */