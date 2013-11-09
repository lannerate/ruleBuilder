package com.flagleader.manager.c.d;

import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.RuleTreeFlow;

public class an extends a
{
  public an(com.flagleader.manager.c.c paramc, RuleTreeFlow paramRuleTreeFlow, r paramr)
  {
    super(paramc, paramRuleTreeFlow, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), g().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), g().getModifyUser());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("active.dialog"), new ap(this));
    a(com.flagleader.manager.d.c.b("syn.dialog"), new aA(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new com.flagleader.manager.c.f(this));
    a(com.flagleader.manager.d.c.b("first.dialog"), new d(this));
    a(com.flagleader.manager.d.c.b("supportException.dialog"), new b(this));
    a(com.flagleader.manager.d.c.b("sheetwhile.dialog"), new ay(this));
    if (f().isSheetWhile())
      a(com.flagleader.manager.d.c.b("sheetuuid.dialog"), new aw(this));
    a(com.flagleader.manager.d.c.b("pri.dialog"), new m(this));
    a(com.flagleader.manager.d.c.b("ruleSetType.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("sheetothers.dialog"), new av(this));
    a(com.flagleader.manager.d.c.b("ruleType.dialog"), new c(this));
    if ((f().getExceptionType() == 1) || (f().getExceptionType() == 2))
      a(com.flagleader.manager.d.c.b("errorInfo.dialog"), new e(this));
    a(com.flagleader.manager.d.c.b("logtypes.dialog"), new as(this));
    a(com.flagleader.manager.d.c.b("datasnaps.dialog"), new aq(this));
    a(com.flagleader.manager.d.c.b("restartType.RuleTreeProperties"), new au(this));
    a(com.flagleader.manager.d.c.b("vmlFlowType.RuleTreeProperties"), new aB(this));
    a(com.flagleader.manager.d.c.b("startTime.dialog"), new az(this));
    a(com.flagleader.manager.d.c.b("endTime.dialog"), new ar(this));
  }

  public RuleTreeFlow g()
  {
    if ((d() != null) && ((d() instanceof RuleTreeFlow)))
      return (RuleTreeFlow)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.an
 * JD-Core Version:    0.6.0
 */