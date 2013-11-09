package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.r;
import com.flagleader.repository.db.SheetTable;

public class aE
  implements com.flagleader.manager.c.c.a
{
  public aE(aw paramaw)
  {
  }

  public int a()
  {
    return 4;
  }

  public String b()
  {
    return this.a.f().getSqlSelect();
  }

  public com.flagleader.manager.c.a c()
  {
    return new aF(this);
  }

  public boolean a(String paramString)
  {
    try
    {
      if (!this.a.f().getSqlSelect().equals(paramString))
      {
        this.a.f().changeSqlText(paramString.toString());
        this.a.f().setModified(true);
        this.a.f().updateViewer();
        return true;
      }
    }
    catch (Exception localException)
    {
      aw.a(this.a).b().showError(localException.getLocalizedMessage());
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aE
 * JD-Core Version:    0.6.0
 */