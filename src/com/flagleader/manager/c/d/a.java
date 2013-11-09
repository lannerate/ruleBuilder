package com.flagleader.manager.c.d;

import com.flagleader.manager.r;
import com.flagleader.repository.tree.AbstractRuleSet;

public abstract class a extends ao
{
  public static String[] e = com.flagleader.manager.d.c.d("exceptions.RulePropertiesEditor");
  public static String[] f;

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".RulePropertiesEditor");
    f = com.flagleader.manager.d.c.d("types.RuleSetPropertiesEditor");
    for (i = 0; i < f.length; i++)
      f[i] = com.flagleader.manager.d.c.b(f[i] + ".RuleSetPropertiesEditor");
  }

  public a(com.flagleader.manager.c.c paramc, AbstractRuleSet paramAbstractRuleSet, r paramr)
  {
    super(paramc, paramAbstractRuleSet, paramr);
  }

  public AbstractRuleSet f()
  {
    if ((d() != null) && ((d() instanceof AbstractRuleSet)))
      return (AbstractRuleSet)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.a
 * JD-Core Version:    0.6.0
 */