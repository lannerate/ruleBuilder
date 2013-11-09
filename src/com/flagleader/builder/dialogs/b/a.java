package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.lang.h;
import java.sql.SQLException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class a extends r
{
  private DBModel a = null;
  private String b;
  private String c;
  private String d;
  private Text e;
  private StyledText f;
  private Combo g;
  private p h;

  public a(Shell paramShell, DBModel paramDBModel)
  {
    super(paramShell);
    this.a = paramDBModel;
    this.b = "";
    this.c = "";
  }

  public a(Shell paramShell, DBModel paramDBModel, String paramString1, String paramString2)
  {
    super(paramShell);
    this.a = paramDBModel;
    this.c = paramString1;
    this.b = paramString2;
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
    this.e.setText(this.b);
    a(localComposite2).setText(a("type.SelectTableDialog") + ":  ");
    this.g = b(localComposite2, 2056, 280, 12);
    this.g.setItems(this.a.getTypeManager().b());
    if (this.g.getItemCount() < 20)
      this.g.setVisibleItemCount(this.g.getItemCount());
    else
      this.g.setVisibleItemCount(20);
    this.g.setText("void");
    localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(500, 200));
    a(localComposite2).setText(" " + a("sqlStr.SelectTableDialog") + ":  ");
    this.h = s.a(4, new b(this), localComposite2, 68162);
    this.f = this.h.a();
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 2;
    localGridData.verticalAlignment = 3;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalSpan = 10;
    localGridData.verticalSpan = 10;
    localGridData.widthHint = 400;
    localGridData.heightHint = 180;
    this.f.setLayoutData(localGridData);
    this.f.setText(this.c);
    this.e.selectAll();
    this.e.forceFocus();
    return localComposite1;
  }

  protected void okPressed()
  {
    this.b = this.e.getText();
    this.c = this.f.getText();
    this.d = this.g.getText();
    if (this.b.length() == 0)
      return;
    try
    {
      this.a.checkCustomSql(this.c);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      MessageDialog.openError(null, "", localClassNotFoundException.getLocalizedMessage());
      return;
    }
    catch (SQLException localSQLException)
    {
      MessageDialog.openError(null, "你的语句可能有错误", localSQLException.getLocalizedMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
    super.okPressed();
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.a
 * JD-Core Version:    0.6.0
 */