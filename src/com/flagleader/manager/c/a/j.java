package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.f;
import com.flagleader.manager.d.a;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.ITreeNode;
import java.util.HashMap;

public class j extends e
{
  public static String[] e = com.flagleader.manager.d.c.d("transactionTypes.DatabaseDialog");
  public static String[] f;
  public static String[] g;
  private static HashMap h;
  private static String[] i;

  static
  {
    for (int j = 0; j < e.length; j++)
      e[j] = com.flagleader.manager.d.c.b(e[j] + ".DatabaseDialog");
    f = com.flagleader.manager.d.c.d("connType.DatabaseDialog");
    for (j = 0; j < f.length; j++)
      f[j] = com.flagleader.manager.d.c.b(f[j] + ".DatabaseDialog");
    g = a.b("drivers");
    h = new HashMap();
    i = new String[g.length];
    for (j = 0; j < g.length; j++)
      h.put(a.a(g[j] + ".Driver"), a.a(g[j] + ".URL"));
    for (j = 0; j < i.length; j++)
      i[j] = a.a(g[j] + ".Driver");
  }

  public j(com.flagleader.manager.c.c paramc, DBModel paramDBModel, com.flagleader.manager.r paramr)
  {
    super(paramc, paramDBModel, paramr);
  }

  public void a()
  {
    if (f().isDevelopModel())
    {
      a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
      a(com.flagleader.manager.d.c.b("disName.DatabasePropertiesEditor"), new com.flagleader.manager.c.l(this));
      a(com.flagleader.manager.d.c.b("name.DatabasePropertiesEditor"), new m(this));
      a(com.flagleader.manager.d.c.b("varName.DatabasePropertiesEditor"), new t(this));
      a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
      a(com.flagleader.manager.d.c.b("Driver.DatabaseDialog"), new n(this));
      a(com.flagleader.manager.d.c.b("URL.DatabaseDialog"), new r(this));
      a(com.flagleader.manager.d.c.b("UserName.DatabaseDialog"), new s(this));
      b(com.flagleader.manager.d.c.b("Password.DatabaseDialog"), new o(this));
      a(com.flagleader.manager.d.c.b("catalog.DatabaseDialog"), new k(this));
      a(com.flagleader.manager.d.c.b("schema.DatabaseDialog"), new p(this));
      a(com.flagleader.manager.d.c.b("commitType.DatabaseDialog"), new l(this));
      a(com.flagleader.manager.d.c.b("transactionType.DatabaseDialog"), new q(this));
      a(com.flagleader.manager.d.c.b("order.dialog"), new com.flagleader.manager.c.m(this));
    }
  }

  public DBModel f()
  {
    if ((d() != null) && ((d() instanceof DBModel)))
      return (DBModel)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.j
 * JD-Core Version:    0.6.0
 */