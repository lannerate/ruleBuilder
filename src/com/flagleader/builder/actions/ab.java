package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bs;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.util.Iterator;

public class ab extends h
{
  public ab(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    ITreeNode localITreeNode = ActionsManager.a(this.a).getProjectTree().c();
    if ((localITreeNode instanceof TestCaseLib))
    {
      ActionsManager.a(this.a).getRulesManager().l().a((TestCaseLib)localITreeNode);
    }
    else if ((localITreeNode instanceof TestCase))
    {
      ActionsManager.a(this.a).getRulesManager().l().a((TestCase)localITreeNode);
    }
    else if ((ActionsManager.a(this.a).getRuleEditor().e() instanceof bs))
    {
      ((bs)ActionsManager.a(this.a).getRuleEditor().e()).a_();
    }
    else if (((localITreeNode instanceof RulePackage)) || ((localITreeNode instanceof IRuleGroup)))
    {
      Iterator localIterator = localITreeNode.getAcceptElements(new ac(this));
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TestCase))
        {
          ActionsManager.a(this.a).getRulesManager().l().a((TestCase)localObject);
        }
        else
        {
          if (!(localObject instanceof TestCaseLib))
            continue;
          ActionsManager.a(this.a).getRulesManager().l().a((TestCaseLib)localObject);
        }
      }
    }
  }

  public boolean isEnabled()
  {
    if (ActionsManager.a(this.a).getProjectTree().c() == null)
      return false;
    ITreeNode localITreeNode = ActionsManager.a(this.a).getProjectTree().c();
    if (((localITreeNode instanceof TestCaseLib)) || ((localITreeNode instanceof TestCase)) || ((localITreeNode instanceof RulePackage)) || ((localITreeNode instanceof IRuleGroup)))
      return true;
    return (ActionsManager.a(this.a).getRuleEditor().e() instanceof bs);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ab
 * JD-Core Version:    0.6.0
 */