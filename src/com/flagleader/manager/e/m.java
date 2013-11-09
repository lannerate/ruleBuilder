package com.flagleader.manager.e;

import com.flagleader.manager.a.e;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.d.u;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.StringUtil;
import java.io.File;

class m extends Thread
{
  m(l paraml, IRuleClass paramIRuleClass, String paramString, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = null;
    Object localObject1;
    Object localObject2;
    try
    {
      this.a.a(1);
      if (this.a.n().a().c().d().d(this.b.getMainPackage()))
      {
        this.a.a(100);
        this.a.b(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().getDisplayName() }));
        this.a.o().a(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().toString() + " : " }));
        return;
      }
      com.flagleader.repository.lang.a locala = com.flagleader.repository.m.a().f();
      this.a.a(20);
      if (this.a.j)
      {
        this.a.a(100);
        return;
      }
      localObject1 = locala.a(this.b, this.c, false);
      this.a.a(40);
      if (this.a.j)
      {
        this.a.a(100);
        return;
      }
      str1 = locala.a((File)localObject1, this.b.getClassPath());
      if (this.a.j)
      {
        this.a.a(100);
        return;
      }
      if ((str1 != null) && (str1.length() > 0))
      {
        this.a.b(str1);
        this.a.o().a(str1);
        this.a.o().a(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().toString() + " : " }));
        this.a.a(100);
        return;
      }
      sleep(10L);
      this.a.a(60);
      if (this.a.j)
      {
        this.a.a(100);
        return;
      }
      localObject2 = locala.a(this.b, true, this.c);
      this.a.a(80);
      this.a.o().c(c.a("HasBeenExport", new String[] { ((File)localObject2).getAbsolutePath() }));
    }
    catch (Exception localException)
    {
      this.a.b(localException.getMessage());
      this.a.o().a(localException.getMessage(), localException);
      this.a.o().a(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().toString() + " : " }));
      this.a.a(100);
      return;
    }
    if (str1 != null)
    {
      this.a.o().a(str1);
    }
    else if ((this.d) && ((this.b instanceof IRulePackage)))
    {
      String str2 = b.a().t();
      localObject1 = this.b.getExeRulePackageName().replace('.', '/');
      if (str2.endsWith("/"))
        str2 = str2 + (String)localObject1 + ".rsc";
      else
        str2 = str2 + "/" + (String)localObject1 + ".rsc";
      localObject2 = x.a().a(this);
      if (localObject2 == null)
      {
        this.a.b("no avariable ftp thread when export " + this.b.getDisplayName());
      }
      else
      {
        this.a.b("ftp excute " + this.b.getDisplayName());
        String str3 = ((com.flagleader.repository.d.l)localObject2).a(str2, new File(this.c, localObject1 + ".rsc"), true);
        x.a().a((com.flagleader.repository.d.l)localObject2);
        if (StringUtil.isEmpty(str3))
          this.a.o().c(c.a("HasBeenftpExport", new String[] { str2 }));
        else
          this.a.o().c(u.a("ftpUploadFile.error", new String[] { str3 }));
      }
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.m
 * JD-Core Version:    0.6.0
 */