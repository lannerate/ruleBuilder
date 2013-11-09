package com.flagleader.manager.c;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.ITreeNode;

public class k
  implements f
{
  public k(h paramh)
  {
  }

  public String a()
  {
    return this.a.d().getDocument();
  }

  public boolean a(String paramString)
  {
    if (!this.a.c.getDocument().equals(paramString))
    {
      this.a.c.setDocument(paramString);
      this.a.c.setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.k
 * JD-Core Version:    0.6.0
 */