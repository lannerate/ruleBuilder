package com.flagleader.manager.e;

import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.impl.RuleRecordServer;
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
import com.flagleader.repository.tree.ao;
import com.flagleader.util.NumberUtil;
import java.io.File;
import java.util.List;

class L extends Thread
{
  L(K paramK, TestCase paramTestCase)
  {
  }

  public void run()
  {
    this.a.a(1);
    this.a.e = System.currentTimeMillis();
    if ((this.b.getRuleSet() != null) && (this.a.n().a().c().d().d(this.b.getRuleSet())))
    {
      this.a.a(100);
      this.a.b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getRuleSet().getDisplayName() }));
      this.a.o().b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getRuleSet().toString() + " : " }));
      return;
    }
    this.a.a.clear();
    try
    {
      if (this.b.getRuleSet() != null)
      {
        RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(this.b.getRuleSet().getCompilePath()));
        RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(this.b.getRuleSet().getClassPaths());
        RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(this.b.getRuleSet().getEnvionment().getClassDirs());
        RuleEngineFactory.getInstance(this.b.getRuleSet().getUuid()).getClassLoader().addResourceFile(new File(this.b.getRuleSet().getCompilePath()));
        RuleEngineFactory.getInstance(this.b.getRuleSet().getUuid()).getClassLoader().addResourceFiles(this.b.getRuleSet().getClassPaths());
        RuleEngineFactory.getInstance(this.b.getRuleSet().getUuid()).getClassLoader().addResourceFiles(this.b.getRuleSet().getEnvionment().getClassDirs());
        RuleEngineFactory.getInstance(this.b.getRuleSet().getUuid()).getClassLoader().addResourceFiles(com.flagleader.repository.d.a.d());
      }
      else
      {
        RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(this.b.getTestLib().getRepository().getExportExeRulePath()));
      }
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(com.flagleader.repository.d.a.d());
      RuleRecordServer.clearUnused();
    }
    catch (Exception localException)
    {
      this.a.n().a().j().a(localException.getLocalizedMessage(), localException);
    }
    long l = System.nanoTime();
    this.a.a(this.b);
    this.a.o().c(this.b.getDisplayName() + c.a("finish.Test", new String[] { NumberUtil.formatDouble((System.nanoTime() - l) / 1000000.0D, "0.00") }));
    if (this.a.a.size() > 0)
      this.a.n().a().m().a(this.a.a, false);
    this.a.a(100);
    this.a.f = System.currentTimeMillis();
    System.gc();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.L
 * JD-Core Version:    0.6.0
 */