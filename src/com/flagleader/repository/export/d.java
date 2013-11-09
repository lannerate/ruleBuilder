package com.flagleader.repository.export;

import com.flagleader.export.ExportAction;
import com.flagleader.export.PagePropertyPool;
import com.flagleader.repository.a.a;
import com.flagleader.repository.a.b;
import com.flagleader.repository.h;
import com.flagleader.repository.m;
import com.flagleader.util.JspUtil;
import com.flagleader.util.RuleClassLoader;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TempID;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang.SystemUtils;

public abstract class d
{
  private static final String i = "<?";
  private static final String j = "?>";
  public static final String a = FileUtil.newline;
  protected String b = "";
  protected String c = "";
  private String k = SystemUtils.JAVA_IO_TMPDIR;
  protected StringBuffer d = null;
  private StringBuffer l = null;
  protected HashMap e = new HashMap();
  protected HashMap f = new HashMap();
  protected HashMap g = new HashMap();
  b h = new b();

  private void n()
  {
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.c = "";
    this.b = "";
  }

  private void a(StringBuffer paramStringBuffer)
  {
    int m = paramStringBuffer.indexOf("<?");
    for (int n = paramStringBuffer.indexOf("?>", m + 2); (m >= 0) && (n > m); n = paramStringBuffer.indexOf("?>", m + 2))
    {
      String str1 = paramStringBuffer.substring(m + 2, n).trim();
      if (str1.startsWith("="))
      {
        paramStringBuffer.replace(m + 2, n, "print(" + str1.substring(1) + ");");
        n += 7;
      }
      m = paramStringBuffer.indexOf("<?", n + 2);
    }
    int i1 = 0;
    int i2 = paramStringBuffer.indexOf("<?");
    int i3 = 0;
    int i4 = 0;
    while (i2 >= 0)
    {
      int i5 = a(paramStringBuffer, i1, i2);
      i3 = i1 + i5;
      i4 = paramStringBuffer.indexOf("?>", i3);
      if ((i3 >= 0) && (i4 >= 0) && (i4 >= i3 + 2))
      {
        String str2 = paramStringBuffer.substring(i3 + 2, i4);
        paramStringBuffer.replace(i3, i4 + 2, str2);
        i1 = i4 - 2;
        i2 = paramStringBuffer.indexOf("<?", i1);
      }
      else
      {
        if ((i3 == -1) && (i4 == -1))
          break;
        throw new a("not match <? and ?>");
      }
    }
    a(paramStringBuffer, i1, paramStringBuffer.length());
  }

