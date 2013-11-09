package com.flagleader.manager.e;

import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.manager.a.e;
import com.flagleader.manager.d.c;
import com.flagleader.manager.n;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.h;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.util.NumberUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

class O extends Thread
{
  O(N paramN, CheckRuleInfo paramCheckRuleInfo)
  {
  }

  public void run()
  {
    this.a.a(1);
    this.a.e = System.currentTimeMillis();
    if (this.b.getMainPackage() != null)
    {
      if (this.a.n().a().c().d().d(this.b.getMainPackage().getMainPackage()))
      {
        this.a.a(100);
        this.a.b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().getDisplayName() }));
        this.a.o().b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().toString() + " : " }));
        return;
      }
      if (this.b.getMainPackage().needRecompile())
        try
        {
          IRulePackage localIRulePackage = this.b.getMainPackage();
          if (this.a.j)
          {
            this.a.a(100);
            return;
          }
          com.flagleader.repository.lang.a locala = m.a().f();
          localObject = locala.a(localIRulePackage, localIRulePackage.getCompilePath(), false);
          this.a.a(20);
          if (this.a.j)
          {
            this.a.a(100);
            return;
          }
          String str = locala.a((File)localObject, localIRulePackage.getClassPath());
          if (this.a.j)
          {
            this.a.a(100);
            return;
          }
          if ((str != null) && (str.length() > 0))
          {
            this.a.b(str);
            this.a.o().b(str);
            this.a.a(100);
            return;
          }
          locala.a(localIRulePackage, true, localIRulePackage.getCompilePath());
        }
        catch (Exception localException)
        {
          this.a.b(localException.getMessage());
          this.a.o().b(localException.getMessage(), localException);
          this.a.a(100);
          return;
        }
      this.a.a(40);
    }
    this.a.a.clear();
    this.a.n().a().m().a(this.a.a, false);
    try
    {
      if (this.b.getMainPackage() != null)
      {
        RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(this.b.getMainPackage().getCompilePath()));
        RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(this.b.getMainPackage().getClassPaths());
        RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(this.b.getMainPackage().getEnvionment().getClassDirs());
      }
      else
      {
        RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(this.b.getRepository().getExportExeRulePath()));
      }
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(com.flagleader.repository.d.a.d());
      if (this.b.getMainPackage() != null)
      {
        RuleEngineFactory.getInstance(this.b.getMainPackage().getUuid()).getClassLoader().addResourceFile(new File(this.b.getMainPackage().getCompilePath()));
        RuleEngineFactory.getInstance(this.b.getMainPackage().getUuid()).getClassLoader().addResourceFiles(this.b.getMainPackage().getClassPaths());
        RuleEngineFactory.getInstance(this.b.getMainPackage().getUuid()).getClassLoader().addResourceFiles(this.b.getMainPackage().getEnvionment().getClassDirs());
        RuleEngineFactory.getInstance(this.b.getMainPackage().getUuid()).getClassLoader().addResourceFiles(com.flagleader.repository.d.a.d());
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.a.n().a().j().a(localMalformedURLException.getLocalizedMessage(), localMalformedURLException);
    }
    long l = System.nanoTime();
    Object localObject = this.b.getTestInfos();
    for (int i = 0; i < ((List)localObject).size(); i++)
    {
      this.a.a(40 + 40 * i / ((List)localObject).size());
      this.a.a((TestCase)((List)localObject).get(i));
    }
    this.a.o().c(this.b.getDisplayName() + c.a("finish.Test", new String[] { NumberUtil.formatDouble((System.nanoTime() - l) / 1000000.0D, "0.00") }));
    if (this.a.a.size() > 0)
      this.a.n().a().m().a(this.a.a, true);
    this.a.a(100);
    this.a.f = System.currentTimeMillis();
    System.gc();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.O
 * JD-Core Version:    0.6.0
 */