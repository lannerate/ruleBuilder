package com.flagleader.builder.a.d;

import com.flagleader.builder.a.aP;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.builder.widget.editor.s;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.ExportModel;
import org.eclipse.swt.widgets.Composite;

public class ax extends aP
  implements IElementViewer
{
  public ax(ExportModel paramExportModel, Composite paramComposite, bu parambu)
  {
    super(paramExportModel, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new ax((ExportModel)this.c, paramComposite, this.a);
  }

  protected ExportModel e()
  {
    return (ExportModel)this.c;
  }

  protected p b(Composite paramComposite)
  {
    if (e().isRspFile())
      this.e = s.a(5, null, paramComposite, 8391426, new ay(this, e().getModelStr()));
    else if (e().isJspFile())
      this.e = s.a(2, new az(this), paramComposite, 8391426, new aA(this, e().getModelStr()));
    else
      this.e = s.a(3, null, paramComposite, 8391426, new aB(this, e().getModelStr()));
    return this.e;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.e.a(e().getModelStr());
    super.update();
  }

  protected void a(String paramString)
  {
    if (!e().getModelStr().equals(paramString))
    {
      e().setModifyTime(System.currentTimeMillis());
      e().setModelStr(paramString);
      e().setModified(true);
    }
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "model";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.ax
 * JD-Core Version:    0.6.0
 */