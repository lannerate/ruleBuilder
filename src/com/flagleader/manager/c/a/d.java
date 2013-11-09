package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.ClassContainer;

public class d
  implements e
{
  public d(b paramb)
  {
  }

  public int a()
  {
    return this.a.f().getMultiType();
  }

  public String[] b()
  {
    return b.f;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getMultiType())
    {
      this.a.f().setMultiType(paramInt);
      if (this.a.f().isSingleValue())
        this.a.f().clearfunction();
      else
        this.a.f().updateFunction();
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.d
 * JD-Core Version:    0.6.0
 */