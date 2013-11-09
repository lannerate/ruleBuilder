package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.dialogs.f;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

class bQ extends f
{
  private Combo b;
  private Combo c;
  private Combo d;
  private String e;
  private String f;
  private int g;

  public bQ(bE parambE)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = "";
    this.g = 0;
    this.f = "";
  }

  public bQ(bE parambE, String paramString1, int paramInt, String paramString2)
  {
    super(Display.getCurrent().getActiveShell());
    this.e = paramString2;
    this.g = paramInt;
    this.f = paramString1;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.c = b(localComposite, "funcName.SelectSheetFunctionsDialog", 2056, 280, 12, 2);
    this.c.setItems(bE.a(this.a));
    if (this.c.getItemCount() < 20)
      this.c.setVisibleItemCount(this.c.getItemCount());
    else
      this.c.setVisibleItemCount(20);
    if (this.f != null)
      this.c.setText(this.f);
    this.b = b(localComposite, "fieldName.SelectSheetFunctionsDialog", 2056, 280, 12, 2);
    this.b.setItems(bE.b(this.a));
    if (this.b.getItemCount() < 20)
      this.b.setVisibleItemCount(this.b.getItemCount());
    else
      this.b.setVisibleItemCount(20);
    if (this.g >= 0)
      this.b.select(this.g);
    this.b.addSelectionListener(new bR(this));
    this.d = b(localComposite, "asName.SelectSheetFunctionsDialog", 2056, 280, 12, 2);
    this.d.setItems(bE.c(this.a));
    if (this.d.getItemCount() < 20)
      this.d.setVisibleItemCount(this.d.getItemCount());
    else
      this.d.setVisibleItemCount(20);
    if (this.d != null)
      this.d.setText(this.e);
    return localComposite;
  }

  protected void okPressed()
  {
    this.e = this.d.getText();
    this.g = this.b.getSelectionIndex();
    this.f = this.c.getText();
    close();
  }

  public String a()
  {
    return this.e;
  }

  public int b()
  {
    return this.g;
  }

  public String c()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bQ
 * JD-Core Version:    0.6.0
 */