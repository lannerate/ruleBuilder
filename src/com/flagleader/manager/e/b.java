package com.flagleader.manager.e;

import com.flagleader.manager.n;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.IRulePackage;

class b extends Thread
{
  b(a parama, IRulePackage paramIRulePackage)
  {
  }

  public void run()
  {
    this.a.e = System.currentTimeMillis();
    if (this.b.needCheck())
    {
      com.flagleader.repository.lang.a locala = m.a().f();
      this.b.setError(locala.b(this.b));
    }
    this.a.n().a().m().a(this.b);
    this.a.a(100);
    this.a.f = System.currentTimeMillis();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.b
 * JD-Core Version:    0.6.0
 */