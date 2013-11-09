package com.flagleader.builder.a.f;

import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class bb extends aW
  implements IElementViewer
{
  public AbstractRuleSet k()
  {
    return (AbstractRuleSet)j().getRuleTree();
  }

  public bb(IRuleContainer paramIRuleContainer, Composite paramComposite, bu parambu)
  {
    super(paramIRuleContainer, paramComposite, parambu);
  }

  protected void a()
  {
    a(new bc(this));
    a(new bd(this));
    super.a();
  }

  protected void a(ToolBar paramToolBar)
  {
    super.a(paramToolBar);
    new ToolItem(paramToolBar, 2);
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
 * Qualified Name:     com.flagleader.builder.a.f.bb
 * JD-Core Version:    0.6.0
 */