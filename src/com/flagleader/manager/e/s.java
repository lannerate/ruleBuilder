package com.flagleader.manager.e;

import com.flagleader.manager.a.e;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.t;
import com.flagleader.repository.d.l;
import com.flagleader.repository.d.u;
import com.flagleader.repository.h;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.StringUtil;
import java.io.File;

class s extends Thread
{
  s(r paramr, IRulePackage paramIRulePackage, String paramString)
  {
  }

  public void run()
  {
    try
    {
      this.a.d = ("ftp excute " + this.b.getDisplayName());
      String str1 = b.a().t();
      String str2 = this.b.getExeRulePackageName().replace('.', '/');
      if (str1.endsWith("/"))
        str1 = str1 + str2 + ".rsc";
      else
        str1 = str1 + "/" + str2 + ".rsc";
      File localFile1 = new File(this.c, str2 + ".rsc");
      if (!localFile1.exists())
      {
        localObject = null;
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
          com.flagleader.repository.lang.a locala = m.a().f();
          this.a.a(20);
          if (this.a.j)
          {
            this.a.a(100);
            return;
          }
          File localFile2 = locala.a(this.b, this.c, false);
          this.a.a(40);
          if (this.a.j)
          {
            this.a.a(100);
            return;
          }
          localObject = locala.a(localFile2, this.b.getClassPath());
          if (this.a.j)
          {
            this.a.a(100);
            return;
          }
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.a.b((String)localObject);
            this.a.o().a((String)localObject);
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
          localFile1 = locala.a(this.b, true, this.c);
          this.a.a(80);
          this.a.o().c(c.a("HasBeenExport", new String[] { localFile1.getAbsolutePath() }));
        }
        catch (Exception localException)
        {
          this.a.b(localException.getMessage());
          this.a.o().a(localException.getMessage(), localException);
          this.a.o().a(c.a("errorRulePackage.ExportExeThreadInfo", new String[] { this.b.getMainPackage().toString() + " : " }));
          this.a.a(100);
          return;
        }
      }
      Object localObject = x.a().a(this);
      if (localObject == null)
      {
        this.a.b("no avariable ftp thread!");
      }
      else
      {
        String str3 = ((l)localObject).a(str1, new File(this.c, str2 + ".rsc"), true);
        x.a().a((l)localObject);
        if (StringUtil.isEmpty(str3))
          this.a.o().c(c.a("HasBeenftpExport", new String[] { str1 }));
        else
          this.a.o().c(u.a("ftpUploadFile.error", new String[] { str3 }));
      }
    }
    catch (Throwable localThrowable)
    {
      this.a.b(u.a("ftpUploadFile.error", new String[] { localThrowable.getLocalizedMessage() }));
      this.a.o().a(u.a("ftpUploadFile.error", new String[] { localThrowable.getLocalizedMessage() }));
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.s
 * JD-Core Version:    0.6.0
 */