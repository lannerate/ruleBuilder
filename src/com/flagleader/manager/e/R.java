package com.flagleader.manager.e;

import com.flagleader.manager.a.e;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.h;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import java.io.File;

class R extends Thread
{
  R(Q paramQ, IRuleTree paramIRuleTree)
  {
  }

  public void run()
  {
    String str = null;
    try
    {
      this.a.a(1);
      if (this.a.a.needRecompile())
      {
        if (this.a.n().a().c().d().d(this.a.a.getCompilePackage()))
        {
          this.a.a(100);
          this.a.b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.a.a.getCompilePackage().getDisplayName() }));
          this.a.o().b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.a.a.getCompilePackage().toString() + " : " }));
        }
        while (true)
        {
          return;
          if (!this.a.j)
            break;
          this.a.a(100);
        }
        if (this.b.getMainPackage() != null)
          this.b.setRunBreak(true);
        com.flagleader.repository.lang.a locala = m.a().f();
        File localFile = locala.a(this.a.a, this.a.a.getCompilePath(), true);
        this.a.a(20);
        if (this.a.j)
        {
          this.a.a(100);
          return;
        }
        str = locala.a(localFile, this.a.a.getClassPath());
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
        locala.a(this.a.a, true, this.a.a.getCompilePath());
      }
      this.a.a(40);
    }
    catch (Throwable localThrowable)
    {
      this.a.b(localThrowable.getMessage());
      this.a.o().b(localThrowable.getMessage(), localThrowable);
      this.a.a(100);
      return;
    }
    finally
    {
      this.b.setRunBreak(false);
    }
    this.b.setRunBreak(false);
    try
    {
      if (this.a.j)
      {
        this.a.a(100);
        return;
      }
      this.a.a("");
    }
    catch (Exception localException)
    {
      this.a.o().b(localException.getMessage());
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.R
 * JD-Core Version:    0.6.0
 */