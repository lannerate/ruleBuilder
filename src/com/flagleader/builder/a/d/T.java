package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageElementModel;

class T
  implements d
{
  T(P paramP, IElement paramIElement)
  {
  }

  public String[] a()
  {
    return P.a(this.a, "elementType.choise");
  }

  public boolean a(int paramInt)
  {
    if ((this.a.a(paramInt)) && (!((PageElementModel)this.b).getElementType().equalsIgnoreCase(P.c(this.a)[paramInt])))
    {
      String str = P.c(this.a)[paramInt];
      ((PageElementModel)this.b).setElementType(str);
      this.a.a((PageElementModel)this.b, str);
      this.a.q().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.T
 * JD-Core Version:    0.6.0
 */