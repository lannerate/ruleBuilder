package com.flagleader.builder.actions;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;

public class ap
  implements IMenuListener
{
  private IMenuManager b;

  public ap(al paramal, IMenuManager paramIMenuManager)
  {
    this.b = paramIMenuManager;
  }

  public void menuAboutToShow(IMenuManager paramIMenuManager)
  {
    al.a(this.a, this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.ap
 * JD-Core Version:    0.6.0
 */