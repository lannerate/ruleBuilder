package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.a.a.a;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class x extends bl
{
  public x(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean e()
  {
    return !StringUtil.isEmpty(this.a.getUserServer());
  }

  public void a(RulePackage paramRulePackage, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramRulePackage.getProject() != null) && (paramRulePackage.getProject().isLocked()))
    {
      this.a.showError(c.b("lockproject.checkin"));
      return;
    }
    if (paramRulePackage.isLocked())
    {
      this.a.showError(c.b("locked.checkin"));
      return;
    }
    this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
    this.a.getRulesManager().u().a(paramRulePackage, paramBoolean, paramInt, paramString, false);
    this.a.getShell().setCursor(null);
  }

  public void a(List paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
    boolean bool = false;
    for (int i = 0; i < paramList.size(); i++)
    {
      if (!(paramList.get(i) instanceof RulePackage))
        continue;
      RulePackage localRulePackage = (RulePackage)paramList.get(i);
      if ((localRulePackage.getProject() != null) && (localRulePackage.getProject().isLocked()))
        this.a.showError(c.b("lockproject.checkin"));
      else if (localRulePackage.isLocked())
        this.a.showError(c.b("locked.checkin"));
      else
        bool = this.a.getRulesManager().u().a(localRulePackage, paramBoolean, paramInt, paramString, bool);
    }
    this.a.getShell().setCursor(null);
  }

  public void b(RulePackage paramRulePackage)
  {
    if ((paramRulePackage.getProject() != null) && (paramRulePackage.getProject().isLocked()))
    {
      this.a.showError(c.b("lockproject.checkin"));
      return;
    }
    if (paramRulePackage.isLocked())
    {
      this.a.showError(c.b("locked.checkin"));
      return;
    }
    this.a.getRulesManager().u().b(paramRulePackage);
  }

  public void a(RulePackage paramRulePackage, boolean paramBoolean)
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
      this.a.getRulesManager().u().a(0, null, paramRulePackage, paramBoolean, false);
    }
    catch (Throwable localThrowable)
    {
      this.a.showError(c.a("error.checkout", new String[] { localThrowable.getMessage() }));
    }
    this.a.getShell().setCursor(null);
  }

  public void a(List paramList, boolean paramBoolean)
  {
    this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
    boolean bool = false;
    for (int i = 0; i < paramList.size(); i++)
    {
      RulePackage localRulePackage = (RulePackage)paramList.get(i);
      if ((localRulePackage.isModified()) && (!this.a.showConfirm(c.b("continue.checkout"))))
        continue;
      if ((localRulePackage.getProject() != null) && (localRulePackage.getProject().isLocked()))
        this.a.showError(c.b("lockproject.checkout"));
      else
        try
        {
          bool = this.a.getRulesManager().u().a(0, null, localRulePackage, paramBoolean, bool);
        }
        catch (Throwable localThrowable)
        {
          this.a.showError(c.a("error.checkout", new String[] { localThrowable.getMessage() }));
        }
    }
    this.a.getShell().setCursor(null);
  }

  protected void a(RulePackage paramRulePackage, int paramInt, String paramString, boolean paramBoolean)
  {
    this.a.getRulesManager().u().a(paramInt, paramString, paramRulePackage, paramBoolean, false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.x
 * JD-Core Version:    0.6.0
 */