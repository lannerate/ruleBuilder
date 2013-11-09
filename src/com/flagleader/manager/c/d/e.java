package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.AbstractRuleSet;

public class e
  implements f
{
  public e(a parama)
  {
  }

  public String a()
  {
    return this.a.f().getErrorMsg();
  }

  public boolean a(String paramString)
  {
    if ((this.a.f().getExceptionType() == 0) || (this.a.f().getExceptionType() == 3))
      return false;
    if (!this.a.f().getErrorMsg().equals(paramString))
    {
      this.a.f().setErrorMsg(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.e
 * JD-Core Version:    0.6.0
 */