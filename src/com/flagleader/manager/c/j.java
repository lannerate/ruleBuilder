package com.flagleader.manager.c;

import com.flagleader.manager.builder.a;
import com.flagleader.repository.tree.IRulePackage;
import java.io.File;

public class j extends a
{
  private IRulePackage b = null;

  public j(h paramh, IRulePackage paramIRulePackage)
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
 * Qualified Name:     com.flagleader.manager.c.j
 * JD-Core Version:    0.6.0
 */