package com.flagleader.repository.lang.b;

import com.flagleader.engine.Property;
import com.flagleader.repository.collections.a;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.lang.MethodInfos;
import com.flagleader.repository.lang.TypeMethod;
import com.flagleader.repository.lang.d;
import com.flagleader.repository.lang.e;
import com.flagleader.repository.rom.MethodParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class f
  implements d
{
  MethodInfos a;
  private static f d = null;
  public static final String b = "javamethod.xml";
  public static final String c = "javamethod." + Locale.getDefault().toString() + ".xml";

  f()
  {
    try
    {
      if (new File(Property.getInstance().getRuleEngineClassDir(), "javamethod.xml").exists())
        this.a = ((MethodInfos)new e().load(new File(new File(Property.getInstance().getRuleEngineClassDir()), "javamethod.xml")));
      else if (getClass().getClassLoader().getResource(c) != null)
        this.a = ((MethodInfos)new e().load(getClass().getClassLoader().getResourceAsStream(c)));
      else if (getClass().getClassLoader().getResource("javamethod.xml") != null)
        this.a = ((MethodInfos)new e().load(getClass().getClassLoader().getResourceAsStream("javamethod.xml")));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a = new MethodInfos();
    }
  }

  public void c()
  {
    File localFile = null;
    if (new File(Property.getInstance().getRuleEngineClassDir(), "javamethod.xml").exists())
      localFile = new File(new File(Property.getInstance().getRuleEngineClassDir()), "javamethod.xml");
    else if ((getClass().getClassLoader().getResource(c) != null) && (new File(getClass().getClassLoader().getResource(c).getPath()).isFile()))
      localFile = new File(getClass().getClassLoader().getResource(c).getPath());
    else if ((getClass().getClassLoader().getResource("javamethod.xml") != null) && (new File(getClass().getClassLoader().getResource("javamethod.xml").getPath()).isFile()))
      localFile = new File(getClass().getClassLoader().getResource("javamethod.xml").getPath());
    else
      localFile = new File(new File(Property.getInstance().getRuleEngineClassDir()), "javamethod.xml");
    localFile.getParentFile().mkdirs();
    if (localFile.exists())
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(localFile), "UTF-8");
      com.flagleader.repository.lang.f localf = new com.flagleader.repository.lang.f(localOutputStreamWriter);
      localf.setFildEncode("UTF-8");
      localf.a(this.a);
      localf.close();
    }
  }

  public static f d()
  {
    if (d == null)
      d = new f();
    return d;
  }

  public Iterator a()
  {
    return this.a.getGlobalMethods().iterator();
  }

  public Iterator a(com.flagleader.repository.lang.g paramg)
  {
    return new a(this.a.getTypeMethods().iterator(), new g(this, paramg));
  }

  public String c(TypeMethod paramTypeMethod, List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramTypeMethod.getDisName());
    int i = paramList.size() + 1;
    int j = 0;
    int k = 0;
    while (true)
    {
      j = localStringBuffer.indexOf("{", k);
      k = localStringBuffer.indexOf("}", j);
      if ((j >= k) || (j < 0))
        break;
      localStringBuffer.replace(j + 1, k, "arg" + i++);
    }
    return localStringBuffer.toString();
  }

  public String b(TypeMethod paramTypeMethod, List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramTypeMethod.getFuncBody());
    int i = paramList.size() + 1;
    int j = 0;
    int k = 0;
    while (true)
    {
      j = localStringBuffer.indexOf("{", k);
      k = localStringBuffer.indexOf("}", j);
      if ((j >= k) || (j < 0))
        break;
      localStringBuffer.replace(j + 1, k, "arg" + i++);
    }
    return localStringBuffer.toString();
  }

  public List a(TypeMethod paramTypeMethod, List paramList)
  {
    ArrayList localArrayList = new ArrayList(3);
    StringBuffer localStringBuffer = new StringBuffer(paramTypeMethod.getFuncBody());
    int i = 0;
    int j = 0;
    int k = paramList.size();
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localArrayList.add(new MethodParam(localStringBuffer.substring(i + 1, j).trim(), k++));
    }
    return localArrayList;
  }

  public String c(GlobalMethod paramGlobalMethod)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramGlobalMethod.getDisName());
    int i = 1;
    int j = 0;
    int k = 0;
    while (true)
    {
      j = localStringBuffer.indexOf("{", k);
      k = localStringBuffer.indexOf("}", j);
      if ((j >= k) || (j < 0))
        break;
      localStringBuffer.replace(j + 1, k, "arg" + i++);
    }
    return localStringBuffer.toString();
  }

  public String b(GlobalMethod paramGlobalMethod)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramGlobalMethod.getFuncBody());
    int i = 1;
    int j = 0;
    for (int k = 0; ; k = j + 5)
    {
      j = localStringBuffer.indexOf("{", k);
      k = localStringBuffer.indexOf("}", j);
      if ((j >= k) || (j < 0))
        break;
      localStringBuffer.replace(j + 1, k, "arg" + i++);
    }
    return localStringBuffer.toString();
  }

  public List a(GlobalMethod paramGlobalMethod)
  {
    ArrayList localArrayList = new ArrayList(3);
    StringBuffer localStringBuffer = new StringBuffer(paramGlobalMethod.getFuncBody());
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localArrayList.add(new MethodParam(localStringBuffer.substring(i + 1, j).trim(), k++));
    }
    return localArrayList;
  }

  public MethodInfos b()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.f
 * JD-Core Version:    0.6.0
 */