package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.excel.ExcelRowModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class R
  implements e
{
  public R(Q paramQ)
  {
  }

  public int a()
  {
    for (int i = 0; i < b().length; i++)
      if (Q.a(this.a).getCellType().equals(b()[i]))
        return i;
    return 0;
  }

  public String[] b()
  {
    return ExcelRowModel.DATETYPES;
  }

  public boolean a(int paramInt)
  {
    return a(ExcelRowModel.DATETYPES[paramInt]);
  }

  private boolean a(Object paramObject)
  {
    if (!Q.a(this.a).getCellType().equals(paramObject))
    {
      Q.a(this.a).setCellType(paramObject.toString());
      Q.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.R
 * JD-Core Version:    0.6.0
 */