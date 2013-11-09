package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.d;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;

public class aI
  implements d
{
  public aI(aw paramaw)
  {
  }

  public String a()
  {
    return this.a.f().getTestFile();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getTestFile().equalsIgnoreCase(paramString))
    {
      if ((paramString == null) || (paramString.length() == 0))
      {
        this.a.f().setTestFile("");
        this.a.f().setModified(true);
        this.a.f().updateViewer();
        return true;
      }
      File localFile = new File(paramString);
      if (localFile.exists())
        try
        {
          FileUtil.copy(localFile, new File(b.a().f(), localFile.getName()), true);
        }
        catch (Exception localException)
        {
          EngineLogger.getEngineLogger().error(localException.getMessage(), localException);
        }
      this.a.f().setTestFile(localFile.getName());
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }

  public String[] b()
  {
    return new String[] { "*.xls;*.csv" };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aI
 * JD-Core Version:    0.6.0
 */