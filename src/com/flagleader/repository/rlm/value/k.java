package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.xml.TreeValueNode;

class k
  implements ChildAcceptor
{
  k(MemberToken paramMemberToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.k
 * JD-Core Version:    0.6.0
 */