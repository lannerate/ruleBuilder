package com.flagleader.manager.a;

import com.flagleader.manager.builder.a;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleProject;
import java.io.IOException;

class l extends a
{
  private IRuleProject b = null;

  public l(k paramk, IRuleProject paramIRuleProject)
  {
    this.b = paramIRuleProject;
  }

  public void cancel()
  {
    super.cancel();
  }

  public void ok()
  {
    try
    {
      this.b.save();
    }
    catch (IOException localIOException)
    {
      this.a.a.j().b(localIOException.getMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.l
 * JD-Core Version:    0.6.0
 */