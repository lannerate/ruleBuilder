package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.db.SelectTable;

public class am
  implements b
{
  public am(al paramal)
  {
  }

  public boolean a()
  {
    return this.a.f().isAfterCommit();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isAfterCommit() != paramBoolean)
    {
      this.a.f().setAfterCommit(paramBoolean);
      this.a.f().setModified(true);
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.am
 * JD-Core Version:    0.6.0
 */