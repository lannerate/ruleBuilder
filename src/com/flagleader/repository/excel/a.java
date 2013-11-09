package com.flagleader.repository.excel;

import com.flagleader.repository.collections.Acceptor;

class a
  implements Acceptor
{
  a(AbstractExcelFieldModel paramAbstractExcelFieldModel)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof AbstractExcelFieldModel;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.a
 * JD-Core Version:    0.6.0
 */