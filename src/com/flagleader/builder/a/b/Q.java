package com.flagleader.builder.a.b;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.excel.ExcelSheetModel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class Q extends f
{
  private Combo b;
  private Combo c;
  private int d;
  private int e;

  public Q(N paramN)
  {
    super(Display.getCurrent().getActiveShell());
  }

  public int a()
  {
    return this.d;
  }

  public int b()
  {
    return this.e;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setLayout(a(2));
    this.b = b(localComposite, "fieldType.ExcelFieldView", 2048, 280, 12, 2);
    this.b.setItems(ExcelSheetModel.COLORTYPES);
    if (this.b.getItemCount() < 30)
      this.b.setVisibleItemCount(this.b.getItemCount());
    else
      this.b.setVisibleItemCount(30);
    this.b.select(this.d);
    this.c = b(localComposite, "fieldType.ExcelFieldView", 2048, 280, 12, 2);
    this.c.setItems(ExcelSheetModel.COLORTYPES);
    if (this.c.getItemCount() < 30)
      this.c.setVisibleItemCount(this.c.getItemCount());
    else
      this.c.setVisibleItemCount(30);
    this.c.select(this.e);
    return localComposite;
  }

  protected void okPressed()
  {
    if (this.b.getSelectionIndex() >= 0)
      this.d = this.b.getSelectionIndex();
    if (this.c.getSelectionIndex() >= 0)
      this.e = this.c.getSelectionIndex();
    close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.Q
 * JD-Core Version:    0.6.0
 */