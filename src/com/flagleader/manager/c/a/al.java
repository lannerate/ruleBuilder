package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.tree.ITreeNode;

public class al extends e
{
  public static String[] e = com.flagleader.manager.d.c.d("resultTypes.TableModelPropertiesEditor");

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".TableModelPropertiesEditor");
  }

  public al(com.flagleader.manager.c.c paramc, SelectTable paramSelectTable, r paramr)
  {
    super(paramc, paramSelectTable, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.SelectTableDialog"), new l(this));
    a(com.flagleader.manager.d.c.b("varName.SelectTableDialog"), new aq(this));
    a(com.flagleader.manager.d.c.b("aftercommit.SelectTableDialog"), new am(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("sqlStr.SelectTableDialog"), new an(this));
    a(com.flagleader.manager.d.c.b("resultType.dialog"), new ap(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  public SelectTable f()
  {
    if ((d() != null) && ((d() instanceof SelectTable)))
      return (SelectTable)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.al
 * JD-Core Version:    0.6.0
 */