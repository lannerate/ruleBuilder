package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

public class j extends a
{
  private int b;

  public void a()
  {
    if (ExeRuleToken.access$1(this.a) != this.b)
    {
      ExeRuleToken.access$2(this.a);
      this.a.setReturnType(this.b);
      ExeRuleToken.access$3(this.a);
      this.a.update();
    }
  }

  public j(ExeRuleToken paramExeRuleToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return ExeRuleToken.access$0()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.j
 * JD-Core Version:    0.6.0
 */