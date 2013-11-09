package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.FunctionLibrary;

class j
  implements ChildAcceptor
{
  j(MemberStaticToken paramMemberStaticToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    String str = this.a.getValueType();
    if (((paramObject instanceof IBusinessObjectEditen)) && (((IBusinessObjectEditen)paramObject).isEditVisible()))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IClassObject)) && (!(localIBusinessObjectEditen instanceof FunctionClass)))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().c(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IFunctionObject)) && (((str != null) && (str.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().c(str)))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof FunctionLibrary)) || ((paramObject instanceof CustomFunction)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof IFunctionObject)) || ((paramObject instanceof IClassObject)) || ((paramObject instanceof ISubVariable));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.j
 * JD-Core Version:    0.6.0
 */