package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.r;
import com.flagleader.repository.db.SheetTable;

public class aG
  implements com.flagleader.manager.c.c.a
{
  public aG(aw paramaw)
  {
  }

  public int a()
  {
    return 4;
  }

  public String b()
  {
    return this.a.f().getSqlScript();
  }

  public com.flagleader.manager.c.a c()
  {
    return new aH(this);
  }

  public boolean a(String paramString)
  {
    try
    {
      if (!this.a.f().getSqlScript().equals(paramString))
      {
        this.a.f().setSqlScript(paramString.toString());
        this.a.f().setModified(true);
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
 * Qualified Name:     com.flagleader.manager.c.a.aG
 * JD-Core Version:    0.6.0
 */