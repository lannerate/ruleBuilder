package com.flagleader.manager.a;

import com.flagleader.manager.builder.a;
import com.flagleader.repository.tree.IRulePackage;

class j extends a
{
  private IRulePackage b = null;

  public j(e parame, IRulePackage paramIRulePackage)
  {
    this.b = paramIRulePackage;
  }

  public void cancel()
  {
  }

  public void ok()
  {
    this.b.disposeAndUpdate();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.j
 * JD-Core Version:    0.6.0
 */