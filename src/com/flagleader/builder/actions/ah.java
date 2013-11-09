package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RuleGroup;
import com.flagleader.repository.tree.RulePackage;
import java.util.Iterator;

public class ah extends h
{
  public ah(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    if (ActionsManager.a(this.a).getMenuAndToolBar().f())
    {
      Object localObject;
      Iterator localIterator1;
      if ((ActionsManager.a(this.a).getProjectTree().c() instanceof RulePackage))
      {
        localObject = (RulePackage)ActionsManager.a(this.a).getProjectTree().c();
        ActionsManager.a(this.a).getRulesManager().l().a((IRulePackage)localObject, ((RulePackage)localObject).getCompilePath());
        localIterator1 = ((RulePackage)ActionsManager.a(this.a).getProjectTree().c()).getExportModels();
        while (localIterator1.hasNext())
          ActionsManager.a(this.a).getRulesManager().l().a((IPage)localIterator1.next(), b.a().e());
      }
      else
      {
        RulePackage localRulePackage;
        Iterator localIterator2;
        if ((ActionsManager.a(this.a).getProjectTree().c() instanceof IRuleProject))
        {
          localObject = (IRuleProject)ActionsManager.a(this.a).getProjectTree().c();
          localIterator1 = ((IRuleProject)localObject).getRulePackages();
          while (localIterator1.hasNext())
          {
            localRulePackage = (RulePackage)localIterator1.next();
            ActionsManager.a(this.a).getRulesManager().l().a(localRulePackage, localRulePackage.getCompilePath());
            localIterator2 = localRulePackage.getExportModels();
            while (localIterator2.hasNext())
              ActionsManager.a(this.a).getRulesManager().l().a((IPage)localIterator2.next(), b.a().e());
          }
        }
        else if ((ActionsManager.a(this.a).getProjectTree().c() instanceof RuleGroup))
        {
          localObject = (RuleGroup)ActionsManager.a(this.a).getProjectTree().c();
          localIterator1 = ((RuleGroup)localObject).getRulePackages();
          while (localIterator1.hasNext())
          {
            localRulePackage = (RulePackage)localIterator1.next();
            ActionsManager.a(this.a).getRulesManager().l().a(localRulePackage, localRulePackage.getCompilePath());
            localIterator2 = localRulePackage.getExportModels();
            while (localIterator2.hasNext())
              ActionsManager.a(this.a).getRulesManager().l().a((IPage)localIterator2.next(), b.a().e());
          }
        }
        else if ((ActionsManager.a(this.a).getProjectTree().c() instanceof IPage))
        {
          ActionsManager.a(this.a).getRulesManager().l().a((IPage)ActionsManager.a(this.a).getProjectTree().c(), b.a().e());
        }
      }
    }
  }

  public boolean isEnabled()
  {
    return ActionsManager.a(this.a).getMenuAndToolBar().f();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ah
 * JD-Core Version:    0.6.0
 */