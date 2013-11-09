package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.db.DBModel;
import com.flagleader.util.TempID;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class f extends r
{
  private DBModel a = null;
  private String b;
  private String c;
  private String d;
  private Text e;
  private Text f;
  private StyledText g;
  private p h;

  public f(Shell paramShell, DBModel paramDBModel, String paramString)
  {
    super(paramShell);
    this.a = paramDBModel;
    this.d = paramString;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("newSelectTable.SelectTableDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(500, 60));
    a(localComposite2).setText(a("disName.SelectTableDialog") + ":  ");
    this.e = a(localComposite2, 2048, 380, 12);
    this.e.setText(a("defaultDisName.SelectTableDialog"));
    a(localComposite2).setText(a("varName.SelectTableDialog") + ":  ");
    this.f = a(localComposite2, 2048, 380, 12);
    this.f.setText(this.a.getVarTableName("select" + TempID.newShortTempID()));
    localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 200));
    a(localComposite2).setText(a("sqlStr.SelectTableDialog") + ":  ");
    this.h = s.a(4, new g(this), localComposite2, 68162);
    this.g = this.h.a();
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 2;
    localGridData.verticalAlignment = 3;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalSpan = 10;
    localGridData.verticalSpan = 10;
    localGridData.widthHint = 380;
    localGridData.heightHint = 180;
    this.g.setLayoutData(localGridData);
    this.g.setText(this.d);
    this.e.selectAll();
    this.e.forceFocus();
    return localComposite1;
  }

  protected void okPressed()
  {
    this.b = this.e.getText();
    this.c = this.f.getText();
    this.d = this.g.getText();
    try
    {
      if (this.a.checkSql(this.d))
        super.okPressed();
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "", localException.getLocalizedMessage());
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.f
 * JD-Core Version:    0.6.0
 */