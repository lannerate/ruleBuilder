package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.e.e;
import com.flagleader.repository.tree.IRulePackage;

class i extends Thread
{
  i(h paramh, IRulePackage paramIRulePackage, String paramString)
  {
  }

  public void run()
  {
    try
    {
      this.a.d = ("deploying " + this.b.getDisplayName());
      g localg = new g(this.c);
      String str1 = e.b(this.b);
      String str2 = localg.b(str1);
      if (str2.startsWith("<r><e>"))
      {
        String str3 = str2.substring(6, str2.length() - 8);
        this.a.b(str3);
        this.a.o().a(str3);
      }
      else
      {
        this.a.o().d(c.a("uploadfinish.ftp", new String[] { this.b.getDisplayName() }));
      }
    }
    catch (Exception localException)
    {
      this.a.b(c.b("ftpUploadFile.error") + localException.getLocalizedMessage());
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.i
 * JD-Core Version:    0.6.0
 */