package com.flagleader.builder.a.d;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.a.k;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.d;
import java.io.File;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class I extends aS
  implements IElementViewer
{
  private Browser e;
  private StyledText f;
  private boolean g = false;

  public I(IPage paramIPage, Composite paramComposite, bu parambu)
  {
    super(paramIPage, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new I((IPage)this.c, paramComposite, this.a);
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected void h()
  {
    a(new O(this));
    super.h();
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  protected IPage e()
  {
    return (IPage)this.c;
  }

  private void b(Composite paramComposite)
  {
    try
    {
      this.e = new Browser(paramComposite, 0);
      GridData localGridData = new GridData(1808);
      localGridData.horizontalAlignment = 4;
      localGridData.grabExcessHorizontalSpace = true;
      localGridData.verticalAlignment = 4;
      localGridData.grabExcessVerticalSpace = true;
      this.e.setLayoutData(localGridData);
      localObject = Display.getDefault().getSystemColor(29);
      this.e.setBackground((Color)localObject);
      this.e.setForeground(Display.getDefault().getSystemColor(9));
      this.e.addTitleListener(new J(this));
    }
    catch (Exception localException)
    {
      Object localObject = new k(a(), paramComposite, 8456770);
      this.f = ((k)localObject).m();
    }
  }

  private void a(boolean paramBoolean)
  {
    K localK = new K(this, paramBoolean);
    a(localK, true);
    localK.start();
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    a(false);
    super.update();
  }

  private void a(d paramd, Exception paramException)
  {
    this.e.getDisplay().asyncExec(new L(this, paramd, paramException));
  }

  private void a(File paramFile)
  {
    this.e.getDisplay().asyncExec(new M(this, paramFile));
  }

  private void a(String paramString)
  {
    this.f.getDisplay().asyncExec(new N(this, paramString));
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "modelhtml";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.I
 * JD-Core Version:    0.6.0
 */