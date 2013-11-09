package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.a;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.StaticTextToken;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IMultiEditen;
import com.flagleader.repository.rlm.lang.IConditionToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DecisionConditionToken extends ConditionToken
  implements ILineEditen, IMultiEditen, IConditionToken
{
  transient DecisionConditionToken.ModifyLogicalJudgeToken a = null;
  public static final String[] messages = { "&setLoc" };
  private transient k[] popupEvents = { new f(this) };

  public DecisionConditionToken()
  {
  }

  public DecisionConditionToken(DecisionConditionToken paramDecisionConditionToken)
  {
    super(paramDecisionConditionToken);
    setUuid(paramDecisionConditionToken.getUuid());
  }

  public boolean isFirstCondition()
  {
    return getConditionContainer() != null;
  }

  protected boolean a(IElement paramIElement)
  {
    if ((paramIElement instanceof DecisionConditionToken.ModifyLogicalJudgeToken))
      return true;
    return super.a(paramIElement);
  }

  public String getName()
  {
    return "DecisionConditionToken";
  }

  public IElement deepClone()
  {
    return new DecisionConditionToken(this);
  }

  public DecisionConditionToken.ModifyLogicalJudgeToken getModifyLogicalJudge()
  {
    if (this.a == null)
      setModifyLogicalJudge(new DecisionConditionToken.ModifyLogicalJudgeToken(this));
    return this.a;
  }

  public StringJudgeToken createStringJudge()
  {
    return new StringJudgeToken(new e(this), 13);
  }

  public Iterator getMultiToken()
  {
    ArrayList localArrayList = new ArrayList();
    if (!isFirstCondition())
      localArrayList.add(getLogicalOperator());
    else
      localArrayList.add(getModifyLogicalJudge());
    int i;
    if ((getLeftParenthesisNumber() > 0) || (getNextTests().hasNext()))
    {
      localObject = "";
      for (i = 0; i < getLeftParenthesisNumber(); i++)
        localObject = localObject + "( ";
      localArrayList.add(new StaticTextToken((String)localObject, "parenthsis"));
    }
    if (getFirstValue() != null)
      localArrayList.add(getFirstValue());
    if (getCompareOperator() != null)
      localArrayList.add(getCompareOperator());
    if (getComparedValue() != null)
      localArrayList.add(getComparedValue());
    if (getRightParenthesisNumber() > 0)
    {
      localObject = "";
      for (i = 0; i < getRightParenthesisNumber(); i++)
        localObject = localObject + ") ";
      localArrayList.add(new StaticTextToken((String)localObject, "parenthsis"));
    }
    Object localObject = getNextTests();
    while (((Iterator)localObject).hasNext())
    {
      IConditionToken localIConditionToken = (IConditionToken)((Iterator)localObject).next();
      localArrayList.add(localIConditionToken.getLogicalOperator());
      if (localIConditionToken.getLeftParenthesisNumber() > 0)
      {
        str = "";
        for (j = 0; j < localIConditionToken.getLeftParenthesisNumber(); j++)
          str = str + "( ";
        localArrayList.add(new StaticTextToken(str, "parenthsis"));
      }
      if (localIConditionToken.getFirstValue() != null)
        localArrayList.add(localIConditionToken.getFirstValue());
      if (localIConditionToken.getCompareOperator() != null)
        localArrayList.add(localIConditionToken.getCompareOperator());
      if (localIConditionToken.getComparedValue() != null)
        localArrayList.add(localIConditionToken.getComparedValue());
      if (localIConditionToken.getRightParenthesisNumber() <= 0)
        continue;
      String str = "";
      for (int j = 0; j < localIConditionToken.getRightParenthesisNumber(); j++)
        str = str + ") ";
      localArrayList.add(new StaticTextToken(str, "parenthsis"));
    }
    if (getDisposeModifier() != null)
      localArrayList.add(getDisposeModifier());
    return (Iterator)localArrayList.iterator();
  }

  public void setModifyLogicalJudge(DecisionConditionToken.ModifyLogicalJudgeToken paramModifyLogicalJudgeToken)
  {
    this.a = paramModifyLogicalJudgeToken;
  }

  public void init()
  {
    super.init();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.DecisionConditionToken
 * JD-Core Version:    0.6.0
 */