package com.flagleader.repository.rlm.value;

import com.flagleader.repository.c.a;

class s extends a
{
  private int b;

  public void a()
  {
    if (NumberOperatorToken.access$0(this.a) != this.b)
    {
      NumberOperatorToken.access$1(this.a);
      this.a.setType(this.b);
      NumberOperatorToken.access$2(this.a);
    }
  }

  public s(NumberOperatorToken paramNumberOperatorToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return NumberOperatorToken.access$3()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.s
 * JD-Core Version:    0.6.0
 */