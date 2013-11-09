package com.flagleader.builder.dialogs.d;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class n extends f
{
  private Text b;
  private Text c;
  private Combo d;
  private String e;
  private String f;
  private String g;

  public n(a parama)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = "";
    this.f = "";
    this.g = "";
  }

  public n(a parama, String paramString1, String paramString2, String paramString3)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.d = b(localComposite, "describe.DataDialog", 2048, 280, 12, 2);
    this.d.setItems(a.a(this.a));
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    if (this.g != null)
      this.d.setText(this.g);
    this.d.addSelectionListener(new o(this));
    this.c = a(localComposite, "key.ExportDialog", 2048, 300, 12, 2);
    this.c.setText(this.e);
    this.c.selectAll();
    this.b = a(localComposite, "value.ExportDialog", 2048, 300, 12, 2);
    this.b.setText(this.f);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.e = this.c.getText();
    this.f = this.b.getText();
    this.g = this.d.getText();
    close();
  }

  public String a()
  {
    return this.e;
  }

  public String b()
  {
    return this.f;
  }

  public String c()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.n
 * JD-Core Version:    0.6.0
 */