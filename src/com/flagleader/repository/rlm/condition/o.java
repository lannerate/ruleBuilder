package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.lang.IConditionToken;

class o extends a
{
  o(LogicalJudgeToken paramLogicalJudgeToken)
  {
  }

  public void a()
  {
    LogicalJudgeToken.access$1(this.a);
    this.a.getParentCondition().addOneRightParenthesis();
    LogicalJudgeToken.access$2(this.a);
    this.a.getParentCondition().update();
  }

  public String c()
  {
    return "AddRightParenthesis";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.o
 * JD-Core Version:    0.6.0
 */