package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.dialogs.x;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.e.l;
import com.flagleader.repository.e.m;
import com.flagleader.repository.e.n;
import com.flagleader.repository.e.o;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRule;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class da extends aS
  implements IElementViewer
{
  private Browser f;
  boolean e = false;
  private boolean g = false;
  private HashMap q = new HashMap();
  private boolean r = false;

  public da(IPackageElement paramIPackageElement, Composite paramComposite, bu parambu)
  {
    super(paramIPackageElement, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new da((IPackageElement)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    a(paramToolBar, "export");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "html");
    a(paramToolBar, "print");
    a(paramToolBar, "email");
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new di(this));
    a(new dh(this));
    a(new df(this));
    a(new dg(this));
    super.h();
  }

  private IPackageElement e()
  {
    return (IPackageElement)this.c;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    try
    {
      b(localComposite);
    }
    catch (Throwable localThrowable)
    {
    }
    return localComposite;
  }

  private void f()
  {
    new x(e().getDisplayName(), a(false).toString()).open();
  }

  private StringBuffer a(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = null;
    if (paramBoolean)
      localObject1 = new n();
    else
      localObject1 = new o();
    if ((e() instanceof IRule))
      localStringBuffer.append(((o)localObject1).a((IRule)e()));
    else
      localStringBuffer.append(((o)localObject1).b(e()));
    if ((!paramBoolean) && (this.q.size() > 0))
    {
      localStringBuffer.append("<SCRIPT language=javascript >").append(m.q);
      Iterator localIterator = this.q.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        Object localObject3 = this.q.get(localObject2);
        localStringBuffer.append("moveRule('" + localObject2 + "','" + localObject3 + "');").append(m.q);
      }
      localStringBuffer.append("</SCRIPT>");
    }
    return (StringBuffer)localStringBuffer;
  }

  private void b(boolean paramBoolean)
  {
    FileDialog localFileDialog = new FileDialog(a().getShell(), 8192);
    localFileDialog.setFileName(e().getDisplayName());
    localFileDialog.setFilterExtensions(new String[] { "*.html" });
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        StringBuffer localStringBuffer = a(paramBoolean);
        FileUtil.saveToFile(str, localStringBuffer.toString(), o.b(localStringBuffer.toString()));
        a().showSuccess(c.a("HasBeenExport", new String[] { str }));
      }
      catch (Exception localException)
      {
        a().getRulesManager().j().b(localException.getMessage());
      }
  }

  private void b(Composite paramComposite)
  {
    this.f = new Browser(paramComposite, 0);
    GridData localGridData = new GridData(1808);
    localGridData.horizontalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessVerticalSpace = true;
    this.f.setLayoutData(localGridData);
    Color localColor = Display.getDefault().getSystemColor(29);
    this.f.setBackground(localColor);
    this.f.setForeground(Display.getDefault().getSystemColor(9));
    this.f.setText("<script language=javascript>function isie(){return  !-[1,];}</script>");
    this.r = "not".equals(String.valueOf(this.f.evaluate("if ( document.all ) return \"ie\"; else return \"not\";")));
    this.f.addTitleListener(new db(this));
  }

  private String g()
  {
    if (!this.r)
    {
      if ((e() instanceof IRule))
        return new o().a((IRule)e());
      return new o().b(e());
    }
    if ((e() instanceof IRule))
      return new l().a((IRule)e());
    return new l().b(e());
  }

  private void c(boolean paramBoolean)
  {
    dc localdc = new dc(this, paramBoolean);
    a(localdc, true);
    localdc.start();
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    c(false);
    super.update();
  }

  private void a(File paramFile)
  {
    if ((this.f != null) && (!this.f.isDisposed()))
      this.f.getDisplay().asyncExec(new dd(this, paramFile));
  }

  private void a(String paramString)
  {
    if ((this.f != null) && (!this.f.isDisposed()))
      this.f.getDisplay().asyncExec(new de(this, paramString));
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < e().getMaxModifyTime()) || (this.d < e().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "brower";
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean c()
  {
    return true;
  }

  public void copy()
  {
    this.f.execute("document.execCommand('copy')");
  }

  public void d()
  {
    this.f.execute("window.print()");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.da
 * JD-Core Version:    0.6.0
 */