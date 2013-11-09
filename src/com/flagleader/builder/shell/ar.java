package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.lang.TypeMethod;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.m;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class ar extends f
{
  private Text b;
  private Text c;
  private Text d;
  private Combo e;
  private Combo f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;

  public ar(aa paramaa)
  {
    super(Display.getCurrent().getActiveShell());
    this.k = "string";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
  }

  public ar(aa paramaa, TypeMethod paramTypeMethod)
  {
    super(Display.getCurrent().getActiveShell());
    this.g = paramTypeMethod.getDisName();
    this.k = paramTypeMethod.getReturnType();
    this.h = paramTypeMethod.getFuncName();
    this.i = paramTypeMethod.getTypeName();
    this.j = paramTypeMethod.getFuncBody();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.b = a(localComposite, "funcName.MethodInfosEditor", 2048, 300, 12, 2);
    this.b.setText(this.h);
    this.b.selectAll();
    this.e = b(localComposite, "returnType.MethodInfosEditor", 2048, 280, 12, 2);
    this.e.setItems(m.a().g().a());
    if (this.e.getItemCount() < 20)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(20);
    this.e.setText(this.k);
    this.c = a(localComposite, "disName.MethodInfosEditor", 2048, 300, 12, 2);
    this.c.setText(this.g);
    this.c.selectAll();
    this.f = b(localComposite, "typeName.MethodInfosEditor", 2048, 280, 12, 2);
    this.f.setItems(m.a().g().a());
    if (this.f.getItemCount() < 20)
      this.f.setVisibleItemCount(this.f.getItemCount());
    else
      this.f.setVisibleItemCount(20);
    if (this.i != null)
      this.f.setText(this.i);
    this.d = a(localComposite, "funcBody.MethodInfosEditor", 2048, 300, 12, 2);
    this.d.setText(this.j);
    this.d.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.g = this.c.getText();
    this.k = this.e.getText();
    this.h = this.b.getText();
    this.i = this.f.getText();
    this.j = this.d.getText();
    if ((this.g.length() > 0) && (this.k.length() > 0) && (this.h.length() > 0) && (this.j.length() > 0) && (this.i.length() > 0))
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

  public String d()
  {
    return this.j;
  }

  public String e()
  {
    return this.k;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ar
 * JD-Core Version:    0.6.0
 */