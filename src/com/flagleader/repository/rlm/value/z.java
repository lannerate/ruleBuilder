package com.flagleader.repository.rlm.value;

import com.flagleader.repository.c.a;

class z extends a
{
  private int b;

  public void a()
  {
    if (StringOperatorToken.access$0(this.a) != this.b)
    {
      StringOperatorToken.access$1(this.a);
      this.a.setType(this.b);
      StringOperatorToken.access$2(this.a);
    }
  }

  public z(StringOperatorToken paramStringOperatorToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return StringOperatorToken.access$3()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.z
 * JD-Core Version:    0.6.0
 */