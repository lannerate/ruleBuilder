package com.flagleader.repository.rlm.value;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.xml.TreeValueNode;

class l
  implements Acceptor
{
  l(MemberTreeToken paramMemberTreeToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.l
 * JD-Core Version:    0.6.0
 */