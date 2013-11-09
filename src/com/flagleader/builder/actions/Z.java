package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import java.io.File;
import java.io.IOException;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Shell;

public class Z extends h
{
  public Z(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    if (new File("RuleBuilder.chm").exists())
    {
      try
      {
        Runtime.getRuntime().exec("hh.exe RuleBuilder.chm");
      }
      catch (IOException localIOException)
      {
        ActionsManager.a(this.a).getUserLogger().a("not exist RuleBuilder.chm file!", localIOException);
      }
    }
    else
    {
      Browser localBrowser = new Browser(new Shell(), 0);
      localBrowser.setUrl("http://www.flagleader.com/download/RuleBuilder.chm");
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.Z
 * JD-Core Version:    0.6.0
 */