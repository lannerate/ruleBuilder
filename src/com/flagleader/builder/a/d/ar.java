package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.N;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.d;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.util.JspUtil;
import java.io.File;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class ar extends aS
  implements IElementViewer
{
  private StyledText f;
  N e;

  public ar(IPage paramIPage, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new ar((ExportModel)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    a(paramToolBar, "export");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new aw(this));
    a(new av(this));
    super.h();
  }

  protected IPage e()
  {
    return (IPage)this.c;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.e = new N(a(), localComposite, 8456770);
    this.f = this.e.m();
    return localComposite;
  }

  private void f()
  {
    FileDialog localFileDialog = new FileDialog(a().getShell(), 8192);
    if (a().getConfigManager().d().length() > 0)
    {
      str1 = "";
      if (e().getDisplayName().lastIndexOf("/") > 0)
        str1 = File.separator + e().getDisplayName().substring(0, e().getDisplayName().lastIndexOf("/"));
      if (new File(a().getConfigManager().d()).exists())
        localFileDialog.setFilterPath(a().getConfigManager().d() + str1);
      else
        localFileDialog.setFilterPath(a().getConfigManager().a + File.separator + a().getConfigManager().d() + str1);
      if (e().getDisplayName().lastIndexOf("/") > 0)
        localFileDialog.setFileName(e().getDisplayName().substring(e().getDisplayName().lastIndexOf("/") + 1));
      else
        localFileDialog.setFileName("struts-" + e().getDisplayName());
    }
    localFileDialog.setFilterExtensions(new String[] { "*.jsp" });
    String str1 = localFileDialog.open();
    if (str1 != null)
      try
      {
        String str2 = this.e.m().getText();
        JspUtil.saveHtmlFile(str1, str2);
        a().showSuccess(c.a("HasBeenExport", new String[] { str1 }));
      }
      catch (Exception localException)
      {
        a().getRulesManager().j().b(localException.getMessage());
      }
  }

  private void a(boolean paramBoolean)
  {
    as localas = new as(this, paramBoolean);
    a(localas, true);
    localas.start();
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.e.a(e().getAllVars());
    a(false);
    super.update();
  }

  protected void a(String paramString)
  {
    this.f.getDisplay().asyncExec(new at(this, paramString));
  }

  private void a(d paramd, Exception paramException)
  {
    this.f.getDisplay().asyncExec(new au(this, paramd, paramException));
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "jstl";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.ar
 * JD-Core Version:    0.6.0
 */