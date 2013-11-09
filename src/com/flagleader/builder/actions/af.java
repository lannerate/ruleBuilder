package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;

public class af extends h
{
  public af(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canUndo()))
    {
      localIElementViewer.undo();
      return;
    }
  }

  public boolean isEnabled()
  {
    return ActionsManager.a(this.a).getMenuAndToolBar().d();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.af
 * JD-Core Version:    0.6.0
 */