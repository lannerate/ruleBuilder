package com.flagleader.builder.dialogs;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class e extends g
{
  private String a = "";
  private static final int b = 2;

  public e(Shell paramShell)
  {
    super(paramShell);
  }

  public e(Shell paramShell, String paramString)
  {
    super(paramShell);
    this.a = paramString;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return this.a;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    localComposite.setLayout(new GridLayout());
    a(localComposite);
    a(localComposite, a(), 350, 35);
    return localComposite;
  }

  protected void createButtonsForButtonBar(Composite paramComposite)
  {
    createButton(paramComposite, 0, b("YES"), true);
    createButton(paramComposite, 2, b("NOT"), false);
    createButton(paramComposite, 1, b("Cancel"), false);
  }

  protected void b()
  {
  }

  protected void buttonPressed(int paramInt)
  {
    if (paramInt == 0)
      okPressed();
    else if (1 == paramInt)
      cancelPressed();
    else if (paramInt == 2)
      b();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e
 * JD-Core Version:    0.6.0
 */