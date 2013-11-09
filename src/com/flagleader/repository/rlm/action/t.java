package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

public class t extends a
{
  private int b;

  public void a()
  {
    if (ReturnToken.access$0(this.a) != this.b)
    {
      ReturnToken.access$1(this.a);
      this.a.setReturnType(this.b);
      ReturnToken.access$2(this.a);
      this.a.update();
    }
  }

  public t(ReturnToken paramReturnToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return ReturnToken.access$3()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.t
 * JD-Core Version:    0.6.0
 */