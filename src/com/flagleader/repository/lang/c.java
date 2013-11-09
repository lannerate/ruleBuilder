package com.flagleader.repository.lang;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.condition.RuleLogConditionToken;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.RulePackage;
import java.util.HashMap;

public abstract interface c
{
  public abstract String a(IElement paramIElement);

  public abstract String b(IElement paramIElement);

  public abstract void a(boolean paramBoolean);

  public abstract void b(boolean paramBoolean);

  public abstract String a(IRuleTree paramIRuleTree);

  public abstract String a(RuleLogConditionToken paramRuleLogConditionToken);

  public abstract String a(RulePackage paramRulePackage);

  public abstract HashMap a();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.c
 * JD-Core Version:    0.6.0
 */