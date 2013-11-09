package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.excel.ExcelFunction;
import com.flagleader.repository.excel.IExcelObject;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;

class c
  implements ChildAcceptor
{
  c(MemberExcelToken paramMemberExcelToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
      {
        if ((this.b == null) || (this.b.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(this.b)))
          return true;
      }
      else if ((localIBusinessObjectEditen instanceof IFunctionObject))
      {
        if (((this.b != null) && (this.b.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().c(this.b))))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IExcelObject)) && (this.b != null) && (this.b.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().c(this.b)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof IExcelObject)) || ((paramObject instanceof ExcelFunction)) || ((paramObject instanceof IPropertyObject)) || ((paramObject instanceof ISubFunction)) || ((paramObject instanceof ISubVariable));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.c
 * JD-Core Version:    0.6.0
 */