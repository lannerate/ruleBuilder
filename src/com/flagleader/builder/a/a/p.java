package com.flagleader.builder.a.a;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class p extends f
{
  private Text b;
  private Text c;
  private Combo d;
  private Combo e;
  private Combo f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;

  public p(o paramo)
  {
    super(Display.getCurrent().getActiveShell());
    this.g = "";
    this.h = "";
    this.i = "";
  }

  public p(o paramo, String paramString1, String paramString2, String paramString3)
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
    this.c = a(localComposite, "pos.ProcedureParameterView", 2048, 300, 12, 2);
    this.c.setText(this.g);
    this.c.selectAll();
    this.e = b(localComposite, "modeType.ProcedureParameterView", 2048, 280, 12, 2);
    this.e.setItems(o.r);
    if (this.j != null)
      this.e.setText(this.j);
    this.d = b(localComposite, "sqlType.ProcedureParameterView", 2048, 280, 12, 2);
    this.d.setItems(o.t);
    if (this.i != null)
      this.d.setText(this.i);
    this.d.addSelectionListener(new q(this));
    this.f = b(localComposite, "valueType.ProcedureParameterView", 2048, 280, 12, 2);
    this.b = a(localComposite, "displayName.ProcedureParameterView", 2048, 300, 12, 2);
    this.b.setText(this.h);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.g = this.c.getText();
    if (this.g.length() == 0)
    {
      this.c.forceFocus();
      return;
    }
    this.h = this.b.getText();
    if (this.h.length() == 0)
    {
      this.b.forceFocus();
      return;
    }
    this.i = this.d.getText();
    if (this.i.length() == 0)
    {
      this.d.forceFocus();
      return;
    }
    this.j = this.e.getText();
    if (this.j.length() == 0)
    {
      this.e.forceFocus();
      return;
    }
    this.k = this.f.getText();
    if (this.k.length() == 0)
    {
      this.f.forceFocus();
      return;
    }
    close();
  }

  public String a()
  {
    return this.g;
  }

  public String b()
  {
    return this.h;
  }

  public String c()
  {
    return this.i;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.p
 * JD-Core Version:    0.6.0
 */