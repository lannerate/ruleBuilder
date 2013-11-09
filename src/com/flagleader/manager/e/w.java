package com.flagleader.manager.e;

import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.repository.d.l;
import com.flagleader.repository.d.u;
import com.flagleader.repository.e.e;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.util.StringUtil;

class w extends Thread
{
  w(v paramv, IRulePackage paramIRulePackage)
  {
  }

  public void run()
  {
    try
    {
      this.a.d = ("ftp " + this.b.getDisplayName());
      String str1 = b.a().C();
      if (this.b.getProject() != null)
        str1 = str1 + this.b.getProject().getDisplayName() + "/data/";
      String str2 = this.b.getExeRulePackageName().replace('.', '/');
      if (str1.endsWith("/"))
        str1 = str1 + str2 + ".rpk";
      else
        str1 = str1 + "/" + str2 + ".rpk";
      String str3 = e.b(this.b);
      l locall = x.a().a(this);
      if (locall == null)
      {
        this.a.b("no avariable ftp thread!");
      }
      else
      {
        String str4 = locall.a(str1, str3);
        x.a().a(locall);
        if (StringUtil.isEmpty(str4))
          this.a.o().c(c.a("HasBeenftpExport", new String[] { this.b.getDisplayName() }));
        else
          this.a.o().c(u.a("ftpUploadFile.error", new String[] { str4 }));
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
 * Qualified Name:     com.flagleader.manager.e.w
 * JD-Core Version:    0.6.0
 */