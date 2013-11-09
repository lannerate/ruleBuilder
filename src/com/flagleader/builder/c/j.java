package com.flagleader.builder.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.c.d.an;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleTreeFlow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class j extends k
{
  an a = null;

  public j(RuleTreeFlow paramRuleTreeFlow, Composite paramComposite, bu parambu)
  {
    super(paramRuleTreeFlow, paramComposite, parambu);
    this.a = new an(this, paramRuleTreeFlow, parambu.i().getRulesManager());
  }

  protected void a(Table paramTable)
  {
    this.a.a();
  }

  private RuleTreeFlow i()
  {
    if ((d() != null) && ((d() instanceof RuleTreeFlow)))
      return (RuleTreeFlow)d();
    return null;
  }

  public String getCompositeUuid()
  {
    return d().getEditUuid() + "props1";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.j
 * JD-Core Version:    0.6.0
 */