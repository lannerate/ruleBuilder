package com.flagleader.server;

import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.RuleLogList;
import com.flagleader.util.TempID;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.xml.XMLReceiveBean;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

abstract class a extends Thread
{
  protected Socket a;
  protected String b;
  protected boolean c = false;
  protected int d;

  public a(Socket paramSocket, String paramString)
  {
    this.a = paramSocket;
    this.b = paramString;
    this.a.setTcpNoDelay(true);
    this.a.setReceiveBufferSize(1024);
    this.a.setSendBufferSize(1024);
  }

  public String a(String paramString)
  {
    try
    {
      XMLReceiveBean localXMLReceiveBean = new XMLReceiveBean(paramString);
      if ((ServerProperty.a().h() >= 0) || (RuleServer.d != null))
      {
        localObject1 = ServerProperty.a(localXMLReceiveBean);
        ServerProperty.a().a((String)localObject1, this.b);
        if (RuleServer.d != null)
          this.d = RuleServer.d.a(localXMLReceiveBean.getRuleName(), this.b, (String)localObject1);
      }
      localObject1 = RuleEngineFactory.getInstance(localXMLReceiveBean.getLibraryName()).getRuleEngine();
      if (ServerProperty.a().k() == 1)
        ((RuleEngine)localObject1).put("ruleLog", new RuleLogList());
      Object localObject2;
      try
      {
        HashMap localHashMap = localXMLReceiveBean.getValues();
        if (localHashMap.size() > 0)
        {
          ((RuleEngine)localObject1).excute(localHashMap, localXMLReceiveBean.getRuleName(), localXMLReceiveBean.getRuleVersion());
          ServerProperty.a().a((RuleEngine)localObject1, this.b, localXMLReceiveBean.getRuleName());
          localXMLReceiveBean.resetRoot(((RuleEngine)localObject1).getOutputVariables(), ((RuleEngine)localObject1).getAll());
        }
        else if (localXMLReceiveBean.isBatchExecute())
        {
          localObject2 = ((RuleEngine)localObject1).executeBatch(localXMLReceiveBean.getRuleName(), localXMLReceiveBean.getBatchValues());
          ServerProperty.a().a((RuleEngine)localObject1, this.b, localXMLReceiveBean.getRuleName());
          localXMLReceiveBean.resetBatchValues((List)localObject2);
        }
        else
        {
          localObject2 = ((RuleEngine)localObject1).executeDynamic(localXMLReceiveBean.getRuleName(), localXMLReceiveBean.getDymicValues());
          ServerProperty.a().a((RuleEngine)localObject1, this.b, localXMLReceiveBean.getRuleName());
          localXMLReceiveBean.resetDynamicValues(localObject2);
        }
      }
      catch (RuleEngineException localRuleEngineException)
      {
        ServerProperty.a().a(localXMLReceiveBean, this.b, localRuleEngineException.getDetailMessage());
        localXMLReceiveBean.clearRoot();
        localXMLReceiveBean.setErrorInfo(localRuleEngineException.getMessage(), localRuleEngineException.getDetailMessage());
      }
      if (ServerProperty.a().k() == 1)
        try
        {
          RuleLogList localRuleLogList = (RuleLogList)((RuleEngine)localObject1).get("ruleLog");
          if ((localRuleLogList != null) && (localRuleLogList.hasChild()))
          {
            localObject2 = new File(FileUtil.getCurrentDir() + File.separator + "logs" + File.separator + localXMLReceiveBean.getRuleName(), TempID.newShortTempID() + ".rlg");
            if (!((File)localObject2).getParentFile().exists())
              ((File)localObject2).getParentFile().mkdirs();
            SerializationUtils.serialize(localRuleLogList, new FileOutputStream((File)localObject2));
          }
        }
        catch (Throwable localThrowable2)
        {
        }
      str2 = localXMLReceiveBean.getContent();
      return str2;
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1 = new XMLReceiveBean();
      ((XMLReceiveBean)localObject1).setErrorInfo(localThrowable1.getMessage(), localThrowable1.getLocalizedMessage());
      String str1 = MessageUtil.format("rulereceiveerror.text", new String[] { this.b, paramString, localThrowable1.getLocalizedMessage() });
      LogFactory.getLog("ruleengine").info(str1);
      String str2 = ((XMLReceiveBean)localObject1).getContent();
      return str2;
    }
    finally
    {
      if ((RuleServer.d != null) && (this.d > 0))
        RuleServer.d.a(this.d);
    }
    throw localObject3;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.a
 * JD-Core Version:    0.6.0
 */