package com.flagleader.repository.lang.expression;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleTree;

class o
  implements ChildAcceptor
{
  o(StatementSystem paramStatementSystem)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof IBusinessObject;
  }

  public boolean hasChildren(Object paramObject)
  {
    return !(paramObject instanceof IRuleTree);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.o
 * JD-Core Version:    0.6.0
 */