package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleProject;
import java.util.List;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;

class ao
  implements IMenuListener
{
  ao(al paramal, IMenuManager paramIMenuManager)
  {
  }

  public void menuAboutToShow(IMenuManager paramIMenuManager)
  {
    this.b.removeAll();
    IRuleRepository localIRuleRepository = al.b(this.a).getRulesManager().d();
    if (localIRuleRepository != null)
    {
      List localList = localIRuleRepository.getClosedNode();
      if (localList.size() > 0)
        for (int i = 0; i < localList.size(); i++)
        {
          if (!(localList.get(i) instanceof RuleProject))
            continue;
          ActionsManager tmp81_78 = al.b(this.a).getActionsManager();
          tmp81_78.getClass();
          this.b.add(new N(tmp81_78, (RuleProject)localList.get(i)));
        }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ao
 * JD-Core Version:    0.6.0
 */