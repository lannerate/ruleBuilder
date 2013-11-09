package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.a;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class j extends h
{
  public j(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()))
    {
      if ((localControl instanceof Text))
      {
        ((Text)localControl).copy();
        return;
      }
      if ((localControl instanceof StyledText))
      {
        ((StyledText)localControl).copy();
        return;
      }
      if ((localControl instanceof Combo))
      {
        ((Combo)localControl).copy();
        return;
      }
    }
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canCopy()))
      localIElementViewer.copy();
    else if (ActionsManager.a(this.a).getProjectTree().c() != null)
      ActionsManager.a(this.a).getRulesManager().c().c(ActionsManager.a(this.a).getProjectTree().c());
  }

  public boolean isEnabled()
  {
    if (ActionsManager.b(this.a))
      return true;
    if (ActionsManager.c(this.a))
      return false;
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canCopy()))
      return true;
    return (ActionsManager.a(this.a).getProjectTree().c() != null) && (ActionsManager.a(this.a).getProjectTree().c().canCopy());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j
 * JD-Core Version:    0.6.0
 */