package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.j;
import com.flagleader.manager.a.a.g;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class i extends x
{
  public i(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleGroup;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if ((paramITreeNode instanceof IRuleGroup))
    {
      IRuleGroup localIRuleGroup = (IRuleGroup)paramITreeNode;
      j localj = new j(this.a, localIRuleGroup.getProject(), 0);
      if (localj.open() == 0)
      {
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        List localList = localj.b();
        for (int i = 0; i < localList.size(); i++)
        {
          RulePackage localRulePackage1 = localIRuleGroup.exitsPackage(((List)localList.get(i)).get(2).toString());
          if (localRulePackage1 != null)
          {
            if (!this.a.showQuestion(c.b("importPackError.importpackage")))
              continue;
            localRulePackage1.disposeAndUpdate();
          }
          try
          {
            g localg = this.a.getRulesManager().e();
            if (!localg.a(NumberUtil.getInt(StringUtil.stringValue(((List)localList.get(i)).get(0))), StringUtil.stringValue(((List)localList.get(i)).get(8)), StringUtil.stringValue(((List)localList.get(i)).get(2))))
              continue;
            RulePackage localRulePackage2 = localg.d();
            if (((localIRuleGroup instanceof RuleProject)) && (localg.h().length() > 0))
              ((RuleProject)localIRuleGroup).addGroupPackage(localRulePackage2, localg.h());
            else
              localIRuleGroup.addChildElement(localRulePackage2);
            localRulePackage2.setNeedSave(true);
            this.a.getUserLogger().c(c.a("success.loadDB", new String[] { localRulePackage2.toString() + " : " }));
          }
          catch (Exception localException)
          {
            this.a.showError(localException.getMessage());
            return;
          }
        }
        if (localList.size() > 0)
        {
          localIRuleGroup.setModified(true);
          localIRuleGroup.updateTree();
        }
        this.a.getShell().setCursor(null);
      }
    }
  }

  public String a()
  {
    return "LoadRuleServer";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.i
 * JD-Core Version:    0.6.0
 */