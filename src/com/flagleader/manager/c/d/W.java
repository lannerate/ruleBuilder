package com.flagleader.manager.c.d;

import com.flagleader.manager.c.h;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleProject;

public class W extends h
{
  public static String[] a = com.flagleader.manager.d.c.d("savetypes.RuleProjectProperties");

  static
  {
    for (int i = 0; i < a.length; i++)
      a[i] = com.flagleader.manager.d.c.b(a[i] + ".RuleProjectProperties");
  }

  public W(com.flagleader.manager.c.c paramc, RuleProject paramRuleProject, r paramr)
  {
    super(paramc, paramRuleProject, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), c().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("projectdir.dialog"), c().getFilePath());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("projver.RuleProjectProperties"), new X(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
    a(com.flagleader.manager.d.c.b("savetype.RuleProjectProperties"), new Y(this));
  }

  private RuleProject c()
  {
    if ((d() != null) && ((d() instanceof RuleProject)))
      return (RuleProject)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.W
 * JD-Core Version:    0.6.0
 */