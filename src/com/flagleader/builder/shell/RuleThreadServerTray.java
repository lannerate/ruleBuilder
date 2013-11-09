package com.flagleader.builder.shell;

import com.flagleader.a.a.r;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.AboutLicenseDialog1;
import com.flagleader.builder.widget.a.af;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.i;
import com.flagleader.engine.Property;
import com.flagleader.manager.d.b;
import com.flagleader.server.RuleThreadInfo;
import com.flagleader.server.RuleThreadServer;
import com.flagleader.server.j;
import com.flagleader.server.k;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.xml.XMLReceiveBean;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
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
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

public class RuleThreadServerTray extends Shell
  implements j
{
  private Vector k = new Vector();
  private static final Color l = new Color(null, 255, 0, 0);
  private static final Color m = new Color(null, 0, 0, 255);
  private static final Color n = new Color(null, 200, 200, 0);
  private static final Color o = new Color(null, 0, 0, 0);
  private static Image p = ImageDescriptor.createFromURL(ClassInfoEditor.class.getClassLoader().getResource("icons/rulesettemplate.gif")).createImage();
  CTabFolder a;
  CTabItem b;
  CTabItem c;
  CTabItem d;
  StyledText e;
  i f;
  Table g;
  Table h;
  Menu i;
  private eD q;
  StyledText j;
  private int r = 0;
  private long s = 0L;
  private Stack t = new Stack();

  public static void main(String[] paramArrayOfString)
  {
    try
    {
      RuleThreadServer.c();
      RuleThreadServer.a();
      RuleThreadServer.d();
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
      Object localObject = new RuleThreadServerTray(localDisplay, 1264);
      ((RuleThreadServerTray)localObject).a((Shell)localObject);
      ((RuleThreadServerTray)localObject).open();
      ((RuleThreadServerTray)localObject).layout();
      while (!((RuleThreadServerTray)localObject).isDisposed())
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

  public RuleThreadServerTray(Display paramDisplay, int paramInt)
  {
    super(paramDisplay, paramInt);
    a();
  }

  protected void a()
  {
    setText(ResourceTools.getMessage("title.RuleThreadServerTray"));
    setImage(p);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    setLayout(localGridLayout);
    setLayoutData(new GridData(1808));
    SashForm localSashForm = new SashForm(this, 512);
    localSashForm.setLayout(h.a(1));
    localSashForm.setLayoutData(new GridData(1808));
    Composite localComposite1 = new Composite(localSashForm, 2048);
    localComposite1.setBackground(h.d);
    localComposite1.setLayout(h.a(1));
    localComposite1.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder = new CTabFolder(localComposite1, 8389504);
    localCTabFolder.setLayoutData(new GridData(1808));
    this.b = new CTabItem(localCTabFolder, 0);
    this.b.setText(ResourceTools.getMessage("threadinfo.RuleThreadServerTray"));
    this.b.setControl(a(localCTabFolder));
    Composite localComposite2 = new Composite(localSashForm, 2048);
    localComposite2.setBackground(h.d);
    localComposite2.setLayout(h.a(1));
    localComposite2.setLayoutData(new GridData(1808));
    this.a = new CTabFolder(localComposite2, 8389504);
    this.a.setLayoutData(new GridData(1808));
    this.c = new CTabItem(this.a, 0);
    this.c.setText(ResourceTools.getMessage("loginfo.RuleThreadServerTray"));
    this.c.setControl(e());
    CTabItem localCTabItem1 = new CTabItem(this.a, 0);
    localCTabItem1.setText(ResourceTools.getMessage("logrule.RuleExecuteViewer"));
    localCTabItem1.setControl(c());
    CTabItem localCTabItem2 = new CTabItem(this.a, 0);
    localCTabItem2.setText(ResourceTools.getMessage("receiverule.RuleThreadServerTray"));
    a(this.a);
    localCTabItem2.setControl(this.h);
    this.d = new CTabItem(this.a, 0);
    this.d.setText(ResourceTools.getMessage("ruleinfo.RuleServerTray"));
    this.d.setControl(b());
    this.a.setSelection(this.c);
    this.a.addSelectionListener(new eh(this));
    localSashForm.setWeights(new int[] { 20, 80 });
  }

  private Composite b()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    new df(localComposite).b();
    return localComposite;
  }

  private Composite c()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.j = new af(localComposite, 2882).m();
    this.j.setLayoutData(new GridData(1808));
    return localComposite;
  }

  private void d()
  {
    File localFile = new File("ruleexecute.log");
    if ((localFile == null) || (this.j.isDisposed()))
      return;
    try
    {
      this.j.setText(FileUtil.readFromFile(localFile));
      this.j.setSelection(this.j.getText().length());
    }
    catch (Exception localException)
    {
    }
  }

  void a(Composite paramComposite)
  {
    i locali = new i(false, true);
    this.h = locali.a(paramComposite, 66306);
    this.h.setLayoutData(new GridData(1808));
    this.h.setHeaderVisible(true);
    this.h.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("receivecolumns.RuleThreadServerTray");
    for (int i1 = 0; i1 < arrayOfString1.length; i1++)
    {
      if (ResourceTools.getMessage(arrayOfString1[i1] + ".RuleThreadServerTray") == null)
        continue;
      arrayOfString1[i1] = ResourceTools.getMessage(arrayOfString1[i1] + ".RuleThreadServerTray");
    }
    String[] arrayOfString2 = ResourceTools.getStringArray("receivetypes.RuleThreadServerTray");
    String[] arrayOfString3 = ResourceTools.getStringArray("receivelengths.RuleThreadServerTray");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i2 = 0; i2 < arrayOfString3.length; i2++)
      arrayOfInt[i2] = Integer.parseInt(arrayOfString3[i2]);
    locali.a(arrayOfString1, arrayOfInt, arrayOfString2);
    es locales = new es(this);
    getDisplay().timerExec(1000, locales);
  }

  private Composite e()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.e = new af(localComposite, 2882).m();
    this.e.setLayoutData(new GridData(1808));
    eC localeC = new eC(this);
    localeC.setLevel(Level.ALL);
    Logger localLogger = Logger.getLogger("ruleengine");
    localLogger.addHandler(localeC);
    et localet = new et(this);
    getDisplay().timerExec(1000, localet);
    f();
    return localComposite;
  }

  private String a(XMLReceiveBean paramXMLReceiveBean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    Object localObject1;
    if (paramXMLReceiveBean.getValues().size() > 0)
    {
      localObject1 = paramXMLReceiveBean.getValues().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        Object localObject3 = paramXMLReceiveBean.getValue(String.valueOf(localObject2));
        if ((!(localObject3 instanceof String)) && (!(localObject3 instanceof Number)) && (!(localObject3 instanceof Date)))
          (localObject3 instanceof Boolean);
        localStringBuffer.append(localObject2).append(":").append(StringUtil.stringValue(localObject3)).append(";");
      }
    }
    else
    {
      localObject1 = paramXMLReceiveBean.getDymicValues();
      for (int i1 = 0; (localObject1 != null) && (i1 < localObject1.length); i1++)
        localStringBuffer.append(StringUtil.stringValue(localObject1[i1])).append(";");
    }
    localStringBuffer.append("}");
    return (String)localStringBuffer.toString();
  }

  public synchronized void a(RuleThreadInfo paramRuleThreadInfo)
  {
    this.t.push(paramRuleThreadInfo);
  }

  public synchronized void a(k paramk)
  {
    this.r += 1;
    int i1 = this.r;
    paramk.a(i1);
    getDisplay().asyncExec(new eu(this, i1, paramk));
  }

  private void a(TableItem paramTableItem, k paramk)
  {
    if ((paramTableItem != null) && (!paramTableItem.isDisposed()))
    {
      paramTableItem.setText(1, paramk.d().getRuleName());
      paramTableItem.setText(2, Property.getInstance().formatDatetime(new Date()));
      paramTableItem.setText(3, paramk.c());
      paramTableItem.setText(4, paramk.a());
      paramTableItem.setText(5, a(paramk.d()));
      paramTableItem.setData(paramk);
    }
  }

  private void b(TableItem paramTableItem, k paramk)
  {
    if ((paramTableItem != null) && (!paramTableItem.isDisposed()))
      paramTableItem.setText(4, paramk.a());
  }

  public Composite a(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.f = new i(true, true);
    this.g = this.f.a(localComposite, 66304);
    this.g.setLayoutData(new GridData(1808));
    this.g.setHeaderVisible(true);
    this.g.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("threadcolumns.RuleThreadServerTray");
    for (int i1 = 0; i1 < arrayOfString1.length; i1++)
    {
      if (ResourceTools.getMessage(arrayOfString1[i1] + ".RuleThreadServerTray") == null)
        continue;
      arrayOfString1[i1] = ResourceTools.getMessage(arrayOfString1[i1] + ".RuleThreadServerTray");
    }
    String[] arrayOfString2 = ResourceTools.getStringArray("threadtypes.RuleThreadServerTray");
    String[] arrayOfString3 = ResourceTools.getStringArray("threadlengths.RuleThreadServerTray");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i2 = 0; i2 < arrayOfString3.length; i2++)
      arrayOfInt[i2] = Integer.parseInt(arrayOfString3[i2]);
    this.f.a(arrayOfString1, arrayOfInt, arrayOfString2);
    RuleThreadServer.a(this);
    this.g.addMouseListener(new ev(this));
    ex localex = new ex(this);
    getDisplay().timerExec(1000, localex);
    return localComposite;
  }

  protected void checkSubclass()
  {
  }

  public void a(Shell paramShell)
  {
    int i1 = paramShell.handle;
    OS.SetWindowLong(i1, -20, -2147483648);
    paramShell.addShellListener(new ey(this, paramShell));
    Display localDisplay = paramShell.getDisplay();
    Tray localTray = localDisplay.getSystemTray();
    TrayItem localTrayItem = new TrayItem(localTray, 0);
    localTrayItem.setToolTipText(ResourceTools.getMessage("title.RuleThreadServerTray"));
    localTrayItem.addListener(22, new ez(this));
    localTrayItem.addListener(23, new eA(this));
    localTrayItem.addListener(13, new ei(this));
    localTrayItem.addListener(14, new ej(this, paramShell));
    Menu localMenu = new Menu(paramShell, 8);
    MenuItem localMenuItem1 = new MenuItem(localMenu, 8);
    localMenuItem1.setText(ResourceTools.getMessage("Maximize.RuleServerTray"));
    localMenuItem1.addSelectionListener(new ek(this, paramShell));
    MenuItem localMenuItem2 = new MenuItem(localMenu, 8);
    localMenuItem2.setText(ResourceTools.getMessage("Minimize.RuleServerTray"));
    localMenuItem2.addSelectionListener(new el(this, paramShell));
    localMenuItem2 = new MenuItem(localMenu, 8);
    localMenuItem2.setText(ResourceTools.getMessage("startServer.RuleServerTray"));
    localMenuItem2.addSelectionListener(new em(this));
    localMenuItem2 = new MenuItem(localMenu, 8);
    localMenuItem2.setText(ResourceTools.getMessage("stopServer.RuleServerTray"));
    localMenuItem2.addSelectionListener(new en(this));
    new MenuItem(localMenu, 2);
    MenuItem localMenuItem3 = new MenuItem(localMenu, 8);
    localMenuItem3.setText(ResourceTools.getMessage("setting.RuleServerTray"));
    localMenuItem3.addSelectionListener(new eo(this));
    localMenuItem3 = new MenuItem(localMenu, 8);
    localMenuItem3.setText(ResourceTools.getMessage("close.RuleServerTray"));
    localMenuItem3.addSelectionListener(new ep(this));
    new MenuItem(localMenu, 2);
    localMenuItem3 = new MenuItem(localMenu, 8);
    localMenuItem3.setText(ResourceTools.getMessage("AboutItem"));
    localMenuItem3.addSelectionListener(new eq(this, paramShell));
    localTrayItem.addListener(35, new er(this, localMenu, paramShell));
    localTrayItem.setImage(p);
  }

  private void f()
  {
    if ((this.q == null) || (this.q.b()))
    {
      this.q = new eD(this);
      this.q.start();
    }
  }

  private void a(String paramString, Level paramLevel)
  {
    paramString = Property.getInstance().formatDatetime(new Date()) + " : " + paramString;
    if (paramString.indexOf("\n") < 0)
      this.k.add(paramString + "\n");
    else
      this.k.add(paramString);
  }

  private void g()
  {
    if (this.e.isDisposed())
      return;
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i1 = this.k.size() - 1; i1 >= 0; i1--)
      localStringBuffer.append(this.k.get(i1).toString());
    this.e.setText(localStringBuffer.toString());
    while (this.k.size() > 30)
      this.k.remove(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.RuleThreadServerTray
 * JD-Core Version:    0.6.0
 */