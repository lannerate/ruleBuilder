package com.flagleader.repository.db;

import com.flagleader.repository.collections.Acceptor;

class a
  implements Acceptor
{
  a(SheetMap paramSheetMap)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof MapValue;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.a
 * JD-Core Version:    0.6.0
 */