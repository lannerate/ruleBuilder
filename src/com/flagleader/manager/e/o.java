package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.d.l;
import com.flagleader.repository.d.u;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.h;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.List;

class o extends Thread
{
  o(n paramn, IPage paramIPage, String paramString, boolean paramBoolean)
  {
  }

  public void run()
  {
    List localList = null;
    Object localObject;
    try
    {
      this.a.a(1);
      this.a.a(30);
      localList = this.b.exportFile(this.c);
      if (this.a.j)
      {
        this.a.a(100);
        return;
      }
      if (localList != null)
        for (int i = 0; i < localList.size(); i++)
        {
          localObject = (File)localList.get(i);
          if (!com.flagleader.repository.a.b.a(((File)localObject).getName()))
            continue;
          this.a.a.a(((File)localObject).getPath(), (File)localObject, getClass().getClassLoader());
        }
      this.a.a(60);
      this.a.o().c(c.a("HasBeenExport", new String[] { new File(this.c, this.b.getDisplayName()).getAbsolutePath() }));
    }
    catch (Exception localException)
    {
      this.a.b(localException.getLocalizedMessage());
      this.a.o().b(localException.getMessage(), localException);
      this.a.a(100);
      return;
    }
    if (this.d)
    {
      String str1 = new File(this.c).getPath();
      localObject = com.flagleader.manager.d.b.a().r();
      l locall = x.a().a(this);
      if (locall == null)
      {
        this.a.o().c(c.a("noftpThead.error", new String[] { this.b.getDisplayName() }));
      }
      else
      {
        this.a.d = ("ftp " + this.b.getDisplayName());
        if (localList != null)
          for (int j = 0; j < localList.size(); j++)
          {
            File localFile = (File)localList.get(j);
            if (!localFile.getPath().toLowerCase().startsWith(str1.toLowerCase()))
              continue;
            String str2 = localObject + StringUtil.replaceAll(localFile.getPath().substring(str1.length() + 1), "\\", "/");
            String str3 = locall.a(str2, localFile, false);
            if (StringUtil.isEmpty(str3))
              this.a.o().c(c.a("HasBeenftpExport", new String[] { str2 }));
            else
              this.a.o().c(u.a("ftpUploadFile.error", new String[] { str3 }));
          }
        x.a().a(locall);
      }
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.o
 * JD-Core Version:    0.6.0
 */