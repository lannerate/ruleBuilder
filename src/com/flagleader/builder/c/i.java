package com.flagleader.builder.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.c.d.y;
import com.flagleader.manager.d.c;
import com.flagleader.repository.rlm.action.PackCatchActionToken;
import com.flagleader.repository.rlm.condition.RuleLogConditionToken;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class i extends k
{
  y a = null;

  public i(RulePackage paramRulePackage, Composite paramComposite, bu parambu)
  {
    super(paramRulePackage, paramComposite, parambu);
    this.a = new y(this, paramRulePackage, parambu.i().getRulesManager());
  }

  protected void a(Table paramTable)
  {
    this.a.a();
    a(c.b("rulelog.dialog"), i().getLogCondition().getNote(), i().getLogCondition());
    a(c.b("supportException.dialog"), i().getCatchActions().getText(), i().getCatchActions());
  }

  private RulePackage i()
  {
    if ((d() != null) && ((d() instanceof RulePackage)))
      return (RulePackage)d();
    return null;
  }

  public String getCompositeUuid()
  {
    return d().getEditUuid() + "props1";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.i
 * JD-Core Version:    0.6.0
 */