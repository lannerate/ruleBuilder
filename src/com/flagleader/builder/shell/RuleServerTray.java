package com.flagleader.builder.shell;

import com.flagleader.a.a.r;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.AboutLicenseDialog1;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.h;
import com.flagleader.engine.Property;
import com.flagleader.manager.d.b;
import com.flagleader.server.RuleServer;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

public class RuleServerTray extends Shell
  implements com.flagleader.server.i
{
  private Vector j = new Vector();
  private static final Color k = new Color(null, 255, 0, 0);
  private static final Color l = new Color(null, 0, 0, 255);
  private static final Color m = new Color(null, 200, 200, 0);
  private static final Color n = new Color(null, 0, 0, 0);
  private static Image o = ImageDescriptor.createFromURL(ClassInfoEditor.class.getClassLoader().getResource("icons/rulesettemplate.gif")).createImage();
  CTabFolder a;
  CTabItem b;
  CTabItem c;
  CTabItem d;
  StyledText e;
  com.flagleader.builder.widget.i f;
  Table g;
  Menu h;
  private eg p;
  private int q = 0;
  Vector i = new Vector();

  public static void main(String[] paramArrayOfString)
  {
    try
    {
      RuleServer.c();
      RuleServer.d();
      if (new File(a(b.a().f())).exists())
        try
        {
          if (Property.getInstance().getRuleEngineJarsDir().length() > 0)
            Property.getInstance().setRuleEngineJarsDir(Property.getInstance().getRuleEngineJarsDir() + a(b.a().f()) + StringUtil.classPathAdd());
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      Display localDisplay = Display.getDefault();
      if (r.a("ruleengine.rlc"))
      {
        Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
      }
      else
      {
        Property.getInstance().setEngineImplement("com.flagleader.engine.impl.TestRuleEngineFactory");
        localObject = new AboutLicenseDialog1(localDisplay.getActiveShell());
        ((AboutLicenseDialog1)localObject).open();
      }
      Object localObject = new RuleServerTray(localDisplay, 1264);
      ((RuleServerTray)localObject).a((Shell)localObject);
      ((RuleServerTray)localObject).open();
      ((RuleServerTray)localObject).layout();
      while (!((RuleServerTray)localObject).isDisposed())
      {
        if (localDisplay.readAndDispatch())
          continue;
        localDisplay.sleep();
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }

  private static String a(String paramString)
  {
    if (new File(FileUtil.getCurrentDir(), paramString).exists())
      return new File(FileUtil.getCurrentDir(), paramString).getAbsolutePath();
    return paramString;
  }

  public RuleServerTray(Display paramDisplay, int paramInt)
  {
    super(paramDisplay, paramInt);
    a();
  }

  protected void a()
  {
    setText(ResourceTools.getMessage("title.RuleServerTray"));
    setImage(o);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    setLayout(localGridLayout);
    setLayoutData(new GridData(1808));
    this.a = new CTabFolder(this, 8389504);
    this.a.setLayoutData(new GridData(1808));
    this.b = new CTabItem(this.a, 0);
    this.b.setText(ResourceTools.getMessage("runinfo.RuleServerTray"));
    this.b.setControl(c());
    this.c = new CTabItem(this.a, 0);
    this.c.setText(ResourceTools.getMessage("loginfo.RuleServerTray"));
    this.c.setControl(e());
    this.d = new CTabItem(this.a, 0);
    this.d.setText(ResourceTools.getMessage("ruleinfo.RuleServerTray"));
    this.d.setControl(d());
    this.a.setSelection(this.c);
  }

  private Composite d()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    new df(localComposite).b();
    return localComposite;
  }

  private Composite e()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.e = new af(localComposite, 2882).m();
    this.e.setLayoutData(new GridData(1808));
    ef localef = new ef(this);
    localef.setLevel(Level.ALL);
    Logger localLogger = Logger.getLogger("ruleengine");
    localLogger.addHandler(localef);
    dM localdM = new dM(this);
    getDisplay().timerExec(1000, localdM);
    f();
    return localComposite;
  }

  public void b()
  {
    String[] arrayOfString1 = ResourceTools.getStringArray("threadcolumns.RuleServerTray");
    for (int i1 = 0; i1 < arrayOfString1.length; i1++)
    {
      if (ResourceTools.getMessage(arrayOfString1[i1] + ".RuleServerTray") == null)
        continue;
      arrayOfString1[i1] = ResourceTools.getMessage(arrayOfString1[i1] + ".RuleServerTray");
    }
    String[] arrayOfString2 = ResourceTools.getStringArray("threadtypes.RuleServerTray");
    String[] arrayOfString3 = ResourceTools.getStringArray("threadlengths.RuleServerTray");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i2 = 0; i2 < arrayOfString3.length; i2++)
      arrayOfInt[i2] = Integer.parseInt(arrayOfString3[i2]);
    this.f.a(arrayOfString1, arrayOfInt, arrayOfString2);
  }

  public synchronized int a(String paramString1, String paramString2, String paramString3)
  {
    this.q += 1;
    int i1 = this.q;
    getDisplay().asyncExec(new dV(this, paramString1, paramString2, paramString3, i1));
    return this.q;
  }

  public void a(int paramInt)
  {
    this.i.add(String.valueOf(paramInt));
  }

  public Composite c()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.f = new com.flagleader.builder.widget.i(true, true);
    this.g = this.f.a(localComposite, 66304);
    this.g.setLayoutData(new GridData(1808));
    this.g.setHeaderVisible(true);
    this.g.setLinesVisible(true);
    b();
    RuleServer.a(this);
    this.g.addMouseListener(new dW(this));
    dY localdY = new dY(this);
    getDisplay().timerExec(1000, localdY);
    return localComposite;
  }

  protected void checkSubclass()
  {
  }

  public void a(Shell paramShell)
  {
    int i1 = paramShell.handle;
    OS.SetWindowLong(i1, -20, -2147483648);
    paramShell.addShellListener(new dZ(this, paramShell));
    Display localDisplay = paramShell.getDisplay();
    Tray localTray = localDisplay.getSystemTray();
    TrayItem localTrayItem = new TrayItem(localTray, 0);
    localTrayItem.setToolTipText(ResourceTools.getMessage("title.RuleServerTray"));
    localTrayItem.addListener(22, new ea(this));
    localTrayItem.addListener(23, new eb(this));
    localTrayItem.addListener(13, new ec(this));
    localTrayItem.addListener(14, new ed(this, paramShell));
    Menu localMenu = new Menu(paramShell, 8);
    MenuItem localMenuItem1 = new MenuItem(localMenu, 8);
    localMenuItem1.setText(ResourceTools.getMessage("Maximize.RuleServerTray"));
    localMenuItem1.addSelectionListener(new dN(this, paramShell));
    MenuItem localMenuItem2 = new MenuItem(localMenu, 8);
    localMenuItem2.setText(ResourceTools.getMessage("Minimize.RuleServerTray"));
    localMenuItem2.addSelectionListener(new dO(this, paramShell));
    localMenuItem2 = new MenuItem(localMenu, 8);
    localMenuItem2.setText(ResourceTools.getMessage("startServer.RuleServerTray"));
    localMenuItem2.addSelectionListener(new dP(this));
    localMenuItem2 = new MenuItem(localMenu, 8);
    localMenuItem2.setText(ResourceTools.getMessage("stopServer.RuleServerTray"));
    localMenuItem2.addSelectionListener(new dQ(this));
    new MenuItem(localMenu, 2);
    MenuItem localMenuItem3 = new MenuItem(localMenu, 8);
    localMenuItem3.setText(ResourceTools.getMessage("setting.RuleServerTray"));
    localMenuItem3.addSelectionListener(new dR(this));
    localMenuItem3 = new MenuItem(localMenu, 8);
    localMenuItem3.setText(ResourceTools.getMessage("close.RuleServerTray"));
    localMenuItem3.addSelectionListener(new dS(this));
    new MenuItem(localMenu, 2);
    localMenuItem3 = new MenuItem(localMenu, 8);
    localMenuItem3.setText(ResourceTools.getMessage("AboutItem"));
    localMenuItem3.addSelectionListener(new dT(this, paramShell));
    localTrayItem.addListener(35, new dU(this, localMenu, paramShell));
    localTrayItem.setImage(o);
  }

  private void f()
  {
    if ((this.p == null) || (this.p.b()))
    {
      this.p = new eg(this);
      this.p.start();
    }
  }

  private void a(String paramString, Level paramLevel)
  {
    paramString = Property.getInstance().formatDatetime(new Date()) + " : " + paramString;
    if (paramString.indexOf("\n") < 0)
      this.j.add(paramString + "\n");
    else
      this.j.add(paramString);
  }

  private void g()
  {
    if (this.e.isDisposed())
      return;
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i1 = this.j.size() - 1; i1 >= 0; i1--)
      localStringBuffer.append(this.j.get(i1).toString());
    this.e.setText(localStringBuffer.toString());
    while (this.j.size() > 30)
      this.j.remove(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.RuleServerTray
 * JD-Core Version:    0.6.0
 */