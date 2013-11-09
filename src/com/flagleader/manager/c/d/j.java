package com.flagleader.manager.c.d;

import com.flagleader.repository.tree.DecisionMultiRule;

public class j
  implements com.flagleader.manager.c.c.g
{
  public j(g paramg)
  {
  }

  public String[] a()
  {
    return new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
  }

  public String b()
  {
    return new Integer(this.a.f().getValueNum()).toString();
  }

  public boolean a(String paramString)
  {
    if (this.a.f().getValueNum() != Integer.parseInt(paramString.toString()))
    {
      this.a.f().setValueNum(Integer.parseInt(paramString.toString()));
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.j
 * JD-Core Version:    0.6.0
 */