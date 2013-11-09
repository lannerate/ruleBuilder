package com.flagleader.manager.a;

import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleServiceException;
import com.flagleader.engine.impl.LocalRuleService;
import java.sql.Connection;

public class a extends LocalRuleService
{
  protected b a;

  public a(b paramb)
  {
    this.a = paramb;
  }

  public void execute(String paramString1, String paramString2)
  {
    Connection localConnection = a().b();
    try
    {
      this.engine.put("rules", localConnection);
      super.execute(paramString1, paramString2);
      if (!localConnection.getAutoCommit())
        localConnection.commit();
    }
    catch (RuleServiceException localRuleServiceException)
    {
      throw localRuleServiceException;
    }
    catch (Exception localException)
    {
      throw new RuleServiceException(localException);
    }
    finally
    {
      a().a(localConnection);
    }
  }

  private b a()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a
 * JD-Core Version:    0.6.0
 */