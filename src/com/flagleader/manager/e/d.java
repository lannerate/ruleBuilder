package com.flagleader.manager.e;

import com.flagleader.manager.n;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.lang.a;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.IOpenNode;
import com.flagleader.repository.tree.IRulePackage;
import java.util.ArrayList;
import java.util.Iterator;

class d extends Thread
{
  d(c paramc, IOpenNode paramIOpenNode)
  {
  }

  public void run()
  {
    Iterator localIterator = this.b.getRulePackages();
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    this.a.e = System.currentTimeMillis();
    for (int i = 0; i < localArrayList.size(); i++)
    {
      IRulePackage localIRulePackage = (IRulePackage)localArrayList.get(i);
      if (localIRulePackage.needCheck())
      {
        a locala = m.a().f();
        localIRulePackage.setError(locala.b(localIRulePackage));
      }
      this.a.n().a().m().b(localIRulePackage);
      this.a.a(100 * i / localArrayList.size());
    }
    this.a.a(100);
    this.a.f = System.currentTimeMillis();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.d
 * JD-Core Version:    0.6.0
 */