package com.flagleader.repository.f;

import com.flagleader.engine.EngineProject;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineManager;
import com.flagleader.engine.RuleExecuteException;
import com.flagleader.repository.d.u;
import com.flagleader.repository.lang.a;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.GroupInfo;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.PackageInfo;
import com.flagleader.repository.tree.ProjectInfo;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.al;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class g extends q
{
  private String a = null;
  private i b;
  private h c;

  public g(h paramh)
  {
    this.c = paramh;
  }

  public List a()
  {
    return this.c.d(this.a);
  }

  public void b()
  {
    this.b = null;
    this.a = null;
  }

  public synchronized boolean a(String paramString1, String paramString2)
  {
    i locali = this.c.b(paramString1, paramString2);
    if (locali != null)
    {
      this.b = locali;
      this.a = paramString1;
      return true;
    }
    return false;
  }

  public boolean c()
  {
    return (this.a != null) && (this.a.length() > 0);
  }

  public synchronized p a(String paramString)
  {
    if (!this.c.e(paramString))
      return this.c.a(paramString, this.a);
    return null;
  }

  public boolean b(String paramString1, String paramString2)
  {
    Object localObject = this.c.b(paramString1);
    if ((localObject != null) && ((localObject instanceof al)))
    {
      ((al)localObject).setDisplayName(paramString2);
      ((al)localObject).getWebProject().a();
      return true;
    }
    return false;
  }

  public synchronized GroupInfo c(String paramString1, String paramString2)
  {
    Object localObject = this.c.b(paramString1);
    if ((localObject != null) && ((localObject instanceof al)))
    {
      GroupInfo localGroupInfo = new GroupInfo();
      localGroupInfo.setDisplayName(paramString2);
      ((al)localObject).addPackageInfo(localGroupInfo);
      this.c.a(localGroupInfo);
      localGroupInfo.getWebProject().a();
      return localGroupInfo;
    }
    return null;
  }

  public synchronized PackageInfo a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1 = this.c.b(paramString1);
    Object localObject2 = this.c.b(paramString4);
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof PackageInfo)))
    {
      RulePackage localRulePackage2;
      Object localObject3;
      String str;
      Object localObject4;
      if ((localObject1 instanceof ProjectInfo))
      {
        if (((ProjectInfo)localObject1).exitsPackage(paramString2))
          break label434;
        try
        {
          RulePackage localRulePackage1 = (RulePackage)new com.flagleader.repository.e.d().load(((PackageInfo)localObject2).getPackFile());
          localRulePackage2 = (RulePackage)localRulePackage1.deepClone();
          localRulePackage2.setExeRulePackageName(paramString2);
          localRulePackage2.setDisplayName(paramString3);
          localRulePackage2.setModified(true);
          localObject3 = ((ProjectInfo)localObject1).getDisplayName();
          if (StringUtil.isEmpty((String)localObject3))
            localObject3 = "ruleproj";
          this.c.a(localRulePackage2, this.b);
          str = a(localRulePackage2, Property.getInstance().getRuleEngineClassDir());
          localObject4 = new PackageInfo();
          ((PackageInfo)localObject4).setDisplayName(paramString3);
          ((PackageInfo)localObject4).setExename(paramString2);
          ((ProjectInfo)localObject1).addPackageInfo((com.flagleader.repository.f)localObject4);
          this.c.a((PackageInfo)localObject4);
          ((ProjectInfo)localObject1).getWebProject().a();
          return localObject4;
        }
        catch (Exception localException1)
        {
          throw new RuleExecuteException(localException1.getMessage(), localException1);
        }
      }
      if ((localObject1 instanceof GroupInfo))
      {
        ProjectInfo localProjectInfo = ((GroupInfo)localObject1).getWebProject().c();
        if ((localProjectInfo != null) && (!localProjectInfo.exitsPackage(paramString2)))
          try
          {
            localRulePackage2 = (RulePackage)new com.flagleader.repository.e.d().load(((PackageInfo)localObject2).getPackFile());
            localObject3 = (RulePackage)localRulePackage2.deepClone();
            ((RulePackage)localObject3).setExeRulePackageName(paramString2);
            ((RulePackage)localObject3).setDisplayName(paramString3);
            ((RulePackage)localObject3).setModified(true);
            str = localProjectInfo.getDisplayName();
            if (StringUtil.isEmpty(str))
              str = "ruleproj";
            this.c.a((RulePackage)localObject3, this.b);
            localObject4 = a((RulePackage)localObject3, Property.getInstance().getRuleEngineClassDir());
            PackageInfo localPackageInfo = new PackageInfo();
            localPackageInfo.setDisplayName(paramString3);
            localPackageInfo.setExename(paramString2);
            ((GroupInfo)localObject1).addPackageInfo(localPackageInfo);
            this.c.a(localPackageInfo);
            localProjectInfo.getWebProject().a();
            return localPackageInfo;
          }
          catch (Exception localException2)
          {
            throw new RuleExecuteException(localException2.getMessage(), localException2);
          }
      }
    }
    label434: return (PackageInfo)(PackageInfo)null;
  }

  public static String a(RulePackage paramRulePackage, String paramString)
  {
    String str = null;
    try
    {
      if (paramRulePackage.getMainPackage().needCheck())
        paramRulePackage.getMainPackage().setError(new com.flagleader.repository.e.h().c(paramRulePackage.getMainPackage()));
      boolean bool = paramRulePackage.getMainPackage().hasError();
      if (paramRulePackage.getMainPackage().hasError())
        return a(paramRulePackage.getMainPackage().getErrorList());
      a locala = m.a().f();
      File localFile1 = locala.a(paramRulePackage, paramString, false);
      str = locala.a(localFile1, paramRulePackage.getClassPath());
      if ((str != null) && (str.length() > 0))
        return str;
      File localFile2 = locala.a(paramRulePackage, true, paramString);
    }
    catch (Exception localException)
    {
      return "error:" + localException.getMessage();
    }
    if (str != null)
      return str;
    return "";
  }

  private static String a(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      com.flagleader.repository.d.d locald = (com.flagleader.repository.d.d)paramList.get(i);
      localStringBuffer.append(locald.a()).append("\n");
    }
    return localStringBuffer.toString();
  }

  public synchronized PackageInfo a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = this.c.b(paramString1);
    if (localObject1 != null)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ((localObject1 instanceof ProjectInfo))
      {
        if (((ProjectInfo)localObject1).exitsPackage(paramString2))
          break label352;
        localObject2 = new RulePackage(paramString3);
        ((RulePackage)localObject2).setExeRulePackageName(paramString2);
        ((RulePackage)localObject2).setVmlFlowType(0);
        localObject3 = ((ProjectInfo)localObject1).getDisplayName();
        if (StringUtil.isEmpty((String)localObject3))
          localObject3 = "ruleproj";
        try
        {
          this.c.a((RulePackage)localObject2, this.b);
          String str1 = a((RulePackage)localObject2, Property.getInstance().getRuleEngineClassDir());
          localObject4 = new PackageInfo();
          ((PackageInfo)localObject4).setDisplayName(paramString3);
          ((PackageInfo)localObject4).setExename(paramString2);
          ((ProjectInfo)localObject1).addPackageInfo((com.flagleader.repository.f)localObject4);
          this.c.a((PackageInfo)localObject4);
          ((ProjectInfo)localObject1).getWebProject().a();
          return localObject4;
        }
        catch (Exception localException1)
        {
          throw new RuleExecuteException(localException1.getMessage(), localException1);
        }
      }
      if ((localObject1 instanceof GroupInfo))
      {
        localObject2 = ((GroupInfo)localObject1).getWebProject().c();
        if ((localObject2 != null) && (!((ProjectInfo)localObject2).exitsPackage(paramString2)))
        {
          localObject3 = new RulePackage(paramString3);
          ((RulePackage)localObject3).setExeRulePackageName(paramString2);
          ((RulePackage)localObject3).setVmlFlowType(0);
          String str2 = ((ProjectInfo)localObject2).getDisplayName();
          if (StringUtil.isEmpty(str2))
            str2 = "ruleproj";
          try
          {
            this.c.a((RulePackage)localObject3, this.b);
            localObject4 = a((RulePackage)localObject3, Property.getInstance().getRuleEngineClassDir());
            PackageInfo localPackageInfo = new PackageInfo();
            localPackageInfo.setDisplayName(paramString3);
            localPackageInfo.setExename(paramString2);
            ((GroupInfo)localObject1).addPackageInfo(localPackageInfo);
            this.c.a(localPackageInfo);
            ((ProjectInfo)localObject2).getWebProject().a();
            return localPackageInfo;
          }
          catch (Exception localException2)
          {
            throw new RuleExecuteException(localException2.getMessage(), localException2);
          }
        }
      }
    }
    label352: return (PackageInfo)(PackageInfo)(PackageInfo)null;
  }

  public Object b(String paramString)
  {
    return this.c.b(paramString);
  }

  public synchronized boolean d(String paramString1, String paramString2)
  {
    Object localObject1 = this.c.b(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof al)))
    {
      String[] arrayOfString = paramString2.split(",");
      for (int i = 0; i < arrayOfString.length; i++)
      {
        Object localObject2 = this.c.b(arrayOfString[i]);
        if (!(localObject2 instanceof PackageInfo))
          continue;
        ((PackageInfo)localObject2).getPackFile().delete();
        File localFile = new File(Property.getInstance().getRuleEngineClassDir(), ((PackageInfo)localObject2).getExename().replace('.', '/') + ".rsc");
        if (localFile.exists())
          localFile.delete();
        ((al)localObject1).removeInfo(localObject2);
        this.c.a(((PackageInfo)localObject2).getUuid());
        ((al)localObject1).getWebProject().a();
      }
      return true;
    }
    return false;
  }

  private String a(File paramFile, String paramString)
  {
    RulePackage localRulePackage = (RulePackage)new com.flagleader.repository.e.d().load(paramFile);
    String str = m.a().i().b(localRulePackage);
    if ((paramString == null) || (paramString.length() == 0))
      paramString = Property.getInstance().getRuleEngineClassDir();
    synchronized (this)
    {
      return new com.flagleader.repository.a.c().a(paramString, Property.getInstance().getRuleEngineJarsDir(), localRulePackage.getExeRulePackageName(), localRulePackage.getAllVersion(), localRulePackage.getRuleClassName(), str, true);
    }
  }

  public String e(String paramString1, String paramString2)
  {
    Object localObject1 = this.c.b(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof al)))
    {
      String[] arrayOfString = paramString2.split(",");
      try
      {
        for (int i = 0; i < arrayOfString.length; i++)
        {
          Object localObject2 = this.c.b(arrayOfString[i]);
          if (!(localObject2 instanceof PackageInfo))
            continue;
          a(((PackageInfo)localObject2).getPackFile(), Property.getInstance().getRuleEngineClassDir());
        }
      }
      catch (Exception localException)
      {
        return localException.getMessage();
      }
      return "";
    }
    return "empty";
  }

  public synchronized String f(String paramString1, String paramString2)
  {
    Object localObject1 = this.c.b(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof al)))
    {
      String[] arrayOfString = paramString2.split(",");
      for (int i = 0; i < arrayOfString.length; i++)
      {
        Object localObject2 = this.c.b(arrayOfString[i]);
        if (!(localObject2 instanceof PackageInfo))
          continue;
        File localFile = new File(Property.getInstance().getRuleEngineClassDir(), ((PackageInfo)localObject2).getExename().replace('.', '/') + ".rsc");
        if (!localFile.exists())
          continue;
        EngineProject localEngineProject = RuleEngineManager.getInstance().getProject(((PackageInfo)localObject2).getProjectName());
        if (localEngineProject != null)
          try
          {
            FileUtil.copy(localFile, new File(localEngineProject.getPath(), ((PackageInfo)localObject2).getExename().replace('.', '/') + ".rsc"), true);
          }
          catch (Exception localException1)
          {
            return "error:" + localException1.getMessage();
          }
        try
        {
          String str = this.c.a(localFile, ((PackageInfo)localObject2).getExename(), ((PackageInfo)localObject2).getProjectName());
          if (!StringUtil.isEmpty(str))
            return str;
        }
        catch (Exception localException2)
        {
          return localException2.getMessage();
        }
      }
      return "";
    }
    return "empty";
  }

  public List c(String paramString)
  {
    Object localObject = this.c.b(paramString);
    if (localObject != null)
    {
      ArrayList localArrayList;
      int i;
      if ((localObject instanceof ProjectInfo))
      {
        localArrayList = new ArrayList();
        for (i = 0; i < ((ProjectInfo)localObject).getPackageInfos().size(); i++)
        {
          if (!(((ProjectInfo)localObject).getPackageInfos().get(i) instanceof PackageInfo))
            continue;
          localArrayList.add(((ProjectInfo)localObject).getPackageInfos().get(i));
        }
        return localArrayList;
      }
      if ((localObject instanceof GroupInfo))
      {
        localArrayList = new ArrayList();
        for (i = 0; i < ((GroupInfo)localObject).getPackageInfos().size(); i++)
        {
          if (!(((GroupInfo)localObject).getPackageInfos().get(i) instanceof PackageInfo))
            continue;
          localArrayList.add(((GroupInfo)localObject).getPackageInfos().get(i));
        }
        return localArrayList;
      }
    }
    return null;
  }

  public boolean d()
  {
    if (this.b != null)
      return this.b.d();
    return false;
  }

  public boolean e()
  {
    if (this.b != null)
      return this.b.e();
    return false;
  }

  public boolean f()
  {
    if (this.b != null)
      return this.b.f();
    return false;
  }

  public boolean g()
  {
    if (this.b != null)
      return this.b.g();
    return false;
  }

  public boolean d(String paramString)
  {
    Object localObject = this.c.b(paramString);
    if ((localObject != null) && ((localObject instanceof ProjectInfo)))
    {
      if (((ProjectInfo)localObject).exitsPackage(null))
        throw new RuleExecuteException(u.a("nopackage.WebRepository", new String[] { ((ProjectInfo)localObject).getDisplayName() }));
      ((f)((ProjectInfo)localObject).getWebProject()).b();
      return true;
    }
    return false;
  }

  public boolean e(String paramString)
  {
    Object localObject = this.c.b(paramString);
    if ((localObject != null) && ((localObject instanceof GroupInfo)))
    {
      if (((GroupInfo)localObject).exitsPackage(null))
        throw new RuleExecuteException(u.a("nopackage.WebRepository", new String[] { ((GroupInfo)localObject).getDisplayName() }));
      ((GroupInfo)localObject).delete();
      return true;
    }
    return false;
  }

  public boolean h()
  {
    if (this.b != null)
      return this.b.h();
    return false;
  }

  public d i()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.g
 * JD-Core Version:    0.6.0
 */