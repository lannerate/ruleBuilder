package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.value.FieldToken;

public class LogConditionToken extends ConditionToken
  implements ILineEditen, IMultiEditen, IConditionToken
{
  public LogConditionToken()
  {
  }

  public LogConditionToken(LogConditionToken paramLogConditionToken)
  {
    super(paramLogConditionToken);
  }

  public void init()
  {
    if (!isFirstCondition())
      addChildElement(new LogicalJudgeToken());
    addChildElement(new FieldToken());
  }

  protected boolean a(IElement paramIElement)
  {
    return super.a(paramIElement);
  }

  public String getName()
  {
    return "LogConditionToken";
  }

  public IElement deepClone()
  {
    return new LogConditionToken(this);
  }

  public StringJudgeToken createStringJudge()
  {
    return new StringJudgeToken(new e(this), 11);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.LogConditionToken
 * JD-Core Version:    0.6.0
 */