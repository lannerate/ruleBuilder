package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.lang.IConditionToken;

class n extends a
{
  n(LogicalJudgeToken paramLogicalJudgeToken)
  {
  }

  public void a()
  {
    LogicalJudgeToken.access$1(this.a);
    this.a.getParentCondition().deleteOneLeftParenthesis();
    LogicalJudgeToken.access$2(this.a);
    this.a.getParentCondition().update();
  }

  public String c()
  {
    return "DeleteLeftParenthesis";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.n
 * JD-Core Version:    0.6.0
 */