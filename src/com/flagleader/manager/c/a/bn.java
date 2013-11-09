package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.xml.XmlNode;

public class bn
  implements f
{
  public bn(bj parambj)
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
      this.a.f().getEnvionment().reRegistAllBusinessObject();
      this.a.f().setModified(true);
      this.a.f().updateFunction();
      this.a.f().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bn
 * JD-Core Version:    0.6.0
 */