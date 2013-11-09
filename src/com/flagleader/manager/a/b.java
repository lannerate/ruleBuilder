package com.flagleader.manager.a;

import com.flagleader.engine.RuleService;
import com.flagleader.engine.RuleServiceException;
import com.flagleader.engine.impl.LocalRuleServiceFactory;
import com.flagleader.engine.impl.RuleServletFactory;
import com.flagleader.manager.r;
import java.sql.Connection;

public class b extends LocalRuleServiceFactory
{
  private r a;

  public b(r paramr)
  {
    this.a = paramr;
  }

  public RuleService getRuleService()
  {
    if ((com.flagleader.manager.d.b.a().I()) && (com.flagleader.manager.d.b.a().H().length() > 0))
      return new RuleServletFactory(com.flagleader.manager.d.b.a().H()).getRuleService();
    return new a(this);
  }

  public r a()
  {
    return this.a;
  }

  public void a(r paramr)
  {
    this.a = paramr;
  }

  public void a(Connection paramConnection)
  {
    try
    {
      if ((paramConnection != null) && (!paramConnection.isClosed()))
        paramConnection.close();
    }
    catch (Exception localException)
    {
    }
  }

  public Connection b()
  {
    Connection localConnection = this.a.b().loginRuleServer();
    if (localConnection == null)
      throw new RuleServiceException("can not connection !");
    return localConnection;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.b
 * JD-Core Version:    0.6.0
 */