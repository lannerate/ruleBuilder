package com.flagleader.repository.a;

import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.impl.RuleContextContainer;
import com.flagleader.engine.impl.XmlRuleSetFile;
import com.flagleader.repository.d.a;
import com.flagleader.repository.d.u;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.util.loader.ToolsClassLoader;
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
import org.apache.commons.lang.SystemUtils;

public class c
{
  private ClassLoader a = RuleEngineFactory.getInstance("").getClassLoader();
  private static String b = u.a("error.text");
  private File c;
  private File d;
  private File e;
  private File f;

  public String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    String str1 = null;
    RuleContextContainer localRuleContextContainer = null;
    this.f = new File(XmlRuleSetFile.classFileName(paramString1, paramString3 + a(paramString4))).getParentFile();
    this.c = new File(this.f, paramString5 + ".java");
    this.d = new File(this.f, paramString5 + ".class");
    this.e = new File(this.f, XmlRuleSetFile.containerName(new StringBuilder(String.valueOf(paramString3)).append(a(paramString4)).toString()) + ".rsc");
    try
    {
      a(paramString6, this.c);
      str1 = a(this.c, paramString2);
      if (str1 != null)
      {
        if ((paramBoolean) && (this.c.exists()))
          this.c.delete();
        String str2 = str1;
        return str2;
      }
      localRuleContextContainer = new RuleContextContainer(a(this.d));
      a(localRuleContextContainer, this.e);
      localRuleContextContainer.setLastModified(this.e.lastModified());
      try
      {
        if ((paramString4 != null) && (paramString4.length() > 0))
          FileUtil.copy(this.e, new File(this.f, XmlRuleSetFile.containerName(paramString3) + ".rsc"), true);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    catch (RuleEngineException localRuleEngineException)
    {
      throw localRuleEngineException;
    }
    finally
    {
      if (paramBoolean)
      {
        if (this.c.exists())
          this.c.delete();
        if (this.d.exists())
          this.d.delete();
      }
    }
    if (paramBoolean)
    {
      if (this.c.exists())
        this.c.delete();
      if (this.d.exists())
        this.d.delete();
    }
    return str1;
  }

  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    return StringUtil.replace(".", "_", paramString);
  }

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
      throw new RuleEngineException(112, new Object[] { paramFile.getPath() }, localIOException);
    }
  }

  public synchronized String a(File paramFile, String paramString)
  {
    String str1 = paramString;
    String[] arrayOfString = a.d();
    if (arrayOfString != null)
      for (int i = 0; i < arrayOfString.length; i++)
        str1 = str1 + StringUtil.classPathAdd() + arrayOfString[i];
    if (Property.getInstance().getRuleEngineJarsDir().length() > 0)
      str1 = str1 + StringUtil.classPathAdd() + Property.getInstance().getRuleEngineJarsDir();
    if (Property.getInstance().getDynamicClassDir().length() > 0)
      str1 = str1 + StringUtil.classPathAdd() + Property.getInstance().getDynamicClassDir();
    if ((str1.indexOf("engine.jar") < 0) && (new File(SystemUtils.JAVA_IO_TMPDIR, "engine.jar").exists()))
      str1 = str1 + StringUtil.classPathAdd() + SystemUtils.JAVA_IO_TMPDIR + File.separator + "engine.jar";
    String str2 = System.getProperty("rules.compiler");
    if ((str2 == null) || (str1.length() == 0))
    {
      Class localClass = null;
      try
      {
        localClass = this.a.loadClass("sun.tools.javac.Main");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        try
        {
          if (localClass == null)
            localClass = Class.forName("sun.tools.javac.Main");
        }
        catch (Exception localException2)
        {
        }
      }
      try
      {
        if (localClass == null)
          localClass = ToolsClassLoader.getInstance(this.a).loadClass("sun.tools.javac.Main");
        if (localClass == null)
          str2 = "javac";
      }
      catch (Exception localException1)
      {
        str2 = "javac";
      }
    }
    if ((str2 == null) || (str1.length() == 0))
      return b(paramFile, str1);
    return a(paramFile, str1, str2);
  }

  protected String b(File paramFile, String paramString)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramFile.getPath();
    arrayOfString[1] = "-classpath";
    arrayOfString[2] = paramString;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Class localClass = null;
    try
    {
      localClass = this.a.loadClass("sun.tools.javac.Main");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      try
      {
        if (localClass == null)
          localClass = Class.forName("sun.tools.javac.Main");
      }
      catch (Exception localException2)
      {
      }
    }
    try
    {
      if (localClass == null)
        localClass = ToolsClassLoader.getInstance(this.a).loadClass("sun.tools.javac.Main");
      Constructor localConstructor = localClass.getConstructor(new Class[] { OutputStream.class, String.class });
      Method localMethod = localClass.getMethod("compile", new Class[] { [Ljava.lang.String.class });
      Object localObject = localConstructor.newInstance(new Object[] { localByteArrayOutputStream, arrayOfString[0] });
      localMethod.invoke(localObject, new Object[] { arrayOfString });
    }
    catch (Exception localException1)
    {
      throw new RuleEngineException(110, new Object[] { paramFile }, localException1);
    }
    if ((localByteArrayOutputStream.toString().indexOf("error") != -1) || (localByteArrayOutputStream.toString().indexOf(b) != -1))
      return paramString.toString() + "\n" + localByteArrayOutputStream.toString();
    return null;
  }

  protected static String a(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_4
    //   1: anewarray 44	java/lang/String
    //   4: astore_3
    //   5: aload_3
    //   6: iconst_0
    //   7: aload_2
    //   8: aastore
    //   9: aload_3
    //   10: iconst_1
    //   11: ldc 3
    //   13: aastore
    //   14: aload_3
    //   15: iconst_2
    //   16: aload_1
    //   17: aastore
    //   18: aload_3
    //   19: iconst_3
    //   20: aload_0
    //   21: invokevirtual 94	java/io/File:getPath	()Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 120	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   28: aload_3
    //   29: invokevirtual 119	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   32: astore 4
    //   34: aload 4
    //   36: invokevirtual 118	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   39: astore 5
    //   41: new 28	java/io/ByteArrayOutputStream
    //   44: dup
    //   45: invokespecial 82	java/io/ByteArrayOutputStream:<init>	()V
    //   48: astore 6
    //   50: sipush 1024
    //   53: newarray byte
    //   55: astore 7
    //   57: iconst_0
    //   58: istore 8
    //   60: aload 5
    //   62: aload 7
    //   64: invokevirtual 107	java/io/InputStream:read	([B)I
    //   67: istore 8
    //   69: iload 8
    //   71: ifle +13 -> 84
    //   74: aload 6
    //   76: aload 7
    //   78: iconst_0
    //   79: iload 8
    //   81: invokevirtual 87	java/io/ByteArrayOutputStream:write	([BII)V
    //   84: iload 8
    //   86: ifge -26 -> 60
    //   89: aload 6
    //   91: invokevirtual 86	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   94: ldc 11
    //   96: invokevirtual 121	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   99: iconst_m1
    //   100: if_icmpne +18 -> 118
    //   103: aload 6
    //   105: invokevirtual 86	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   108: getstatic 51	com/flagleader/repository/a/c:b	Ljava/lang/String;
    //   111: invokevirtual 121	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   114: iconst_m1
    //   115: if_icmpeq +34 -> 149
    //   118: new 45	java/lang/StringBuilder
    //   121: dup
    //   122: aload_1
    //   123: invokevirtual 123	java/lang/String:toString	()Ljava/lang/String;
    //   126: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: ldc 2
    //   134: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 6
    //   139: invokevirtual 86	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   142: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: areturn
    //   149: aconst_null
    //   150: areturn
    //   151: astore 4
    //   153: new 18	com/flagleader/engine/RuleEngineException
    //   156: dup
    //   157: bipush 110
    //   159: iconst_1
    //   160: anewarray 41	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: invokevirtual 94	java/io/File:getPath	()Ljava/lang/String;
    //   169: aastore
    //   170: aload 4
    //   172: invokespecial 61	com/flagleader/engine/RuleEngineException:<init>	(I[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   175: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	148	151	java/io/IOException
  }

  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: new 30	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 28	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 82	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_2
    //   17: sipush 10000
    //   20: newarray byte
    //   22: astore_3
    //   23: iconst_0
    //   24: istore 4
    //   26: goto +11 -> 37
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: iload 4
    //   34: invokevirtual 87	java/io/ByteArrayOutputStream:write	([BII)V
    //   37: aload_1
    //   38: aload_3
    //   39: invokevirtual 99	java/io/FileInputStream:read	([B)I
    //   42: dup
    //   43: istore 4
    //   45: ifgt -16 -> 29
    //   48: aload_2
    //   49: invokevirtual 84	java/io/ByteArrayOutputStream:flush	()V
    //   52: aload_2
    //   53: invokevirtual 83	java/io/ByteArrayOutputStream:close	()V
    //   56: aload_1
    //   57: invokevirtual 98	java/io/FileInputStream:close	()V
    //   60: aload_2
    //   61: invokevirtual 85	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: astore_3
    //   65: aload_3
    //   66: areturn
    //   67: astore_1
    //   68: new 18	com/flagleader/engine/RuleEngineException
    //   71: dup
    //   72: bipush 111
    //   74: iconst_1
    //   75: anewarray 41	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: invokevirtual 94	java/io/File:getPath	()Ljava/lang/String;
    //   84: aastore
    //   85: aload_1
    //   86: invokespecial 61	com/flagleader/engine/RuleEngineException:<init>	(I[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   89: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	66	67	java/lang/Exception
  }

  public static void a(Object paramObject, File paramFile)
  {
    try
    {
      if (paramFile.exists())
        paramFile.delete();
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
      throw new RuleEngineException(113, new Object[] { paramFile.getPath() }, localIOException);
    }
  }

  public File a()
  {
    return this.c;
  }

  public File b()
  {
    return this.d;
  }

  public File c()
  {
    return this.e;
  }

  public File d()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.a.c
 * JD-Core Version:    0.6.0
 */