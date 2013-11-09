package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.a;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import java.util.Observable;
import java.util.Observer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class k extends h
  implements Observer
{
  public k(ActionsManager paramActionsManager, String paramString)
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
    if ((localIElementViewer != null) && (localIElementViewer.canCut()))
      localIElementViewer.cut();
    else if (ActionsManager.a(this.a).getProjectTree().c() != null)
      ActionsManager.a(this.a).getRulesManager().c().b(ActionsManager.a(this.a).getProjectTree().c());
  }

  public void update(Observable paramObservable, Object paramObject)
  {
    setEnabled(true);
  }

  public boolean isEnabled()
  {
    if (ActionsManager.b(this.a))
      return true;
    if (ActionsManager.c(this.a))
      return false;
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canCut()))
      return true;
    if (ActionsManager.a(this.a).getProjectTree().c() == null)
      return false;
    if (ActionsManager.a(this.a).getProjectTree().c().isLocked())
      return false;
    return ActionsManager.a(this.a).getProjectTree().c().canCut();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.k
 * JD-Core Version:    0.6.0
 */