package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class cz extends f
{
  private Text b;
  private Text c;
  private String d;
  private String e;

  public cz(bX parambX)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = "";
    this.e = "";
  }

  public cz(bX parambX, String paramString1, String paramString2)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = paramString1;
    this.e = paramString2;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.b = a(localComposite, "name.tag", 2048, 200, 20, 2);
    this.b.setText(this.d);
    this.c = a(localComposite, "disname.tag", 2048, 200, 20, 2);
    this.c.setText(this.e);
    return localComposite;
  }

  protected void okPressed()
  {
    this.d = this.b.getText();
    this.e = this.c.getText();
    close();
  }

  public String a()
  {
    return this.d;
  }

  public String b()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cz
 * JD-Core Version:    0.6.0
 */