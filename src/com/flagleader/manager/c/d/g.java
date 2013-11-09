package com.flagleader.manager.c.d;

import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionMultiRule;

public class g extends ao
{
  public g(com.flagleader.manager.c.c paramc, DecisionMultiRule paramDecisionMultiRule, r paramr)
  {
    super(paramc, paramDecisionMultiRule, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), f().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), f().getModifyUser());
    a(com.flagleader.manager.d.c.b("active.dialog"), new ap(this));
    a(com.flagleader.manager.d.c.b("syn.dialog"), new aA(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("sheetwhile.dialog"), new ay(this));
    if (f().isSheetWhile())
      a(com.flagleader.manager.d.c.b("sheetuuid.dialog"), new aw(this));
    a(com.flagleader.manager.d.c.b("pri.dialog"), new m(this));
    a(com.flagleader.manager.d.c.b("conditionNum.dialog"), new h(this));
    a(com.flagleader.manager.d.c.b("valueNum.dialog"), new j(this));
    for (int i = 1; i <= f().getValueNum(); i++)
      if ((f().getDecisionElement(i) != null) && (f().getDecisionElement(i).getMemberElement() != null))
        a(com.flagleader.manager.d.c.b("assignDecision.dialog"), new i(this, i));
      else
        a(com.flagleader.manager.d.c.b("assignDecision.dialog"), new i(this, i));
    a(com.flagleader.manager.d.c.b("sheetothers.dialog"), new av(this));
    a(com.flagleader.manager.d.c.b("logtypes.dialog"), new as(this));
    a(com.flagleader.manager.d.c.b("datasnaps.dialog"), new aq(this));
    a(com.flagleader.manager.d.c.b("restartType.RuleTreeProperties"), new au(this));
    a(com.flagleader.manager.d.c.b("matchType.RuleTreeProperties"), new at(this));
    a(com.flagleader.manager.d.c.b("vmlFlowType.RuleTreeProperties"), new aB(this));
    a(com.flagleader.manager.d.c.b("startTime.dialog"), new az(this));
    a(com.flagleader.manager.d.c.b("endTime.dialog"), new ar(this));
  }

  public DecisionMultiRule f()
  {
    if ((d() != null) && ((d() instanceof DecisionMultiRule)))
      return (DecisionMultiRule)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.g
 * JD-Core Version:    0.6.0
 */