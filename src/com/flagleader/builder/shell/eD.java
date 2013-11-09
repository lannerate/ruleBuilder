package com.flagleader.builder.shell;

import com.flagleader.server.RuleThreadServer;
import com.flagleader.util.EngineLogger;

class eD extends Thread
{
  private boolean b = false;

  public eD(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void run()
  {
    try
    {
      RuleThreadServer.e();
    }
    catch (Exception localException)
    {
      EngineLogger.getSqlLogger().error(localException.getMessage(), localException);
      this.b = true;
    }
  }

  public void a()
  {
    RuleThreadServer.f();
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
 * Qualified Name:     com.flagleader.builder.shell.eD
 * JD-Core Version:    0.6.0
 */