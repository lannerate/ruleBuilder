package com.flagleader.repository.f;

import com.flagleader.engine.EngineProject;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineManager;
import com.flagleader.engine.RuleExecuteException;
import com.flagleader.repository.d.u;
import com.flagleader.repository.e.e;
import com.flagleader.repository.e.h;
import com.flagleader.repository.f;
import com.flagleader.repository.lang.a;
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

public class m extends q
{
  private String a = null;
  private o b;
  private n c = n.e();

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
    o localo = this.c.a(paramString1, paramString2);
    if (localo != null)
    {
      this.b = localo;
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
    {
      k localk = new k();
      localk.b(paramString);
      this.c.a(localk);
      this.b.c(paramString);
      try
      {
        this.c.d();
      }
      catch (Exception localException)
      {
      }
      return localk;
    }
    return null;
  }

  public boolean d(String paramString)
  {
    Object localObject = this.c.c(paramString);
    if ((localObject != null) && ((localObject instanceof ProjectInfo)))
    {
      if (((ProjectInfo)localObject).exitsPackage(null))
        throw new RuleExecuteException(u.a("nopackage.WebRepository", new String[] { ((ProjectInfo)localObject).getDisplayName() }));
      ((k)((ProjectInfo)localObject).getWebProject()).b();
      return true;
    }
    return false;
  }

  public boolean e(String paramString)
  {
    Object localObject = this.c.c(paramString);
    if ((localObject != null) && ((localObject instanceof GroupInfo)))
    {
      if (((GroupInfo)localObject).exitsPackage(null))
        throw new RuleExecuteException(u.a("nopackage.WebRepository", new String[] { ((GroupInfo)localObject).getDisplayName() }));
      p localp = ((GroupInfo)localObject).getWebProject();
      ((GroupInfo)localObject).delete();
      localp.a();
      return true;
    }
    return false;
  }

