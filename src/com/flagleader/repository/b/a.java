package com.flagleader.repository.b;

import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleEngineInfo;
import com.flagleader.engine.impl.AbstractRuleEngine;
import com.flagleader.engine.impl.RuleRecordServer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends AbstractRuleEngine
  implements RuleEngine
{
  public a(RuleEngineFactory paramRuleEngineFactory)
  {
    super(paramRuleEngineFactory);
  }

  public int excute(String paramString)
  {
    parseRuleName(paramString);
    IRuleContext localIRuleContext = null;
    if (localIRuleContext == null)
      localIRuleContext = a().getContext(this.ruleName, false);
    if (localIRuleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { this.ruleName }));
    return runContext(localIRuleContext, this.ruleName);
  }

  public List executeBatch(String paramString, List paramList)
  {
    parseRuleName(paramString);
    this.ruleContext = a().getContext(this.ruleName, false);
    if (this.ruleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { this.ruleName }));
    String[] arrayOfString1 = this.ruleContext.getInputs();
    String[] arrayOfString2 = this.ruleContext.getOutputs();
    ArrayList localArrayList1 = new ArrayList();
    for (int i = 0; i < paramList.size(); i++)
    {
      List localList = (List)paramList.get(i);
      if ((localList != null) && (arrayOfString1 != null))
        for (int j = 0; (j < localList.size()) && (j < arrayOfString1.length); j++)
          super.put(arrayOfString1[j], localList.get(j));
      runContext(this.ruleContext, this.ruleName);
      if (arrayOfString2 == null)
        continue;
      ArrayList localArrayList2 = new ArrayList();
      for (int k = 0; k < arrayOfString2.length; k++)
        localArrayList2.add(super.get(arrayOfString2[k]));
      localArrayList1.add(localArrayList2);
    }
    return localArrayList1;
  }

  public Object[] executeDynamic(String paramString, Object[] paramArrayOfObject)
  {
    parseRuleName(paramString);
    this.ruleContext = a().getContext(this.ruleName, false);
    if (this.ruleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { this.ruleName }));
    String[] arrayOfString1 = this.ruleContext.getInputs();
    if ((paramArrayOfObject != null) && (arrayOfString1 != null))
      for (int i = 0; (i < paramArrayOfObject.length) && (i < arrayOfString1.length); i++)
        super.put(arrayOfString1[i], paramArrayOfObject[i]);
    runContext(this.ruleContext, this.ruleName);
    String[] arrayOfString2 = this.ruleContext.getOutputs();
    if (arrayOfString2 != null)
    {
      Object[] arrayOfObject = new Object[arrayOfString2.length];
      for (int j = 0; j < arrayOfString2.length; j++)
        arrayOfObject[j] = super.get(arrayOfString2[j]);
      return arrayOfObject;
    }
    return null;
  }

  public void attachRule(String paramString)
  {
    parseRuleName(paramString);
    this.ruleContext = a().getContext(paramString, false);
    if (this.ruleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { paramString }));
  }

  public int excuteExits(String paramString)
  {
    parseRuleName(paramString);
    IRuleContext localIRuleContext = null;
    if (localIRuleContext == null)
      localIRuleContext = a().getContext(this.ruleName, false);
    if (localIRuleContext == null)
      return -2;
    return runContext(localIRuleContext, this.ruleName);
  }

  public int excuteNew(String paramString)
  {
    parseRuleName(paramString);
    IRuleContext localIRuleContext = null;
    if (localIRuleContext == null)
      localIRuleContext = a().getContext(this.ruleName, true);
    if (localIRuleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { this.ruleName }));
    return runContext(localIRuleContext, this.ruleName);
  }

  public b a()
  {
    return (b)this.factory;
  }

  public boolean exitsRule(String paramString)
  {
    parseRuleName(paramString);
    IRuleContext localIRuleContext = null;
    if (localIRuleContext == null)
      localIRuleContext = a().getContext(this.ruleName, false);
    return localIRuleContext == null;
  }

  public void excuteExistSynchronized(String paramString)
  {
    parseRuleName(paramString);
    if (this.ruleContext == null)
      this.ruleContext = a().getContext(this.ruleName, false);
    if (this.ruleContext == null)
      return;
    copyMap();
    RuleRecordServer.getInstance().addExecute(new RuleEngineInfo(this, this.ruleName, false));
  }

  public void excuteSynchronized(String paramString)
  {
    parseRuleName(paramString);
    if (this.ruleContext == null)
      this.ruleContext = a().getContext(this.ruleName, false);
    if (this.ruleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { this.ruleName }));
    copyMap();
    RuleRecordServer.getInstance().addExecute(new RuleEngineInfo(this, this.ruleName, false));
  }

  public Map executeMap(String paramString, Map paramMap)
  {
    parseRuleName(paramString);
    this.ruleContext = a().getContext(this.ruleName, false);
    if (this.ruleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { this.ruleName }));
    super.putAll(paramMap);
    runContext(this.ruleContext, this.ruleName);
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = this.ruleContext.getOutputs();
    if (arrayOfString != null)
    {
      Object[] arrayOfObject = new Object[arrayOfString.length];
      for (int i = 0; i < arrayOfString.length; i++)
        localHashMap.put(arrayOfString[i], get(arrayOfString[i]));
      return localHashMap;
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.b.a
 * JD-Core Version:    0.6.0
 */