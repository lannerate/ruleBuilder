package com.flagleader.manager.c.d;

import com.flagleader.manager.c.h;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleGroup;

public class w extends h
{
  public w(com.flagleader.manager.c.c paramc, RuleGroup paramRuleGroup, r paramr)
  {
    super(paramc, paramRuleGroup, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  private RuleGroup c()
  {
    if ((d() != null) && ((d() instanceof RuleGroup)))
      return (RuleGroup)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.w
 * JD-Core Version:    0.6.0
 */