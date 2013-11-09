package com.flagleader.builder.b;

import com.a.c;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.c.b;
import com.flagleader.builder.widget.editor.p;
import com.flagleader.manager.c.a;
import com.flagleader.util.StringUtil;
import java.util.HashMap;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class r
{
  private Control a;
  private Shell e;
  protected String b = null;
  private static final int f = 0;
  private p g;
  private a h = null;
  protected ToolBar c;
  protected HashMap d = new HashMap();

  public r(String paramString)
  {
    this.b = paramString;
  }

  protected Control a(Composite paramComposite)
  {
    Display localDisplay = paramComposite.getDisplay();
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setBackground(localDisplay.getSystemColor(1));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localComposite.setLayoutData(new GridData(4, 4, true, true));
    localComposite.setLayout(localGridLayout);
    int i = 2882;
    this.g = com.flagleader.builder.widget.editor.s.a(0, this.h, localComposite, i);
    this.g.a().setText(this.b);
    GridData localGridData = new GridData(1808);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    this.g.a().setLayoutData(localGridData);
    this.g.a().forceFocus();
    this.g.a().selectAll();
    this.g.a().addFocusListener(new s(this));
    this.g.a().addModifyListener(new t(this));
    return localComposite;
  }

  protected void b(Composite paramComposite)
  {
    CoolBar localCoolBar = new CoolBar(paramComposite, 0);
    localCoolBar.setLayoutData(new GridData(4, 16777216, true, false));
    CoolItem localCoolItem = new CoolItem(localCoolBar, 8);
    int i = 0;
    ToolBar localToolBar = a(localCoolBar, i);
    localCoolItem.setControl(localToolBar);
    c.a(localCoolBar);
    localCoolBar.setLocked(true);
  }

  public ToolBar a(Composite paramComposite, int paramInt)
  {
    this.c = new ToolBar(paramComposite, 0);
    a(this.c);
    return this.c;
  }

  public String b()
  {
    return this.g.a().getText();
  }

  public void b(String paramString)
  {
    this.g.a().setText(paramString);
  }

  protected boolean a(String paramString)
  {
    return true;
  }

  protected boolean c(String paramString)
  {
    return !StringUtil.equalsCase(this.b, paramString);
  }

  public void a(Control paramControl)
  {
    this.e = new Shell(paramControl.getShell(), 16400);
    this.e.setBackground(paramControl.getBackground());
    this.e.setLayout(new FillLayout());
    this.e.addKeyListener(new u(this));
    this.e.addShellListener(new v(this));
    Display localDisplay = paramControl.getDisplay();
    Rectangle localRectangle1 = localDisplay.map(paramControl.getParent(), null, paramControl.getBounds());
    Rectangle localRectangle2 = paramControl.getMonitor().getClientArea();
    int i = localRectangle1.x;
    int j = localRectangle1.y + localRectangle1.height;
    int k = localRectangle1.width;
    if (localRectangle1.width < 360)
      k = 360;
    if (localRectangle1.width > 600)
      k = 600;
    int m = 100;
    if ((this.b != null) && (this.b.length() > 0))
    {
      n = (StringUtil.numberOf(this.b, '\n') + 1) * 25;
      if (n > m)
        m = n;
    }
    int n = m + localRectangle1.height;
    if (n > 500)
      n = 500;
    if (i + k > localRectangle2.x + localRectangle2.width)
      i = localRectangle2.x + localRectangle2.width - k;
    if ((i < 0) || (i > 800))
      i = 300;
    if (j + n > localRectangle2.y + localRectangle2.height)
      j = localRectangle1.y - n;
    this.e.setBounds(i + 10, j, k, n);
    Composite localComposite = new Composite(this.e, 0);
    localComposite.setBackground(localComposite.getParent().getBackground());
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localComposite.setLayout(localGridLayout);
    this.a = a(localComposite);
    if (this.a != null)
      this.a.addKeyListener(new w(this));
    k();
    b(localComposite);
    this.e.open();
    this.e.layout();
  }

  protected void a()
  {
  }

  protected void c()
  {
  }

  public void d()
  {
    if ((this.e != null) && (!this.e.isDisposed()))
      this.e.dispose();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "undo");
    a(paramToolBar, "redo");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "cut");
    a(paramToolBar, "copy");
    a(paramToolBar, "paste");
    a(paramToolBar, "delete");
    a(paramToolBar, "selectall");
    a(paramToolBar, "ok");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "close");
    j();
  }

  protected ToolItem a(ToolBar paramToolBar, String paramString)
  {
    b localb = d(paramString);
    if (localb != null)
    {
      ToolItem localToolItem = new ToolItem(paramToolBar, 8);
      localToolItem.setImage(ResourceTools.getImage(localb.d()));
      localToolItem.setToolTipText(localb.f());
      localToolItem.addSelectionListener(new x(this, localb));
      localToolItem.setData(localb);
      return localToolItem;
    }
    return null;
  }

  protected b d(String paramString)
  {
    return (b)this.d.get(paramString);
  }

  public void e()
  {
    this.g.a().selectAll();
  }

  public void f()
  {
  }

  public void g()
  {
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    return true;
  }

  protected void j()
  {
    ToolItem[] arrayOfToolItem = this.c.getItems();
    for (int i = 0; i < arrayOfToolItem.length; i++)
    {
      b localb = (b)arrayOfToolItem[i].getData();
      if (localb == null)
        continue;
      if (localb.b())
        arrayOfToolItem[i].setEnabled(true);
      else
        arrayOfToolItem[i].setEnabled(false);
    }
  }

  protected void k()
  {
    a(new D(this));
    a(new E(this));
    a(new C(this));
    a(new B(this));
    a(new F(this));
    a(new z(this));
    a(new y(this));
    a(new A(this));
  }

  protected void a(b paramb)
  {
    this.d.put(paramb.c(), paramb);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.r
 * JD-Core Version:    0.6.0
 */