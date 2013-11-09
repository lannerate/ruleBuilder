package com.flagleader.server;

import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class e extends XmlWriter
{
  public e(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public e(Writer paramWriter)
  {
    super(paramWriter);
  }

  public e(File paramFile)
  {
    super(paramFile);
  }

  public void a(ExecuteInfos paramExecuteInfos)
  {
    printHeader();
    String[] arrayOfString = { "displayName", paramExecuteInfos.getDisplayName() };
    openMarkerLn("ExecuteInfos", arrayOfString);
    for (int i = 0; i < paramExecuteInfos.getInfos().size(); i++)
      a((RuleExecuteInfo)paramExecuteInfos.getInfos().get(i));
    closeMarkerLn("ExecuteInfos");
    flush();
  }

  private void a(RuleExecuteInfo paramRuleExecuteInfo)
  {
    String[] arrayOfString = { "displayName", paramRuleExecuteInfo.getDisplayName(), "exeRuleName", paramRuleExecuteInfo.getExeRuleName(), "internalTime", String.valueOf(paramRuleExecuteInfo.getInternalTime()), "planType", String.valueOf(paramRuleExecuteInfo.getPlanType()), "specialDay", paramRuleExecuteInfo.getSpecialDay(), "specialTime", paramRuleExecuteInfo.getSpecialTime(), "startTime", String.valueOf(paramRuleExecuteInfo.getStartTime()), "lastTime", String.valueOf(paramRuleExecuteInfo.getLastTime()), "state", String.valueOf(paramRuleExecuteInfo.getState()), "times", String.valueOf(paramRuleExecuteInfo.getTimes()), "tracelogtype", String.valueOf(paramRuleExecuteInfo.getTracelogtype()), "errorInfo", paramRuleExecuteInfo.getErrorInfo() };
    openMarkerLn("RuleExecuteInfo", arrayOfString);
    a(paramRuleExecuteInfo.getPropertiesList());
    closeMarkerLn("RuleExecuteInfo");
  }

  private void a(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      String[] arrayOfString = { "key", ((AdvancedProperty)paramList.get(i)).getKey(), "property", ((AdvancedProperty)paramList.get(i)).getProperty() };
      openCloseMarkerLn("advancedProperty", arrayOfString);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.e
 * JD-Core Version:    0.6.0
 */