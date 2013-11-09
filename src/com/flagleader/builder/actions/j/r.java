package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.C;
import com.flagleader.manager.a.a.a;
import com.flagleader.manager.a.a.g;
import com.flagleader.manager.d.c;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class r extends x
{
  public r(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof IRuleProject)) || ((paramITreeNode instanceof IRuleGroup));
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return;
    if (!e())
      return;
    if ((paramITreeNode instanceof RulePackage))
      a((RulePackage)paramITreeNode);
    else if ((paramITreeNode instanceof IRuleProject))
      a((IRuleProject)paramITreeNode);
    else if ((paramITreeNode instanceof IRuleGroup))
      a((IRuleGroup)paramITreeNode);
  }

  protected boolean c()
  {
    return false;
  }

  public String a()
  {
    return "Synchronize";
  }

  public void a(RulePackage paramRulePackage)
  {
    this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
    try
    {
      this.a.getRulesManager().u().a(paramRulePackage);
    }
    catch (Exception localException)
    {
      this.a.showError(c.a("error.checkout", new String[] { localException.getMessage() }));
    }
    this.a.getShell().setCursor(null);
  }

  public void a(IRuleGroup paramIRuleGroup)
  {
    if (paramIRuleGroup.isLocked())
      return;
    C localC = new C(this.a, paramIRuleGroup, 0);
    if (localC.open() == 0)
    {
      String str = "";
      if (((RulePackage)paramIRuleGroup).getProject() != null)
        str = ((RulePackage)paramIRuleGroup).getProject().getDisplayName();
      List localList1 = localC.b();
      a(localC.b(), false, 0, str);
      List localList2 = localC.a();
      for (int i = 0; i < localList2.size(); i++)
        if ((localList2.get(i) instanceof RulePackage))
        {
          a((RulePackage)localList2.get(i), false);
        }
        else
        {
          if (!(localList2.get(i) instanceof List))
            continue;
          try
          {
            g localg = this.a.getRulesManager().e();
            if (!localg.a(NumberUtil.getInt(StringUtil.stringValue(((List)localList2.get(i)).get(0))), ((List)localList2.get(i)).get(8).toString(), ((List)localList2.get(i)).get(2).toString()))
              continue;
            RulePackage localRulePackage = localg.d();
            if (localRulePackage == null)
              return;
            if (((paramIRuleGroup instanceof RuleProject)) && (localg.h().length() > 0))
              ((RuleProject)paramIRuleGroup).addGroupPackage(localRulePackage, localg.h());
            else
              paramIRuleGroup.addChildElement(localRulePackage);
            paramIRuleGroup.setModified(true);
            paramIRuleGroup.updateTree();
            long l = localRulePackage.getModifyTime();
            localRulePackage.setModified(true);
            localRulePackage.setModifyTime(l);
          }
          catch (Exception localException)
          {
            this.a.showError(localException.getMessage());
            return;
          }
        }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.r
 * JD-Core Version:    0.6.0
 */