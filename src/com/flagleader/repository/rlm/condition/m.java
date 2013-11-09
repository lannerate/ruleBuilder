package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.lang.IConditionToken;

class m extends a
{
  m(LogicalJudgeToken paramLogicalJudgeToken)
  {
  }

  public void a()
  {
    LogicalJudgeToken.access$1(this.a);
    this.a.getParentCondition().addOneLeftParenthesis();
    LogicalJudgeToken.access$2(this.a);
    this.a.getParentCondition().update();
  }

  public String c()
  {
    return "addLeftParenthesis";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.m
 * JD-Core Version:    0.6.0
 */