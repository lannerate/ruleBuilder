package com.flagleader.builder.dialogs.c;

import com.flagleader.repository.excel.ExcelBookModel;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class b extends a
{
  protected int h;
  protected int i;
  short j;
  protected Text k;
  protected Text l;
  protected Text m;

  public b(Shell paramShell, ExcelBookModel paramExcelBookModel)
  {
    super(paramShell, paramExcelBookModel);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddExcelTableSheetDialog"));
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    d(localComposite);
    return localComposite;
  }

  protected void d(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(2));
    localComposite.setLayoutData(a(500, 100));
    a(localComposite).setText(a("colNameLine.AddExcelTableSheetDialog") + ":  ");
    this.k = a(localComposite, 2048, 380, 12);
    this.k.setText("1");
    a(localComposite).setText(a("startRowLine.AddExcelTableSheetDialog") + ":  ");
    this.l = a(localComposite, 2048, 380, 12);
    this.l.setText("2");
    a(localComposite).setText(a("startCol.AddExcelTableSheetDialog") + ":  ");
    this.m = a(localComposite, 2048, 380, 12);
    this.m.setText("1");
  }

  protected void okPressed()
  {
    try
    {
      this.h = Integer.parseInt(this.k.getText());
      this.i = Integer.parseInt(this.l.getText());
      this.j = Short.parseShort(this.m.getText());
      super.okPressed();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getLocalizedMessage());
    }
  }

  public int d()
  {
    return this.h;
  }

  public int e()
  {
    return this.i;
  }

  public short f()
  {
    return this.j;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.c.b
 * JD-Core Version:    0.6.0
 */