package com.flagleader.builder.a.f;

import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.Rule;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class dj extends aW
  implements IElementViewer
{
  public Rule k()
  {
    return (Rule)j().getRuleTree();
  }

  public dj(IRuleContainer paramIRuleContainer, Composite paramComposite, bu parambu)
  {
    super(paramIRuleContainer, paramComposite, parambu);
  }

  protected void a()
  {
    a(new dm(this));
    a(new dl(this));
    a(new dk(this));
    a(new dn(this));
    super.a();
  }

  protected void a(ToolBar paramToolBar)
  {
    super.a(paramToolBar);
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "InitSupport");
    a(paramToolBar, "InitElse");
    a(paramToolBar, "AllowSheet");
    a(paramToolBar, "RuleOrder");
  }

  public void update()
  {
    b();
    super.update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dj
 * JD-Core Version:    0.6.0
 */