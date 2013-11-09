package com.flagleader.manager.c.d;

import com.flagleader.manager.c.h;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.TestCaseLib;

public class aC extends h
{
  public aC(com.flagleader.manager.c.c paramc, TestCaseLib paramTestCaseLib, r paramr)
  {
    super(paramc, paramTestCaseLib, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), c().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), c().getModifyUser());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("exepackagename.dialog"), new aD(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  private TestCaseLib c()
  {
    if ((d() != null) && ((d() instanceof TestCaseLib)))
      return (TestCaseLib)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.aC
 * JD-Core Version:    0.6.0
 */