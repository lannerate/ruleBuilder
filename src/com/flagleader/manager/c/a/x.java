package com.flagleader.manager.c.a;

import com.flagleader.manager.c.d;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.a.b;
import com.flagleader.util.ListIterator;
import java.util.Iterator;

class x extends d
{
  x(w paramw)
  {
  }

  public Iterator a(String paramString)
  {
    return new ListIterator(w.a(this.a).f().getDBModel().getDBTableFields(b.a(this.a.b(), paramString)));
  }

  public Iterator a()
  {
    return new ListIterator(w.a(this.a).f().getDBModel().getDBTableNames());
  }

  public Iterator a_(String paramString)
  {
    if (b.b(paramString))
      return a();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.x
 * JD-Core Version:    0.6.0
 */