package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.manager.d.c;
import com.flagleader.repository.db.TableModel;

public class aY
  implements e
{
  public aY(aX paramaX)
  {
  }

  public int a()
  {
    return this.a.f().getAccessType();
  }

  public String[] b()
  {
    return new String[] { c.b("notAccess.TableModelDialog"), c.b("access.TableModelDialog"), c.b("shareAccess.TableModelDialog") };
  }

  public boolean a(int paramInt)
  {
    this.a.f().setAccessType(paramInt);
    this.a.f().setModified(true);
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aY
 * JD-Core Version:    0.6.0
 */