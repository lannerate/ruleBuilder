package com.flagleader.builder;

import org.eclipse.jface.dialogs.MessageDialog;

class a
  implements Runnable
{
  a(BuilderManager paramBuilderManager, String paramString)
  {
  }

  public void run()
  {
    if ((this.b != null) && (this.b.length() > 1000))
      MessageDialog.openError(this.a.getShell(), ResourceTools.getMessage("error.dialog"), this.b.substring(0, 1000));
    else
      MessageDialog.openError(this.a.getShell(), ResourceTools.getMessage("error.dialog"), this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a
 * JD-Core Version:    0.6.0
 */