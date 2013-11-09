package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.c.l;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.value.ValueToken;

public class b extends l
{
  private String b = "decimal";

  public b(ConditionToken paramConditionToken, String paramString)
  {
    this.b = paramString;
  }

  public void a(JudgeToken paramJudgeToken, boolean paramBoolean)
  {
    if ((paramJudgeToken instanceof DecimalJudgeToken))
      if ((paramJudgeToken.getType() < 6) || (paramJudgeToken.getType() > 7))
      {
        if (this.a.getComparedValue() == null)
          ConditionToken.access$0(this.a, new ValueToken(1, this.b, ""));
      }
      else if (this.a.getComparedValue() != null)
        this.a.removeChildElement(this.a.getComparedValue());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.b
 * JD-Core Version:    0.6.0
 */