package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.TableModel;

public class ba
  implements e
{
  public ba(aX paramaX)
  {
  }

  public int a()
  {
    return this.a.f().getResultType();
  }

  public String[] b()
  {
    return aX.e;
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
 * Qualified Name:     com.flagleader.manager.c.a.ba
 * JD-Core Version:    0.6.0
 */