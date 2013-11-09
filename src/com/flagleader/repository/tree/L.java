package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IWhileObject;
import java.util.List;

class L
  implements ChildAcceptor
{
  L(Envionment paramEnvionment, String paramString, List paramList)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof IBusinessObject)) && (((IBusinessObject)paramObject).getDisplayName().equals(this.b));
  }

  public boolean hasChildren(Object paramObject)
  {
    if ((paramObject instanceof IWhileObject))
    {
      for (int i = 0; i < this.c.size(); i++)
        if (this.c.get(i).equals(paramObject))
          return true;
      return false;
    }
    return !(paramObject instanceof IRuleTree);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.L
 * JD-Core Version:    0.6.0
 */