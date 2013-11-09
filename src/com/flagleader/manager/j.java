package com.flagleader.manager;

import com.flagleader.db.Sheet;
import com.flagleader.engine.IRuleContext;
import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleEngineInfo;
import com.flagleader.engine.impl.AbstractRuleEngine;
import com.flagleader.engine.impl.RuleRecordServer;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class j extends AbstractRuleEngine
  implements RuleEngine
{
  public j(RuleEngineFactory paramRuleEngineFactory)
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
    int i = runContext(localIRuleContext, this.ruleName);
    return i;
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
    this.ruleContext = a().getContext(this.ruleName, false);
    if (this.ruleContext == null)
      throw new RuleEngineException(MessageUtil.format("ruleContextNotFound.error", new String[] { this.ruleName }));
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

  public m a()
  {
    return (m)this.factory;
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

  protected int runContext(IRuleContext paramIRuleContext, String paramString)
  {
    int i = super.runContext(paramIRuleContext, paramString);
    String str = paramString;
    if ((b.a().G()) && (r.A() != null))
    {
      Iterator localIterator1 = r.A().getAcceptElements(new k(this, str));
      if (localIterator1.hasNext())
      {
        IRulePackage localIRulePackage = (IRulePackage)localIterator1.next();
        if (localIRulePackage.getLogType() == 0)
        {
          Iterator localIterator2 = localIRulePackage.getAcceptElements(new l(this));
          File localFile = new File("trace");
          if (!localFile.exists())
            localFile.mkdirs();
          int j = localFile.list().length + 1;
          while (localIterator2.hasNext())
          {
            Object localObject1 = localIterator2.next();
            try
            {
              if (!(localObject1 instanceof SheetTable))
                continue;
              Object localObject2 = this.dtcs.get(((SheetTable)localObject1).getValueName());
              if ((localObject2 == null) || (!(localObject2 instanceof Sheet)))
                continue;
              ((Sheet)localObject2).saveToExcel(new File(localFile, String.valueOf(j++) + localIRulePackage.getDisplayName() + "-" + ((SheetTable)localObject1).getDisplayName() + ".xls").getPath());
            }
            catch (Throwable localThrowable)
            {
            }
          }
        }
      }
    }
    return i;
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
 * Qualified Name:     com.flagleader.manager.j
 * JD-Core Version:    0.6.0
 */