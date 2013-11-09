package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.xml.TreeAttribute;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class aM extends f
  implements y
{
  private Text b;
  private Text c;
  private Combo d;
  private Combo e;
  private String f;
  private String g;
  private String h;
  private int i = 0;

  public aM(aL paramaL)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = "";
    this.g = "";
    this.h = "string";
  }

  public aM(aL paramaL, String paramString1, String paramString2, String paramString3)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = a(localComposite, "key.TreeValueAttributesEditor", 2048, 300, 12, 2);
    this.c.setText(this.f);
    this.c.selectAll();
    this.d = b(localComposite, "type.TreeValueAttributesEditor", 2048, 280, 12, 2);
    this.d.setItems(TreeAttribute.DATETYPES);
    if (this.d.getItemCount() < 30)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(30);
    if (this.h != null)
      this.d.setText(this.h);
    this.e = b(localComposite, "locate.TreeValueAttributesEditor", 2048, 280, 12, 2);
    this.e.setItems(aL.q);
    if (this.e.getItemCount() < 30)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(30);
    if (this.i >= 0)
      this.e.select(this.i);
    this.b = a(localComposite, "describe.TreeValueAttributesEditor", 2048, 300, 12, 2);
    this.b.setText(this.g);
    this.b.selectAll();
    return localComposite;
  }

  protected void okPressed()
  {
    this.f = this.c.getText();
    this.g = this.b.getText();
    this.h = this.d.getText();
    this.i = this.e.getSelectionIndex();
    if ((this.f.length() > 0) || (this.g.length() > 0))
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

  public String c()
  {
    return this.h;
  }

  public int d()
  {
    return this.i;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aM
 * JD-Core Version:    0.6.0
 */