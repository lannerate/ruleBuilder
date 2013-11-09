package com.flagleader.builder.shell;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.VisibilityWindowListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

class aA
  implements VisibilityWindowListener
{
  public void hide(WindowEvent paramWindowEvent)
  {
  }

  public void show(WindowEvent paramWindowEvent)
  {
    Browser localBrowser = (Browser)paramWindowEvent.widget;
    Shell localShell = localBrowser.getShell();
    if (paramWindowEvent.location != null)
      localShell.setLocation(paramWindowEvent.location);
    if (paramWindowEvent.size != null)
    {
      Point localPoint = paramWindowEvent.size;
      localShell.setSize(localShell.computeSize(localPoint.x, localPoint.y));
    }
    localShell.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aA
 * JD-Core Version:    0.6.0
 */