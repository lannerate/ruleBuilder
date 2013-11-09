package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;

class k extends a
{
  k(LogicalJudgeToken paramLogicalJudgeToken)
  {
  }

  public void a()
  {
    if (LogicalJudgeToken.access$0(this.a) != 1)
    {
      LogicalJudgeToken.access$1(this.a);
      this.a.setType(1);
      LogicalJudgeToken.access$2(this.a);
      this.a.update();
    }
  }

  public String c()
  {
    return "notNary";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.k
 * JD-Core Version:    0.6.0
 */