package com.flagleader.server;

import com.flagleader.engine.IRuleEngineInfo;
import com.flagleader.repository.f;
import com.flagleader.util.TempID;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ExecuteInfos
  implements f
{
  List a = new ArrayList();
  String b = "";
  private String uuid = null;
  private static final Vector records = new Vector();

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public void addRuleExecuteInfo(RuleExecuteInfo paramRuleExecuteInfo)
  {
    this.a.add(paramRuleExecuteInfo);
  }

  public List getInfos()
  {
    return this.a;
  }

  public RuleExecuteInfo getExecuteInfo(String paramString)
  {
    for (int i = 0; i < this.a.size(); i++)
      if (((RuleExecuteInfo)this.a.get(i)).getUuid().equals(paramString))
        return (RuleExecuteInfo)this.a.get(i);
    return null;
  }

  public void romoveMethod(RuleExecuteInfo paramRuleExecuteInfo)
  {
    this.a.remove(paramRuleExecuteInfo);
  }

  public String getDisplayName()
  {
    return this.b;
  }

  public void setDisplayName(String paramString)
  {
    this.b = paramString;
  }

  public static void addRecord(IRuleEngineInfo paramIRuleEngineInfo)
  {
    records.add(paramIRuleEngineInfo);
  }

  public static void removeRecord(IRuleEngineInfo paramIRuleEngineInfo)
  {
    records.remove(paramIRuleEngineInfo);
  }

  public static Vector getRecords()
  {
    return records;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.ExecuteInfos
 * JD-Core Version:    0.6.0
 */