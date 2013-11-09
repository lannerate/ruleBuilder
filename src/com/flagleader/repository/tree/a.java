package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObject;

class a
  implements Acceptor
{
  a(AbstractBOContainer paramAbstractBOContainer, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IBusinessObject)) && (((IBusinessObject)paramObject).isEditVisible()) && ((this.b == null) || (this.b.length() == 0) || (((IBusinessObject)paramObject).getJavaType().c(this.b)));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.a
 * JD-Core Version:    0.6.0
 */