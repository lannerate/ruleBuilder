package com.flagleader.builder.dialogs.b;

import com.flagleader.builder.dialogs.f;
import com.flagleader.repository.db.DBModel;
import java.sql.SQLException;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class l extends f
{
  private DBModel a = null;
  private Combo b;
  private String c = "";

  public l(DBModel paramDBModel)
  {
    super(Display.getCurrent().getActiveShell());
    this.a = paramDBModel;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    c("title.AddViewDialog");
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = a(localComposite1, 200, 30, 2);
    this.b = b(localComposite2, "table.AddViewDialog", 12, 90, 18, 2);
    try
    {
      getShell().setCursor(getShell().getDisplay().getSystemCursor(1));
      List localList = this.a.getAvalibleViews();
      getShell().setCursor(null);
      String[] arrayOfString = new String[localList.size()];
      for (int i = 0; i < arrayOfString.length; i++)
        arrayOfString[i] = localList.get(i).toString();
      this.b.setItems(arrayOfString);
      if (this.b.getItemCount() < 20)
        this.b.setVisibleItemCount(this.b.getItemCount());
      else
        this.b.setVisibleItemCount(20);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      MessageDialog.openError(getShell(), "error", "class not found");
    }
    catch (SQLException localSQLException)
    {
      MessageDialog.openError(getShell(), "error", localSQLException.getMessage());
    }
    return localComposite1;
  }

  protected void okPressed()
  {
    this.c = this.b.getText();
    super.okPressed();
  }

  public String a()
  {
    return this.c;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.l
 * JD-Core Version:    0.6.0
 */