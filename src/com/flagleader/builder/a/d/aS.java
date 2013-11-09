package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.N;
import com.flagleader.export.PagesMessages;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.h;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class aS extends com.flagleader.builder.a.aS
  implements IElementViewer
{
  private StyledText f;
  N e;
  private String g = "";

  public aS(IPage paramIPage, String paramString, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
    this.g = paramString;
  }

  protected com.flagleader.builder.a.aS e(Composite paramComposite)
  {
    return new aS((IPage)this.c, this.g, paramComposite, this.a);
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
    a(new aX(this));
    a(new aW(this));
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
    String str = e().getPreferences().getString(this.g + ".export");
    if (str != null)
    {
      str = StringUtil.replace("{pname}", e().getPName(), str);
      str = StringUtil.replace("{fname}", e().getFName(), str);
      localObject = new File(a().getConfigManager().d(), str);
      if (((File)localObject).exists())
        localFileDialog.setFilterPath(((File)localObject).getPath());
      localFileDialog.setFileName(((File)localObject).getName());
      if (((File)localObject).getName().lastIndexOf(".") > 0)
        localFileDialog.setFilterExtensions(new String[] { "*." + ((File)localObject).getName().substring(((File)localObject).getName().lastIndexOf(".") + 1) });
    }
    Object localObject = localFileDialog.open();
    if (localObject != null)
      try
      {
        FileUtil.writeFile((String)localObject, this.e.m().getText().getBytes());
        a().showSuccess(c.a("HasBeenExport", new String[] { localObject }));
      }
      catch (Exception localException)
      {
        a().getRulesManager().j().b(localException.getMessage());
      }
  }

  private void a(boolean paramBoolean)
  {
    aT localaT = new aT(this, paramBoolean);
    a(localaT, true);
    localaT.start();
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
    this.f.getDisplay().asyncExec(new aU(this, paramString));
  }

  private void a(IPage paramIPage, Exception paramException)
  {
    this.f.getDisplay().asyncExec(new aV(this, paramIPage, paramException));
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + this.g;
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
 * Qualified Name:     com.flagleader.builder.a.d.aS
 * JD-Core Version:    0.6.0
 */