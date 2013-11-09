package com.flagleader.manager.c.d;

import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.RuleMirror;

public class x extends ao
{
  public x(com.flagleader.manager.c.c paramc, RuleMirror paramRuleMirror, r paramr)
  {
    super(paramc, paramRuleMirror, paramr);
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
    a(com.flagleader.manager.d.c.b("vmlFlowType.RuleTreeProperties"), new aB(this));
    a(com.flagleader.manager.d.c.b("startTime.dialog"), new az(this));
    a(com.flagleader.manager.d.c.b("endTime.dialog"), new ar(this));
  }

  public RuleMirror f()
  {
    if ((d() != null) && ((d() instanceof RuleMirror)))
      return (RuleMirror)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.x
 * JD-Core Version:    0.6.0
 */