package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.g;
import com.flagleader.repository.tree.DecisionRelateRule;

public class l
  implements g
{
  public l(k paramk)
  {
  }

  public String[] a()
  {
    return new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
  }

  public String b()
  {
    return new Integer(this.a.f().getConditionNum()).toString();
  }

  public boolean a(String paramString)
  {
    if (this.a.f().getConditionNum() != Integer.parseInt(paramString.toString()))
    {
      this.a.f().setConditionNum(Integer.parseInt(paramString.toString()));
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.l
 * JD-Core Version:    0.6.0
 */