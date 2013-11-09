package com.flagleader.manager.c.d;

import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleSetFlow;

public class aj extends ao
{
  public aj(com.flagleader.manager.c.c paramc, RuleSetFlow paramRuleSetFlow, r paramr)
  {
    super(paramc, paramRuleSetFlow, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), f().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), f().getModifyUser());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("active.dialog"), new ap(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("pri.dialog"), new m(this));
    a(com.flagleader.manager.d.c.b("logtypes.dialog"), new as(this));
    a(com.flagleader.manager.d.c.b("restartType.RuleTreeProperties"), new au(this));
    a(com.flagleader.manager.d.c.b("vmlFlowType.RuleTreeProperties"), new aB(this));
    a(com.flagleader.manager.d.c.b("startTime.dialog"), new az(this));
    a(com.flagleader.manager.d.c.b("endTime.dialog"), new ar(this));
  }

  public RuleSetFlow f()
  {
    if ((d() != null) && ((d() instanceof RuleSetFlow)))
      return (RuleSetFlow)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.aj
 * JD-Core Version:    0.6.0
 */