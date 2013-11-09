package com.flagleader.repository.d;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.ValueLibrary;

class B
  implements ChildAcceptor
{
  B(A paramA)
  {
  }

  public boolean accept(Object paramObject)
  {
    if ((paramObject instanceof MappingVariable))
    {
      MappingVariable localMappingVariable = (MappingVariable)paramObject;
      if ((localMappingVariable.getInout() > 0) && ((localMappingVariable.getJavaType().m()) || (localMappingVariable.getJavaType().b()) || (localMappingVariable.getJavaType().e()) || (localMappingVariable.getJavaType().G())))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof ValueLibrary;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.B
 * JD-Core Version:    0.6.0
 */