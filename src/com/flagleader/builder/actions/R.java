package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;

public class R extends h
{
  public R(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
    setEnabled(ActionsManager.a(paramActionsManager).getMenuAndToolBar().e());
  }

  public void run()
  {
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if ((localIElementViewer != null) && (localIElementViewer.canRedo()))
      localIElementViewer.redo();
  }

  public boolean isEnabled()
  {
    return ActionsManager.a(this.a).getMenuAndToolBar().e();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.R
 * JD-Core Version:    0.6.0
 */