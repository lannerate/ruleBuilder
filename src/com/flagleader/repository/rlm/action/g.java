package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

public class g extends a
{
  private int b;

  public void a()
  {
    if (ExcuteRuleToken.access$1(this.a) != this.b)
    {
      ExcuteRuleToken.access$2(this.a);
      this.a.setReturnType(this.b);
      ExcuteRuleToken.access$3(this.a);
      this.a.update();
    }
  }

  public g(ExcuteRuleToken paramExcuteRuleToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return ExcuteRuleToken.access$0()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.g
 * JD-Core Version:    0.6.0
 */