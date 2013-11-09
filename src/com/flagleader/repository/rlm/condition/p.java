package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.a;
import com.flagleader.repository.rlm.lang.IConditionToken;

class p extends a
{
  p(LogicalJudgeToken paramLogicalJudgeToken)
  {
  }

  public void a()
  {
    LogicalJudgeToken.access$1(this.a);
    this.a.getParentCondition().deleteOneRightParenthesis();
    LogicalJudgeToken.access$2(this.a);
    this.a.getParentCondition().update();
  }

  public String c()
  {
    return "DeleteRightParenthesis";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.p
 * JD-Core Version:    0.6.0
 */