package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class D extends f
  implements y
{
  private Text b;
  private Text c;
  private Combo d;
  private String e;
  private String f;
  private String g;

  public D(e parame)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = "";
    this.f = "";
    this.g = "string";
  }

  public D(e parame, String paramString1, String paramString2, String paramString3)
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
    this.c = a(localComposite, "trueName.BusinessObjectEditor", 2048, 300, 12, 2);
    this.c.setText(this.e);
    this.c.selectAll();
    this.d = b(localComposite, "type.BusinessObjectEditor", 2048, 280, 12, 2);
    this.d.setItems(this.a.E());
    if (this.d.getItemCount() < 30)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(30);
    if (this.g != null)
      this.d.setText(this.g);
    this.b = a(localComposite, "disName.BusinessObjectEditor", 2048, 300, 12, 2);
    this.b.setText(this.f);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.e = this.c.getText();
    this.f = this.b.getText();
    this.g = this.d.getText();
    if ((this.f != null) && (this.f.length() > 0))
      close();
  }

  public String a()
  {
    return this.e;
  }

  public String b()
  {
    if ((this.f == null) || (this.f.length() == 0))
      return this.e;
    return this.f;
  }

  public String c()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.D
 * JD-Core Version:    0.6.0
 */