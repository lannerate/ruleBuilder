package com.flagleader.repository.rlm.value;

class a extends com.flagleader.repository.c.a
{
  private int b;

  public void a()
  {
    if (DateOperatorToken.access$0(this.a) != this.b)
    {
      DateOperatorToken.access$1(this.a);
      this.a.setType(this.b);
      DateOperatorToken.access$2(this.a);
    }
  }

  public a(DateOperatorToken paramDateOperatorToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return DateOperatorToken.access$3()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.a
 * JD-Core Version:    0.6.0
 */