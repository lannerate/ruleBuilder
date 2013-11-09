package com.flagleader.repository.rlm.action;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.xml.TreeValueNode;

class Q
  implements Acceptor
{
  Q(TreeFunctionToken paramTreeFunctionToken)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof TreeValueNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.Q
 * JD-Core Version:    0.6.0
 */