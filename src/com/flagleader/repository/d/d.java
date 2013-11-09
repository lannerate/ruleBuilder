package com.flagleader.repository.d;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.e;
import com.flagleader.repository.rlm.IRuleObject;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.ITreeNode;

public class d
  implements e
{
  private IElement f = null;
  private String g = "";
  private int h = 0;

  public d(String paramString, IElement paramIElement, int paramInt)
  {
    this.f = paramIElement;
    this.g = paramString;
    this.h = paramInt;
  }

  public d(String paramString, IElement paramIElement)
  {
    this.f = paramIElement;
    this.g = paramString;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(u.a("checkError.error", " Error") + " : " + this.g + "     ");
    if (this.f != null)
      localStringBuffer.append(u.a("errorSource.error", " Source") + " : " + this.f.toString());
    return localStringBuffer.toString();
  }

  public ITreeNode c()
  {
    if (this.f == null)
      throw new q();
    if (((this.f instanceof IRuleObject)) && (((IRuleObject)this.f).getRoot() != null))
      return ((IRuleObject)this.f).getRoot().getRuleTree();
    if ((this.f instanceof ITreeNode))
      return (ITreeNode)this.f;
    if ((this.f instanceof IBusinessObject))
      return ((IBusinessObject)this.f).getContainer().getEnvionment();
    return null;
  }

  public String b()
  {
    if (this.f != null)
      return this.f.toString();
    return "";
  }

  public String a()
  {
    return this.g;
  }

  public int d()
  {
    return this.h;
  }

  public boolean e()
  {
    return (this.h != 2) && (this.h != 3);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.d
 * JD-Core Version:    0.6.0
 */