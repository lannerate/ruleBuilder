package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.tree.ITreeNode;

public class u extends e
{
  public u(com.flagleader.manager.c.c paramc, EnumTable paramEnumTable, r paramr)
  {
    super(paramc, paramEnumTable, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.EnumTableDialog"), new l(this));
    if ((f().getParent() instanceof DBModel))
      a(com.flagleader.manager.d.c.b("sqlStr.EnumTableDialog"), new w(this));
    a(com.flagleader.manager.d.c.b("datatype.EnumTableDialog"), new v(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  public EnumTable f()
  {
    if ((d() != null) && ((d() instanceof EnumTable)))
      return (EnumTable)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.u
 * JD-Core Version:    0.6.0
 */