package com.flagleader.manager.c.d;

import com.flagleader.manager.c.h;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleDBProject;

public class u extends h
{
  public u(com.flagleader.manager.c.c paramc, RuleDBProject paramRuleDBProject, r paramr)
  {
    super(paramc, paramRuleDBProject, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), c().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("projver.RuleProjectProperties"), new v(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  private RuleDBProject c()
  {
    if ((d() != null) && ((d() instanceof RuleDBProject)))
      return (RuleDBProject)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.u
 * JD-Core Version:    0.6.0
 */