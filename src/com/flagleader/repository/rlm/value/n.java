package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.xml.TreeFunction;
import com.flagleader.repository.xml.TreeValueNode;

class n
  implements ChildAcceptor
{
  n(MemberTreeToken paramMemberTreeToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return this.a.acceptBusinessObject(paramObject);
  }

  public boolean hasChildren(Object paramObject)
  {
    return ((paramObject instanceof TreeValueNode)) || ((paramObject instanceof TreeFunction)) || ((paramObject instanceof IPropertyObject)) || ((paramObject instanceof ISubFunction)) || ((paramObject instanceof ISubVariable));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.n
 * JD-Core Version:    0.6.0
 */