  private String a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer(b(paramString1, paramString2));
    b(paramString1, localStringBuffer);
    c(paramString1, localStringBuffer);
    d(paramString1, localStringBuffer);
    a(localStringBuffer);
    b(localStringBuffer);
    if (this.d != null)
      return this.d.toString();
    return "";
  }

  protected void a()
  {
    Iterator localIterator = this.e.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = localIterator.next().toString();
      StringBuffer localStringBuffer = (StringBuffer)this.e.get(str);
      a(localStringBuffer);
      this.d.append("\tprivate void " + str + "() {").append(a);
      this.d.append(localStringBuffer);
      this.d.append("\t}").append(a);
    }
  }

  protected void b()
  {
    Iterator localIterator = this.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = localIterator.next().toString();
      String str2 = (String)this.g.get(str1);
      if ((!str1.startsWith("private ")) && (!str1.startsWith("public ")) && (!str1.startsWith("protected ")))
        this.d.append("\tprivate ");
      this.d.append(str2);
      this.d.append(a);
    }
  }

  private void a(String paramString, StringBuffer paramStringBuffer)
  {
    int m = paramStringBuffer.indexOf("<?include ");
    for (int n = paramStringBuffer.indexOf("?>", m + 10); (m >= 0) && (n > m); n = paramStringBuffer.indexOf("?>", m + 10))
    {
      String str1 = paramStringBuffer.substring(m + 10, n).trim();
      String str2 = null;
      if (str1.endsWith(";"))
        str1 = str1.substring(0, str1.length() - 1);
      try
      {
        if ((paramString.length() > 0) && (new File(paramString, str1).exists()))
          str2 = FileUtil.readFromFile(new File(paramString, str1));
        else if (new File(PagePropertyPool.getRSPDIR(), str1).exists())
          str2 = FileUtil.readFromFile(new File(PagePropertyPool.getRSPDIR(), str1));
        else if (d.class.getClassLoader().getResource(str1) != null)
          str2 = FileUtil.readFromStream(d.class.getClassLoader().getResourceAsStream(str1));
      }
      catch (IOException localIOException)
      {
        m.a().j().b(localIOException.getLocalizedMessage(), localIOException);
      }
      if (str2 != null)
        paramStringBuffer.replace(m, n + 2, str2);
      else
        paramStringBuffer.replace(m, n + 2, "");
      n = m - 2;
      m = paramStringBuffer.indexOf("<?include ", n + 2);
    }
  }

  private String b(String paramString1, String paramString2)
  {
    this.l = new StringBuffer(e.b(paramString2));
    a(paramString1, this.l);
    return this.l.toString();
  }

  private String b(String paramString, StringBuffer paramStringBuffer)
  {
    e.a(paramStringBuffer);
    int m = paramStringBuffer.indexOf("<?i ");
    for (int n = paramStringBuffer.indexOf("?>", m + 4); (m >= 0) && (n > m); n = paramStringBuffer.indexOf("?>", m + 4))
    {
      String str = paramStringBuffer.substring(m + 4, n).trim();
      if (str.endsWith(";"))
        str = str.substring(0, str.length() - 1);
      if (str.startsWith("import "))
        str = str.substring(7);
      this.f.put(str, str);
      paramStringBuffer.replace(m, n + 2, "");
      n = m;
      m = paramStringBuffer.indexOf("<?i ", n + 2);
    }
    return paramStringBuffer.toString();
  }

  private String c(String paramString, StringBuffer paramStringBuffer)
  {
    e.a(paramStringBuffer);
    int m = paramStringBuffer.indexOf("<?p ");
    for (int n = paramStringBuffer.indexOf("?>", m + 4); (m >= 0) && (n > m); n = paramStringBuffer.indexOf("?>", m + 4))
    {
      String str = paramStringBuffer.substring(m + 4, n).trim();
      this.g.put(str, str);
      paramStringBuffer.replace(m, n + 2, "");
      n = m;
      m = paramStringBuffer.indexOf("<?p ", n + 2);
    }
    return paramStringBuffer.toString();
  }

  private String d(String paramString, StringBuffer paramStringBuffer)
  {
    e.a(paramStringBuffer);
    int m = paramStringBuffer.indexOf("<?call ");
    for (int n = paramStringBuffer.indexOf("?>", m + 7); (m >= 0) && (n > m); n = paramStringBuffer.indexOf("?>", m + 7))
    {
      String str1 = paramStringBuffer.substring(m + 7, n).trim();
      StringBuffer localStringBuffer = null;
      if (str1.endsWith(";"))
        str1 = str1.substring(0, str1.length() - 1);
      String str2 = str1;
      try
      {
        if (str1.indexOf(".") > 0)
          str2 = str1.substring(0, str1.indexOf("."));
        if ((paramString.length() > 0) && (new File(paramString, str1).exists()))
          localStringBuffer = new StringBuffer(FileUtil.readFromFile(new File(paramString, str1)));
        else if (new File(PagePropertyPool.getRSPDIR(), str1).exists())
          localStringBuffer = new StringBuffer(FileUtil.readFromFile(new File(PagePropertyPool.getRSPDIR(), str1)));
        else if (d.class.getClassLoader().getResource(str1) != null)
          localStringBuffer = new StringBuffer(FileUtil.readFromStream(d.class.getClassLoader().getResourceAsStream(str1)));
      }
      catch (IOException localIOException)
      {
        m.a().j().b(localIOException.getLocalizedMessage(), localIOException);
      }
      if (localStringBuffer != null)
      {
        a(paramString, localStringBuffer);
        if (localStringBuffer.toString().indexOf("<?call ") >= 0)
          d(paramString, localStringBuffer);
        this.e.put(str2, localStringBuffer);
        paramStringBuffer.replace(m + 2, n, str2 + "();");
      }
      else
      {
        paramStringBuffer.replace(m + 2, n, "/* error: 未能找到文件" + str1 + "*/");
      }
      n = m;
      m = paramStringBuffer.indexOf("<?call ", n + 2);
    }
    return paramStringBuffer.toString();
  }

  protected void c()
  {
    Iterator localIterator = this.f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = localIterator.next().toString();
      String str2 = (String)this.f.get(str1);
      if (!str1.startsWith("import "))
        this.d.append("import ");
      this.d.append(str2).append(";");
      this.d.append(a);
    }
  }

  private void b(StringBuffer paramStringBuffer)
  {
    this.d = new StringBuffer();
    e();
    this.d.append(paramStringBuffer.toString());
    f();
  }

  protected void d()
  {
  }

  protected abstract void e();

  protected abstract void f();

  private int a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
      return 0;
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = paramStringBuffer.substring(paramInt1, paramInt2);
    if ((paramInt1 > 2) && (paramInt1 + 4 < paramStringBuffer.length()) && (paramStringBuffer.substring(paramInt1, paramInt1 + a.length()).equals(a)) && (!paramStringBuffer.substring(paramInt1 + a.length(), paramInt1 + a.length() + 2).equals("<?")))
      localStringBuffer.append("println();");
    int m = 0;
    String str2;
    for (int n = str1.indexOf(a); n >= 0; n = str1.indexOf(a, m))
    {
      str2 = str1.substring(m, n);
      str2 = StringUtil.replace("<\\?", "<?", str2);
      str2 = StringUtil.replace("?\\>", "?>", str2);
      str2 = StringUtil.replace("\\", "\\\\", str2);
      str2 = StringUtil.replace("\"", "\\\"", str2);
      if (str2.length() > 0)
      {
        localStringBuffer.append("println(\"");
        if (str2.indexOf("\n") >= 0)
          localStringBuffer.append(StringUtil.replace("\n", "\\n", str2));
        else
          localStringBuffer.append(str2);
        localStringBuffer.append("\");");
        if ((paramInt2 >= paramStringBuffer.length() - 2) || (!paramStringBuffer.substring(paramInt1 + n, paramInt1 + n + 2).equals("<?")))
          localStringBuffer.append(a);
      }
      else if ((paramInt1 <= 2) || (!paramStringBuffer.substring(paramInt1 - 2, paramInt1).equals("?>")))
      {
        localStringBuffer.append(a);
      }
      m = n + a.length();
    }
    if (m < str1.length())
    {
      str2 = str1.substring(m);
      str2 = StringUtil.replace("<\\?", "<?", str2);
      str2 = StringUtil.replace("?\\>", "?>", str2);
      str2 = StringUtil.replace("\\", "\\\\", str2);
      str2 = StringUtil.replace("\"", "\\\"", str2);
      if (str2.length() > 0)
      {
        localStringBuffer.append(a + "print(\"" + str2 + "\");");
        if ((paramInt1 + str1.length() >= paramStringBuffer.length() - 2) || (!paramStringBuffer.substring(paramInt1 + str1.length(), paramInt1 + str1.length() + 2).equals("<?")))
          localStringBuffer.append(a);
      }
      else if ((paramInt1 <= 2) || (!paramStringBuffer.substring(paramInt1 - 2, paramInt1).equals("?>")))
      {
        localStringBuffer.append(a);
      }
    }
    paramStringBuffer.replace(paramInt1, paramInt2, localStringBuffer.toString());
    return localStringBuffer.length();
  }

  private ExportAction c(String paramString1, String paramString2)
  {
    ExportAction localExportAction = null;
    a(paramString1, paramString2);
    File localFile1 = new File(g(), i() + ".java");
    File localFile2 = new File(g(), i() + ".class");
    b.a(this.d.toString(), localFile1);
    String str = this.h.a(paramString1, localFile1, getClass().getClassLoader());
    if (str != null)
      throw new a(str);
    RuleClassLoader localRuleClassLoader = new RuleClassLoader(getClass().getClassLoader());
    localRuleClassLoader.addDir(paramString1);
    localExportAction = (ExportAction)localRuleClassLoader.loadClassFromFile(localFile2).newInstance();
    return localExportAction;
  }

  private static String e(String paramString)
  {
    String str = paramString;
    if ((str == null) || (str.length() == 0))
      str = ".";
    return str;
  }

  private String a(File paramFile)
  {
    String str = "";
    if (paramFile.getName().lastIndexOf(".") > 0)
      str = paramFile.getName().substring(0, paramFile.getName().lastIndexOf("."));
    else
      str = paramFile.getName();
    return "J" + str + "Action";
  }

  protected String g()
  {
    String str = h();
    if (this.c.length() > 0)
      str = str + File.separator + this.c.replace('.', File.separatorChar);
    return str;
  }

  public static boolean a(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
      return true;
    localFile = new File(PagePropertyPool.getRSPDIR(), paramString);
    if (localFile.exists())
      return true;
    if (d.class.getClassLoader().getResource(paramString) != null)
      return true;
    String str1 = paramString;
    if (paramString.endsWith(".rsp"))
      str1 = paramString.substring(0, paramString.length() - 4);
    if (str1.startsWith("/"))
      str1 = str1.substring(1);
    if (paramString.lastIndexOf("/") >= 0)
    {
      String str2 = str1.substring(0, str1.lastIndexOf("/"));
      str2 = str2.replace('/', '.');
      str1 = str2 + "J" + str1.substring(str1.lastIndexOf("/") + 1) + "Action";
    }
    else
    {
      str1 = "J" + str1 + "Action";
    }
    return d.class.getClassLoader().getResource(str1) != null;
  }

  public synchronized ExportAction b(String paramString)
  {
    n();
    File localFile1 = new File(paramString);
    File localFile2;
    RuleClassLoader localRuleClassLoader;
    if (localFile1.exists())
    {
      d(localFile1.getParent());
      str = FileUtil.readFromFile(localFile1);
      this.b = a(localFile1);
      localFile2 = new File(localFile1.getParent(), i() + ".class");
      if ((!localFile2.exists()) || (localFile2.lastModified() <= localFile1.lastModified() + 1000L) || (a(localFile2, localFile1.getParent(), str)))
        return c(localFile1.getParent(), str);
      localRuleClassLoader = new RuleClassLoader(getClass().getClassLoader());
      localRuleClassLoader.addDir(localFile1.getParent());
      return (ExportAction)localRuleClassLoader.loadClassFromFile(localFile2).newInstance();
    }
    localFile1 = new File(PagePropertyPool.getRSPDIR(), paramString);
    if (localFile1.exists())
    {
      d(PagePropertyPool.getRSPDIR());
      str = FileUtil.readFromFile(localFile1);
      f(paramString);
      localFile2 = new File(localFile1.getParent(), i() + ".class");
      if ((!localFile2.exists()) || (localFile2.lastModified() <= localFile1.lastModified() + 1000L) || (a(localFile2, PagePropertyPool.getRSPDIR(), str)))
        return c(PagePropertyPool.getRSPDIR(), str);
      localRuleClassLoader = new RuleClassLoader(getClass().getClassLoader());
      localRuleClassLoader.addDir(PagePropertyPool.getRSPDIR());
      return (ExportAction)localRuleClassLoader.loadClassFromFile(localFile2).newInstance();
    }
    f(paramString);
    String str = this.b;
    if (this.c.length() > 0)
      str = this.c + "." + this.b;
    try
    {
      return (ExportAction)d.class.getClassLoader().loadClass(str).newInstance();
    }
    catch (Exception localException)
    {
      if (d.class.getClassLoader().getResource(paramString) != null)
        return c(FileUtil.readFromStream(d.class.getClassLoader().getResource(paramString).openStream()));
    }
    return null;
  }

  public ExportAction c(String paramString)
  {
    n();
    d(SystemUtils.JAVA_IO_TMPDIR);
    return c(SystemUtils.JAVA_IO_TMPDIR, paramString);
  }

  private boolean a(File paramFile, String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString2);
    int m = localStringBuffer.indexOf("<?");
    for (int n = localStringBuffer.indexOf("?>", m + 2); (m >= 0) && (n > m); n = localStringBuffer.indexOf("?>", m + 2))
    {
      String str1 = localStringBuffer.substring(m + 2, n).trim();
      Object localObject;
      String str2;
      if (str1.startsWith("include"))
      {
        localObject = null;
        str2 = str1.substring(7).trim();
        if (str2.endsWith(";"))
          str2 = str2.substring(0, str2.length() - 1);
        if (new File(paramString1, str2).exists())
        {
          if (new File(paramString1, str2).lastModified() + 1000L > paramFile.lastModified())
            return true;
          localObject = FileUtil.readFromFile(new File(paramString1, str2));
        }
        else if (new File(PagePropertyPool.getRSPDIR(), str2).exists())
        {
          if (new File(PagePropertyPool.getRSPDIR(), str2).lastModified() + 1000L > paramFile.lastModified())
            return true;
          localObject = FileUtil.readFromFile(new File(PagePropertyPool.getRSPDIR(), str2));
        }
        else if (d.class.getClassLoader().getResource(str2) != null)
        {
          if (JspUtil.getUrlLastTime(d.class.getClassLoader().getResource(str2)) + 1000L > paramFile.lastModified())
            return true;
          localObject = FileUtil.readFromStream(d.class.getClassLoader().getResourceAsStream(str2));
        }
        if (localObject != null)
          localStringBuffer.replace(m, n + 2, (String)localObject);
        else
          localStringBuffer.replace(m, n + 2, "");
        n = m - 2;
      }
      else if (str1.startsWith("call"))
      {
        localObject = (byte[])null;
        str2 = str1.substring(4).trim();
        if (str2.endsWith(";"))
          str2 = str2.substring(0, str2.length() - 1);
        if (new File(paramString1, str2).exists())
        {
          if (new File(paramString1, str2).lastModified() + 1000L > paramFile.lastModified())
            return true;
          localObject = FileUtil.readFile(new File(paramString1, str2).getPath());
        }
        else if (new File(PagePropertyPool.getRSPDIR(), str2).exists())
        {
          if (new File(PagePropertyPool.getRSPDIR(), str2).lastModified() + 1000L > paramFile.lastModified())
            return true;
          localObject = FileUtil.readFile(new File(PagePropertyPool.getRSPDIR(), str2).getPath());
        }
        else if (d.class.getClassLoader().getResource(str2) != null)
        {
          if (JspUtil.getUrlLastTime(d.class.getClassLoader().getResource(str2)) + 1000L > paramFile.lastModified())
            return true;
          localObject = FileUtil.getContent(d.class.getClassLoader().getResourceAsStream(str2));
        }
        if (localObject != null)
          localStringBuffer.replace(m, n + 2, new String(localObject));
        else
          localStringBuffer.replace(m, n + 2, "");
        n = m - 2;
      }
      m = localStringBuffer.indexOf("<?", n + 2);
    }
    return false;
  }

  protected String h()
  {
    return this.k;
  }

  protected void d(String paramString)
  {
    this.k = paramString;
  }

  private void f(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".rsp"))
      str = paramString.substring(0, paramString.length() - 4);
    if (str.startsWith("/"))
      str = str.substring(1);
    if (paramString.lastIndexOf("/") >= 0)
    {
      this.c = str.substring(0, str.lastIndexOf("/"));
      this.c = this.c.replace('/', '.');
      this.b = ("J" + str.substring(str.lastIndexOf("/") + 1) + "Action");
    }
    else
    {
      this.c = "";
      this.b = ("J" + str + "Action");
    }
  }

  protected String i()
  {
    if (this.b.length() == 0)
      this.b = ("J" + TempID.newShortTempID() + "Action");
    return this.b;
  }

  public synchronized String j()
  {
    String str = this.b;
    if (this.c.length() > 0)
      str = this.c + "/" + this.b + ".java";
    File localFile = new File(str);
    if (localFile.exists())
      return FileUtil.readFromFile(localFile);
    localFile = new File(PagePropertyPool.getRSPDIR(), str);
    if (localFile.exists())
      return FileUtil.readFromFile(localFile);
    return FileUtil.readFromStream(d.class.getClassLoader().getResourceAsStream(str));
  }

  public String k()
  {
    if (this.d == null)
    {
      try
      {
        if ((this.b != null) && (this.b.length() > 0))
          return j();
      }
      catch (Exception localException)
      {
      }
      return "";
    }
    return this.d.toString();
  }

  public String l()
  {
    if (this.l == null)
      return "";
    return this.l.toString();
  }

  protected String m()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.d
 * JD-Core Version:    0.6.0
 */