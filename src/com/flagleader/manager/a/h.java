package com.flagleader.manager.a;

import com.flagleader.manager.builder.a;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRulePackage;

class h extends a
{
  private IRulePackage b = null;

  public h(e parame, IRulePackage paramIRulePackage)
  {
    this.b = paramIRulePackage;
  }

  public void cancel()
  {
    this.b.clearAutoSave();
    this.b.disposeAndUpdate();
  }

  public void ok()
  {
    try
    {
      this.a.b(this.b);
    }
    catch (Exception localException)
    {
      this.a.a.j().b(localException.getMessage());
    }
    this.b.disposeAndUpdate();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.h
 * JD-Core Version:    0.6.0
 */