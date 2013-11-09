package com.flagleader.builder;

import org.eclipse.jface.dialogs.MessageDialog;

class b
  implements Runnable
{
  b(BuilderManager paramBuilderManager, String paramString)
  {
  }

  public void run()
  {
    MessageDialog.openInformation(this.a.getShell(), ResourceTools.getMessage("success.dialog"), this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b
 * JD-Core Version:    0.6.0
 */