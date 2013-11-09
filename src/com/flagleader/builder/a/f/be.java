package com.flagleader.builder.a.f;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.c.g;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleSet;
import java.io.File;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class be extends aS
  implements IElementViewer
{
  private Browser e;

  public be(IRuleSet paramIRuleSet, Composite paramComposite, bu parambu)
  {
    super(paramIRuleSet, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new be((IRuleSet)this.c, paramComposite, this.a);
  }

  private IRuleSet e()
  {
    return (IRuleSet)this.c;
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

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new bi(this));
    super.h();
  }

  private void b(Composite paramComposite)
  {
    this.e = new Browser(paramComposite, 0);
    GridData localGridData = new GridData(1808);
    localGridData.horizontalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessVerticalSpace = true;
    this.e.setLayoutData(localGridData);
    Color localColor = Display.getDefault().getSystemColor(29);
    this.e.setBackground(localColor);
    this.e.setForeground(Display.getDefault().getSystemColor(9));
  }

  private void a(boolean paramBoolean)
  {
    bf localbf = new bf(this, paramBoolean);
    a(localbf, true);
    localbf.start();
  }

  private String f()
  {
    if ((e() instanceof Envionment))
      return new g().a((Envionment)e());
    return new g().b(e());
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    a(false);
    super.update();
  }

  private void a(File paramFile)
  {
    if (this.e != null)
      this.e.getDisplay().asyncExec(new bg(this, paramFile));
  }

  private void a(String paramString)
  {
    if (this.e != null)
      this.e.getDisplay().asyncExec(new bh(this, paramString));
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < e().getMaxModifyTime()) || (this.d < e().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "html";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.be
 * JD-Core Version:    0.6.0
 */