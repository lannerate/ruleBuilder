package com.flagleader.repository.d;

import com.flagleader.repository.collections.Acceptor;
import com.flagleader.repository.tree.TestCaseLib;

class C
  implements Acceptor
{
  C(A paramA)
  {
  }

  public boolean accept(Object paramObject)
  {
    return paramObject instanceof TestCaseLib;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.C
 * JD-Core Version:    0.6.0
 */