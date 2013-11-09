package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.manager.e.U;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.RulePackage;

public class dt extends a
{
  public dt(do paramdo)
  {
  }

  public void a()
  {
    if ((this.a.e() instanceof IRuleTree))
      this.a.a(((IRuleTree)this.a.e()).getVisitRuleName());
  }

  public boolean b()
  {
    if ((this.a.e() instanceof RulePackage))
      return false;
    return (do.a(this.a) == null) || (do.a(this.a).i());
  }

  public String c()
  {
    return "gointer";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dt
 * JD-Core Version:    0.6.0
 */