package com.flagleader.manager.e;

import com.flagleader.repository.tree.IRuleClass;
import java.io.Writer;
import java.util.HashMap;

public class S extends U
{
  public S(IRuleClass paramIRuleClass, Writer paramWriter, HashMap paramHashMap, String paramString)
  {
    super(paramIRuleClass, paramWriter, paramHashMap);
    this.g = new T(this, paramIRuleClass, paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.S
 * JD-Core Version:    0.6.0
 */