package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.c.a;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.JudgeToken;
import com.flagleader.repository.rlm.lang.IConditionToken;
import com.flagleader.repository.rlm.lang.ILogicalToken;

public class LogicalJudgeToken extends JudgeToken
  implements ILogicalToken
{
  public static final int ISNARY = 0;
  public static final int NOTNARY = 1;
  public static final String[] messages = { "isNary", "notNary", "setLoc", "addLeftParenthesis", "DeleteLeftParenthesis", "AddRightParenthesis", "DeleteRightParenthesis" };
  private transient com.flagleader.repository.k[] popupEvents = { new j(this), new k(this), new l(this), new m(this), new n(this), new o(this), new p(this) };

  public LogicalJudgeToken()
  {
    this.a = 1;
  }

  public LogicalJudgeToken(LogicalJudgeToken paramLogicalJudgeToken)
  {
    super(paramLogicalJudgeToken);
    this.a = paramLogicalJudgeToken.a;
  }

  public boolean isNary()
  {
    return this.a == 0;
  }

  public String getName()
  {
    return "LogicalJudgeToken";
  }

  public int getCount()
  {
    return 7;
  }

  protected com.flagleader.repository.k b(int paramInt)
  {
    return this.popupEvents[paramInt];
  }

  protected String a(int paramInt)
  {
    String str = getLocalString(messages[paramInt] + ".edit", messages[paramInt]);
    return str;
  }

  public boolean acceptType(g paramg)
  {
    return true;
  }

  public IElement deepClone()
  {
    return new LogicalJudgeToken(this);
  }

  public String getRlmStr()
  {
    if (this.a == 0)
      return " || ";
    return " && ";
  }

  public String getColorType()
  {
    return "logical";
  }

  public IConditionToken getParentCondition()
  {
    if ((getParent() != null) && ((getParent() instanceof IConditionToken)))
      return (IConditionToken)getParent();
    throw new RuntimeException("no condition parent in this logical judge ");
  }

  public IElement copyElement()
  {
    return getParentCondition().deepClone();
  }

  public boolean canCopy()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.condition.LogicalJudgeToken
 * JD-Core Version:    0.6.0
 */