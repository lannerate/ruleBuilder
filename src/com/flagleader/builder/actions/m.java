package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class m extends h
{
  public m(ActionsManager paramActionsManager, String paramString)
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
        ((Text)localControl).cut();
        return;
      }
      if ((localControl instanceof StyledText))
      {
        ((StyledText)localControl).cut();
        return;
      }
      if ((localControl instanceof Combo))
      {
        ((Combo)localControl).cut();
        return;
      }
    }
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canDelete()))
      localIElementViewer.delete();
    else if (ActionsManager.a(this.a).getProjectTree().c() != null)
      ActionsManager.a(this.a).getProjectTree().h();
  }

  public boolean isEnabled()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()))
    {
      if ((localControl instanceof Text))
        return false;
      if ((localControl instanceof StyledText))
        return false;
      if ((localControl instanceof Combo))
        return false;
      if ((localControl instanceof CCombo))
        return false;
    }
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canDelete()))
      return true;
    if (ActionsManager.a(this.a).getProjectTree().c() == null)
      return false;
    if (ActionsManager.a(this.a).getProjectTree().c().isLocked())
      return false;
    return (ActionsManager.a(this.a).getProjectTree().c() != null) && (ActionsManager.a(this.a).getProjectTree().c().canDelete());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.m
 * JD-Core Version:    0.6.0
 */