package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.k;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.d;
import com.flagleader.repository.h;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class be extends aS
  implements IElementViewer
{
  private StyledText f;
  k e;

  public be(IPage paramIPage, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new be((IPage)this.c, paramComposite, this.a);
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
    a(new bj(this));
    a(new bi(this));
    super.h();
  }

  protected IPage e()
  {
    return (IPage)this.c;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.e = new k(a(), localComposite, 8456770);
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
        localFileDialog.setFilterPath(a().getConfigManager().d() + "/WEB-INF" + str1);
      else
        localFileDialog.setFilterPath(a().getConfigManager().a + File.separator + a().getConfigManager().d() + "/WEB-INF" + str1);
      String str2 = "";
      if (e().getDisplayName().lastIndexOf("/") > 0)
        str2 = e().getDisplayName().substring(e().getDisplayName().lastIndexOf("/") + 1);
      else
        str2 = e().getDisplayName();
      if (str2.lastIndexOf(".") > 0)
        str2 = str2.substring(0, str2.lastIndexOf("."));
      str2 = "struts-" + str2 + ".xml";
      localFileDialog.setFileName(str2);
    }
    localFileDialog.setFilterExtensions(new String[] { "*.xml" });
    String str1 = localFileDialog.open();
    if (str1 != null)
      try
      {
        FileUtil.writeFile(str1, this.e.m().getText().getBytes());
        a().showSuccess(c.a("HasBeenExport", new String[] { str1 }));
      }
      catch (Exception localException)
      {
        a().getRulesManager().j().b(localException.getMessage());
      }
  }

  private void a(boolean paramBoolean)
  {
    bf localbf = new bf(this, paramBoolean);
    a(localbf, true);
    localbf.start();
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
    this.f.getDisplay().asyncExec(new bg(this, paramString));
  }

  private void a(d paramd, Exception paramException)
  {
    this.f.getDisplay().asyncExec(new bh(this, paramd, paramException));
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "struts";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.be
 * JD-Core Version:    0.6.0
 */