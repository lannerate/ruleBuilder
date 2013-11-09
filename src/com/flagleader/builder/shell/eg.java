package com.flagleader.builder.shell;

import com.flagleader.server.RuleServer;
import com.flagleader.util.EngineLogger;

class eg extends Thread
{
  private boolean b = false;

  public eg(RuleServerTray paramRuleServerTray)
  {
  }

  public void run()
  {
    try
    {
      RuleServer.a();
    }
    catch (Exception localException)
    {
      EngineLogger.getSqlLogger().error(localException.getMessage(), localException);
      this.b = true;
    }
  }

  public void a()
  {
    RuleServer.e();
    this.b = true;
  }

  public boolean b()
  {
    return this.b;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eg
 * JD-Core Version:    0.6.0
 */