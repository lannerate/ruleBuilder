package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.m;
import com.flagleader.manager.a.a.a;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class d extends x
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if ((paramITreeNode instanceof RulePackage))
      a((RulePackage)paramITreeNode);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RulePackage;
  }

  protected boolean c()
  {
    return false;
  }

  protected boolean d()
  {
    return false;
  }

  public String a()
  {
    return "CheckOutVersion";
  }

  public void a(RulePackage paramRulePackage)
  {
    if ((paramRulePackage.isModified()) && (!this.a.showConfirm(c.b("continue.checkout"))))
      return;
    if ((paramRulePackage.getProject() != null) && (paramRulePackage.getProject().isLocked()))
    {
      this.a.showError(c.b("lockproject.checkout"));
      return;
    }
    this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
    try
    {
      m localm = new m(this.a, paramRulePackage.getExeRulePackageName(), paramRulePackage.getRulesid());
      if (localm.open() == 0)
      {
        boolean bool = false;
        List localList = localm.c();
        if (localList.size() > 0)
          bool = this.a.getRulesManager().u().a(NumberUtil.getInt(StringUtil.stringValue(((List)localList.get(0)).get(3))), ((List)localList.get(0)).get(1).toString(), paramRulePackage, localm.b(), bool);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.showError(c.a("error.checkout", new String[] { localException.getMessage() }));
    }
    this.a.getShell().setCursor(null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.d
 * JD-Core Version:    0.6.0
 */