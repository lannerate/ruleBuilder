package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RulePackage;

public class G
  implements e
{
  public G(y paramy)
  {
  }

  public int a()
  {
    return y.a(this.a).getLockType();
  }

  public String[] b()
  {
    return y.j;
  }

  public boolean a(int paramInt)
  {
    if (y.a(this.a).isDbRules())
      return false;
    if (paramInt != y.a(this.a).getLockType())
    {
      y.a(this.a).setLockType(paramInt);
      y.a(this.a).setModified(true);
      if (y.a(this.a).getProject() != null)
        y.a(this.a).getProject().updateTree();
      y.a(this.a).disposeAllViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.G
 * JD-Core Version:    0.6.0
 */