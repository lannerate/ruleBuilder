package com.flagleader.repository.rlm;

import com.flagleader.repository.c.a;

public class d extends a
{
  private int b;

  public void a()
  {
    if (this.a.a != this.b)
    {
      this.a.h();
      this.a.setType(this.b);
      this.a.g();
      this.a.update();
    }
    else
    {
      this.a.setType(this.b);
      this.a.update();
    }
  }

  public d(JudgeToken paramJudgeToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return this.a.a(this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.d
 * JD-Core Version:    0.6.0
 */