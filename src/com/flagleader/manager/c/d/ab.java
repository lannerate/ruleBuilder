package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.manager.d.c;
import com.flagleader.repository.rlm.ElseIfRuleToken;
import com.flagleader.repository.rlm.RuleToken;
import com.flagleader.repository.tree.Rule;
import java.util.List;

public class ab
  implements e
{
  public ab(Z paramZ)
  {
  }

  public int a()
  {
    return 0;
  }

  public String[] b()
  {
    String[] arrayOfString = new String[this.a.f().getRuleElementToken().getElseIfTokens().size() + 2];
    arrayOfString[0] = c.b("elseifsupport.dialog");
    arrayOfString[1] = c.b("elseifadd.dialog");
    for (int i = 0; i < this.a.f().getRuleElementToken().getElseIfTokens().size(); i++)
      arrayOfString[(i + 2)] = c.a("elseifdelete.dialog", new String[] { i + 1 });
    return arrayOfString;
  }

  public boolean a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.f().getRuleElementToken().addElseIfToken();
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    if (paramInt > 1)
    {
      List localList = this.a.f().getRuleElementToken().getElseIfTokens();
      ((ElseIfRuleToken)localList.get(paramInt - 2)).dispose();
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ab
 * JD-Core Version:    0.6.0
 */