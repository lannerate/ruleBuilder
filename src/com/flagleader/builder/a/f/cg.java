package com.flagleader.builder.a.f;

import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class cg extends aW
  implements IElementViewer
{
  public AbstractRuleSet k()
  {
    return (AbstractRuleSet)j().getRuleTree();
  }

  public cg(IRuleContainer paramIRuleContainer, Composite paramComposite, bu parambu)
  {
    super(paramIRuleContainer, paramComposite, parambu);
  }

  protected void a()
  {
    a(new cj(this));
    a(new ch(this));
    a(new ci(this));
    super.a();
  }

  protected void a(ToolBar paramToolBar)
  {
    super.a(paramToolBar);
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "AllowSheet");
    a(paramToolBar, "RuleSetType");
    a(paramToolBar, "RuleOrder");
  }

  public void update()
  {
    b();
    super.update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cg
 * JD-Core Version:    0.6.0
 */