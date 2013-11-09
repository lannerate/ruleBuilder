package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.FunctionMember;

class P
  implements ChildAcceptor
{
  P(Envionment paramEnvionment, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof FunctionMember))
    {
      FunctionMember localFunctionMember = (FunctionMember)paramObject;
      if ((localFunctionMember.isEditVisible()) && ((this.b == null) || (this.b.length() == 0) || (localFunctionMember.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof CustomFunction;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.P
 * JD-Core Version:    0.6.0
 */