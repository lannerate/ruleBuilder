package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.excel.ExcelFunction;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.ISubFunction;

class l
  implements ChildAcceptor
{
  l(FunctionExcelToken paramFunctionExcelToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((((localIBusinessObjectEditen instanceof ExcelFunction)) || ((localIBusinessObjectEditen instanceof ISubFunction))) && ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IExcelObject)) || ((paramObject instanceof ExcelFunction)) || ((paramObject instanceof ISubFunction));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.l
 * JD-Core Version:    0.6.0
 */