package com.flagleader.manager;

import com.flagleader.manager.b.a;
import com.flagleader.manager.b.b;
import com.flagleader.manager.b.c;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class n
{
  r a = null;
  private q b = new q(this);
  private List c = new ArrayList();
  private List d = new ArrayList();
  private c e = null;
  private p f = null;

  public n(r paramr)
  {
    this.a = paramr;
    Logger localLogger = Logger.getLogger("flagleader");
    p localp = new p(this);
    localp.setLevel(Level.ALL);
    localLogger.addHandler(localp);
  }

  public q a()
  {
    return this.b;
  }

  public void a(IRuleRepository paramIRuleRepository)
  {
    Logger localLogger = Logger.getLogger("ruleengine");
    if (this.f != null)
      localLogger.removeHandler(this.f);
    this.f = new p(this);
    this.f.setLevel(Level.ALL);
    localLogger.addHandler(this.f);
  }

  public void a(b paramb)
  {
    this.c.add(paramb);
  }

  public void a(a parama)
  {
    this.d.add(parama);
  }

  public void a(LogRecord paramLogRecord)
  {
    for (int i = 0; i < this.c.size(); i++)
      ((b)this.c.get(i)).a(paramLogRecord);
  }

  public void a(String paramString, Level paramLevel)
  {
    for (int i = 0; i < this.c.size(); i++)
      ((b)this.c.get(i)).a(paramString, paramLevel);
  }

  public void a(List paramList, boolean paramBoolean)
  {
    for (int i = 0; i < this.d.size(); i++)
      ((a)this.d.get(i)).a(paramList, paramBoolean);
  }

  public void a(c paramc)
  {
    this.e = paramc;
  }

  public void a(IRulePackage paramIRulePackage)
  {
    if (this.e != null)
      this.e.c(paramIRulePackage);
  }

  public void b(IRulePackage paramIRulePackage)
  {
    if (this.e != null)
      this.e.b(paramIRulePackage);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.n
 * JD-Core Version:    0.6.0
 */