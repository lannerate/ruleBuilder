package com.flagleader.builder.dialogs.a;

import com.flagleader.builder.dialogs.r;
import com.flagleader.repository.tree.Envionment;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class b extends r
{
  protected Envionment a = null;
  protected String b = "";
  protected String c;
  protected String d;
  protected String e;
  protected Text f;
  protected Text g;
  protected Text h;
  protected Text i;

  public b(Shell paramShell, Envionment paramEnvionment)
  {
    super(paramShell);
    this.a = paramEnvionment;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddInterfaceDialog"));
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    c(localComposite);
    return localComposite;
  }

  protected void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(2));
    localComposite.setLayoutData(a(500, 105));
    a(localComposite).setText(a("interfaceName.AddInterfaceDialog") + ":  ");
    this.f = a(localComposite, 2048, 380, 12);
    a(localComposite).setText(a("disName.AddInterfaceDialog") + ":  ");
    this.h = a(localComposite, 2048, 380, 12);
    a(localComposite).setText(a("varName.AddInterfaceDialog") + ":  ");
    this.i = a(localComposite, 2048, 380, 12);
    a(localComposite).setText(a("initStatement.AddInterfaceDialog") + ":  ");
    this.g = a(localComposite, 2048, 380, 12);
    this.g.setText("");
    this.f.selectAll();
    this.f.forceFocus();
  }

  protected void okPressed()
  {
    this.d = this.h.getText();
    this.b = this.f.getText();
    this.c = this.g.getText();
    this.e = this.i.getText();
    try
    {
      if ((this.d.length() > 0) && (this.b.length() > 0) && (this.a.getClassInfo("", this.b) != null))
        super.okPressed();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getMessage());
    }
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.d;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.b
 * JD-Core Version:    0.6.0
 */