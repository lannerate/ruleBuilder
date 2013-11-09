package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class Z extends f
{
  private Text b;
  private Text c;
  private String d;
  private String e;

  public Z(M paramM)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = "";
    this.e = "";
  }

  public Z(M paramM, String paramString1, String paramString2, String paramString3)
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
    this.c = a(localComposite, "key.ExportDialog", 2048, 300, 12, 2);
    this.c.setText(this.d);
    this.c.selectAll();
    this.b = a(localComposite, "value.ExportDialog", 2048, 300, 12, 2);
    this.b.setText(this.e);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.d = this.c.getText();
    this.e = this.b.getText();
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
 * Qualified Name:     com.flagleader.builder.shell.Z
 * JD-Core Version:    0.6.0
 */