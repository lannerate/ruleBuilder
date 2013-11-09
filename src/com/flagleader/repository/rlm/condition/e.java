package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.l;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.value.ValueToken;

public class e extends l
{
  public e(ConditionToken paramConditionToken)
  {
  }

  public void a(JudgeToken paramJudgeToken, boolean paramBoolean)
  {
    if ((paramJudgeToken instanceof StringJudgeToken))
      if (paramJudgeToken.getType() <= 5)
      {
        if (this.a.getComparedValue() == null)
          ConditionToken.access$0(this.a, new ValueToken(2, "String", ""));
      }
      else if (paramJudgeToken.getType() == 10)
      {
        if (this.a.getComparedValue() == null)
          ConditionToken.access$0(this.a, new ValueToken(2, "String", ""));
      }
      else if (paramJudgeToken.getType() == 11)
      {
        if (this.a.getComparedValue() == null)
          ConditionToken.access$0(this.a, new ValueToken(2, "String", ""));
      }
      else if (paramJudgeToken.getType() >= 13)
      {
        if (this.a.getComparedValue() == null)
          ConditionToken.access$0(this.a, new ValueToken(2, "String", ""));
      }
      else if (this.a.getComparedValue() != null)
        this.a.removeChildElement(this.a.getComparedValue());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.e
 * JD-Core Version:    0.6.0
 */