package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.db.DBModel;
import java.sql.SQLException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class c extends r
{
  private DBModel a = null;
  private String b;
  private String c;
  private Text d;
  private StyledText e;
  private p f;

  public c(Shell paramShell, DBModel paramDBModel, String paramString)
  {
    super(paramShell);
    this.a = paramDBModel;
    this.c = paramString;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("newSelectTable.AddEnumTableDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(500, 60));
    a(localComposite2).setText(a("disName.AddEnumTableDialog") + ":  ");
    this.d = a(localComposite2, 2048, 380, 12);
    this.d.setText(a("defaultDisName.AddEnumTableDialog"));
    if (this.a != null)
    {
      localComposite2 = new Composite(localComposite1, 0);
      localComposite2.setLayout(a(1));
      localComposite2.setLayoutData(a(500, 200));
      a(localComposite2).setText(a("sqlStr.AddEnumTableDialog") + ":  ");
      this.f = s.a(4, new d(this), localComposite2, 68162);
      this.e = this.f.a();
      GridData localGridData = new GridData();
      localGridData.horizontalAlignment = 2;
      localGridData.verticalAlignment = 3;
      localGridData.grabExcessHorizontalSpace = true;
      localGridData.grabExcessVerticalSpace = true;
      localGridData.horizontalSpan = 10;
      localGridData.verticalSpan = 10;
      localGridData.widthHint = 380;
      localGridData.heightHint = 180;
      this.e.setLayoutData(localGridData);
      this.e.setText(this.c);
    }
    this.d.selectAll();
    this.d.forceFocus();
    return localComposite1;
  }

  protected void okPressed()
  {
    this.b = this.d.getText();
    if (this.a != null)
    {
      this.c = this.e.getText();
      try
      {
        if (!this.a.checkSql(this.c))
          return;
        super.okPressed();
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        MessageDialog.openError(null, "", localClassNotFoundException.getLocalizedMessage());
      }
      catch (SQLException localSQLException)
      {
        MessageDialog.openError(null, "", localSQLException.getLocalizedMessage());
      }
    }
    else
    {
      super.okPressed();
    }
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.c
 * JD-Core Version:    0.6.0
 */