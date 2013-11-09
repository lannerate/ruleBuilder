package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.FunctionLibrary;

class p
  implements ChildAcceptor
{
  p(FunctionStaticToken paramFunctionStaticToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IFunctionObject)) && (((IFunctionObject)paramObject).isEditVisible()))
    {
      IFunctionObject localIFunctionObject = (IFunctionObject)paramObject;
      if (((localIFunctionObject instanceof IFunctionObject)) && ((this.b == null) || (this.b.length() == 0) || (localIFunctionObject.getJavaType().c(this.b))))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof FunctionLibrary)) || ((paramObject instanceof CustomFunction)) || ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof IFunctionObject)) || ((paramObject instanceof IClassObject));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.p
 * JD-Core Version:    0.6.0
 */