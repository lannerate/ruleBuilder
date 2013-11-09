package com.flagleader.builder.dialogs;

import com.flagleader.builder.widget.i;
import com.flagleader.db.Sheet;
import com.flagleader.repository.d.I;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class m extends f
{
  private Sheet a = null;
  private i b;
  private Table c = null;
  private int d = 500;
  private int e = 400;
  private int f = 50;
  private int g = -1;
  private int h = 0;
  private List i = new ArrayList();
  private int j = 0;

  public m(Sheet paramSheet, int paramInt)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramSheet;
    this.h = paramInt;
    super.setShellStyle(1168);
  }

  public m(Sheet paramSheet, int paramInt1, int paramInt2)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramSheet;
    this.h = paramInt1;
    this.j = paramInt2;
    super.setShellStyle(1168);
  }

  public m(Shell paramShell, Sheet paramSheet, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramShell);
    this.a = paramSheet;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt1;
    this.e = paramInt4;
    super.setShellStyle(1168);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    int k = 8391426;
    if ((this.j == 1) || (this.h == 4))
      k = 8456770;
    localComposite.setLayoutData(new GridData(1808));
    this.b = new i(true, true);
    this.c = this.b.a(localComposite, k);
    GridData localGridData = new GridData(this.d, this.e);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.c.setLayoutData(localGridData);
    this.c.clearAll();
    for (int m = 0; m < this.a.getDisNames().length; m++)
    {
      TableColumn localTableColumn = new TableColumn(this.c, 8388608);
      localTableColumn.setText(this.a.getDisNames()[m]);
      localTableColumn.setWidth(50);
    }
    try
    {
      this.a.beforeFirst();
      while (this.a.next())
        a(this.a.getCurrentValues());
    }
    catch (Exception localException)
    {
    }
    for (int n = 0; n < this.c.getColumnCount(); n++)
      this.c.getColumns()[n].pack();
    return localComposite;
  }

  private void a(Object[] paramArrayOfObject)
  {
    TableItem localTableItem = new TableItem(this.c, 0);
    for (int k = 0; k < paramArrayOfObject.length; k++)
    {
      String str = a(paramArrayOfObject[k]);
      if (str.length() > 30)
        localTableItem.setText(k, str.substring(0, 30) + "...");
      else
        localTableItem.setText(k, str);
    }
    localTableItem.setData(paramArrayOfObject);
    this.c.update();
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  protected void okPressed()
  {
    super.okPressed();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.m
 * JD-Core Version:    0.6.0
 */