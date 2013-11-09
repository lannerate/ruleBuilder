package com.flagleader.engine;

import java.util.List;

public abstract interface IExpression
{
  public abstract void addVarDefine(String paramString1, String paramString2, String paramString3);

  public abstract void addFuncDefine(String paramString1, String paramString2, String paramString3);

  public abstract void addRuleDefine(String paramString);

  public abstract void addRuleDefine(List paramList);

  public abstract void deployExpression(String paramString);

  public abstract void redeployExpression(String paramString);

  public abstract String testExpression(String paramString);

  public abstract void addDecisionDefine(String paramString1, String paramString2, List paramList);

  public abstract void addDecisionDefine(String paramString, List paramList);

  public abstract void addDecisionDefine(String paramString1, String paramString2);

  public abstract void addConditionDefine(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.engine.IExpression
 * JD-Core Version:    0.6.0
 */