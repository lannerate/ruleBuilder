package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.repository.IElementViewer;

public class q extends h
{
  public q(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    if (localIElementViewer != null)
      localIElementViewer.findNext();
  }

  public boolean isEnabled()
  {
    IElementViewer localIElementViewer = ActionsManager.a(this.a).getRuleEditor().e();
    return (localIElementViewer != null) && (localIElementViewer.isCanFind());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.q
 * JD-Core Version:    0.6.0
 */