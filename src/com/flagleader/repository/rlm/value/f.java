package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.xml.TreeValueNode;

class f
  implements ChildAcceptor
{
  f(MemberPropertyToken paramMemberPropertyToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return this.a.acceptBusinessObject(paramObject);
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.f
 * JD-Core Version:    0.6.0
 */