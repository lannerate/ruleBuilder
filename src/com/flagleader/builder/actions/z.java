package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class z extends h
{
  public z(ActionsManager paramActionsManager, String paramString)
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
        ((Text)localControl).paste();
        return;
      }
      if ((localControl instanceof StyledText))
      {
        ((StyledText)localControl).paste();
        return;
      }
      if ((localControl instanceof Combo))
      {
        ((Combo)localControl).paste();
        return;
      }
    }
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canPaste()))
    {
      localIElementViewer.paste();
    }
    else if ((ActionsManager.a(this.a).getProjectTree().c() != null) && (!ActionsManager.a(this.a).getProjectTree().c().isLocked()))
    {
      IElement localIElement = ActionsManager.a(this.a).paste();
      if (((localIElement instanceof ITreeNode)) && (ActionsManager.a(this.a).getProjectTree().c().acceptNode((ITreeNode)localIElement)))
        ActionsManager.a(this.a).getProjectTree().c().paste(localIElement.deepClone());
    }
  }

  public boolean isEnabled()
  {
    if (ActionsManager.b(this.a))
      return true;
    if (ActionsManager.c(this.a))
      return false;
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canPaste()))
      return true;
    if (ActionsManager.a(this.a).getProjectTree().c() == null)
      return false;
    ITreeNode localITreeNode = ActionsManager.a(this.a).getProjectTree().c();
    if (localITreeNode.isLocked())
      return false;
    return (ActionsManager.a(this.a).getProjectTree().c() != null) && (ActionsManager.a(this.a).paste() != null);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.z
 * JD-Core Version:    0.6.0
 */