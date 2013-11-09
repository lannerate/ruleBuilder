package com.flagleader.manager.c.d;

import com.flagleader.manager.c.h;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.TestCase;

public class aE extends h
{
  public aE(com.flagleader.manager.c.c paramc, TestCase paramTestCase, r paramr)
  {
    super(paramc, paramTestCase, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), c().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), c().getModifyUser());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  private TestCase c()
  {
    if ((d() != null) && ((d() instanceof TestCase)))
      return (TestCase)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.aE
 * JD-Core Version:    0.6.0
 */