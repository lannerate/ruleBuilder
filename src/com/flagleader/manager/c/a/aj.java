package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.ProcedureModel;

public class aj
  implements e
{
  public aj(ag paramag)
  {
  }

  public int a()
  {
    return this.a.f().getResultType();
  }

  public String[] b()
  {
    return ag.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getResultType())
    {
      this.a.f().setResultType(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aj
 * JD-Core Version:    0.6.0
 */