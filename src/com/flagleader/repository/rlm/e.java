package com.flagleader.repository.rlm;

import com.flagleader.repository.d.u;
import com.flagleader.repository.rlm.lang.ILangToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import org.apache.commons.lang.StringUtils;

public class e
{
  private int g = 0;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  private IRuleObject h;

  public e(int paramInt, IRuleObject paramIRuleObject)
  {
    this.g = paramInt;
    this.h = paramIRuleObject;
  }

  public String a()
  {
    switch (this.g)
    {
    case 2:
      return u.a("tv_enter");
    case 3:
      return u.a("tv_init");
    case 0:
      return u.a("tv_ifthen");
    case 1:
      return u.a("tv_elseif");
    case 4:
      return u.a("tv_else");
    case 5:
      return u.a("tv_catch");
    }
    return "";
  }

  public ILangToken a(int paramInt)
  {
    if (this.g == 0)
    {
      if (paramInt == 0)
        return ((RuleToken)this.h).getWhenCondition();
      if (paramInt == 1)
        return ((RuleToken)this.h).getThenActions();
    }
    else if ((this.g == 4) || (this.g == 3) || (this.g == 5))
    {
      if (paramInt == 1)
        return (IMultiActionToken)this.h;
    }
    else if (this.g == 2)
    {
      if (paramInt == 0)
        return ((RuleEnterToken)this.h).getWhenCondition();
    }
    else if (this.g == 1)
    {
      if (paramInt == 0)
        return ((ElseIfRuleToken)this.h).getWhenCondition();
      if (paramInt == 1)
        return ((ElseIfRuleToken)this.h).getThenActions();
    }
    return null;
  }

  public IMultiConditionToken b()
  {
    if (this.g == 0)
      return ((RuleToken)this.h).getWhenCondition();
    if (this.g == 2)
      return ((RuleEnterToken)this.h).getWhenCondition();
    if (this.g == 1)
      return ((ElseIfRuleToken)this.h).getWhenCondition();
    return null;
  }

  public IMultiActionToken c()
  {
    if (this.g == 0)
      return ((RuleToken)this.h).getThenActions();
    if ((this.g == 4) || (this.g == 3) || (this.g == 5))
      return (IMultiActionToken)this.h;
    if (this.g == 1)
      return ((ElseIfRuleToken)this.h).getThenActions();
    return null;
  }

  public int d()
  {
    int i;
    int j;
    if (this.g == 0)
    {
      i = StringUtils.countMatches(((RuleToken)this.h).getWhenCondition().getText(), "\n");
      j = StringUtils.countMatches(((RuleToken)this.h).getThenActions().getText(), "\n");
      return i > j ? i : j;
    }
    if ((this.g == 4) || (this.g == 3) || (this.g == 5))
      return StringUtils.countMatches(((IMultiActionToken)this.h).getText(), "\n");
    if (this.g == 2)
      return StringUtils.countMatches(((RuleEnterToken)this.h).getWhenCondition().getText(), "\n");
    if (this.g == 1)
    {
      i = StringUtils.countMatches(((ElseIfRuleToken)this.h).getWhenCondition().getText(), "\n");
      j = StringUtils.countMatches(((ElseIfRuleToken)this.h).getThenActions().getText(), "\n");
      return i > j ? i : j;
    }
    return 1;
  }

  public int e()
  {
    return this.g;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public IRuleObject f()
  {
    return this.h;
  }

  public void a(IRuleObject paramIRuleObject)
  {
    this.h = paramIRuleObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.e
 * JD-Core Version:    0.6.0
 */