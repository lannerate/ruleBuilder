package com.flagleader.manager.e;

import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.manager.a.e;
import com.flagleader.manager.d.c;
import com.flagleader.manager.n;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.util.NumberUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

class J extends Thread
{
  J(I paramI, TestCaseLib paramTestCaseLib)
  {
  }

  public void run()
  {
    this.a.a(1);
    this.a.e = System.currentTimeMillis();
    if ((this.b.getMainPackage() != null) && (this.a.n().a().c().d().d(this.b.getMainPackage().getMainPackage())))
    {
      this.a.a(100);
      this.a.b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().getDisplayName() }));
      this.a.o().b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().toString() + " : " }));
      return;
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
    ArrayList localArrayList = this.b.getTestInfos();
    for (int i = 0; i < localArrayList.size(); i++)
    {
      this.a.a(100 * i / localArrayList.size());
      this.a.a((TestCase)localArrayList.get(i));
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
 * Qualified Name:     com.flagleader.manager.e.J
 * JD-Core Version:    0.6.0
 */