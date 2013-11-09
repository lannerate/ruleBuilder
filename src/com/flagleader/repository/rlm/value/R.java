package com.flagleader.repository.rlm.value;

import com.flagleader.repository.c.l;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.lang.IValueToken;

class R extends l
{
  public R(ValueToken paramValueToken)
  {
  }

  public void a(JudgeToken paramJudgeToken, boolean paramBoolean)
  {
    if ((paramJudgeToken instanceof IOperatorToken))
    {
      IOperatorToken localIOperatorToken = (IOperatorToken)paramJudgeToken;
      if (localIOperatorToken.isNoOperator())
      {
        this.a.removeChildElement(this.a.getNextValue());
      }
      else if (this.a.getNextValue() == null)
      {
        if ((paramJudgeToken instanceof DateOperatorToken))
          this.a.addChildElement(new ValueToken(2, "int", "int"));
        else
          this.a.addChildElement(new ValueToken(2, ValueToken.access$4(this.a), this.a.getValueElement().getValueType()));
      }
      else if ((localIOperatorToken.isAddOperator()) && (!paramBoolean))
      {
        ValueToken localValueToken;
        if ((paramJudgeToken instanceof DateOperatorToken))
          localValueToken = new ValueToken(2, "int", "int");
        else
          localValueToken = new ValueToken(2, ValueToken.access$4(this.a), this.a.getValueElement().getValueType());
        localValueToken.addChildElement(this.a.getNextValue());
        localValueToken.getOperator().setType(localIOperatorToken.getAddType());
        this.a.removeChildElement(this.a.getNextValue());
        this.a.addChildElement(localValueToken);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.R
 * JD-Core Version:    0.6.0
 */