package com.flagleader.manager.a;

import com.flagleader.manager.builder.a;
import com.flagleader.repository.tree.IRulePackage;
import java.io.File;

class i extends a
{
  private IRulePackage b = null;

  public i(e parame, IRulePackage paramIRulePackage)
  {
    this.b = paramIRulePackage;
  }

  public void cancel()
  {
  }

  public void ok()
  {
    new File(this.b.getFilePathName()).delete();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.i
 * JD-Core Version:    0.6.0
 */