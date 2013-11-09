package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.tree.ITreeNode;

public class f extends e
{
  public f(com.flagleader.manager.c.c paramc, CustomSql paramCustomSql, r paramr)
  {
    super(paramc, paramCustomSql, paramr);
  }

  public void a()
  {
    if (f().isDevelopModel())
    {
      a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
      a(com.flagleader.manager.d.c.b("disName.dialog"), new l(this));
      a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new com.flagleader.manager.c.f(this));
      a(com.flagleader.manager.d.c.b("sqlStr.CustomSqlProperties"), new h(this));
      a(com.flagleader.manager.d.c.b("datatype.CustomSqlProperties"), new g(this));
      a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
    }
  }

  public CustomSql f()
  {
    if ((d() != null) && ((d() instanceof CustomSql)))
      return (CustomSql)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.f
 * JD-Core Version:    0.6.0
 */