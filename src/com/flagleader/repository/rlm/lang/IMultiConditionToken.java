package com.flagleader.repository.rlm.lang;

import com.flagleader.repository.lang.expression.StatementSystem;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.rom.IBusinessObject;
import java.util.Iterator;
import java.util.List;

public abstract interface IMultiConditionToken extends IMultiLineEditen, ILangToken
{
  public static final int RULETEST = 0;
  public static final int DECISIONFIRST = 1;
  public static final int DECISIONSECOND = 2;
  public static final int RULELOG = 3;

  public abstract Iterator getConditions();

  public abstract List getConditionList();

  public abstract IConditionToken getCondition(int paramInt);

  public abstract int getConditionPos(IConditionToken paramIConditionToken);

  public abstract IValueToken getSameFirstValue();

  public abstract IConditionToken getNextCondition(IConditionToken paramIConditionToken);

  public abstract IConditionToken getPreviousCondition(IConditionToken paramIConditionToken);

  public abstract int getType();

  public abstract IConditionToken findCondition(IBusinessObject paramIBusinessObject, String paramString, StatementSystem paramStatementSystem);

  public abstract String getText();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.lang.IMultiConditionToken
 * JD-Core Version:    0.6.0
 */