package com.flagleader.manager.c.d;

import com.flagleader.manager.c.f;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.DecisionElement;
import com.flagleader.repository.tree.DecisionRelateRule;

public class k extends ao
{
  public k(com.flagleader.manager.c.c paramc, DecisionRelateRule paramDecisionRelateRule, r paramr)
  {
    super(paramc, paramDecisionRelateRule, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), f().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("modifyuser.dialog"), f().getModifyUser());
    a(com.flagleader.manager.d.c.b("active.dialog"), new ap(this));
    a(com.flagleader.manager.d.c.b("syn.dialog"), new aA(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("name.dialog"), new com.flagleader.manager.c.l(this));
    a(com.flagleader.manager.d.c.b("sheetwhile.dialog"), new ay(this));
    if (f().isSheetWhile())
      a(com.flagleader.manager.d.c.b("sheetuuid.dialog"), new aw(this));
    a(com.flagleader.manager.d.c.b("pri.dialog"), new com.flagleader.manager.c.m(this));
    a(com.flagleader.manager.d.c.b("conditionNum.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("valueNum.dialog"), new n(this));
    for (int i = 1; i <= f().getValueNum(); i++)
      if ((f().getDecisionElement(i) != null) && (f().getDecisionElement(i).getMemberElement() != null))
        a(com.flagleader.manager.d.c.b("assignDecision.dialog"), new m(this, i));
      else
        a(com.flagleader.manager.d.c.b("assignDecision.dialog"), new m(this, i));
    a(com.flagleader.manager.d.c.b("sheetothers.dialog"), new av(this));
    a(com.flagleader.manager.d.c.b("logtypes.dialog"), new as(this));
    a(com.flagleader.manager.d.c.b("datasnaps.dialog"), new aq(this));
    a(com.flagleader.manager.d.c.b("restartType.RuleTreeProperties"), new au(this));
    a(com.flagleader.manager.d.c.b("matchType.RuleTreeProperties"), new at(this));
    a(com.flagleader.manager.d.c.b("vmlFlowType.RuleTreeProperties"), new aB(this));
    a(com.flagleader.manager.d.c.b("startTime.dialog"), new az(this));
    a(com.flagleader.manager.d.c.b("endTime.dialog"), new ar(this));
  }

  public DecisionRelateRule f()
  {
    if ((d() != null) && ((d() instanceof DecisionRelateRule)))
      return (DecisionRelateRule)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.k
 * JD-Core Version:    0.6.0
 */