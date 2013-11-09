package com.flagleader.repository.tree;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.excel.AbstractExcelFieldModel;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.excel.IExcelObject;

class x
  implements ChildAcceptor
{
  x(Envionment paramEnvionment)
  {
  }

  public boolean accept(Object paramObject)
  {
    return ((paramObject instanceof AbstractExcelFieldModel)) && (((AbstractExcelFieldModel)paramObject).isEditVisible());
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IExcelObject)) || ((paramObject instanceof ExcelBookModel));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.x
 * JD-Core Version:    0.6.0
 */