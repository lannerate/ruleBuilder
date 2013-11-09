package com.flagleader.repository.lang.b;

import com.flagleader.engine.Property;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.lang.MethodInfos;
import com.flagleader.repository.lang.TypeMethod;
import com.flagleader.repository.lang.d;
import com.flagleader.repository.lang.e;
import com.flagleader.repository.lang.f;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class a
  implements d
{
  MethodInfos a;
  List b;
  private static a e = null;
  public static final String c = "method.xml";
  public static final String d = "method." + Locale.getDefault().toString() + ".xml";

  a()
  {
    try
    {
      if (getClass().getClassLoader().getResource(d) != null)
        this.a = ((MethodInfos)new e().load(getClass().getClassLoader().getResourceAsStream(d)));
      else if (getClass().getClassLoader().getResource("method.xml") != null)
        this.a = ((MethodInfos)new e().load(getClass().getClassLoader().getResourceAsStream("method.xml")));
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
    if ((getClass().getClassLoader().getResource(d) != null) && (new File(getClass().getClassLoader().getResource(d).getPath()).exists()))
      localFile = new File(getClass().getClassLoader().getResource(d).getPath());
    else if ((getClass().getClassLoader().getResource("method.xml") != null) && (new File(getClass().getClassLoader().getResource("method.xml").getPath()).exists()))
      localFile = new File(getClass().getClassLoader().getResource("method.xml").getPath());
    else if (new File(Property.getInstance().getRuleEngineClassDir()).exists())
      localFile = new File(new File(Property.getInstance().getRuleEngineClassDir()), "method.xml");
    else
      localFile = new File(FileUtil.getCurrentDir(), "method.xml");
    localFile.getParentFile().mkdirs();
    if (localFile.exists())
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(localFile), "UTF-8");
      f localf = new f(localOutputStreamWriter);
      localf.setFildEncode("UTF-8");
      localf.a(this.a);
      localf.close();
    }
  }

  public static a d()
  {
    if (e == null)
      e = new a();
    return e;
  }

  public Iterator a()
  {
    return this.a.getGlobalMethods().iterator();
  }

  public List e()
  {
    if ((this.b == null) && (this.a != null))
    {
      List localList = this.a.getGlobalMethods();
      this.b = new ArrayList(localList.size());
      for (int i = 0; i < localList.size(); i++)
      {
        GlobalMethod localGlobalMethod = (GlobalMethod)localList.get(i);
        GlobalFunction localGlobalFunction = new GlobalFunction(localGlobalMethod.getFuncName(), localGlobalMethod.getReturnType(), b(localGlobalMethod), c(localGlobalMethod), a(localGlobalMethod), localGlobalMethod.getTypeName());
        localGlobalFunction.setVisible(true);
        localGlobalFunction.setUuid(localGlobalMethod.getFuncName());
        this.b.add(localGlobalFunction);
      }
    }
    return this.b;
  }

  public Iterator a(g paramg)
  {
    return new com.flagleader.repository.collections.a(this.a.getTypeMethods().iterator(), new b(this, paramg));
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
 * Qualified Name:     com.flagleader.repository.lang.b.a
 * JD-Core Version:    0.6.0
 */