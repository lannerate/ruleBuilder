package com.flagleader.manager.c.a;

import com.flagleader.manager.c.d;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.a.b;
import com.flagleader.util.ListIterator;
import java.util.Iterator;

class ao extends d
{
  ao(an paraman)
  {
  }

  public Iterator a(String paramString)
  {
    return new ListIterator(an.a(this.a).f().getDBModel().getDBTableFields(b.a(this.a.b(), paramString)));
  }

  public Iterator a()
  {
    return new ListIterator(an.a(this.a).f().getDBModel().getDBTableNames());
  }

  public Iterator a_(String paramString)
  {
    if (b.b(paramString))
      return a();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ao
 * JD-Core Version:    0.6.0
 */