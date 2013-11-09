package com.flagleader.builder.a.g;

import com.flagleader.builder.a.c.a;
import com.flagleader.builder.dialogs.d.v;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.util.ArrayList;

public class u extends a
{
  public u(r paramr)
  {
  }

  public void a()
  {
    TestCase localTestCase = new TestCase();
    localTestCase.setParent(r.b(this.a));
    localTestCase.initVariables();
    v localv = new v(localTestCase);
    if (localv.open() == 0)
    {
      r.b(this.a).getTestInfos().add(localTestCase);
      r.b(this.a).refreshInit();
      r.b(this.a).setModified(true);
      this.a.update();
    }
  }

  public boolean b()
  {
    return !r.d(this.a);
  }

  public String c()
  {
    return "add";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.u
 * JD-Core Version:    0.6.0
 */