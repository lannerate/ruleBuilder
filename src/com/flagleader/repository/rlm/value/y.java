package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;

class y
  implements ChildAcceptor
{
  y(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof SheetFieldsSelectToken;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof ValueToken;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.y
 * JD-Core Version:    0.6.0
 */