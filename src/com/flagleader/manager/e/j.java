package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.tree.IRuleGroup;

public class j extends W
{
  String a = null;

  public j(IRuleGroup paramIRuleGroup, String paramString)
  {
    super(paramIRuleGroup);
    this.a = paramString;
    this.g = new k(this, paramIRuleGroup, paramString);
  }

  public String b()
  {
    return super.b() + this.a;
  }

  public String a()
  {
    return c.b("ExportRuleExcelInfo.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.j
 * JD-Core Version:    0.6.0
 */