package com.flagleader.builder.a.g;

import com.flagleader.builder.dialogs.d.v;
import com.flagleader.repository.tree.CheckRuleInfo;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.TestCase;
import java.util.ArrayList;

public class d extends com.flagleader.builder.a.c.a
{
  public d(a parama)
  {
  }

  public void a()
  {
    TestCase localTestCase = new TestCase();
    localTestCase.setParent(a.b(this.a));
    localTestCase.initVariables();
    v localv = new v(localTestCase);
    if (localv.open() == 0)
    {
      a.b(this.a).getTestInfos().add(localTestCase);
      a.b(this.a).refreshInit();
      a.f(this.a).setModified(true);
      this.a.update();
    }
  }

  public boolean b()
  {
    return !a.d(this.a);
  }

  public String c()
  {
    return "add";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.d
 * JD-Core Version:    0.6.0
 */