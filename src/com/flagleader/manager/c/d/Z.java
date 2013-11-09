package com.flagleader.manager.c.d;

import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.Rule;

public class Z extends ao
{
  public static String[] e = com.flagleader.manager.d.c.d("exceptions.RulePropertiesEditor");
  public static String[] f;
  public static String[] g;

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".RulePropertiesEditor");
    f = com.flagleader.manager.d.c.d("supports.RulePropertiesEditor");
    for (i = 0; i < f.length; i++)
      f[i] = com.flagleader.manager.d.c.b(f[i] + ".RulePropertiesEditor");
    g = com.flagleader.manager.d.c.d("logtypes.RulePropertiesEditor");
    for (i = 0; i < g.length; i++)
      g[i] = com.flagleader.manager.d.c.b(g[i] + ".RulePropertiesEditor");
  }

  public Z(com.flagleader.manager.c.c paramc, Rule paramRule, r paramr)
  {
    super(paramc, paramRule, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), f().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), f().getModifyUser());
    a(com.flagleader.manager.d.c.b("active.dialog"), new ap(this));
    a(com.flagleader.manager.d.c.b("syn.dialog"), new aA(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("edittable.dialog"), new aa(this));
    a(com.flagleader.manager.d.c.b("condition.dialog"), new ad(this));
    a(com.flagleader.manager.d.c.b("supportInit.dialog"), new ag(this));
    a(com.flagleader.manager.d.c.b("supportElse.dialog"), new ac(this));
    a(com.flagleader.manager.d.c.b("supportException.dialog"), new ae(this));
    a(com.flagleader.manager.d.c.b("sheetwhile.dialog"), new ay(this));
    if (f().isSheetWhile())
      a(com.flagleader.manager.d.c.b("sheetuuid.dialog"), new aw(this));
    a(com.flagleader.manager.d.c.b("pri.dialog"), new m(this));
    a(com.flagleader.manager.d.c.b("elseif.dialog"), new ab(this));
    a(com.flagleader.manager.d.c.b("ruleType.dialog"), new af(this));
    if ((f().getExceptionType() == 1) || (f().getExceptionType() == 2))
      a(com.flagleader.manager.d.c.b("errorInfo.dialog"), new ah(this));
    a(com.flagleader.manager.d.c.b("sheetothers.dialog"), new av(this));
    a(com.flagleader.manager.d.c.b("logtypes.dialog"), new as(this));
    a(com.flagleader.manager.d.c.b("datasnaps.dialog"), new aq(this));
    a(com.flagleader.manager.d.c.b("restartType.RuleTreeProperties"), new au(this));
    a(com.flagleader.manager.d.c.b("vmlFlowType.RuleTreeProperties"), new aB(this));
    a(com.flagleader.manager.d.c.b("startTime.dialog"), new az(this));
    a(com.flagleader.manager.d.c.b("endTime.dialog"), new ar(this));
  }

  public Rule f()
  {
    if ((d() != null) && ((d() instanceof Rule)))
      return (Rule)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.Z
 * JD-Core Version:    0.6.0
 */