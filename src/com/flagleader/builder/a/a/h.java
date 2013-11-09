package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aP;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import java.sql.SQLException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class h extends aP
  implements IElementViewer
{
  public h(CustomSql paramCustomSql, Composite paramComposite, bu parambu)
  {
    super(paramCustomSql, paramComposite, parambu);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new k(this));
    super.h();
  }

  protected p b(Composite paramComposite)
  {
    this.e = s.a(4, new i(this), paramComposite, 68162, new j(this, e().getSqlCustom()));
    return this.e;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.e.a().setText(e().getSqlCustom());
    super.update();
  }

  protected void a(String paramString)
  {
    if (!e().getSqlCustom().equals(paramString))
    {
      try
      {
        e().getDBModel().checkCustomSql(paramString);
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
      e().changeSqlText(paramString);
      e().setModified(true);
      e().updateTree();
      e().updateViewer();
    }
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid();
  }

  public CustomSql e()
  {
    return (CustomSql)this.c;
  }

  private void a(boolean paramBoolean)
  {
    try
    {
      e().getDBModel().checkSql(this.e.a().getText());
    }
    catch (Exception localException)
    {
      MessageDialog.openError(null, "error", localException.getMessage());
    }
  }

  protected aS e(Composite paramComposite)
  {
    return new h((CustomSql)this.c, paramComposite, this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.h
 * JD-Core Version:    0.6.0
 */