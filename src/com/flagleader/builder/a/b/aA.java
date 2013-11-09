package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.soap.SoapParameter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class aA extends f
  implements y
{
  private Text b;
  private Text c;
  private Combo d;
  private Combo e;
  private int f = 1;
  private String g;
  private String h;
  private String i;

  public aA(az paramaz)
  {
    super(Display.getCurrent().getActiveShell());
    this.g = "";
    this.h = "";
    this.i = "string";
  }

  public aA(az paramaz, String paramString1, String paramString2, String paramString3)
  {
    super(Display.getCurrent().getActiveShell());
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramString3;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = a(localComposite, "key.SoapParametersEditor", 2048, 300, 12, 2);
    this.c.setText(this.g);
    this.c.selectAll();
    this.d = b(localComposite, "type.SoapParametersEditor", 2048, 280, 12, 2);
    this.d.setItems(SoapParameter.DATETYPES);
    if (this.d.getItemCount() < 30)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(30);
    if (this.i != null)
      this.d.setText(this.i);
    this.e = b(localComposite, "retType.SoapParametersEditor", 2048, 280, 12, 2);
    this.e.setItems(az.q);
    if (this.e.getItemCount() < 30)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(30);
    if (this.f != 0)
      this.e.select(this.f - 1);
    this.b = a(localComposite, "disName.SoapParametersEditor", 2048, 300, 12, 2);
    this.b.setText(this.h);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.g = this.c.getText();
    this.h = this.b.getText();
    this.i = this.d.getText();
    this.f = (this.e.getSelectionIndex() + 1);
    if (this.g.length() > 0)
      close();
  }

  public String a()
  {
    return this.g;
  }

  public String b()
  {
    if ((this.h == null) || (this.h.length() == 0))
      return this.g;
    return this.h;
  }

  public String c()
  {
    return this.i;
  }

  public int d()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aA
 * JD-Core Version:    0.6.0
 */