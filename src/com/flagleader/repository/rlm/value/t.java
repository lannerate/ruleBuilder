package com.flagleader.repository.rlm.value;

import com.flagleader.repository.c.a;

public class t extends a
{
  private int b;

  public void a()
  {
    if (RuleInfoToken.access$1(this.a) != this.b)
    {
      RuleInfoToken.access$2(this.a);
      this.a.setReturnType(this.b);
      RuleInfoToken.access$3(this.a);
      this.a.update();
    }
  }

  public t(RuleInfoToken paramRuleInfoToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return RuleInfoToken.access$0()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.t
 * JD-Core Version:    0.6.0
 */