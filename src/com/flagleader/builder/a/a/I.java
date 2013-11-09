package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aP;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SelectTable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class I extends aP
  implements IElementViewer
{
  public I(SelectTable paramSelectTable, Composite paramComposite, bu parambu)
  {
    super(paramSelectTable, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new I((SelectTable)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new L(this));
    super.h();
  }

  protected p b(Composite paramComposite)
  {
    this.e = s.a(4, new J(this), paramComposite, 68162, new K(this, e().getSqlSelect()));
    return this.e;
  }

  protected void a(String paramString)
  {
    if (!e().getSqlSelect().equals(paramString))
      try
      {
        e().changeSqlText(paramString);
        e().setModified(true);
        e().updateTree();
        e().updateViewer();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        MessageDialog.openError(null, "error", localException.getMessage());
      }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.e.a(e().getSqlSelect());
    super.update();
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "sql";
  }

  private SelectTable e()
  {
    return (SelectTable)this.c;
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.I
 * JD-Core Version:    0.6.0
 */