package com.flagleader.manager.e;

import com.flagleader.manager.a.e;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.h;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;

public class X extends W
{
  String a = null;

  public X(IRuleGroup paramIRuleGroup, String paramString)
  {
    super(paramIRuleGroup);
    this.a = paramString;
    this.g = new Y(this, paramIRuleGroup, paramString);
  }

  private boolean a(IRulePackage paramIRulePackage, String paramString)
  {
    String str1 = b.a(paramIRulePackage.getRepository()).f();
    String str2 = paramIRulePackage.getExeRulePackageName().replace('.', '/') + ".rsc";
    File localFile1 = new File(paramString, str2);
    File localFile2 = new File(str1, str2);
    if ((localFile2.exists()) && (localFile2.lastModified() > paramIRulePackage.getMaxModifyTime()))
    {
      if (!localFile1.getParentFile().exists())
        localFile1.getParentFile().mkdirs();
      FileUtil.copy(localFile2, new File(paramString, str2), true);
      return true;
    }
    String str3 = null;
    try
    {
      a(1);
      if (n().a().c().d().d(paramIRulePackage.getMainPackage()))
      {
        a(100);
        b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { paramIRulePackage.getMainPackage().getDisplayName() }));
        o().a(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { paramIRulePackage.getMainPackage().toString() + " : " }));
        return false;
      }
      com.flagleader.repository.lang.a locala = m.a().f();
      if (this.j)
      {
        a(100);
        return false;
      }
      File localFile3 = locala.a(paramIRulePackage, paramString, false);
      a(40);
      if (this.j)
      {
        a(100);
        return false;
      }
      str3 = locala.a(localFile3, paramIRulePackage.getClassPath());
      if (this.j)
      {
        a(100);
        return false;
      }
      if ((str3 != null) && (str3.length() > 0))
      {
        b(str3);
        o().a(str3);
        o().a(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { paramIRulePackage.getMainPackage().toString() + " : " }));
        a(100);
        return false;
      }
      if (this.j)
      {
        a(100);
        return false;
      }
      File localFile4 = locala.a(paramIRulePackage, true, paramString);
    }
    catch (Exception localException)
    {
      b(localException.getMessage());
      o().a(localException.getMessage(), localException);
      o().a(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { paramIRulePackage.getMainPackage().toString() + " : " }));
      a(100);
      return false;
    }
    if (str3 != null)
    {
      o().a(str3);
      a(100);
      return false;
    }
    return true;
  }

  public String b()
  {
    return super.b() + this.a;
  }

  public String a()
  {
    return c.b("ExportExeThreadInfo.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.X
 * JD-Core Version:    0.6.0
 */