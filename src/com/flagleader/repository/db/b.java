package com.flagleader.repository.db;

import com.flagleader.repository.collections.Acceptor;

class b
  implements Acceptor
{
  b(SheetTable paramSheetTable)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof SheetFieldModel;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.b
 * JD-Core Version:    0.6.0
 */