  public boolean b(String paramString1, String paramString2)
  {
    Object localObject = this.c.c(paramString1);
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
    Object localObject = this.c.c(paramString1);
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
    Object localObject1 = this.c.c(paramString1);
    Object localObject2 = this.c.c(paramString4);
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof PackageInfo)))
    {
      RulePackage localRulePackage2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if ((localObject1 instanceof ProjectInfo))
      {
        if (((ProjectInfo)localObject1).exitsPackage(paramString2))
          break label530;
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
          localObject4 = new File(f((String)localObject3), "/data/" + paramString2.replace('.', '/') + ".rpk");
          if (!((File)localObject4).getParentFile().exists())
            ((File)localObject4).getParentFile().mkdirs();
          e.a(localRulePackage2, (File)localObject4);
          localObject5 = a(localRulePackage2, Property.getInstance().getRuleEngineClassDir());
          localObject6 = new PackageInfo(paramString2, (File)localObject4);
          ((ProjectInfo)localObject1).addPackageInfo((f)localObject6);
          this.c.a((PackageInfo)localObject6);
          ((ProjectInfo)localObject1).getWebProject().a();
          return localObject6;
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
            localObject4 = localProjectInfo.getDisplayName();
            if (StringUtil.isEmpty((String)localObject4))
              localObject4 = "ruleproj";
            localObject5 = new File(f((String)localObject4), "/data/" + paramString2.replace('.', '/') + ".rpk");
            if (!((File)localObject5).getParentFile().exists())
              ((File)localObject5).getParentFile().mkdirs();
            e.a((RulePackage)localObject3, (File)localObject5);
            localObject6 = a((RulePackage)localObject3, Property.getInstance().getRuleEngineClassDir());
            PackageInfo localPackageInfo = new PackageInfo(paramString2, (File)localObject5);
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
    label530: return (PackageInfo)(PackageInfo)(PackageInfo)(PackageInfo)null;
  }

  public static String a(RulePackage paramRulePackage, String paramString)
  {
    String str = null;
    try
    {
      if (paramRulePackage.getMainPackage().needCheck())
        paramRulePackage.getMainPackage().setError(new h().c(paramRulePackage.getMainPackage()));
      boolean bool = paramRulePackage.getMainPackage().hasError();
      if (paramRulePackage.getMainPackage().hasError())
        return a(paramRulePackage.getMainPackage().getErrorList());
      a locala = com.flagleader.repository.m.a().f();
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

  public File f(String paramString)
  {
    return new File(this.c.c(), paramString);
  }

  public synchronized PackageInfo a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = this.c.c(paramString1);
    if (localObject1 != null)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if ((localObject1 instanceof ProjectInfo))
      {
        if (((ProjectInfo)localObject1).exitsPackage(paramString2))
          break label448;
        localObject2 = new RulePackage(paramString3);
        ((RulePackage)localObject2).setExeRulePackageName(paramString2);
        ((RulePackage)localObject2).setVmlFlowType(0);
        localObject3 = ((ProjectInfo)localObject1).getDisplayName();
        if (StringUtil.isEmpty((String)localObject3))
          localObject3 = "ruleproj";
        localObject4 = new File(f((String)localObject3), "/data/" + paramString2.replace('.', '/') + ".rpk");
        try
        {
          if (!((File)localObject4).getParentFile().exists())
            ((File)localObject4).getParentFile().mkdirs();
          e.a((RulePackage)localObject2, (File)localObject4);
          String str = a((RulePackage)localObject2, Property.getInstance().getRuleEngineClassDir());
          localObject5 = new PackageInfo(paramString2, (File)localObject4);
          ((ProjectInfo)localObject1).addPackageInfo((f)localObject5);
          this.c.a((PackageInfo)localObject5);
          ((ProjectInfo)localObject1).getWebProject().a();
          return localObject5;
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
          localObject4 = ((ProjectInfo)localObject2).getDisplayName();
          if (StringUtil.isEmpty((String)localObject4))
            localObject4 = "ruleproj";
          File localFile = new File(f((String)localObject4), "/data/" + paramString2.replace('.', '/') + ".rpk");
          try
          {
            if (!localFile.getParentFile().exists())
              localFile.getParentFile().mkdirs();
            e.a((RulePackage)localObject3, localFile);
            localObject5 = a((RulePackage)localObject3, Property.getInstance().getRuleEngineClassDir());
            PackageInfo localPackageInfo = new PackageInfo(paramString2, localFile);
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
    label448: return (PackageInfo)(PackageInfo)(PackageInfo)(PackageInfo)null;
  }

  public Object b(String paramString)
  {
    return this.c.c(paramString);
  }

  public synchronized boolean d(String paramString1, String paramString2)
  {
    Object localObject1 = this.c.c(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof al)))
    {
      String[] arrayOfString = paramString2.split(",");
      for (int i = 0; i < arrayOfString.length; i++)
      {
        Object localObject2 = this.c.c(arrayOfString[i]);
        if (!(localObject2 instanceof PackageInfo))
          continue;
        ((PackageInfo)localObject2).getPackFile().delete();
        File localFile = new File(Property.getInstance().getRuleEngineClassDir(), ((PackageInfo)localObject2).getExename().replace('.', '/') + ".rsc");
        if (localFile.exists())
          localFile.delete();
        ((al)localObject1).removeInfo(localObject2);
        this.c.b(((PackageInfo)localObject2).getUuid());
        ((al)localObject1).getWebProject().a();
      }
      return true;
    }
    return false;
  }

  private String a(File paramFile, String paramString)
  {
    RulePackage localRulePackage = (RulePackage)new com.flagleader.repository.e.d().load(paramFile);
    String str = com.flagleader.repository.m.a().i().b(localRulePackage);
    if ((paramString == null) || (paramString.length() == 0))
      paramString = Property.getInstance().getRuleEngineClassDir();
    synchronized (this)
    {
      return new com.flagleader.repository.a.c().a(paramString, Property.getInstance().getRuleEngineJarsDir(), localRulePackage.getExeRulePackageName(), localRulePackage.getAllVersion(), localRulePackage.getRuleClassName(), str, true);
    }
  }

  public String e(String paramString1, String paramString2)
  {
    Object localObject1 = this.c.c(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof al)))
    {
      String[] arrayOfString = paramString2.split(",");
      try
      {
        for (int i = 0; i < arrayOfString.length; i++)
        {
          Object localObject2 = this.c.c(arrayOfString[i]);
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
    Object localObject1 = this.c.c(paramString1);
    if ((localObject1 != null) && ((localObject1 instanceof al)))
    {
      String[] arrayOfString = paramString2.split(",");
      for (int i = 0; i < arrayOfString.length; i++)
      {
        Object localObject2 = this.c.c(arrayOfString[i]);
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
          catch (Exception localException)
          {
            return "error:" + localException.getMessage();
          }
        String str = this.c.a(localFile, ((PackageInfo)localObject2).getExename());
        if (!StringUtil.isEmpty(str))
          return str;
      }
      return "";
    }
    return "empty";
  }

  public List c(String paramString)
  {
    Object localObject = this.c.c(paramString);
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
      return this.b.e();
    return false;
  }

  public boolean e()
  {
    if (this.b != null)
      return this.b.f();
    return false;
  }

  public boolean f()
  {
    if (this.b != null)
      return this.b.g();
    return false;
  }

  public boolean g()
  {
    if (this.b != null)
      return this.b.h();
    return false;
  }

  public boolean h()
  {
    if (this.b != null)
      return this.b.i();
    return false;
  }

  public d i()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.m
 * JD-Core Version:    0.6.0
 */