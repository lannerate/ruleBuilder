package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.lang.h;

public class v
  implements e
{
  public v(u paramu)
  {
  }

  public int a()
  {
    for (int i = 0; i < b().length; i++)
      if (this.a.f().getEnumType().equals(b()[i]))
        return i;
    return 0;
  }

  public String[] b()
  {
    return this.a.f().getTypeManager().c();
  }

  public boolean a(int paramInt)
  {
    return a(this.a.f().getTypeManager().a()[paramInt]);
  }

  public boolean a(Object paramObject)
  {
    if (!this.a.f().getEnumType().equals(paramObject))
    {
      this.a.f().setEnumType(paramObject.toString());
      this.a.f().updateEnumType();
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      this.a.f().updateTree();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.v
 * JD-Core Version:    0.6.0
 */