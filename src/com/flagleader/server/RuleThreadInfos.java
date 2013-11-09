package com.flagleader.server;

import com.flagleader.repository.f;
import com.flagleader.util.TempID;
import com.flagleader.xml.XMLReceiveBean;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class RuleThreadInfos
  implements f
{
  Hashtable a = new Hashtable();
  String b = "";
  private int port = 1509;
  private boolean autoupdate = false;
  private String acceptIPs = "";
  private int streamtype = 0;
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public void addRuleThreadInfo(RuleThreadInfo paramRuleThreadInfo)
  {
    this.a.put(paramRuleThreadInfo.getRuleName(), paramRuleThreadInfo);
  }

  public void executeReceive(k paramk)
  {
    XMLReceiveBean localXMLReceiveBean = paramk.d();
    RuleThreadInfo localRuleThreadInfo = (RuleThreadInfo)this.a.get(localXMLReceiveBean.getRuleName());
    if (localRuleThreadInfo == null)
    {
      localRuleThreadInfo = new RuleThreadInfo();
      localRuleThreadInfo.setGroupName(localXMLReceiveBean.getRuleName());
      localRuleThreadInfo.setRuleName(localXMLReceiveBean.getRuleName());
      localRuleThreadInfo.setDisplayName(localXMLReceiveBean.getRuleName());
      localRuleThreadInfo.setMinThreads(1L);
      localRuleThreadInfo.setMaxThreads(10L);
      this.a.put(localXMLReceiveBean.getRuleName(), localRuleThreadInfo);
    }
    if (RuleThreadServer.f != null)
      RuleThreadServer.f.a(localRuleThreadInfo);
    localRuleThreadInfo.appendReceive(paramk);
  }

  public void stopAll()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      RuleThreadInfo localRuleThreadInfo = (RuleThreadInfo)localIterator.next();
      localRuleThreadInfo.setStoped(true);
    }
  }

  public Hashtable getInfos()
  {
    return this.a;
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

  public int getPort()
  {
    return this.port;
  }

  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }

  public boolean isAutoupdate()
  {
    return this.autoupdate;
  }

  public void setAutoupdate(boolean paramBoolean)
  {
    this.autoupdate = paramBoolean;
  }

  public String getAcceptIPs()
  {
    return this.acceptIPs;
  }

  public void setAcceptIPs(String paramString)
  {
    this.acceptIPs = paramString;
  }

  public int getStreamtype()
  {
    return this.streamtype;
  }

  public void setStreamtype(int paramInt)
  {
    this.streamtype = paramInt;
  }

  public void save()
  {
    try
    {
      RuleThreadInfoXmlWriter localRuleThreadInfoXmlWriter = new RuleThreadInfoXmlWriter(RuleThreadServer.c);
      localRuleThreadInfoXmlWriter.a(this);
      localRuleThreadInfoXmlWriter.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.RuleThreadInfos
 * JD-Core Version:    0.6.0
 */