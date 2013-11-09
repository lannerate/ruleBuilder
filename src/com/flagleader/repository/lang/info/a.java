package com.flagleader.repository.lang.info;

import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.util.EngineLogger;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class a
{
  private static a c;
  private List d = new ArrayList();
  public static final String a = ".jcf";
  public static final String b = "." + Locale.getDefault().toString() + ".jcf";

  private a()
  {
    String str = Property.getInstance().getRuleEngineClassDir();
    if (str.length() > 0)
    {
      File localFile = new File(str);
      if (localFile.isDirectory())
      {
        String[] arrayOfString = localFile.list();
        for (int i = 0; i < arrayOfString.length; i++)
          if (arrayOfString[i].indexOf(".") >= 0)
          {
            if (!arrayOfString[i].endsWith(".jcf"))
              continue;
            b(new File(str, arrayOfString[i]), "");
          }
          else
          {
            a(new File(str, arrayOfString[i]), arrayOfString[i] + ".");
          }
      }
    }
  }

  private boolean a(File paramFile, String paramString)
  {
    int i = 0;
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      for (int j = 0; j < arrayOfString.length; j++)
        if (arrayOfString[j].indexOf(".") >= 0)
        {
          if ((!arrayOfString[j].endsWith(".jcf")) || (!b(new File(paramFile.getPath(), arrayOfString[j]), paramString)))
            continue;
          i = 1;
        }
        else
        {
          if (!a(new File(paramFile.getPath(), arrayOfString[j]), paramString + arrayOfString[j] + "."))
            continue;
          i = 1;
        }
    }
    return i;
  }

  private boolean b(File paramFile, String paramString)
  {
    String str1 = paramString + paramFile.getName().substring(0, paramFile.getName().length() - 4);
    if (str1.lastIndexOf(".") >= 0)
    {
      String str2 = str1.substring(str1.lastIndexOf(".") + 1);
      if (str2.equalsIgnoreCase(Locale.getDefault().toString()))
        b(paramFile.getPath());
      else
        return false;
    }
    else if (!a(str1))
    {
      b(paramFile.getPath());
    }
    return true;
  }

  public boolean a(String paramString)
  {
    for (int i = 0; i < this.d.size(); i++)
    {
      InfoClass localInfoClass = (InfoClass)this.d.get(i);
      if (localInfoClass.getClassName().equals(paramString))
        return true;
    }
    return false;
  }

  public InfoClass a(Class paramClass)
  {
    InfoClass localInfoClass = null;
    for (int i = 0; i < this.d.size(); i++)
    {
      if (!((InfoClass)this.d.get(i)).getClassName().equals(paramClass.getName()))
        continue;
      localInfoClass = (InfoClass)this.d.get(i);
      break;
    }
    if (localInfoClass == null)
    {
      localInfoClass = new InfoClass();
      localInfoClass.setClassName(paramClass.getName());
      this.d.add(localInfoClass);
    }
    localInfoClass.updateClass(paramClass);
    return localInfoClass;
  }

  public InfoClass b(String paramString)
  {
    InfoClass localInfoClass = null;
    try
    {
      if (new File(paramString).exists())
      {
        localInfoClass = (InfoClass)new c().load(new FileInputStream(paramString));
        localInfoClass.setFileName(paramString);
      }
      else if (a().getResource(paramString) != null)
      {
        localInfoClass = (InfoClass)new c().load(a().getResourceAsStream(paramString));
        if (new File(a().getResource(paramString).getFile()).exists())
          localInfoClass.setFileName(new File(a().getResource(paramString).getFile()).getPath());
      }
      if (localInfoClass != null)
        this.d.add(localInfoClass);
    }
    catch (Exception localException)
    {
      EngineLogger.getEngineLogger().warning(localException.getMessage(), localException);
    }
    return localInfoClass;
  }

  public InfoClass c(String paramString)
  {
    InfoClass localInfoClass = null;
    for (int i = 0; i < this.d.size(); i++)
    {
      if (!((InfoClass)this.d.get(i)).getClassName().equals(paramString))
        continue;
      localInfoClass = (InfoClass)this.d.get(i);
      return localInfoClass;
    }
    if (a().getResource(paramString.replace('.', '/') + b) != null)
      try
      {
        if (a().getResource(paramString.replace('.', '/') + b) == null)
          break label510;
        localInfoClass = (InfoClass)new c().load(a().getResourceAsStream(paramString.replace('.', '/') + b));
        if (!new File(Property.getInstance().getRuleEngineClassDir(), paramString.replace('.', File.separatorChar) + b).exists())
          break label510;
        localInfoClass.setFileName(new File(Property.getInstance().getRuleEngineClassDir(), paramString.replace('.', File.separatorChar) + b).getPath());
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    else if (a().getResource(paramString.replace('.', '/') + ".jcf") != null)
      try
      {
        if (a().getResource(paramString.replace('.', '/') + ".jcf") != null)
        {
          localInfoClass = (InfoClass)new c().load(a().getResourceAsStream(paramString.replace('.', '/') + ".jcf"));
          if (new File(Property.getInstance().getRuleEngineClassDir(), paramString.replace('.', File.separatorChar) + ".jcf").exists())
            localInfoClass.setFileName(new File(Property.getInstance().getRuleEngineClassDir(), paramString.replace('.', File.separatorChar) + ".jcf").getPath());
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    label510: if (localInfoClass == null)
      try
      {
        if (a().loadClass(paramString) != null)
        {
          localInfoClass = new InfoClass(paramString);
          localInfoClass.setClassName(paramString);
          localInfoClass.updateClass(a().loadClass(paramString));
        }
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    return localInfoClass;
  }

  public InfoClass b(Class paramClass)
  {
    String str = paramClass.getName();
    for (int i = 0; i < this.d.size(); i++)
      if (((InfoClass)this.d.get(i)).getClassName().equals(str))
        return (InfoClass)this.d.get(i);
    InfoClass localInfoClass = null;
    if (a().getResource(str.replace('.', '/') + b) != null)
      try
      {
        if (a().getResource(str.replace('.', '/') + b) == null)
          break label329;
        localInfoClass = (InfoClass)new c().load(a().getResourceAsStream(str.replace('.', '/') + b));
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    else if (a().getResource(str.replace('.', '/') + ".jcf") != null)
      try
      {
        if (a().getResource(str.replace('.', '/') + ".jcf") != null)
          localInfoClass = (InfoClass)new c().load(a().getResourceAsStream(str.replace('.', '/') + ".jcf"));
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    label329: return localInfoClass;
  }

  public ClassLoader a()
  {
    return RuleEngineFactory.newInstance().getClassLoader();
  }

  public void a(InfoClass paramInfoClass)
  {
    this.d.remove(paramInfoClass);
  }

  public static a b()
  {
    if (c == null)
      c = new a();
    return c;
  }

  public List c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.a
 * JD-Core Version:    0.6.0
 */