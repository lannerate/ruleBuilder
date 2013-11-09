package com.flagleader.manager;

import com.flagleader.repository.tree.IRulePackage;
import java.io.File;

public class i extends com.flagleader.manager.builder.a
{
  private IRulePackage b = null;

  public i(a parama, IRulePackage paramIRulePackage)
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
 * Qualified Name:     com.flagleader.manager.i
 * JD-Core Version:    0.6.0
 */