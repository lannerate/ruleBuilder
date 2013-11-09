package com.flagleader.manager.c.d;

import com.flagleader.manager.c.e;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleTree;

public abstract class ao extends e
{
  public static String[] h = com.flagleader.manager.d.c.d("sheetothers.RuleSetPropertiesEditor");
  public static String[] i;
  public static String[] j;
  public static String[] k;
  public static String[] l;
  public static String[] m;
  public static String[] n;
  public static String[] o;

  static
  {
    for (int i1 = 0; i1 < h.length; i1++)
      h[i1] = com.flagleader.manager.d.c.b(h[i1] + ".RuleSetPropertiesEditor");
    i = com.flagleader.manager.d.c.d("datasnaps.RuleSetPropertiesEditor");
    for (i1 = 0; i1 < i.length; i1++)
      i[i1] = com.flagleader.manager.d.c.b(i[i1] + ".RuleSetPropertiesEditor");
    j = com.flagleader.manager.d.c.d("logtypes.RuleSetPropertiesEditor");
    for (i1 = 0; i1 < j.length; i1++)
      j[i1] = com.flagleader.manager.d.c.b(j[i1] + ".RuleSetPropertiesEditor");
    k = com.flagleader.manager.d.c.d("logtypes.RulePropertiesEditor");
    for (i1 = 0; i1 < k.length; i1++)
      k[i1] = com.flagleader.manager.d.c.b(k[i1] + ".RulePropertiesEditor");
    l = com.flagleader.manager.d.c.d("restartTypes.RuleTreeProperties");
    for (i1 = 0; i1 < l.length; i1++)
      l[i1] = com.flagleader.manager.d.c.b(l[i1] + ".RuleTreeProperties");
    m = com.flagleader.manager.d.c.d("matchTypes.RuleTreeProperties");
    for (i1 = 0; i1 < m.length; i1++)
      m[i1] = com.flagleader.manager.d.c.b(m[i1] + ".RuleTreeProperties");
    n = com.flagleader.manager.d.c.d("checkSubRuleTypes.RuleTreeProperties");
    for (i1 = 0; i1 < n.length; i1++)
      n[i1] = com.flagleader.manager.d.c.b(n[i1] + ".RuleTreeProperties");
    o = com.flagleader.manager.d.c.d("vmlFlowTypes.RuleTreeProperties");
    for (i1 = 0; i1 < o.length; i1++)
      o[i1] = com.flagleader.manager.d.c.b(o[i1] + ".RuleTreeProperties");
  }

  public ao(com.flagleader.manager.c.c paramc, IRuleTree paramIRuleTree, r paramr)
  {
    super(paramc, paramIRuleTree, paramr);
  }

  public IRuleTree h()
  {
    if ((d() != null) && ((d() instanceof IRuleTree)))
      return (IRuleTree)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.ao
 * JD-Core Version:    0.6.0
 */