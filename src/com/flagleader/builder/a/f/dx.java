package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.RulePackage;

public class dx extends a
{
  public dx(do paramdo)
  {
  }

  public boolean b()
  {
    return (!this.a.e().isLocked()) && ((this.a.e() instanceof RulePackage));
  }

  public boolean h()
  {
    return ((this.a.e() instanceof RulePackage)) && (((RulePackage)this.a.e()).getLogType() == 0);
  }

  public boolean a(boolean paramBoolean)
  {
    if ((this.a.e() instanceof RulePackage))
      if ((!paramBoolean) && (((RulePackage)this.a.e()).getLogType() == 0))
      {
        ((RulePackage)this.a.e()).setLogType(1);
        ((RulePackage)this.a.e()).setModified(true);
        ((RulePackage)this.a.e()).updateViewer();
      }
      else if ((paramBoolean) && (((RulePackage)this.a.e()).getLogType() == 1))
      {
        ((RulePackage)this.a.e()).setLogType(0);
        ((RulePackage)this.a.e()).setModified(true);
        ((RulePackage)this.a.e()).updateViewer();
      }
    return true;
  }

  public String c()
  {
    return "RecordTrace";
  }

  public int g()
  {
    return 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dx
 * JD-Core Version:    0.6.0
 */