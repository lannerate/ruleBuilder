package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.db.TableFunction;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.BOContainerGroup;

class d
  implements ChildAcceptor
{
  d(MemberMapToken paramMemberMapToken, String paramString)
  {
  }

  public boolean accept(Object paramObject)
  {
    if (((paramObject instanceof IBusinessObject)) && (((IBusinessObject)paramObject).isEditVisible()))
    {
      IBusinessObject localIBusinessObject = (IBusinessObject)paramObject;
      if ((localIBusinessObject instanceof IVariableObject))
      {
        if ((this.b == null) || (this.b.length() == 0) || (localIBusinessObject.getJavaType().c(this.b)))
          return true;
      }
      else if ((localIBusinessObject instanceof IFunctionObject))
      {
        if (((this.b != null) && (this.b.length() != 0)) || ((!localIBusinessObject.getJavaType().l()) || (localIBusinessObject.getJavaType().c(this.b))))
          return true;
      }
      else if (((localIBusinessObject instanceof SheetMap)) && (this.b != null) && (this.b.length() > 0) && (!localIBusinessObject.getJavaType().l()) && (localIBusinessObject.getJavaType().c(this.b)))
        return true;
    }
    return false;
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof BOContainerGroup)) || ((paramObject instanceof TableFunction)) || ((paramObject instanceof SheetMap)) || ((paramObject instanceof ISubFunction)) || ((paramObject instanceof ISubVariable));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.d
 * JD-Core Version:    0.6.0
 */