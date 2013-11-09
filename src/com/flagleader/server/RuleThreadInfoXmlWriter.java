package com.flagleader.server;

import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class RuleThreadInfoXmlWriter extends XmlWriter
{
  public RuleThreadInfoXmlWriter(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public RuleThreadInfoXmlWriter(Writer paramWriter)
  {
    super(paramWriter);
  }

  public RuleThreadInfoXmlWriter(File paramFile)
  {
    super(paramFile);
  }

  public void a(RuleThreadInfos paramRuleThreadInfos)
  {
    printHeader();
    String[] arrayOfString = { "displayName", paramRuleThreadInfos.getDisplayName(), "port", String.valueOf(paramRuleThreadInfos.getPort()), "acceptIPs", String.valueOf(paramRuleThreadInfos.getAcceptIPs()), "autoupdate", String.valueOf(paramRuleThreadInfos.isAutoupdate()), "streamtype", String.valueOf(paramRuleThreadInfos.getStreamtype()) };
    openMarkerLn("RuleThreadInfos", arrayOfString);
    Iterator localIterator = paramRuleThreadInfos.getInfos().values().iterator();
    while (localIterator.hasNext())
      a((RuleThreadInfo)localIterator.next());
    closeMarkerLn("RuleThreadInfos");
    flush();
  }

  private void a(RuleThreadInfo paramRuleThreadInfo)
  {
    String[] arrayOfString = { "groupName", paramRuleThreadInfo.getGroupName(), "displayName", paramRuleThreadInfo.getDisplayName(), "ruleName", paramRuleThreadInfo.getRuleName(), "internalTime", String.valueOf(paramRuleThreadInfo.getInternalTime()), "minThreads", String.valueOf(paramRuleThreadInfo.getMinThreads()), "maxThreads", String.valueOf(paramRuleThreadInfo.getMaxThreads()), "location", String.valueOf(paramRuleThreadInfo.getLocation()), "remoteips", String.valueOf(paramRuleThreadInfo.getRemoteips()), "remoteports", String.valueOf(paramRuleThreadInfo.getRemoteports()), "connName", String.valueOf(paramRuleThreadInfo.getConnName()), "sql", String.valueOf(paramRuleThreadInfo.getSql()) };
    openMarkerLn("RuleThreadInfo", arrayOfString);
    closeMarkerLn("RuleThreadInfo");
  }

  public static void main(String[] paramArrayOfString)
  {
    RuleThreadInfos localRuleThreadInfos = new RuleThreadInfos();
    localRuleThreadInfos.setDisplayName("sample");
    RuleThreadInfo localRuleThreadInfo = new RuleThreadInfo();
    localRuleThreadInfo.setGroupName("helloworld");
    localRuleThreadInfo.setRuleName("simple.helloworld");
    localRuleThreadInfo.setDisplayName("世界你好");
    localRuleThreadInfos.addRuleThreadInfo(localRuleThreadInfo);
    File localFile = RuleThreadServer.c;
    try
    {
      RuleThreadInfoXmlWriter localRuleThreadInfoXmlWriter = new RuleThreadInfoXmlWriter(localFile);
      localRuleThreadInfoXmlWriter.a(localRuleThreadInfos);
      localRuleThreadInfoXmlWriter.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.RuleThreadInfoXmlWriter
 * JD-Core Version:    0.6.0
 */