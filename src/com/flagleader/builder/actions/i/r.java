package com.flagleader.builder.actions.i;

import com.flagleader.repository.collections.ChildAcceptor;
import com.flagleader.repository.tree.ITreeNode;

class r
  implements ChildAcceptor
{
  r(q paramq)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof ITreeNode;
  }

  public boolean hasChildren(Object paramObject)
  {
    return paramObject instanceof ITreeNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.r
 * JD-Core Version:    0.6.0
 */