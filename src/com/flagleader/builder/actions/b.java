package com.flagleader.builder.actions;

import com.flagleader.builder.dialogs.AboutLicenseDialog;

public class b extends h
{
  public b(ActionsManager paramActionsManager, String paramString)
  {
    super(paramActionsManager, paramString);
  }

  public void run()
  {
    AboutLicenseDialog localAboutLicenseDialog = new AboutLicenseDialog(null);
    localAboutLicenseDialog.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b
 * JD-Core Version:    0.6.0
 */