package com.flagleader.manager.e;

import com.flagleader.repository.tree.IRuleTree;
import java.io.Writer;
import java.util.HashMap;

public class Q extends U
{
  public Q(IRuleTree paramIRuleTree, Writer paramWriter, HashMap paramHashMap)
  {
    super(paramIRuleTree, paramWriter, paramHashMap);
    this.g = new R(this, paramIRuleTree);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.Q
 * JD-Core Version:    0.6.0
 */