package com.flagleader.server;

import com.flagleader.a.a.r;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RuleAutoExecuter
{
  public static boolean a = false;
  public static File b = new File(FileUtil.getCurrentDir(), "excuter.rei");
  public static ExecuteInfos c;

  public static void main(String[] paramArrayOfString)
  {
    try
    {
      ConsoleHandler localConsoleHandler = new ConsoleHandler();
      localConsoleHandler.setFormatter(new c());
      localConsoleHandler.setLevel(Level.ALL);
      Logger.getLogger("ruleengine").addHandler(localConsoleHandler);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    if (!b.exists())
    {
      LogFactory.getLog("ruleengine").error("Rule Auto Executer can not started because file " + b + " is not exits!");
      return;
    }
    if (r.a("ruleengine.rlc"))
      Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
    else
      Property.getInstance().setEngineImplement("com.flagleader.engine.impl.TestRuleEngineFactory");
    RuleEngineFactory.newInstance();
    try
    {
      c = (ExecuteInfos)new d().load(b);
    }
    catch (Exception localException2)
    {
      LogFactory.getLog("ruleengine").error(localException2.getMessage(), localException2);
      return;
    }
    LogFactory.getLog("ruleengine").info("Rule Auto Executer Started");
    List localList = c.getInfos();
    for (int i = 0; i < localList.size(); i++)
      ((RuleExecuteInfo)localList.get(i)).setStoped(false);
    while (true)
      try
      {
        Thread.currentThread();
        Thread.sleep(60000L);
        continue;
      }
      catch (Exception localException3)
      {
      }
  }

  private static String a(String paramString)
  {
    if (new File(FileUtil.getCurrentDir(), paramString).exists())
      return new File(FileUtil.getCurrentDir(), paramString).getAbsolutePath();
    if ((Property.getInstance().getRuleEngineClassDir().length() > 0) && (new File(new File(Property.getInstance().getRuleEngineClassDir()).getParent(), paramString).exists()))
      return new File(new File(Property.getInstance().getRuleEngineClassDir()).getParent(), paramString).getAbsolutePath();
    return paramString;
  }

  static void a()
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.RuleAutoExecuter
 * JD-Core Version:    0.6.0
 */