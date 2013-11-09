package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.DBModel;
import java.util.HashMap;

public class n
  implements e
{
  public n(j paramj)
  {
  }

  public int a()
  {
    for (int i = 0; i < j.g().length; i++)
      if (this.a.f().getDriver().equals(j.g()[i]))
        return i;
    return 0;
  }

  public String[] b()
  {
    return j.g();
  }

  public boolean a(int paramInt)
  {
    return a(j.g()[paramInt]);
  }

  private boolean a(Object paramObject)
  {
    if (!this.a.f().getDriver().equals(paramObject))
    {
      this.a.f().setDriver(paramObject.toString());
      if (j.h().containsKey(paramObject))
      {
        this.a.f().setUrl((String)j.h().get(paramObject));
        this.a.f().updateViewer();
      }
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.n
 * JD-Core Version:    0.6.0
 */