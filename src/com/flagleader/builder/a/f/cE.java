package com.flagleader.builder.a.f;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bq;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.af;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class cE extends aS
  implements bq, IElementViewer
{
  private StyledText g;
  af e;
  protected String f = "";

  public cE(IPackageElement paramIPackageElement, Composite paramComposite, bu parambu)
  {
    super(paramIPackageElement, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new cE((IPackageElement)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    super.h();
  }

  private IPackageElement e()
  {
    return (IPackageElement)this.c;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.e = new af(a(), localComposite, 8456770);
    this.g = this.e.m();
    this.g.addFocusListener(new cF(this));
    return localComposite;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    this.e.a(e().getText());
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getMaxModifyTime()) || (this.d < e().getEnvionment().getMaxModifyTime());
  }

  public void d()
  {
    if (this.e != null)
      this.e.d();
  }

  public void a(Printer paramPrinter)
  {
    if (this.e != null)
      this.e.a(paramPrinter);
  }

  public String getCompositeUuid()
  {
    return this.c.getEditUuid() + "view";
  }

  public boolean isCanFind()
  {
    return true;
  }

  public void find()
  {
    if (this.e != null)
      this.e.A();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cE
 * JD-Core Version:    0.6.0
 */