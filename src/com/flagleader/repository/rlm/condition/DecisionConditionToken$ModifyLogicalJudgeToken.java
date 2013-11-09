package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.k;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.value.ValueToken;

public class DecisionConditionToken$ModifyLogicalJudgeToken extends JudgeToken
  implements ISelectorEditen
{
  private ValueToken valueToken;

  public DecisionConditionToken$ModifyLogicalJudgeToken(DecisionConditionToken paramDecisionConditionToken)
  {
  }

  public DecisionConditionToken$ModifyLogicalJudgeToken(DecisionConditionToken paramDecisionConditionToken, ModifyLogicalJudgeToken paramModifyLogicalJudgeToken)
  {
    super(paramModifyLogicalJudgeToken);
  }

  public String getName()
  {
    return "ModifyLogicalJudgeToken";
  }

  public int getCount()
  {
    return 1;
  }

  public boolean acceptType(g paramg)
  {
    return true;
  }

  protected k b(int paramInt)
  {
    return DecisionConditionToken.access$2(this.this$0)[paramInt];
  }

  protected String a(int paramInt)
  {
    return DecisionConditionToken.messages[paramInt];
  }

  public String getDisplayName()
  {
    return " ";
  }

  public boolean isLocked()
  {
    return this.this$0.isLocked();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.DecisionConditionToken.ModifyLogicalJudgeToken
 * JD-Core Version:    0.6.0
 */