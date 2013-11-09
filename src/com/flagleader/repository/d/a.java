package com.flagleader.repository.d;

import com.flagleader.engine.Property;
import com.flagleader.repository.collections.k;
import com.flagleader.repository.n;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class a extends URLClassLoader
{
  protected List a = new ArrayList();
  private a b;

  public a()
  {
    super(new URL[0]);
    this.b = null;
    a();
  }

  protected void a()
  {
    if (new File(Property.getInstance().getRuleEngineClassDir()).exists())
      a("", new File(Property.getInstance().getRuleEngineClassDir()).listFiles());
    this.a.add("java.util.Date");
    this.a.add("java.util.ArrayList");
    this.a.add("java.util.Vector");
    this.a.add("java.util.HashMap");
    this.a.add("java.util.Hashtable");
    this.a.add("java.util.StringTokenizer");
    this.a.add("java.util.Stack");
    this.a.add("java.util.Set");
    this.a.add("java.util.Random");
    this.a.add("java.util.Iterator");
    this.a.add("java.util.HashSet");
    this.a.add("java.util.Enumeration");
    this.a.add("java.util.Calendar");
    this.a.add("java.text.SimpleDateFormat");
    this.a.add("java.text.regex.Pattern");
    this.a.add("java.text.regex.Matcher");
    this.a.add("java.lang.Boolean");
    this.a.add("java.lang.Byte");
    this.a.add("java.lang.Character");
    this.a.add("java.lang.Class");
    this.a.add("java.lang.Double");
    this.a.add("java.lang.Float");
    this.a.add("java.lang.Integer");
    this.a.add("java.lang.Long");
    this.a.add("java.lang.Math");
    this.a.add("java.lang.Number");
    this.a.add("java.lang.Short");
    this.a.add("java.lang.String");
    this.a.add("java.lang.StringBuffer");
    this.a.add("java.lang.System");
    this.a.add("java.io.File");
    this.a.add("java.io.RandomAccessFile");
    this.a.add("java.net.URLDecoder");
    this.a.add("java.net.URLEncoder");
    this.a.add("sun.misc.BASE64Decoder");
    this.a.add("sun.misc.BASE64Encoder");
    if (new File(FileUtil.getCurrentDir(), "lib").exists())
    {
      try
      {
        a(new File(FileUtil.getCurrentDir(), "lib" + File.separator + "engine.jar"));
        a(new File(FileUtil.getCurrentDir(), "lib" + File.separator + "flservlet.jar"));
        a(new File(FileUtil.getCurrentDir(), "lib" + File.separator + "servlet-api.jar"));
        a(new File(FileUtil.getCurrentDir(), "lib" + File.separator + "common.jar"));
      }
      catch (Exception localException)
      {
      }
    }
    else
    {
      this.a.add("com.flagleader.util.StringUtil");
      this.a.add("com.flagleader.util.DateUtil");
      this.a.add("com.flagleader.util.NumberUtil");
      this.a.add("com.flagleader.util.UUID");
      this.a.add("com.flagleader.util.filesystem.FileUtil");
      this.a.add("com.flagleader.util.ListUtil");
      this.a.add("com.flagleader.util.Decrypt");
      this.a.add("com.flagleader.util.Encrypt");
      this.a.add("com.flagleader.util.ListResult");
      this.a.add("com.flagleader.util.JspUtil");
      this.a.add("com.flagleader.util.MD5");
      this.a.add("com.flagleader.db.DBFactory");
      this.a.add("com.flagleader.db.Database");
      this.a.add("com.flagleader.db.Table");
      this.a.add("com.flagleader.db.View");
      this.a.add("com.flagleader.db.Select");
      this.a.add("com.flagleader.db.Procedure");
      this.a.add("com.flagleader.xml.XmlFactory");
      this.a.add("com.flagleader.xml.Node");
      this.a.add("com.flagleader.engine.Property");
      this.a.add("com.flagleader.engine.RuleEngineFactory");
      this.a.add("com.flagleader.engine.RuleEngine");
    }
  }

  public a(a parama)
  {
    super(new URL[0], parama);
    this.b = parama;
  }

  public void a(File paramFile)
  {
    if (b(paramFile))
      return;
    addURL(paramFile.toURL());
    if (paramFile.isDirectory())
      a("", paramFile.listFiles());
    else
      try
      {
        ZipFile localZipFile = new ZipFile(paramFile);
        Enumeration localEnumeration = localZipFile.entries();
        while (localEnumeration.hasMoreElements())
        {
          ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
          String str = localZipEntry.getName();
          if (!str.endsWith(".class"))
            continue;
          this.a.add(str.replace('/', '.').substring(0, str.length() - 6));
        }
      }
      catch (Exception localException)
      {
        n.a().a(localException.getMessage());
      }
  }

  private void a(String paramString, File[] paramArrayOfFile)
  {
    for (int i = 0; i < paramArrayOfFile.length; i++)
      if (paramArrayOfFile[i].isDirectory())
      {
        a(paramString + paramArrayOfFile[i].getName() + ".", paramArrayOfFile[i].listFiles());
      }
      else
      {
        if (!paramArrayOfFile[i].getName().endsWith(".class"))
          continue;
        this.a.add(paramString + paramArrayOfFile[i].getName().substring(0, paramArrayOfFile[i].getName().length() - 6));
      }
  }

  public void a(File[] paramArrayOfFile)
  {
    if ((paramArrayOfFile == null) || (paramArrayOfFile.length == 0))
      return;
    for (int i = 0; i < paramArrayOfFile.length; i++)
    {
      String str = paramArrayOfFile[i].getName();
      str = str.toLowerCase();
      if ((!paramArrayOfFile[i].exists()) || ((!paramArrayOfFile[i].isDirectory()) && (!str.endsWith(".jar")) && (!str.endsWith(".zip"))))
        continue;
      try
      {
        a(paramArrayOfFile[i]);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        n.a().a("Malformed url adding '" + paramArrayOfFile[i] + "'");
      }
    }
  }

  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return;
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      File localFile = new File(paramArrayOfString[i]);
      if ((!localFile.exists()) || ((!localFile.isDirectory()) && (!paramArrayOfString[i].endsWith(".jar")) && (!paramArrayOfString[i].endsWith(".zip"))))
        continue;
      try
      {
        a(localFile);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        n.a().a("Malformed url adding '" + paramArrayOfString[i] + "'");
      }
    }
  }

  private boolean b(File paramFile)
  {
    URL[] arrayOfURL = getURLs();
    if ((this.b != null) && (this.b.b(paramFile)))
      return true;
    for (int i = 0; i < arrayOfURL.length; i++)
      if (arrayOfURL[i].equals(paramFile.toURL()))
        return true;
    return false;
  }

  public a b()
  {
    return this.b;
  }

  public Iterator c()
  {
    if (this.b != null)
      return new k(this.a.iterator(), this.b.c());
    return this.a.iterator();
  }

  public static final String[] d()
  {
    File localFile = new File(FileUtil.getCurrentDir(), "userlib");
    if (localFile.exists())
    {
      File[] arrayOfFile = localFile.listFiles();
      String[] arrayOfString = new String[arrayOfFile.length];
      for (int i = 0; i < arrayOfString.length; i++)
        arrayOfString[i] = arrayOfFile[i].getPath();
      return arrayOfString;
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.a
 * JD-Core Version:    0.6.0
 */