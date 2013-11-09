package com.flagleader.manager.c.d;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RulePackage;

public class L
  implements f
{
  public L(y paramy)
  {
  }

  public String a()
  {
    return y.a(this.a).getFilePathName();
  }

  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.a(this.a).setDirPath("");
      y.a(this.a).setFilePathName("");
      y.a(this.a).setModified(true);
      if (y.a(this.a).getProject() != null)
        y.a(this.a).getProject().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.L
 * JD-Core Version:    0.6.0
 */