package com.flagleader.server;

import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.impl.RuleServerFactory;
import com.flagleader.engine.impl.RuleServerPoolFactory;
import com.flagleader.engine.impl.RuleServerService;
import com.flagleader.util.StringUtil;
import com.flagleader.xml.XMLReceiveBean;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class p extends Thread
{
  private int b = 0;
  private int c;

  public p(RuleThreadInfo paramRuleThreadInfo)
  {
  }

  public String a(XMLReceiveBean paramXMLReceiveBean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramXMLReceiveBean.getRuleName());
    localStringBuffer.append("{");
    Object localObject1;
    Object localObject2;
    if (paramXMLReceiveBean.getValues().size() > 0)
    {
      localObject1 = paramXMLReceiveBean.getValues().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = String.valueOf(((Iterator)localObject1).next());
        localObject2 = paramXMLReceiveBean.getValue(str);
        if ((!(localObject2 instanceof Number)) && (!(localObject2 instanceof String)) && (!(localObject2 instanceof Date)))
          continue;
        localStringBuffer.append(str).append("=");
        localStringBuffer.append(StringUtil.stringValue(localObject2));
        localStringBuffer.append(";");
      }
    }
    else
    {
      localObject1 = paramXMLReceiveBean.getDymicValues();
      for (int i = 0; (localObject1 != null) && (i < localObject1.length); i++)
      {
        localObject2 = localObject1[i];
        if ((!(localObject2 instanceof Number)) && (!(localObject2 instanceof String)) && (!(localObject2 instanceof Date)))
          continue;
        localStringBuffer.append(StringUtil.stringValue(localObject2)).append(";");
      }
    }
    return (String)(localStringBuffer.substring(0, localStringBuffer.length() - 1) + "}");
  }

  public void run()
  {
    this.c = RuleThreadInfo.access$0(this.a).indexOf(this);
    LogFactory.getLog("ruleengine").info(MessageUtil.format("ruleonethreadstart.text", new String[] { RuleThreadInfo.access$1(this.a), String.valueOf(this.c) }));
    try
    {
      while (!RuleThreadInfo.access$2(this.a))
      {
        if (!RuleThreadInfo.access$3(this.a).isEmpty())
        {
          k localk = (k)RuleThreadInfo.access$3(this.a).pop();
          if (localk != null)
          {
            if (RuleThreadServer.f != null)
              RuleThreadServer.f.a(this.a);
            localk.e();
            XMLReceiveBean localXMLReceiveBean = localk.d();
            if (localXMLReceiveBean != null)
              try
              {
                this.b = 1;
                LogFactory.getLog("ruleengine").info(MessageUtil.format("ruleonestart.text", new String[] { a(localXMLReceiveBean), String.valueOf(RuleThreadInfo.access$3(this.a).size()) }));
                long l = System.currentTimeMillis();
                if (RuleThreadInfo.access$4(this.a) == 0)
                {
                  RuleEngine localRuleEngine = RuleEngineFactory.getInstance(localXMLReceiveBean.getLibraryName()).getRuleEngine();
                  localRuleEngine.excute(localXMLReceiveBean.getValues(), this.a.getRuleName(), localXMLReceiveBean.getRuleVersion());
                  LogFactory.getLog("ruleengine").info(MessageUtil.format("ruleoneexecuted.text", new String[] { a(localXMLReceiveBean), String.valueOf(System.currentTimeMillis() - l) }));
                  localRuleEngine = null;
                }
                else
                {
                  int i = 0;
                  if (RuleThreadInfo.access$5(this.a).length > 1)
                  {
                    i = RuleThreadInfo.access$6(this.a) % RuleThreadInfo.access$5(this.a).length;
                    RuleThreadInfo.access$7(this.a, i + 1);
                  }
                  Object localObject;
                  RuleServerService localRuleServerService;
                  if (RuleThreadInfo.access$4(this.a) == 1)
                  {
                    localObject = RuleServerPoolFactory.getFactory(RuleThreadInfo.access$5(this.a)[i], RuleThreadInfo.access$8(this.a)[i]);
                    localRuleServerService = (RuleServerService)((RuleServerPoolFactory)localObject).getRuleService();
                    localRuleServerService.execute(localXMLReceiveBean.getValues(), this.a.getRuleName(), localXMLReceiveBean.getRuleVersion());
                  }
                  else
                  {
                    localObject = new RuleServerFactory(RuleThreadInfo.access$5(this.a)[i], RuleThreadInfo.access$8(this.a)[i]);
                    localRuleServerService = (RuleServerService)((RuleServerFactory)localObject).getRuleService();
                    localRuleServerService.execute(localXMLReceiveBean.getValues(), this.a.getRuleName(), localXMLReceiveBean.getRuleVersion());
                  }
                  LogFactory.getLog("ruleengine").info(MessageUtil.format("ruleoneexecuted.text", new String[] { a(localXMLReceiveBean), String.valueOf(System.currentTimeMillis() - l) }));
                }
                this.b = 0;
              }
              catch (Throwable localThrowable2)
              {
                RuleThreadInfo.access$9(this.a, localThrowable2.getMessage());
                LogFactory.getLog("ruleengine").error(a(localXMLReceiveBean) + localThrowable2.getMessage());
                try
                {
                  this.a.insertSql(localXMLReceiveBean.getValues(), localXMLReceiveBean.getRuleName(), localThrowable2.getMessage());
                }
                catch (Exception localException2)
                {
                  LogFactory.getLog("ruleengine").error(localXMLReceiveBean.getRuleName() + localThrowable2.getMessage());
                }
                try
                {
                  sleep(RuleThreadInfo.access$10(this.a));
                }
                catch (Exception localException3)
                {
                }
              }
            localk.f();
          }
        }
        if (!RuleThreadInfo.access$3(this.a).isEmpty())
          continue;
        if (RuleThreadInfo.access$10(this.a) == 0L)
          break;
        try
        {
          sleep(RuleThreadInfo.access$10(this.a));
        }
        catch (Exception localException1)
        {
        }
        if ((RuleThreadInfo.access$11(this.a) > 0L) && (RuleThreadInfo.access$0(this.a).size() > RuleThreadInfo.access$11(this.a)))
          break;
      }
    }
    catch (Throwable localThrowable1)
    {
      LogFactory.getLog("ruleengine").error(RuleThreadInfo.access$1(this.a) + localThrowable1.getMessage());
      localThrowable1.printStackTrace();
    }
    LogFactory.getLog("ruleengine").info(MessageUtil.format("ruleonethreadstop.text", new String[] { RuleThreadInfo.access$1(this.a), String.valueOf(this.c) }));
    RuleThreadInfo.access$0(this.a).remove(this);
    this.b = 2;
  }

  public int a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.p
 * JD-Core Version:    0.6.0
 */