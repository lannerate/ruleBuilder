package com.flagleader.manager.e;

import com.flagleader.repository.d.u;
import com.flagleader.repository.e;
import com.flagleader.repository.tree.ITreeNode;

public class H
  implements e
{
  private String f = "";
  private ITreeNode g = null;
  private String h = "";

  public H(String paramString1, ITreeNode paramITreeNode, String paramString2)
  {
    this.f = paramString1;
    this.g = paramITreeNode;
    this.h = paramString2;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(u.a("checkError.error", " Error") + " : " + this.f + "     ");
    localStringBuffer.append(u.a("actualValue.error", " actualValue") + " : " + this.h);
    return localStringBuffer.toString();
  }

  public String a()
  {
    return this.f;
  }

  public String b()
  {
    return this.h;
  }

  public ITreeNode c()
  {
    return this.g;
  }

  public int d()
  {
    return 10;
  }

  public boolean e()
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.H
 * JD-Core Version:    0.6.0
 */