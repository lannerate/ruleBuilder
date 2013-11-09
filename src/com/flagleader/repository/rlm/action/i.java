package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

public class i extends a
{
  private int b;

  public void a()
  {
    if (ExeExpressionToken.access$1(this.a) != this.b)
    {
      ExeExpressionToken.access$2(this.a);
      this.a.setReturnType(this.b);
      ExeExpressionToken.access$3(this.a);
      this.a.update();
    }
  }

  public i(ExeExpressionToken paramExeExpressionToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return ExeExpressionToken.access$0()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.i
 * JD-Core Version:    0.6.0
 */