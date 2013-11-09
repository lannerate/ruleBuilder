package com.flagleader.builder.a.g;

import com.flagleader.builder.a.c.a;
import com.flagleader.builder.dialogs.d.v;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.util.ArrayList;

public class E extends a
{
  public E(B paramB)
  {
  }

  public void a()
  {
    TestCase localTestCase = new TestCase();
    localTestCase.setParent(B.b(this.a));
    localTestCase.initVariables();
    v localv = new v(localTestCase);
    if (localv.open() == 0)
    {
      B.b(this.a).getTestInfos().add(localTestCase);
      B.b(this.a).refreshInit();
      B.b(this.a).setModified(true);
      this.a.update();
    }
  }

  public boolean b()
  {
    return !B.d(this.a);
  }

  public String c()
  {
    return "add";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.E
 * JD-Core Version:    0.6.0
 */