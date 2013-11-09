package com.flagleader.builder.a.a;

import com.flagleader.builder.a.b.y;
import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class aj extends f
  implements y
{
  private Text b;
  private Text c;
  private Text d;
  private Combo e;
  private String f;
  private String g;
  private String h;
  private String i;

  public aj(ai paramai)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = "";
    this.g = "";
    this.i = "";
    this.h = "string";
  }

  public aj(ai paramai, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramString4;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = a(localComposite, "key.SheetMapFieldView", 2048, 300, 12, 2);
    this.c.setText(this.f);
    this.c.selectAll();
    this.d = a(localComposite, "value.SheetMapFieldView", 2048, 300, 12, 2);
    this.d.setText(this.i);
    this.e = b(localComposite, "type.BusinessObjectEditor", 2048, 280, 12, 2);
    this.e.setItems(this.a.E());
    if (this.e.getItemCount() < 30)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(30);
    if (this.h != null)
      this.e.setText(this.h);
    this.b = a(localComposite, "disName.BusinessObjectEditor", 2048, 300, 12, 2);
    this.b.setText(this.g);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.f = this.c.getText();
    this.g = this.b.getText();
    this.h = this.e.getText();
    this.i = this.d.getText();
    if (this.g != null)
      close();
  }

  public String a()
  {
    return this.f;
  }

  public String b()
  {
    if ((this.g == null) || (this.g.length() == 0))
      return this.f;
    return this.g;
  }

  public String d()
  {
    return this.i;
  }

  public String c()
  {
    return this.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.aj
 * JD-Core Version:    0.6.0
 */