package com.flagleader.manager.e;

import com.flagleader.manager.n;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IElement;
import com.flagleader.repository.e.h;
import com.flagleader.repository.tree.AbstractRuleSet;

class f extends Thread
{
  f(e parame, IElement paramIElement, boolean paramBoolean)
  {
  }

  public void run()
  {
    this.a.e = System.currentTimeMillis();
    if (((this.b instanceof AbstractRuleSet)) && (!this.c))
      this.a.a = new h().c(((AbstractRuleSet)this.b).getRuleSetToken());
    else
      this.a.a = new h().c(this.b);
    this.a.n().a().m().a(this.a.a, false);
    this.a.a(100);
    this.a.f = System.currentTimeMillis();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.f
 * JD-Core Version:    0.6.0
 */