package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import java.util.List;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

class P
  implements IMenuCreator
{
  P(O paramO)
  {
  }

  public void dispose()
  {
    if ((O.a(this.a).a != null) && (!O.a(this.a).a.isDisposed()))
      O.a(this.a).a.dispose();
    O.a(this.a).a = null;
  }

  public Menu getMenu(Control paramControl)
  {
    return null;
  }

  public Menu getMenu(Menu paramMenu)
  {
    if ((O.a(this.a).a != null) && (!O.a(this.a).a.isDisposed()))
      O.a(this.a).a.dispose();
    O.a(this.a).a = new Menu(paramMenu);
    IRuleRepository localIRuleRepository = ActionsManager.a(O.a(this.a)).getRulesManager().d();
    if (localIRuleRepository != null)
    {
      List localList = localIRuleRepository.getClosedNode();
      if (localList.size() > 0)
        for (int i = 0; i < localList.size(); i++)
        {
          if (!(localList.get(i) instanceof RuleProject))
            continue;
          RuleProject localRuleProject = (RuleProject)localList.get(i);
          MenuItem localMenuItem = new MenuItem(O.a(this.a).a, 8);
          localMenuItem.setText(localRuleProject.getFilePath());
          localMenuItem.addListener(13, new Q(this, localRuleProject));
        }
    }
    O.a(this.a).a.setEnabled(true);
    return O.a(this.a).a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.P
 * JD-Core Version:    0.6.0
 */