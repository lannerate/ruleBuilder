package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.Envionment;

public class e
  implements f
{
  public e(b paramb)
  {
  }

  public String a()
  {
    return this.a.f().getNodeName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getNodeName().equals(paramString))
    {
      this.a.f().setNodeName(paramString.toString());
      this.a.f().getEnvionment().registBusinessObject(this.a.f());
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.e
 * JD-Core Version:    0.6.0
 */