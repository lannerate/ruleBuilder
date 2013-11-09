package com.flagleader.manager.e;

import com.flagleader.manager.a.e;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.h;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import java.io.File;

class T extends Thread
{
  T(S paramS, IRuleClass paramIRuleClass, String paramString)
  {
  }

  public void run()
  {
    String str = null;
    try
    {
      this.a.a(1);
      if (this.b.needRecompile())
      {
        if (this.a.n().a().c().d().d(this.b.getCompilePackage()))
        {
          this.a.a(100);
          this.a.b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getCompilePackage().getDisplayName() }));
          this.a.o().b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getCompilePackage().toString() + " : " }));
          return;
        }
        if (this.a.j)
        {
          this.a.a(100);
          return;
        }
        com.flagleader.repository.lang.a locala = m.a().f();
        File localFile = locala.a(this.b, this.b.getCompilePath(), false);
        this.a.a(20);
        if (this.a.j)
        {
          this.a.a(100);
          return;
        }
        str = locala.a(localFile, this.b.getClassPath());
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
        locala.a(this.b, true, this.b.getCompilePath());
      }
      this.a.a(40);
      if (this.a.j)
      {
        this.a.a(100);
        return;
      }
    }
    catch (Exception localException1)
    {
      this.a.b(localException1.getMessage());
      this.a.o().b(localException1.getMessage(), localException1);
      this.a.a(100);
      return;
    }
    try
    {
      this.a.a(this.c);
    }
    catch (Exception localException2)
    {
      this.a.o().a("exception : " + localException2.getMessage());
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.T
 * JD-Core Version:    0.6.0
 */