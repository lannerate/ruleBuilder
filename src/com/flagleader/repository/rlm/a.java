package com.flagleader.repository.rlm;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.BusinessObjectClass;
import com.flagleader.repository.tree.ClassContainer;

class a
  implements ChildAcceptor
{
  a(AbstractClassToken paramAbstractClassToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof BusinessObjectClass)) && ((this.a.getValueType() == null) || (this.a.getValueType().length() == 0) || (((BusinessObjectClass)paramObject).getJavaType().c(this.a.getValueType())));
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof ClassContainer;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.a
 * JD-Core Version:    0.6.0
 */