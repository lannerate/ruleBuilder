package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISheetWhereEditen;
import com.flagleader.repository.rom.IBusinessObject;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

class cd extends f
{
  private Text b;
  private Combo c;
  private Combo d;
  private Combo e;
  private String f;
  private String g;
  private String h;
  private int i;
  private g j;

  public String a()
  {
    return this.h;
  }

  public cd(bS parambS)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = "";
    this.i = 0;
    this.g = "";
    this.h = "and";
  }

  public cd(bS parambS, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(Display.getCurrent().getActiveShell());
    this.f = paramString2;
    this.i = paramInt;
    this.g = paramString1;
    this.h = paramString3;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = b(localComposite, "fieldName.SelectSheetWheresDialog", 2056, 280, 12, 2);
    this.c.setItems(bS.a(this.a));
    if (this.c.getItemCount() < 20)
      this.c.setVisibleItemCount(this.c.getItemCount());
    else
      this.c.setVisibleItemCount(20);
    if (this.i >= 0)
      this.c.select(this.i);
    this.c.addSelectionListener(new ce(this));
    this.d = b(localComposite, "operateName.SelectSheetWheresDialog", 2056, 280, 12, 2);
    if (this.i >= 0)
    {
      this.j = bS.b(this.a)[this.i].getJavaType();
      this.d.setItems(bS.c(this.a).getTypeFunctions(this.j));
    }
    else
    {
      this.d.setItems(bS.d(this.a));
    }
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    if (this.g != null)
      this.d.setText(this.g);
    this.b = a(localComposite, "valueName.SelectSheetWheresDialog", 2048, 300, 12, 2);
    this.b.setText(this.f);
    this.b.selectAll();
    this.e = b(localComposite, "naryType.SelectSheetWheresDialog", 2056, 280, 12, 2);
    this.e.setItems(new String[] { "and", "or" });
    if (this.h != null)
      this.e.setText(this.h);
    return localComposite;
  }

  protected void okPressed()
  {
    this.f = this.b.getText();
    this.i = this.c.getSelectionIndex();
    this.g = this.d.getText();
    this.h = this.e.getText();
    close();
  }

  public String b()
  {
    return this.f;
  }

  public int c()
  {
    return this.i;
  }

  public String d()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.cd
 * JD-Core Version:    0.6.0
 */