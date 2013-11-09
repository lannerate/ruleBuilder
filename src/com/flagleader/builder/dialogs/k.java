package com.flagleader.builder.dialogs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class k extends f
{
  private String a = "";
  private String b = null;
  private Text c;

  public k(String paramString1, String paramString2)
  {
    super(new Shell());
    this.a = paramString1;
    this.b = paramString2;
  }

  public k(Shell paramShell)
  {
    super(paramShell);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 300, 60, 1);
    a(localComposite2, this.a);
    this.c = b(localComposite2, 2048, 300, 12);
    if (this.b != null)
    {
      this.c.setText(this.b);
      this.c.selectAll();
    }
    return localComposite1;
  }

  protected void okPressed()
  {
    this.b = this.c.getText();
    super.okPressed();
  }

  public static String b(String paramString1, String paramString2)
  {
    k localk = new k(paramString1, paramString2);
    if (localk.open() == 0)
      return localk.a();
    return null;
  }

  public String a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.k
 * JD-Core Version:    0.6.0
 */