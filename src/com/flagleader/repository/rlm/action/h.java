package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

public class h extends a
{
  private int b;

  public void a()
  {
    if (ExeDecisionToken.access$1(this.a) != this.b)
    {
      ExeDecisionToken.access$2(this.a);
      this.a.setReturnType(this.b);
      ExeDecisionToken.access$3(this.a);
      this.a.update();
    }
  }

  public h(ExeDecisionToken paramExeDecisionToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return ExeDecisionToken.access$0()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.h
 * JD-Core Version:    0.6.0
 */