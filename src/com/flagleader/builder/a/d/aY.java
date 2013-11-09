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
import com.flagleader.repository.h;
import com.flagleader.util.JspUtil;
import java.io.File;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class aY extends aS
  implements IElementViewer
{
  private StyledText f;
  N e;

  public aY(IPage paramIPage, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new aY((IPage)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    a(paramToolBar, "export");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new bd(this));
    a(new bc(this));
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
      localObject = "";
      if (e().getDisplayName().lastIndexOf("/") > 0)
        localObject = File.separator + e().getDisplayName().substring(0, e().getDisplayName().lastIndexOf("/"));
      if (new File(a().getConfigManager().d()).exists())
        localFileDialog.setFilterPath(a().getConfigManager().d() + (String)localObject);
      else
        localFileDialog.setFilterPath(a().getConfigManager().a + File.separator + a().getConfigManager().d() + (String)localObject);
      if (e().getDisplayName().lastIndexOf("/") > 0)
        localFileDialog.setFileName(e().getDisplayName().substring(e().getDisplayName().lastIndexOf("/") + 1));
      else
        localFileDialog.setFileName(e().getDisplayName());
    }
    else if (e().getExportFile().length() > 0)
    {
      localObject = new File(a().getConfigManager().a + File.separator + e().getExportFile());
      if (!((File)localObject).exists())
        localObject = new File(e().getExportFile());
      localFileDialog.setFilterPath(((File)localObject).getPath());
      localFileDialog.setFileName(((File)localObject).getName());
    }
    localFileDialog.setFilterExtensions(new String[] { "*.jsp" });
    Object localObject = localFileDialog.open();
    if (localObject != null)
      try
      {
        String str = this.e.m().getText();
        JspUtil.saveHtmlFile((String)localObject, str);
        a().showSuccess(c.a("HasBeenExport", new String[] { localObject }));
      }
      catch (Exception localException)
      {
        a().getRulesManager().j().b(localException.getMessage());
      }
  }

  private void a(boolean paramBoolean)
  {
    aZ localaZ = new aZ(this, paramBoolean);
    a(localaZ, true);
    localaZ.start();
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
    this.f.getDisplay().asyncExec(new ba(this, paramString));
  }

  private void a(IPage paramIPage, Exception paramException)
  {
    this.f.getDisplay().asyncExec(new bb(this, paramIPage, paramException));
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "jsp";
  }

  public boolean isCanFind()
  {
    return true;
  }

  public void find()
  {
    this.e.A();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aY
 * JD-Core Version:    0.6.0
 */