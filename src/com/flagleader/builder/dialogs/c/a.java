package com.flagleader.builder.dialogs.c;

import com.flagleader.builder.dialogs.r;
import com.flagleader.repository.excel.ExcelBookModel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class a extends r
{
  protected ExcelBookModel a = null;
  protected String b = "";
  protected String c;
  protected String d;
  protected Text e;
  protected Text f;
  protected Text g;

  public a(Shell paramShell, ExcelBookModel paramExcelBookModel)
  {
    super(paramShell);
    this.a = paramExcelBookModel;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.AddExcelSheetDialog"));
    Composite localComposite = (Composite)super.createDialogArea(paramComposite);
    c(localComposite);
    return localComposite;
  }

  protected void c(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(a(2));
    localComposite.setLayoutData(a(500, 65));
    a(localComposite).setText(a("disName.AddExcelSheetDialog") + ":  ");
    this.g = a(localComposite, 2048, 380, 12);
    this.g.setText(a("defaultDisName.AddExcelSheetDialog"));
    a(localComposite).setText(a("sheetReg.AddExcelSheetDialog") + ":  ");
    this.f = a(localComposite, 2048, 380, 12);
    this.f.setText("");
    this.g.selectAll();
    this.g.forceFocus();
  }

  protected void okPressed()
  {
    this.d = this.g.getText();
    this.c = this.f.getText();
    super.okPressed();
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.c.a
 * JD-Core Version:    0.6.0
 */