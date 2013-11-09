package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;

class j extends a
{
  j(LogicalJudgeToken paramLogicalJudgeToken)
  {
  }

  public void a()
  {
    if (LogicalJudgeToken.access$0(this.a) != 0)
    {
      LogicalJudgeToken.access$1(this.a);
      this.a.setType(0);
      LogicalJudgeToken.access$2(this.a);
      this.a.update();
    }
  }

  public String c()
  {
    return "isNary";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.j
 * JD-Core Version:    0.6.0
 */