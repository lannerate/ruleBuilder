package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.CustomVariable;

class F
  implements ChildAcceptor
{
  F(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return (paramObject instanceof CustomVariable);
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof ValueLibrary)) || ((paramObject instanceof VariableLibrary));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.F
 * JD-Core Version:    0.6.0
 */