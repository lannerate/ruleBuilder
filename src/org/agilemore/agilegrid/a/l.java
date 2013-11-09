package org.agilemore.agilegrid.a;

import org.agilemore.agilegrid.J;
import org.agilemore.agilegrid.ad;
import org.agilemore.agilegrid.ax;
import org.agilemore.agilegrid.e;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public abstract class l extends J
{
  private Composite a;
  private Control o;
  private CLabel p;
  private Shell q;
  protected Object n = null;
  private static final int r = 0;

  public l(e parame)
  {
    this(parame, 0);
  }

  public l(e parame, int paramInt)
  {
    super(parame, paramInt);
  }

  public void a(ad paramad)
  {
    super.a(paramad);
    a(this.a);
  }

  protected abstract Control a(Composite paramComposite);

  protected void b(Composite paramComposite)
  {
  }

  protected Control a(e parame)
  {
    Font localFont = parame.getFont();
    Color localColor = parame.getBackground();
    int i = h();
    this.a = new Composite(parame, i);
    this.a.setFont(localFont);
    this.a.setBackground(localColor);
    this.a.setLayout(new FillLayout());
    this.p = new CLabel(this.a, 8404992);
    this.p.setFont(this.a.getFont());
    this.p.setBackground(this.a.getBackground());
    this.p.setImage(ax.a(l.class, "/icons/editor_normal.png"));
    d(this.n);
    a(true);
    return this.a;
  }

  protected Object d()
  {
    return this.n;
  }

  protected void a(Object paramObject)
  {
    this.n = paramObject;
    d(paramObject);
  }

  protected CLabel M()
  {
    return this.p;
  }

  protected void a(Control paramControl)
  {
    this.q = new Shell(paramControl.getShell(), 16400);
    this.q.setBackground(paramControl.getBackground());
    this.q.setLayout(new FillLayout());
    this.q.addKeyListener(new m(this));
    this.q.addShellListener(new n(this));
    Display localDisplay = paramControl.getDisplay();
    Rectangle localRectangle1 = localDisplay.map(paramControl.getParent(), null, paramControl.getBounds());
    Rectangle localRectangle2 = paramControl.getMonitor().getClientArea();
    int i = localRectangle1.x;
    int j = localRectangle1.y + localRectangle1.height;
    int k = localRectangle1.width;
    if (localRectangle1.width < 360)
      k = 360;
    int m = 200 + localRectangle1.height;
    if (m > 500)
      m = 500;
    if (i + k > localRectangle2.x + localRectangle2.width)
      i = localRectangle2.x + localRectangle2.width - k;
    if (j + m > localRectangle2.y + localRectangle2.height)
      j = localRectangle1.y - m;
    this.q.setBounds(i, j, k, m);
    Composite localComposite = new Composite(this.q, 0);
    localComposite.setBackground(localComposite.getParent().getBackground());
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localComposite.setLayout(localGridLayout);
    this.o = a(localComposite);
    if (this.o != null)
      this.o.addKeyListener(new o(this));
    b(localComposite);
    this.q.open();
    this.q.layout();
  }

  protected void d(Object paramObject)
  {
    if (this.p == null)
      return;
    String str = "";
    if (paramObject != null)
      str = paramObject.toString();
    this.p.setText(str);
  }

  public void b()
  {
    if ((this.q != null) && (!this.q.isDisposed()))
      this.q.dispose();
    super.b();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.a.l
 * JD-Core Version:    0.6.0
 */