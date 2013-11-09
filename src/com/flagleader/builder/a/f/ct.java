package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.tree.Rule;

public class ct extends a
{
  public ct(ck paramck)
  {
  }

  public void a()
  {
    ck.a(this.a).getRuleElementToken().addElseIfToken();
    ck.a(this.a).setModified(true);
    this.a.update();
  }

  public boolean b()
  {
    return !ck.c(this.a);
  }

  public String c()
  {
    return "add";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ct
 * JD-Core Version:    0.6.0
 */