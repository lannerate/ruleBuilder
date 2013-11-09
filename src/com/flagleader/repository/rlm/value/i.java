package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.soap.SoapFunction;
import com.flagleader.repository.soap.SoapService;

class i
  implements ChildAcceptor
{
  i(MemberSoapToken paramMemberSoapToken, String paramString)
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
      else if (((localIBusinessObjectEditen instanceof SoapService)) && (this.b != null) && (this.b.length() > 0) && (!localIBusinessObjectEditen.getJavaType().l()) && (localIBusinessObjectEditen.getJavaType().c(this.b)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof SoapService)) || ((paramObject instanceof SoapFunction)) || ((paramObject instanceof IPropertyObject)) || ((paramObject instanceof ISubFunction)) || ((paramObject instanceof ISubVariable));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.i
 * JD-Core Version:    0.6.0
 */