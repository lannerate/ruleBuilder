package com.flagleader.manager.e;

import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.repository.d.l;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.h;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.List;

class u extends Thread
{
  u(t paramt, IPage paramIPage, String paramString)
  {
  }

  public void run()
  {
    try
    {
      this.a.d = this.b.getDisplayName();
      String str1 = b.a().r();
      List localList = null;
      try
      {
        this.a.a(1);
        localList = this.b.exportFile(this.c);
        if (this.a.j)
        {
          this.a.a(100);
          return;
        }
        if (localList != null)
        {
          String str2 = new File(this.c).getPath();
          for (int i = 0; i < localList.size(); i++)
          {
            File localFile = (File)localList.get(i);
            if (localFile.exists())
            {
              l locall = x.a().a(this);
              if (locall == null)
              {
                this.a.b("no avariable ftp thread!");
              }
              else
              {
                if (localFile.getPath().toLowerCase().startsWith(str2.toLowerCase()))
                {
                  String str3 = str1 + StringUtil.replaceAll(localFile.getPath().substring(str2.length() + 1), "\\", "/");
                  String str4 = locall.a(str3, localFile, false);
                  if (StringUtil.isEmpty(str4))
                    this.a.o().c(c.a("HasBeenftpExport", new String[] { str3 }));
                  else
                    this.a.o().c(com.flagleader.repository.d.u.a("ftpUploadFile.error", new String[] { str4 }));
                }
                x.a().a(locall);
              }
            }
            this.a.a(100 / localList.size());
          }
        }
      }
      catch (Throwable localThrowable)
      {
        this.a.b(localThrowable.getLocalizedMessage());
        this.a.o().b(localThrowable.getMessage(), localThrowable);
        this.a.a(100);
        return;
      }
    }
    catch (Exception localException)
    {
      this.a.b(com.flagleader.repository.d.u.a("ftpUploadFile.error", new String[] { localException.getLocalizedMessage() }));
      this.a.o().a(com.flagleader.repository.d.u.a("ftpUploadFile.error", new String[] { localException.getLocalizedMessage() }));
      this.a.a(100);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.u
 * JD-Core Version:    0.6.0
 */