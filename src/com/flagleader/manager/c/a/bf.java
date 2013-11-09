package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.xml.TreeValueNode;

public class bf
  implements e
{
  public bf(bc parambc)
  {
  }

  public int a()
  {
    return this.a.f().getMultiType();
  }

  public String[] b()
  {
    return bc.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getMultiType())
    {
      this.a.f().setMultiType(paramInt);
      this.a.f().setModified(true);
      this.a.f().resetFunction();
      this.a.f().updateTree();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bf
 * JD-Core Version:    0.6.0
 */