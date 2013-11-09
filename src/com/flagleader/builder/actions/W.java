package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class W extends h
{
  public W(ActionsManager paramActionsManager, String paramString)
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
        ((Text)localControl).selectAll();
        return;
      }
      if ((localControl instanceof StyledText))
      {
        ((StyledText)localControl).selectAll();
        return;
      }
    }
    if (ActionsManager.a(this.a).getRuleEditor().e() != null)
      ActionsManager.a(this.a).getRuleEditor().e().selectAll();
  }

  public boolean isEnabled()
  {
    Control localControl = Display.getCurrent().getFocusControl();
    if ((localControl != null) && (!localControl.isDisposed()))
    {
      if ((localControl instanceof Text))
        return true;
      if ((localControl instanceof StyledText))
        return true;
    }
    return ActionsManager.a(this.a).getRuleEditor().e() != null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.W
 * JD-Core Version:    0.6.0
 */