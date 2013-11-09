package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.database.ConnectionFactory;
import com.flagleader.manager.d.a;
import java.util.HashMap;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class n extends r
{
  protected Text a;
  protected Text b;
  protected Text c;
  protected Text d;
  protected Text e;
  protected Text f;
  protected Text g;
  protected Combo h;
  protected Combo i;
  private HashMap l = new HashMap();
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  protected int j;
  protected static String[] k = ResourceTools.getStringArray("connType.DatabaseDialog");

  public n(Shell paramShell)
  {
    super(paramShell);
    j();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.DatabaseDialog"));
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    Group localGroup = new Group(localComposite, 0);
    localGroup.setLayoutData(a(500, 250));
    localGroup.setLayout(new GridLayout());
    d(localGroup);
    e(localGroup);
    c(localGroup);
    return localComposite;
  }

  private void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(d(2));
    a(localComposite, a("commitType.DatabaseDialog")).setLayoutData(b(80));
    this.i = new Combo(localComposite, 4);
    this.i.setLayoutData(b(325));
    for (int i1 = 0; i1 < k.length; i1++)
      this.i.add(a(k[i1] + ".DatabaseDialog"));
    this.i.setVisibleItemCount(k.length);
    this.i.addSelectionListener(new o(this));
  }

  private void d(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(d(2));
    a(localComposite, a("disName.DatabaseDialog")).setLayoutData(b(80));
    this.g = b(localComposite, 2048);
    this.g.setLayoutData(b(340));
    a(localComposite, a("datasourceName.DatabaseDialog")).setLayoutData(b(80));
    this.a = b(localComposite, 2048);
    this.a.setLayoutData(b(340));
    a(localComposite, a("Driver.DatabaseDialog"));
    this.h = new Combo(localComposite, 4);
    this.h.setLayoutData(b(325));
    a(this.h);
    b(this.h);
    this.h.setVisibleItemCount(this.h.getItemCount());
    a(localComposite, a("URL.DatabaseDialog")).setLayoutData(b(80));
    this.d = b(localComposite, 2048);
    this.d.setLayoutData(b(340));
    this.h.setText(this.h.getItem(0));
  }

  private void e(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(d(2));
    a(localComposite, a("UserName.DatabaseDialog")).setLayoutData(b(80));
    this.b = b(localComposite, 2048);
    this.b.setLayoutData(b(340));
    a(localComposite, a("Password.DatabaseDialog")).setLayoutData(b(80));
    this.c = b(localComposite, 67584);
    this.c.setLayoutData(b(340));
    this.c.setEchoChar('*');
    a(localComposite, a("catalog.DatabaseDialog", "catalog:")).setLayoutData(b(80));
    this.f = b(localComposite, 2048);
    this.f.setLayoutData(b(340));
    a(localComposite, a("schema.DatabaseDialog", "schema:")).setLayoutData(b(80));
    this.e = b(localComposite, 2048);
    this.e.setLayoutData(b(340));
  }

  private GridLayout d(int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    return localGridLayout;
  }

  private void j()
  {
    String[] arrayOfString = a.b("drivers");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      this.l.put(a.a(arrayOfString[i1] + ".Driver"), a.a(arrayOfString[i1] + ".URL"));
  }

  private void a(Combo paramCombo)
  {
    String[] arrayOfString = a.b("drivers");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      paramCombo.add(a.a(arrayOfString[i1] + ".Driver"));
  }

  private void b(Combo paramCombo)
  {
    paramCombo.addModifyListener(new p(this, paramCombo));
  }

  protected void okPressed()
  {
    this.r = this.h.getText();
    this.o = this.b.getText();
    this.n = this.a.getText();
    this.p = this.c.getText();
    this.q = this.d.getText();
    this.t = this.f.getText();
    this.s = this.e.getText();
    this.m = this.g.getText();
    if (this.n.length() == 0)
    {
      MessageDialog.openError(getShell(), "", a("emptydisName.DatabaseDialog"));
      return;
    }
    String str = ConnectionFactory.connectAvailable(this.r, this.q, this.o, this.p);
    if (str != null)
    {
      MessageDialog.openError(getShell(), "", str);
      return;
    }
    super.okPressed();
  }

  public String a()
  {
    return this.n;
  }

  public String b()
  {
    return this.r;
  }

  public String c()
  {
    return this.p;
  }

  public String d()
  {
    return this.q;
  }

  public String e()
  {
    return this.o;
  }

  public String f()
  {
    return this.t;
  }

  public String g()
  {
    return this.s;
  }

  public int h()
  {
    return this.j;
  }

  public String i()
  {
    return this.m;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.n
 * JD-Core Version:    0.6.0
 */