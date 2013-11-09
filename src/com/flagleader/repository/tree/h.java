package com.flagleader.repository.tree;

import com.flagleader.repository.collections.Acceptor;

class h
  implements Acceptor
{
  h(AbstractTreeNode paramAbstractTreeNode)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof ITreeNode;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.h
 * JD-Core Version:    0.6.0
 */