package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.W;
import org.agilemore.agilegrid.X;
import org.agilemore.agilegrid.Z;
import org.agilemore.agilegrid.aA;
import org.agilemore.agilegrid.au;
import org.agilemore.agilegrid.ax;
import org.agilemore.agilegrid.e;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class SamplesGUI extends ApplicationWindow
{
  private e a;
  private e b;
  private e c;
  private e d;

  public SamplesGUI()
  {
    super(null);
    a();
    addCoolBar(8388608);
    addMenuBar();
    addStatusLine();
  }

  protected Control createContents(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    localComposite.setLayout(new FillLayout());
    TabFolder localTabFolder = new TabFolder(localComposite, 0);
    TabItem localTabItem1 = new TabItem(localTabFolder, 0);
    localTabItem1.setText("Sortable Column");
    this.a = new e(localTabFolder, 671351554);
    localTabItem1.setControl(this.a);
    H localH = new H(this.a);
    Z localZ = new Z(localH);
    localH.a(localZ);
    this.a.a(new E(this.a));
    this.a.a(localH);
    this.a.a(new F());
    this.a.a(new X(this.a));
    this.a.addMouseListener(new W(this.a, new D(this.a, -2147483648, -1)));
    this.a.a(new w(this));
    TabItem localTabItem2 = new TabItem(localTabFolder, 0);
    localTabItem2.setText("Scalable Column");
    this.b = new e(localTabFolder, 134217730);
    localTabItem2.setControl(this.b);
    this.b.a(new aA(this.b));
    this.b.a(new B());
    this.b.a(new x(this));
    TabItem localTabItem3 = new TabItem(localTabFolder, 0);
    localTabItem3.setText("Popup Cell Editor");
    this.d = new e(localTabFolder, 134217730);
    this.d.setBackground(paramComposite.getDisplay().getSystemColor(1));
    localTabItem3.setControl(this.d);
    this.d.a(new v(this.d));
    this.d.a(new u());
    this.d.a(new q(this.d));
    this.d.a(new y(this));
    TabItem localTabItem4 = new TabItem(localTabFolder, 0);
    localTabItem4.setText("Weekly Plan");
    this.c = new e(localTabFolder, 1073742658);
    localTabItem4.setControl(this.c);
    this.c.a(new R(this.c));
    this.c.a(new M(this.c));
    this.c.a(new Q());
    this.c.a(new z(this, this.c));
    this.c.k(52);
    this.c.a(new K(this.c));
    this.c.a(new A(this));
    Display localDisplay = this.c.getDisplay();
    Image localImage1;
    Image localImage2;
    Image localImage3;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (SWT.getPlatform().equals("win32"))
    {
      localImage1 = ax.a(SamplesGUI.class, "/icons/cross_win32.gif");
      localImage2 = ax.a(SamplesGUI.class, "/icons/row_resize_win32.gif");
      localImage3 = ax.a(SamplesGUI.class, "/icons/column_resize_win32.gif");
      localObject1 = localImage1.getBounds();
      localObject2 = localImage2.getBounds();
      localObject3 = localImage3.getBounds();
      localObject4 = new Point(((Rectangle)localObject1).width / 2, ((Rectangle)localObject1).height / 2);
      localObject5 = new Point(((Rectangle)localObject2).width / 2, ((Rectangle)localObject2).height / 2);
      localObject6 = new Point(((Rectangle)localObject3).width / 2, ((Rectangle)localObject3).height / 2);
      this.c.a(new Cursor(localDisplay, localImage1.getImageData(), ((Point)localObject4).x, ((Point)localObject4).y), (Point)localObject4);
      this.c.c(new Cursor(localDisplay, localImage2.getImageData(), ((Point)localObject5).x, ((Point)localObject5).y));
      this.c.d(new Cursor(localDisplay, localImage3.getImageData(), ((Point)localObject6).x, ((Point)localObject6).y));
      localImage1.dispose();
      localImage2.dispose();
      localImage3.dispose();
    }
    else
    {
      localImage1 = ax.a(SamplesGUI.class, "/icons/cross.gif");
      localImage2 = ax.a(SamplesGUI.class, "/icons/cross_mask.gif");
      localImage3 = ax.a(SamplesGUI.class, "/icons/row_resize.gif");
      localObject1 = ax.a(SamplesGUI.class, "/icons/row_resize_mask.gif");
      localObject2 = ax.a(SamplesGUI.class, "/icons/column_resize.gif");
      localObject3 = ax.a(SamplesGUI.class, "/icons/column_resize_mask.gif");
      localObject4 = localImage1.getBounds();
      localObject5 = localImage3.getBounds();
      localObject6 = ((Image)localObject2).getBounds();
      Point localPoint1 = new Point(((Rectangle)localObject4).width / 2, ((Rectangle)localObject4).height / 2);
      Point localPoint2 = new Point(((Rectangle)localObject5).width / 2, ((Rectangle)localObject5).height / 2);
      Point localPoint3 = new Point(((Rectangle)localObject6).width / 2, ((Rectangle)localObject6).height / 2);
      this.c.a(new Cursor(localDisplay, localImage2.getImageData(), localImage1.getImageData(), localPoint1.x, localPoint1.y), localPoint1);
      this.c.c(new Cursor(localDisplay, ((Image)localObject1).getImageData(), localImage3.getImageData(), localPoint2.x, localPoint2.y));
      this.c.d(new Cursor(localDisplay, ((Image)localObject3).getImageData(), ((Image)localObject2).getImageData(), localPoint3.x, localPoint3.y));
      localImage1.dispose();
      localImage2.dispose();
      localImage3.dispose();
      ((Image)localObject1).dispose();
      ((Image)localObject2).dispose();
      ((Image)localObject3).dispose();
    }
    return (Control)(Control)(Control)(Control)(Control)(Control)localComposite;
  }

  private void a()
  {
  }

  protected MenuManager createMenuManager()
  {
    MenuManager localMenuManager = new MenuManager("menu");
    return localMenuManager;
  }

  protected CoolBarManager createCoolBarManager(int paramInt)
  {
    CoolBarManager localCoolBarManager = new CoolBarManager(paramInt);
    return localCoolBarManager;
  }

  protected StatusLineManager createStatusLineManager()
  {
    StatusLineManager localStatusLineManager = new StatusLineManager();
    localStatusLineManager.setMessage(null, "");
    return localStatusLineManager;
  }

  public static void main(String[] paramArrayOfString)
  {
    try
    {
      SamplesGUI localSamplesGUI = new SamplesGUI();
      localSamplesGUI.setBlockOnOpen(true);
      localSamplesGUI.open();
      Display.getCurrent().dispose();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  protected void configureShell(Shell paramShell)
  {
    super.configureShell(paramShell);
    paramShell.setText("Agile Grid");
  }

  protected Point getInitialSize()
  {
    return new Point(800, 600);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.SamplesGUI
 * JD-Core Version:    0.6.0
 */