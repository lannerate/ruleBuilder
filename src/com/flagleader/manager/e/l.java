package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.tree.IRuleClass;

public class l extends W
{
  String a = null;

  public l(IRuleClass paramIRuleClass, String paramString, boolean paramBoolean)
  {
    super(paramIRuleClass);
    this.a = paramString;
    this.g = new m(this, paramIRuleClass, paramString, paramBoolean);
  }

  public String b()
  {
    return super.b() + this.a;
  }

  public String a()
  {
    return c.b("ExportExeThreadInfo.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.l
 * JD-Core Version:    0.6.0
 */