package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.lang.h;

public class g
  implements e
{
  public g(f paramf)
  {
  }

  public int a()
  {
    for (int i = 0; i < b().length; i++)
      if (this.a.f().getValueType().equals(b()[i]))
        return i;
    return 0;
  }

  public String[] b()
  {
    return this.a.f().getTypeManager().b();
  }

  public boolean a(int paramInt)
  {
    return a(this.a.f().getTypeManager().b()[paramInt]);
  }

  private boolean a(Object paramObject)
  {
    if (!this.a.f().getValueType().equals(paramObject))
    {
      this.a.f().changeValueType(paramObject.toString());
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      this.a.f().updateTree();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.g
 * JD-Core Version:    0.6.0
 */