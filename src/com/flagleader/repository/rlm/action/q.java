package com.flagleader.repository.rlm.action;

import com.flagleader.repository.c.a;

public class q extends a
{
  private int b;

  public void a()
  {
    if (LogRecordToken.access$1(this.a) != this.b)
    {
      LogRecordToken.access$2(this.a);
      this.a.setReturnType(this.b);
      LogRecordToken.access$3(this.a);
      this.a.update();
    }
  }

  public q(LogRecordToken paramLogRecordToken, int paramInt)
  {
    this.b = paramInt;
  }

  public String c()
  {
    return LogRecordToken.access$0()[this.b];
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.q
 * JD-Core Version:    0.6.0
 */