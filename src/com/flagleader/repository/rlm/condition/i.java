package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;

public class i extends a
{
  private int b;

  public void a()
  {
    if (ForEachConditionToken.access$0(this.a) != this.b)
    {
      ForEachConditionToken.access$1(this.a);
      this.a.changeReturnType(this.b);
      ForEachConditionToken.access$2(this.a);
      this.a.update();
    }
  }

  public i(ForEachConditionToken paramForEachConditionToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return ForEachConditionToken.access$3()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.i
 * JD-Core Version:    0.6.0
 */