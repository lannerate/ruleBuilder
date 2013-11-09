package com.flagleader.builder.a.a;

import com.flagleader.builder.a.b.y;
import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.db.EnumTable;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class m extends f
  implements y
{
  private Text b;
  private Text c;
  private String d;
  private String e;

  public m(l paraml)
  {
    super(Display.getCurrent().getActiveShell());
    this.d = "";
    this.e = "";
  }

  public m(l paraml, String paramString1, String paramString2, String paramString3)
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
    this.c = a(localComposite, "trueName.BusinessObjectEditor", 2048, 300, 12, 2);
    this.c.setText(this.d);
    this.c.selectAll();
    this.b = a(localComposite, "disName.BusinessObjectEditor", 2048, 300, 12, 2);
    this.b.setText(this.e);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.d = this.c.getText();
    this.e = this.b.getText();
    if ((this.e != null) && (this.e.length() > 0))
      close();
  }

  public String a()
  {
    return this.d;
  }

  public String b()
  {
    if ((this.e == null) || (this.e.length() == 0))
      return this.d;
    return this.e;
  }

  public String c()
  {
    return l.a(this.a).getEnumType();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.m
 * JD-Core Version:    0.6.0
 */