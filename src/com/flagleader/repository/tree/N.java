package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.excel.ExcelBookModel;

class N
  implements Acceptor
{
  N(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof ExcelBookModel;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.N
 * JD-Core Version:    0.6.0
 */