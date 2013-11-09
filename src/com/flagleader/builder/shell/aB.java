package com.flagleader.builder.shell;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.widgets.Shell;

class aB
  implements CloseWindowListener
{
  public void close(WindowEvent paramWindowEvent)
  {
    Browser localBrowser = (Browser)paramWindowEvent.widget;
    Shell localShell = localBrowser.getShell();
    localShell.close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.aB
 * JD-Core Version:    0.6.0
 */